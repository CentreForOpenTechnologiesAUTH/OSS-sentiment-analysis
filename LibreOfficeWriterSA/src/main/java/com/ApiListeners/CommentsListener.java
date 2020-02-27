package com.ApiListeners;

import com.Models.InputObjects.BugsObject;
import com.Models.InputObjects.CommentsObject;
import com.StaticObjects;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentsListener {
    public static List<CommentsObject.Comment> fetchComments(int bugId) {
        List<CommentsObject.Comment> output=new ArrayList<CommentsObject.Comment>();
        try {

            URL url = new URL(String.format(StaticObjects.baseUrl+StaticObjects.bugsUrl+StaticObjects.commentsUrl,bugId));
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
            CommentsObject.Comments temp=objectMapper.readValue(json.toString(),CommentsObject.Comments.class);
            if(temp.getBugs()!=null && temp.getBugs().getAdditionalProperties()!=null) {
                for (Object x : temp.getBugs().getAdditionalProperties().values()) {
                    output.addAll((List<CommentsObject.Comment>)objectMapper.convertValue(((HashMap<String,Object>)x).get("comments"),new TypeReference<List<CommentsObject.Comment>>(){}));
                }
            }

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            output=null;
        }
        return output;
    }
}
