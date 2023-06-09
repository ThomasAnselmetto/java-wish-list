package org.lessons.java.christmas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wishList = new ArrayList<>();
        boolean basta = false;

        do {
            System.out.println("Inserisci di seguito la lista dei regali che vorresti ricevere! Aggiungine e scrivi 'basta' per fermarti");

            String present = scanner.nextLine();
            switch (present) {
                case "basta":
                    basta = true;
                    break;
                default:
                    try {
                        wishList.add(present);
                        System.out.println("Hai scelto di aggiungere '" + present + "' alla tua wishlist");
                    } catch (RuntimeException e) {
                        System.out.println("Errore durante l'esecuzione");
                    }
                    break;
            }

            if (!present.equals("basta")) {
                System.out.println("La tua WishList al momento contiene: " + wishList.size() + " Elemento/i");
            }
        } while (!basta);

        System.out.println("Hai chiuso la tua lista con: " + wishList.size() + " Elemento/i");
        Collections.sort(wishList);
        System.out.println("La wishlist contiene: " + wishList);

        scanner.close();
    }
}
