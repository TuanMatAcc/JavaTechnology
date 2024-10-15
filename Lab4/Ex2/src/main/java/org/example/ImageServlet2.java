package org.example;

import java.io.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletOutputStream;

public class ImageServlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("image/jpg");
        response.setHeader("Content-disposition", "attachment; filename=GOAT.jpg");

//        String relativePath = "images/GOAT.jpg";
//        String filePath = getServletContext().getRealPath(relativePath);

        InputStream fin = getClass().getClassLoader().getResourceAsStream("images/GOAT.jpg");
        ServletOutputStream out = response.getOutputStream();
        BufferedOutputStream bout = new BufferedOutputStream(out);
        BufferedInputStream bin = new BufferedInputStream(fin);

        byte[] buffer = new byte[1024];

        int bytesRead;
        while ((bytesRead = bin.read(buffer)) > 0) {
            bout.write(buffer, 0, bytesRead);
        }
        bout.flush();
    }
}
