package main.java.hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(100); // tamaño de la tabla hash

        String line = "";
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader("bussines.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] businessData = line.split(splitBy);
                Business business = new Business(businessData[0], businessData[1], businessData[2], businessData[3], businessData[4]);
                hashTable.insert(business, true); // usa la primera función hash
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ejemplo de extracción
        Business result = hashTable.get("some_business_id", true); // busca usando la primera función hash
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Business not found");
        }
    }
}
