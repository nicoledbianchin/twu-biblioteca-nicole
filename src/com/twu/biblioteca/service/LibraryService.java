package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.objectsCuration.Library;
import com.twu.biblioteca.domain.objects.User;
import com.twu.biblioteca.models.LibraryProduct;

import java.util.ArrayList;

public class LibraryService {
    private Library library = new Library();

    public ArrayList<LibraryProduct> getListOfAvailableProducts() {
        return library.getListOfAvailableProducts();
    }

    public ArrayList<LibraryProduct> getListOfLendedProducts() {
        return library.getListOfLendedProducts();
    }

    public boolean checkOutProduct(String name, String username) {
        LibraryProduct newLendedProduct = library.getListOfAvailableProductByName(name);
        if (newLendedProduct == null) {
            return false;
        } else {
            getListOfAvailableProducts().remove(newLendedProduct);
            addLendedProduct(newLendedProduct);
            newLendedProduct.setUserName(username);
            return true;
        }
    }

    public void addLendedProduct(LibraryProduct libraryProduct) {
        library.addLendedProduct(libraryProduct);
    }

    public void addAvailableProduct(LibraryProduct libraryProduct) {
        library.addAvailableProduct(libraryProduct);
    }

    private LibraryProduct getLendedProductByName(String name) {
        return library.getLendedProductByName(name);
    }

    public boolean returnProduct(String name) {
        LibraryProduct lendedProduct = getLendedProductByName(name);
        if (lendedProduct == null) {
            return false;
        } else {
            getListOfLendedProducts().remove(lendedProduct);
            addAvailableProduct(lendedProduct);
            return true;
        }

    }

    public String getUserCheckoutItem(String name) {
        return getLendedProductByName(name).getUserName();
    }

}
