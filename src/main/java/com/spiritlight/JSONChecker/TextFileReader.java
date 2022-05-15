package com.spiritlight.JSONChecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

    static String readTextFile(File file) {
        String text = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                text = text.concat(line);
            }
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text;
    }
}