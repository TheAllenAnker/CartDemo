package com.shadder.cart.servlet;

import com.shadder.cart.data.LocalCache;
import com.shadder.cart.data.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class DetailInfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        if (Objects.equals("/detail/detail.do", request.getServletPath())) {
            String productId = request.getParameter("productId");
            if (productId != null) {
                LocalCache.addBrowseProduct(Long.valueOf(productId));
                request.setAttribute("product", LocalCache.getProduct(Long.valueOf(productId)));
            }
        }
        request.getRequestDispatcher("/WEB-INF/views/business/detail.jsp").forward(request, response);
    }
}
