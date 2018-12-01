package com.dylan.demo.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component("propertiesUtil")
public class PropertiesUtil {

    private String fileName;
    private Properties properties = new Properties();

    public void setFileName(String fileName) {
        this.fileName = fileName;
        open();
    }

    private void open() {
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readPropertyByKey(String key) {
        return properties.getProperty(key);
    }

}
