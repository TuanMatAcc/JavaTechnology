package org.example;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        if(args.length == 0) {
            downloadFile("", "");
        }
        else {
            downloadFile(args[0], "../ex4.doc");
        }

    }

    public static String checkURL(String url) {
        if (url == null || url.isEmpty()) {
            return "Please specify an URL to a file";
        }
        UrlValidator validator = new UrlValidator();
        if(!validator.isValid(url)) {
            return "This is not a valid URL";
        }
        return "OK";
    }

    public static void downloadFile(String url, String fileName) {
        String checkResult = checkURL(url);
        if(checkResult.equals("OK")) {
            try {
                FileUtils.copyURLToFile(new URL(url), new File(fileName));
                return;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(checkResult);
    }
}