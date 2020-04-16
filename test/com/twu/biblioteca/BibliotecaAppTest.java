package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

public class BibliotecaAppTest {

    @Test
    public void run() {
        PrintStream printStream = System.out;
        BibliotecaApp.run(printStream);
    }
}