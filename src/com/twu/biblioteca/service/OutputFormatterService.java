package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.objects.User;
import com.twu.biblioteca.models.LibraryProduct;

public class OutputFormatterService {

    public String formatOutputBook(LibraryProduct libraryProduct) {
        return String.format("%s, written by %s, published in %d\n", libraryProduct.getName(), libraryProduct.getAuthorOrDirector(), libraryProduct.getPublishedYear());
    }

    public String formatOutputMovies(LibraryProduct libraryProduct) {
        if (libraryProduct.getRate() == -1) {
            return String.format("%s, directed by %s, released in %d, unrated\n", libraryProduct.getName(), libraryProduct.getAuthorOrDirector(), libraryProduct.getPublishedYear());
        } else {
            return String.format("%s, directed by %s, released in %d, rating: %d\n", libraryProduct.getName(), libraryProduct.getAuthorOrDirector(), libraryProduct.getPublishedYear(), libraryProduct.getRate());
        }
    }

    public String formatOutputUserInformation(User user) {
        return String.format("Name: %s, email: %s, phone number: %d", user.getUserName(), user.getEmail(), user.getPhoneNumber());
    }

    public String formatOutputCheckoutItemInformation(String className, String productName, String userName) {
        return String.format("%s: %s, name: %s\n", className, productName, userName);
    }
}
