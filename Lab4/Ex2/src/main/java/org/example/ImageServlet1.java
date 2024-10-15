package org.example;

import java.io.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletOutputStream;

public class ImageServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("image/jpg");

        ServletOutputStream out = response.getOutputStream();

//        String relativePath = "images/GOAT.jpg";
//        String filePath = getServletContext().getRealPath(relativePath);

        InputStream fin = getClass().getClassLoader().getResourceAsStream("images/GOAT.jpg");
        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        byte[] buffer = new byte[1024];
        int bytesRead;

        // Read the image file and write it to the response in chunks
        while ((bytesRead = bin.read(buffer)) != -1) {
            bout.write(buffer, 0, bytesRead);
        }

        bout.flush();  // Ensure all buffered data is written

    }
}
