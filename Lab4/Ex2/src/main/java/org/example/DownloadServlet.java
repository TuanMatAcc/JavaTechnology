package org.example;

import java.io.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletOutputStream;

public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            if(request.getParameter("file") == null) {
                response.getWriter().write("File not found");
            }
            else if(request.getParameter("file").equals("data.zip")) {
                response.setContentType("application/zip");
                response.setHeader("Content-disposition", "attachment; filename=data.zip");

//                String relativePath = "data/data.zip";
//                String filePath = getServletContext().getRealPath(relativePath);
                InputStream fin = getClass().getClassLoader().getResourceAsStream("data/data.zip");
                ServletOutputStream out = response.getOutputStream();
                BufferedOutputStream bout = new BufferedOutputStream(out);
                BufferedInputStream bin = new BufferedInputStream(fin);
                byte[] buffer = new byte[1024];

                int bytesRead;
                while ((bytesRead = bin.read(buffer)) != -1) {
                    bout.write(buffer, 0, bytesRead);
                }
                out.flush();
                bout.flush();
            }
            else if(request.getParameter("file").equals("music.mp3")) {
                response.setContentType("audio/mpeg");
                response.setHeader("Content-disposition", "attachment; filename=music.mp3");

//                String relativePath = "/data/music.mp3";
//                String filePath = getServletContext().getRealPath(relativePath);
                InputStream fin = getClass().getClassLoader().getResourceAsStream("data/music.mp3");
                ServletOutputStream out = response.getOutputStream();
                BufferedOutputStream bout = new BufferedOutputStream(out);
                BufferedInputStream bin = new BufferedInputStream(fin);
                byte[] buffer = new byte[1024];

                int bytesRead;
                while ((bytesRead = bin.read(buffer)) != -1) {
                    bout.write(buffer, 0, bytesRead);
                }
                out.flush();
                bout.flush();
            }
            else {
                response.setContentType("text/html");
                response.getWriter().write("Not support downloading this file");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
