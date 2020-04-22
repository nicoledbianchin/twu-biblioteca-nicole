package com.twu.biblioteca.librarian;

import com.twu.biblioteca.domain.objects.Librarian;
import org.junit.Assert;
import org.junit.Test;

public class LibrarianService {
    private Librarian librarian = new Librarian();

    @Test
    public void shouldValidateLoginNumber() {
        boolean validLogin = librarian.validateLoginNumber(7878 - 1212);

        Assert.assertTrue(validLogin);
    }

    @Test
    public void shouldNotValidateLoginNumber() {
        boolean invalidLogin = librarian.validateLoginNumber(7979 - 2345);

        Assert.assertFalse(invalidLogin);
    }
}
