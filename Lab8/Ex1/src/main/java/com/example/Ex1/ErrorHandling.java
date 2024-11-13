package com.example.Ex1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandling implements ErrorController {

    @GetMapping("/error")
    public String errorPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        String errorMessage = "";
        int httpStatusCode = response.getStatus();

        if(httpStatusCode == 404) {
            errorMessage = "404 Not Found. We don't provide any websites like this";
        }
        else if(httpStatusCode == 405) {
            errorMessage = "405 Not Support. We don't support this method for this site";
        }
        else if(httpStatusCode == 401) {
            errorMessage = "401 Login First. You need to login first";
        }
        else if(httpStatusCode == 400) {
            errorMessage = "400 Bad Request. Check your typo";
        }
        else if(httpStatusCode == 403) {
            errorMessage = "403 No Permission. You don't have permission";
        }
        else if(httpStatusCode == 500) {
            errorMessage = "500 Error Server. We really sorry about this uncomfort";
        }
        else if(httpStatusCode == 502) {
            errorMessage = "500 Bad gateway. We really sorry about this uncomfort";
        }
        request.setAttribute("error_message", errorMessage);
        return "error-handling";
    }
}
