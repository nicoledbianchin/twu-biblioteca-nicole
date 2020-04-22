package com.twu.biblioteca.librarian;

import com.twu.biblioteca.service.LibrarianService;
import org.junit.Assert;
import org.junit.Test;

public class LibrarianServiceTest {
    LibrarianService librarianService = new LibrarianService();

    @Test
    public void shouldLoginLibrarian() {
        boolean login = librarianService.login(7878 - 1212, 666);

        Assert.assertTrue(login);
    }

    @Test
    public void shouldNotLoginLibrarian() {
        boolean login = librarianService.login(9898 - 1345, 435);

        Assert.assertFalse(login);
    }
}
