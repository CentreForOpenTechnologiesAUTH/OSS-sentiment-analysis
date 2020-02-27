package com.ApiListeners;
import com.Models.InputObjects.ProductObject;
import com.StaticObjects;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductListener {
    public static ProductObject.Products fetchProduct() {
        ProductObject.Products output;
        try {

            URL url = new URL(StaticObjects.baseUrl+StaticObjects.productsUrl+StaticObjects.product);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String input;
            StringBuilder json=new StringBuilder();
            while ((input = br.readLine()) != null) {
                json.append(input);
            }
            conn.disconnect();
            ObjectMapper objectMapper=new ObjectMapper();
            output=objectMapper.readValue(json.toString(), ProductObject.Products.class);

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            output=null;
        }
        return output;
    }
}
