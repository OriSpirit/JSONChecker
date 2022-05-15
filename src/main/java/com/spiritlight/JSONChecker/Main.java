package com.spiritlight.JSONChecker;

import java.io.File;
import java.util.Objects;

import com.google.gson.JsonParser;
import org.apache.commons.io.FilenameUtils;

public class Main {
    static boolean b;
    public static void main(String[] args) {
        if(args.length != 0)
            if(Objects.equals(args[0], "-s"))
                b = true;
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
                    if(b)
                    System.out.println("Attempting to parse file " + it.getName());
                    JsonParser.parseString(TextFileReader.readTextFile(it));
                    if(b)
                    System.out.println("Parse successful.");
                } catch (Exception ignored) {
                    System.out.println("Failed to parse " + it.getName());
                    System.out.println(ignored.getMessage());
                }
            } else {
                if (b)
                System.out.println("Ignoring " + (extension.equals("") ? "directory" : "file") + " " + it.getName());
            }
        }
        System.out.println("Finished parsing " + files.length + " files.");
    }
}
