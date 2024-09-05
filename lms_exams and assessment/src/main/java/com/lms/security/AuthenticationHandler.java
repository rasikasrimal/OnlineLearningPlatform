package com.lms.security;

import com.lms.repository.UserRepository;
import com.lms.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * Created by Chathuri
 * */


@Component
public class AuthenticationHandler implements AuthenticationSuccessHandler {

    @Autowired
    HttpSession session;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {

        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if (Role.TEACHER.getRole().equals(auth.getAuthority())) {
                httpServletResponse.sendRedirect("/home");
            }else if (Role.STUDENT.getRole().equals(auth.getAuthority())) {
                httpServletResponse.sendRedirect("/home");
            }
        }

        String userName = ((User)authentication.getPrincipal()).getUsername();
        com.lms.model.User user = userRepository.findByEmail(userName);
        session.setAttribute("USER_ID", user.getId());
    }
}
