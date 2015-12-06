package com.JavaTraining;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by joshika on 9/14/2014.
 */
@WebServlet(urlPatterns = {"/home", "*.do"})
public class SimpleServlet extends HttpServlet {
    String appName = "My Application";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello World From Simple Servlet");
    }
}
