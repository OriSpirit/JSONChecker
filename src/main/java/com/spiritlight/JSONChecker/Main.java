package com.spiritlight.JSONChecker;

import java.io.File;
import java.util.Arrays;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.io.FilenameUtils;

public class Main {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        System.out.println("Working in directory " + path);
        File d = new File(path);
        File[] files = d.listFiles();
        if(files == null) {
            System.out.println("No files found locally, please move me elsewhere.");
            return;
        }
        for (File it : files) {
            String extension = FilenameUtils.getExtension(it.getName());
            if (!it.isDirectory() && extension.equals("json")) {
                try {
                    System.out.println("Attempting to parse file " + it.getName());
                    JsonParser.parseString(TextFileReader.readTextFile(it));
                    System.out.println("Parse successful.");
                } catch (Exception e) {
                    System.out.println("Exception caught at " + e.getMessage());
                    System.out.println("Error: " + e.getClass().getCanonicalName());
                    System.out.println(Arrays.toString(e.getStackTrace()));
                }
            } else {
                System.out.println("Ignoring " + (extension.equals("") ? "directory" : "file") + " " + it.getName());
            }
        }
        System.out.println("Finished parsing " + files.length + " files.");
    }
}
