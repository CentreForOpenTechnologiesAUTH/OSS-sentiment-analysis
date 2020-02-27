package com.SentimentAnalysis;

import com.Models.InputObjects.CommentsObject;
import com.Models.InputObjects.SentimentObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vader.sentiment.analyzer.SentimentAnalyzer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VaderListener {
    public SentimentObject.Sentiment analyzeText(String input){
        String s = null;
        String json="";
        SentimentObject.Sentiment output=null;
        try {
            if(input.length()<2){
                System.out.println("CAUTION : you are analyzing an empty text for sentiments ("+input+")");
            }
            Process p = Runtime.getRuntime().exec("python vader.py \""+input+"\"");
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));
            // read the output from the command
            while ((s = stdInput.readLine()) != null) {
                json=s.replace("'","\"");
            }
            //read any errors during execution of the command
            while ((s = stdError.readLine()) != null) {
                System.out.println("Something went wrong during executing Vader sentiment analyzer :"+s);
            }
            if(json!=null && !json.equalsIgnoreCase("")){
                ObjectMapper objectMapper=new ObjectMapper();
                output=objectMapper.readValue(json.toString(), SentimentObject.Sentiment.class);
            }
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return output;
    }
}
