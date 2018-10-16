package com.shadder.cart.servlet;

import com.shadder.cart.data.LocalCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class FavoriteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String productId = request.getParameter("productId");
        if (Objects.equals("/favorite/favorite.do", request.getServletPath())) {
            if (productId != null) {
                LocalCache.addFavorite(Long.valueOf(productId));
            }
            response.sendRedirect("/favorite/list.do");
        } else if (Objects.equals("/favorite/delete.do", request.getServletPath())) {
            if (productId != null) {
                LocalCache.removeFavorite(Long.valueOf(productId));
            }
            request.setAttribute("products", LocalCache.getFavorites());
            request.getRequestDispatcher("/WEB-INF/views/business/favorite.jsp").forward(request, response);
        } else if (Objects.equals("/favorite/list.do", request.getServletPath())) {
            request.setAttribute("products", LocalCache.getFavorites());
            request.getRequestDispatcher("/WEB-INF/views/business/favorite.jsp").forward(request, response);
        }
    }
}
