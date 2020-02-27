package com.SentimentAnalysis;

import com.Models.InputObjects.BugsObject;
import com.Models.InputObjects.MeaningCloudObject;
import com.StaticObjects;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MeaningCloudListener {
    public MeaningCloudObject.Sentiments analyzeText(String input){
        MeaningCloudObject.Sentiments sentiments=null;
        try {
            if(input.length()<2){
                System.out.println("CAUTION : analyzing empty(?) text with Meaning Cloud : ("+input+")");
            }
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "key="+StaticObjects.MCSubscriptionKey+"&" +
                    "lang=en&" +
                    "txt="+input+"&txtf=plain");
            Request request = new Request.Builder()
                    .url("https://api.meaningcloud.com/sentiment-2.1")
                    .post(body)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .build();

            Response response = client.newCall(request).execute();
            ObjectMapper mapper=new ObjectMapper();
            sentiments=mapper.readValue(response.body().string(),MeaningCloudObject.Sentiments.class);
            if(!sentiments.getStatus().getCode().equalsIgnoreCase("0")){
                System.out.println("Unsuccessful call to MeaningCloud API : "+sentiments.getStatus().getMsg());
                sentiments=null;
            }
        }catch(Exception ex)
        {
            System.out.println("Something went wrong during analyzing text with Meaning Cloud : "+ex.toString());
        }
        return sentiments;
    }
}
