package com.shadder.cart.servlet;

import com.shadder.cart.data.LocalCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class BrowseListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        if (Objects.equals("/browse/list.do", request.getServletPath())) {
            request.setAttribute("products", LocalCache.getBrowseProducts());
            request.getRequestDispatcher("/WEB-INF/views/business/browse_list.jsp").forward(request, response);
        } else if (Objects.equals("/browse/delete.do", request.getServletPath())) {
            String productId = request.getParameter("productId");
            if (productId != null) {
                LocalCache.delBrowseProduct(Long.valueOf(productId));
                request.setAttribute("products", LocalCache.getBrowseProducts());
            }
            response.sendRedirect("/browse/list.do");
        }
    }
}
