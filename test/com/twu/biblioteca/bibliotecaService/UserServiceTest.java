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
        actualList.add(new User("Trixie", "trixie@gmail.com", 1234567890));
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

    @Test
    public void shouldReturnEmail() {
        for (int i = 0; i < actualList.size(); i++) {
            Assert.assertThat(userService.getListOfUsers().get(i).getEmail(), is(equalTo(actualList.get(i).getEmail())));
        }
    }

    @Test
    public void shouldReturnPhoneNumber() {
        for (int i = 0; i < actualList.size(); i++) {
            Assert.assertThat(userService.getListOfUsers().get(i).getPhoneNumber(), is(equalTo(actualList.get(i).getPhoneNumber())));
        }
    }

    @Test
    public void shouldValidateUser() {
        boolean validUser = userService.validateUser("Trixie");

        Assert.assertTrue(validUser);
    }

    @Test
    public void shouldNotValidateUser() {
        boolean validUser = userService.validateUser("OtherName");

        Assert.assertFalse(validUser);
    }

    @Test
    public void shouldAddNewUserToUserList() {
        userService.createNewUser("Crystal", "crystal@gmail.com", 12345678);

        Assert.assertThat(actualList.get(2).getUserName(), is(equalTo("Crystal")));
        Assert.assertThat(actualList.get(2).getEmail(), is(equalTo("crystal@gmail.com")));
        Assert.assertThat(actualList.get(2).getPhoneNumber(), is(equalTo(12345678)));
    }

    @Test
    public void shouldGetUserByName() {
        User user = userService.getUserByName("Trixie");

        Assert.assertThat(user.getUserName(), is(equalTo("Trixie")));
        Assert.assertThat(user.getEmail(), is(equalTo("trixie@gmail.com")));
        Assert.assertThat(user.getPhoneNumber(), is(equalTo(1234567890)));
    }

    @Test
    public void shouldReturnContactInformation() {
        String actualString = userService.showContactInformation("Trixie");

        String expectedString = "Name: Trixie, email: trixie@gmail.com, phone number: 1234567890";

        Assert.assertThat(actualString, is(equalTo(expectedString)));
    }
}
