//package com.minhnb.spring.restapi.service.impl;
//
//import com.minhnb.spring.restapi.entity.Account;
//import com.minhnb.spring.restapi.repository.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<Account> accountOptional = accountRepository.findByUserName(username);
//
//        if (accountOptional.isPresent()) {
//            Account account = accountOptional.get();
//            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(account.getRole().name());
//
//            return new User(account.getUserName(), account.getPassword(), authorities);
//        }
//
//        throw new UsernameNotFoundException("User not found with username: " + username);
//    }
//
//}
