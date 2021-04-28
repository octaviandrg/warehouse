package utils;

import model.client;
import model.product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class generateBill {
    /**
     * Genereaza factura corespunzatoare comenzii create
     * @param id identificatorul comenzii
     * @param c clinetul care a facut comanda
     * @param p produsul comandat
     * @param quantity cantitatea comandata
     * @param total_price pretul total
     * @throws IOException
     */
    public generateBill(int id, client c, product p, int quantity, int total_price) throws IOException {
        StringBuilder output = new StringBuilder();
        String fileName = "bill"+id+".txt";
        String del = "------------------------------------------------------\n";
        new File(fileName).delete();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
        output.append(del);
        output.append("Order ID: ").append(id).append("\nClient Name: ").append(c.getName()).append("\nProduct Name: ").append(p.getName()).append("\nQuantity: ").append(quantity).append("\nTotal price: ").append(total_price).append("\n").append(del);
        writer.append(output);
        writer.flush();
        writer.close();
    }
}
