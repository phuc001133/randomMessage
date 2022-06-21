package com.example.demotestng.core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private Properties prop;
    private InputStream input;
    private String filePath;

    public String getRunningURL() throws IOException {
        runningURL = getUrl("test");
        return runningURL;
    }

    private String runningURL;

    public Configuration(String filePath){
        this.filePath = filePath;
    }

    public String getProperty(String propertyName) throws IOException {
        String result = "";
        try {
            prop = new Properties();
            input = new FileInputStream(this.filePath);

            if (input != null) {
                prop.load(input);
            } else {
                throw new FileNotFoundException("property file '" + filePath + "' not found in the classpath");
            }

            result = prop.getProperty(propertyName);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            input.close();
        }

        return result;
    }

    public String getUrl(String env) throws IOException {
        switch(env){
            case "test":
                return getProperty("test_url");
            case "uat":
                return getProperty("uat_url");
            default:
                return "";
        }
    }

    public void testGit(){

    }
}
