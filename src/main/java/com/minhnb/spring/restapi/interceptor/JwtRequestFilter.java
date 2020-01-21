package com.minhnb.spring.restapi.interceptor;

import com.minhnb.spring.restapi.entity.Account;
import com.minhnb.spring.restapi.service.AccountService;
import com.minhnb.spring.restapi.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.header-authorization}")
    private String headerAuthorization;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String jwtToken = request.getHeader(headerAuthorization);
        String username = null;
        String companyCode = null;

        // JWT Token is in the form "Bearer token". Remove Bearer word and get
        // only the Token
        if (jwtToken != null) {

            try {

                username = jwtUtil.getUsernameFromToken(jwtToken);
                companyCode = jwtUtil.getCompanyCodeFromToken(jwtToken);

            } catch (IllegalArgumentException e) {

                System.out.println("Unable to get JWT Token!");

            } catch (SignatureException | MalformedJwtException e) {

                System.out.println("Token is invalid!");

            } catch (ExpiredJwtException e) {

                System.out.println("JWT Token has expired!");

            } catch (JwtException e) {

                System.out.println("Token failure!");

            }

        } else {
            logger.warn("JWT Token is null!");
        }
        // Once we get the token validate it.
        if (username != null && companyCode != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            Account account = this.accountService.getAccountByCompanyCodeAndUsername(companyCode, username);

            // if token is valid configure Spring Security to manually set
            // authentication
            if (jwtUtil.validateToken(jwtToken, account)) {

                List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(account.getRole().name());

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        account, null, authorities);

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }

        chain.doFilter(request, response);
    }
}
