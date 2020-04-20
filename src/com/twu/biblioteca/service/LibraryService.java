package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Library;
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

    public boolean checkOutProduct(String name) {
        LibraryProduct newLendedProduct = library.getListOfAvailableProductByName(name);
        if (newLendedProduct == null) {
            return false;
        } else {
            getListOfAvailableProducts().remove(newLendedProduct);
            addLendedProduct(newLendedProduct);
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

    public String returnProduct(String name) {
        LibraryProduct lendedProduct = getLendedProductByName(name);
        try {
            getListOfLendedProducts().removeIf(product -> product.getName().equalsIgnoreCase(name));
            addAvailableProduct(lendedProduct);
            return "Thank you for returning the " + lendedProduct.getClass().getSimpleName().toLowerCase() + ".";
        } catch (NullPointerException exception) {
            return "That is not a valid product to return.";
        }
    }

}
