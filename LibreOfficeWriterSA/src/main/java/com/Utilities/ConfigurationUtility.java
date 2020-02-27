package com.Utilities;

import com.Models.Configuration;
import com.StaticObjects;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ConfigurationUtility {
    public Configuration loadConfiguration(){
        Configuration configuration=new Configuration();
        File configFile=new File("config.txt");
        try{
            FileReader reader=new FileReader(configFile);
            Properties properties=new Properties();
            properties.load(reader);
            String baseUrl=properties.getProperty(StaticObjects.CONFIG_OVERRIDE_BASEURL);
            if(baseUrl!=null){
                StaticObjects.baseUrl=baseUrl;
            }
            String product=properties.getProperty(StaticObjects.CONFIG_OVERRIDE_PRODUCT);
            if(product!=null){
                StaticObjects.product=product;
            }
            String mcSubKey=properties.getProperty(StaticObjects.CONFIG_OVERRIDE_MC_SUB_KEY);
            if(mcSubKey!=null){
                StaticObjects.MCSubscriptionKey=mcSubKey;
            }
            configuration.setFetchProducts(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_FETCH_PRODUCTS)));
            configuration.setAutoActivate(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_AUTO_ACTIVATE)));
            configuration.setFetchBugs(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_FETCH_BUGS)));
            configuration.setFetchComments(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_FETCH_COMMENTS)));
            configuration.setAnalyzeWithVader(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_ANALYZE_WITH_VADER)));
            configuration.setAnalyzeWithMC(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_ANALYZE_WITH_MC)));
            configuration.setExportFromVader(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_EXPORT_FROM_VADER)));
            configuration.setExportFromMC(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_EXPORT_FROM_MC)));
            configuration.setExportByBugs(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_EXPORT_BY_BUGS)));
            configuration.setExportOnlyComments(Boolean.parseBoolean(properties.getProperty(StaticObjects.CONFIG_EXPORT_BY_COMMENTS)));

            configuration.setLoaded(true);
        }catch (Exception ex){
            System.out.println("Error during loading configuration file : "+ex.toString());
        }
        return configuration;
    }
}
