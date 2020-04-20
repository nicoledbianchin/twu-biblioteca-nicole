package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.service.UserService;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserServiceTest {
    private UserService userService = new UserService();

    @Test
    public void shouldAskUserNameOnCheckOutItem() {
        String question = userService.askForLogin();

        Assert.assertThat(question, is(equalTo("Please, tell us your name:")));
    }

}
