import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;


public class Server implements Runnable {
    private List<Product> products;
    private List<Supplier> suppliers;

    private List<Customer> customers;

    public Server() {
        this.products = new ArrayList<>();
        this.suppliers = new ArrayList<>();
        this.customers = new ArrayList<>();
        products.add(new Product(1, "Product 1", 100, 10));
        products.add(new Product(2, "Product 2", 200, 20));
        products.add(new Product(3, "Product 3", 300, 30));
        suppliers.add(new Supplier("Supplier 1", "Address 1", "1234567890", "asdf@gmail.com"));
        suppliers.add(new Supplier("Supplier 2", "Address 2", "1234567890", "asdf@hotmail.com"));
        suppliers.add(new Supplier("Supplier 3", "Address 3", "1234567890", "pepe@gmail.com"));
        customers.add(new Customer(1, "Customer 1", "Address 1", "1234567890", ""));
        customers.add(new Customer(2, "Customer 2", "Address 2", "1234567890", ""));
        customers.add(new Customer(3, "Customer 3", "Address 3", "1234567890", ""));
    }


    public void getProducts(PrintWriter out) {
        Gson gson = new Gson();
        String productsJson = gson.toJson(products);
        out.println(productsJson);
    }

    public void getSuppliers(PrintWriter out) {
        Gson gson = new Gson();
        String suppliersJson = gson.toJson(suppliers);
        out.println(suppliersJson);
    }

    public void getCustomerId(PrintWriter out, int id) {
        Gson gson = new Gson();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                String customerJson = gson.toJson(customer);
                out.println(customerJson);
            }
        }
    }

    public void deleteProduct(PrintWriter out, int id) {
        Gson gson = new Gson();
        for (Product product : products) {
            if (product.getId() == id) {
                String productJson = gson.toJson(product);
                out.println(productJson);
            }
        }
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1999);
            while (true) {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Connected to server");
                switch (in.readLine().split("/")[1]) {
                    case "getProducts":
                        getProducts(out);
                        break;
                    case "getSuppliers":
                        getSuppliers(out);
                        break;
                    case "getCustomer:id":
                        getCustomerId(out, Integer.parseInt(in.readLine().split("/")[2]));
                        break;
                    case "deleteProduct:id":
                        deleteProduct(out, Integer.parseInt(in.readLine().split("/")[2]));
                        break;

                    default:
                        out.println("ERROR 404..");
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Thread s = new Thread(new Server());
        s.run();
    }
}
