import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Iva {
    public static void main(String[] args) {
        threeProductsFile();
    }

    //one product method
    public static void oneProduct(){
        String productName;
        double price, iva;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nombre del producto: ");
        productName = sc.nextLine();
        System.out.println("Precio del producto: ");
        price = sc.nextDouble();
        iva = price * 0.13;
        System.out.println(twoDecimal.format(iva));
    }

    //Three products method
    public static void threeProducts(){
        HashMap<String, Double> products = new HashMap<String, Double>();
        Scanner sc= new Scanner(System.in);
        String tempName;
        double tempPrice, total = 0, ivaTotal=0;
        //Saving the values in the hashmap
        for (int i = 0; i<3; i++){
            System.out.println("Nombre del producto: ");
            tempName = sc.next();
            System.out.println("Precio del producto: ");
            tempPrice = sc.nextDouble();
            products.put(tempName, tempPrice);
        }
        for (double s: products.values()) {
            total += s;
        }
        ivaTotal = total*0.13;

        System.out.println("El total de su compra es de: $"+twoDecimal.format(total)+" con un IVA de: $"+twoDecimal.format(ivaTotal));
    }

    //Three products and save the HashMap in a txt file
    public static void threeProductsFile(){
        //same thing of threeProduct method
        HashMap<String, Double> products = new HashMap<String, Double>();
        Scanner sc= new Scanner(System.in);
        String tempName;
        double tempPrice, total = 0, ivaTotal=0;
        for (int i = 0; i<3; i++){
            System.out.println("Nombre del producto: ");
            tempName = sc.next();
            System.out.println("Precio del producto: ");
            tempPrice = sc.nextDouble();
            products.put(tempName, tempPrice);
        }
        for (double s: products.values()) {
            total += s;
        }
        ivaTotal = total*0.13;

        System.out.println("El total de su compra es de: $"+twoDecimal.format(total)+" con un IVA de: $"+twoDecimal.format(ivaTotal));

        //saving the hashmap in a txt file
        //Setting the out path
        File file = new File("/home/almira/Documents/Cursos/Kodigo/Challenges/products.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter( new FileWriter(file) );
            //Saving Map values by entrys
            for(Map.Entry<String, Double> entry : products.entrySet()) {
                bf.write("Producto: "+entry.getKey() + " - Precio: $" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Method to format decimals
    private static DecimalFormat twoDecimal = new DecimalFormat("#.##");

}
