package com.ApiListeners;

import com.Models.InputObjects.BugsObject;
import com.Models.InputObjects.ProductObject;
import com.StaticObjects;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BugsListener {

    public static BugsObject.Bugs fetchBugs(String product,String component,String version){
        BugsObject.Bugs output;
        try {
            String encodedProduct=URLEncoder.encode(product,"UTF-8");
            String encodedComp=URLEncoder.encode(component,"UTF-8");
            String encodedVer=URLEncoder.encode(version,"UTF-8");
            URL url = new URL(StaticObjects.baseUrl+StaticObjects.bugsUrl+String.format(StaticObjects.bugSearchUrl,encodedProduct,encodedComp,encodedVer));
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
            output=objectMapper.readValue(json.toString(), BugsObject.Bugs.class);

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            output=null;
        }
        return output;
    }
}
