package com.example.sundevilpizza;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Filesystem {

    private final String upcomingOrdersDir = System.getProperty("user.dir") + "/data/orders/upcomingOrders/";
    private final String currentOrderDir = System.getProperty("user.dir") + "/data/orders/currentOrder/";
    private final String finishedOrdersDir = System.getProperty("user.dir") + "/data/orders/finishedOrders/";
    // takes in a formatted string of order data and writes to a file
    public void writeToFile(String str) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(currentOrderDir + "/" + "output.txt"));
        writer.write(str);
        writer.close();
    }

    // takes in a file path and returns an array of order data
    public HashMap<String, String> readFromFile(String str) throws IOException {

        // hashmap to return
        HashMap<String, String> orderInfoMap = new HashMap<String, String>();
        BufferedReader reader = new BufferedReader(new FileReader(currentOrderDir + "/" + "output.txt"));
        String order = reader.readLine();
        reader.close();

        String delims = ",";
        String[] tokens = order.split(delims);
        // populate OrderInfoMap
        orderInfoMap.put("OrderID", tokens[0]);
        orderInfoMap.put("Name", tokens[1]);
        orderInfoMap.put("Total", tokens[2]);
        orderInfoMap.put("Type", tokens[3]);
        orderInfoMap.put("Toppings", tokens[4]);

        System.out.println("Iterating Hashmap...");
        for (Map.Entry<String, String> set : orderInfoMap.entrySet()) {
            System.out.println(set.getKey() + " " + set.getValue());
        }

        return orderInfoMap;
    }

    public File getLatestOrder() {
        File folder = new File(upcomingOrdersDir);
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        return listOfFiles[listOfFiles.length-1];
    }
}
