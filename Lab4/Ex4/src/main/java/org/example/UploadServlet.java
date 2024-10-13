package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;


@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5 * 10,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nameFile = request.getParameter("name");
        String isOverrided = request.getParameter("override");
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Part part = request.getPart("document");
        String fileName = part.getSubmittedFileName();
        String extension = (fileName.split("\\."))[1];
        if(isOverrided == null) {
            File f = new File(uploadPath + File.separator + nameFile + "." + extension);
            if(f.exists() && !f.isDirectory()) {
                response.getWriter().write("File already exists");
                return;
            }

            part.write(uploadPath + File.separator + nameFile + "." + extension);
        }
        else {

            part.write(uploadPath + File.separator + nameFile + "." + extension);
            File f = new File(uploadPath + File.separator + nameFile + "." + extension);
            if(f.exists() && !f.isDirectory()) {
                response.getWriter().write("File has been overriden");
            }
        }
        String fileUrl = request.getContextPath() + "/" + "uploads" + "/" + nameFile + "." + extension;
        response.setContentType("text/html");
        response.getWriter().println("<h1>File uploaded successfully!</h1>");
        response.getWriter().println("<p>Click <a href=\"" + fileUrl + "\">here</a> to visit the file.</p>");
    }
}
