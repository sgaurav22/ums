package com.mav.business.ums.controller;

import com.mav.business.ums.domain.Role;
import com.mav.business.ums.domain.User;
import com.mav.business.ums.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.Mockito.*;

class UserControllerTest {
    @Mock
    UserService userService;
    @InjectMocks
    UserController userController;
    @Mock
    BindingResult bindingResult;
    @Mock
    Authentication auth;
    @Mock
    SecurityContext context;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        User user = getUser();
        when(userService.findUserByEmail(anyString())).thenReturn(user);
        when(userService.saveUser(any())).thenReturn(user);
        when(bindingResult.hasErrors()).thenReturn(false);
    }

    @Test
    void testLogin() {
        ModelAndView result = userController.login();
        Assertions.assertEquals("login", result.getViewName());
    }

    @Test
    void testRegistration() {
        ModelAndView result = userController.registration();
        Assertions.assertEquals("registration", result.getViewName());
    }

    @Test
    void testCreateNewUser() {
        User user = getUser();

        ModelAndView result = userController.createNewUser(user, bindingResult);
        Assertions.assertEquals("registration", result.getViewName());
    }

    @Test
    void testHome() {
        /*when(userController.getContext()).thenReturn(context);
        when(context.getAuthentication()).thenReturn(auth);*/

        //when(auth.getName()).thenReturn(anyString());
        /*ModelAndView result = userController.home();
        Assertions.assertEquals("admin/adminHome", result.getViewName());*/
    }

    @Test
    void testUser() {
        /*when(userService.findUserByEmail(anyString())).thenReturn(new User(0, "email", "password", "name", "lastName", 0, new HashSet<Role>(Arrays.asList(new Role(0, "role")))));

        ModelAndView result = userController.user();
        Assertions.assertEquals("user/userHome", result.getViewName());*/
    }

    private User getUser() {
        return new User(0, "saxenagau@gmail.com", "text", "honey", "sexy", 1, new HashSet<Role>(Arrays.asList(new Role(1, "ADMIN"))));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme