package com.shadder.cart.servlet;

import com.shadder.cart.data.LocalCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setAttribute("products", LocalCache.getProducts());
        request.getRequestDispatcher("/WEB-INF/views/business/list.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
