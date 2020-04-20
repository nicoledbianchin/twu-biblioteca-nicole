package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.objects.User;
import com.twu.biblioteca.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserServiceTest {
    private UserService userService = new UserService();
    private ArrayList<User> actualList = userService.getListOfUsers();

    @Before
    public void init() {
        actualList.add(new User("Trixie"));
    }

    @Test
    public void shouldAskUserNameOnCheckOutItem() {
        String question = userService.askForLogin();

        Assert.assertThat(question, is(equalTo("Please, tell us your name:")));
    }

    @Test
    public void shouldReturnUserInformation() {
        userService.getListOfUsers();

        for (int i = 0; i < actualList.size(); i++) {
            Assert.assertThat(userService.getListOfUsers(), is(equalTo(actualList)));
        }
    }

    @Test
    public void shouldReturnUserName() {
        for (int i = 0; i < actualList.size(); i++) {
            Assert.assertThat(userService.getListOfUsers().get(i).getUserName(), is(equalTo(actualList.get(i).getUserName())));
        }
    }

}
