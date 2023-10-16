package com.pm06.product_web_app.controllers;

import java.io.IOException;
import java.sql.Connection;

import com.pm06.product_web_app.models.DBCrud;
import com.pm06.product_web_app.models.MySQLConnector;
import com.pm06.product_web_app.models.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createProduct")
public class CreateProductServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. lay code tu url browser
        String code = req.getParameter("code");
        // 2. ket noi csdl
        Connection conn = MySQLConnector.getMySQLConnection();
        // 3. lay product tu bang code

        // 4. close
        MySQLConnector.closeConnection(conn);
        // 5. dat doi tuon product vao trong request (req)

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/CreateProductView.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lay du lieu tu form cua Broswer request
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        double price = 0;

        try {
            price = Double.parseDouble(priceStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // chuyen du lieu do thanh doi tuong Product
        Product product = new Product(code, name, price);

        // ket noi csdl
        Connection conn = MySQLConnector.getMySQLConnection(); 


        DBCrud.addProduct(conn, product);

        // close ket noi
        MySQLConnector.closeConnection(conn);

        // di chuyen sang ProductView
        resp.sendRedirect(req.getContextPath()+ "/productList");
    }

}
