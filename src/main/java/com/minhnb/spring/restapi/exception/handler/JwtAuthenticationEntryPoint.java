package com.minhnb.spring.restapi.exception.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.minhnb.spring.restapi.constant.ResponseMessageKey;
import com.minhnb.spring.restapi.dto.ResponseDto;
import com.minhnb.spring.restapi.dto.StatusDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

        ResponseDto responseDto = new ResponseDto(null, new StatusDto(HttpStatus.UNAUTHORIZED, ResponseMessageKey.FAILURE));
        Gson gson = new GsonBuilder().serializeNulls().create();
        String responseJson = gson.toJson(responseDto);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getOutputStream().write(responseJson.getBytes());
        response.getOutputStream().flush();
        response.getOutputStream().close();

    }

}
