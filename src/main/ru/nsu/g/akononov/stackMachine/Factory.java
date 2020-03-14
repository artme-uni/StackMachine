package ru.nsu.g.akononov.stackMachine;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Factory {

    private final Map<String, Cmd> cmdMap = new HashMap<>();
    private final static Factory instance = new Factory();

    private Factory() {
        Properties properties = new Properties();

        try (InputStream in = Factory.class.getResourceAsStream("cmd.properties")) {
            properties.load(in);
        } catch (IOException e) {
            System.out.println("Cannot read cmd.properties");
        }

        for (String key : properties.stringPropertyNames()) {
            properties.get(key);

            try {
                Class cur = Class.forName(properties.getProperty(key));
                cmdMap.put(key, (Cmd) cur.getDeclaredConstructor().newInstance());

            } catch (Exception e) {
                System.out.println("Cannot instance class " + key);
            }
        }
    }

    public Cmd getClass (String cmd){
        return cmdMap.get(cmd);
    }

    public static Factory getInstance(){
        return instance;
    }
}
