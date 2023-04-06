package com.example.SOF3011_IT17319;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = "Anhdtph23299";
        request.setAttribute("hoTen",name);
        request.getRequestDispatcher("views/hello.jsp").forward(request,response);
    }

    public void destroy() {
    }
}