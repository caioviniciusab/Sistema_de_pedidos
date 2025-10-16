package Cod_vs.application;

import Cod_vs.entitie.enuns.orderStatus;
import Cod_vs.entities.Client;
import Cod_vs.entities.Order;
import Cod_vs.entities.OrderItem;
import Cod_vs.entities.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[]  args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date clientBirth = sdf.parse(sc.next());
        Client dados = new Client(clientName, clientEmail, clientBirth);

        System.out.println("-----------------------------------");
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        sc.nextLine();
        String status = sc.nextLine();
        Order client = new Order(new Date(), orderStatus.valueOf(status), dados);
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        System.out.println("-----------------------------------");

        for (int i=0; i<n; i++){
            System.out.println("#" + (i+1) + " item: ");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            OrderItem product = new OrderItem(quantity, productPrice, new Product(productName, productPrice));
            client.addItem(product);
            System.out.println("-----------------------------------");
        }
        System.out.println("ORDER SUMMARY");
        System.out.println("Order moment: " + client.getMoment());
        System.out.println("Order status: " + client.getStatus());
        System.out.println(dados);
        System.out.println("-----------------------------------");
        System.out.println("Order items: ");
        for (OrderItem i : client.getItems()){
            System.out.println(i.getProduct().getName()
                    + ", $"
                    + String.format("%.2f", i.getPrice())
                    + ", Quantity: "
                    + i.getQuantity()
                    + ", Subtotal: $"
                    + String.format("%.2f", i.subTotal()));
        }
        System.out.println("Total price: $" + String.format("%.2f", client.total()));
        System.out.println("-----------------------------------");


        sc.close();
    }
}
