package org.lessons.java.christmas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class WishList {

//    in primis creo il path per definire dove ho il mio file(servira' per il bonus)
private final static String fileRegali = "wishlist.txt";

    public static void main(String[] args) throws IOException {

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
//        -------------------------------BONUS-------------------------------------------------
//        creazione del writer tutta questa operazione lancia eccezioni quindi la chiudiamo in un try catch
        FileWriter writer = null;

        try {
            writer = new FileWriter(fileRegali);
            for (String present : wishList) {
                writer.write(present + "\n");
            }
        } catch (IOException e) {
            System.out.println("qualcosa e' andato storto durante la scrittura del file");
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (IOException ne) {
                ne.printStackTrace();
            }
//            preso questa parte dalle slide ma non so se sto facendo una cosa sensata
            File file = new File(fileRegali);
            Scanner scannerletturafile = new Scanner(file);

            while(scannerletturafile.hasNextLine()){
                String dataRegali = scannerletturafile.nextLine();
                System.out.println(dataRegali);
            }
            scannerletturafile.close();
        }
    }}
