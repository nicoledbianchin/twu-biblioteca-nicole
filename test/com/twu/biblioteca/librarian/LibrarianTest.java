package com.twu.biblioteca.librarian;

import com.twu.biblioteca.domain.objects.Librarian;
import org.junit.Assert;
import org.junit.Test;

public class LibrarianTest {
    private Librarian librarian = new Librarian();

    @Test
    public void shouldValidateLoginNumber() {
        boolean validLogin = librarian.validateLoginNumber(78781212);

        Assert.assertTrue(validLogin);
    }

    @Test
    public void shouldNotValidateLoginNumber() {
        boolean invalidLogin = librarian.validateLoginNumber(79792345);

        Assert.assertFalse(invalidLogin);
    }

    @Test
    public void shouldValidatePassword() {
        boolean validPassword = librarian.validatePassword(666);

        Assert.assertTrue(validPassword);
    }

    @Test
    public void shouldNotValidatePassword() {
        boolean invalidPassword = librarian.validatePassword(345);

        Assert.assertFalse(invalidPassword);
    }
}
