package com.shadder.cart.servlet;

import com.shadder.cart.data.CartItem;
import com.shadder.cart.data.LocalCache;
import com.shadder.cart.data.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class CartServlet extends HttpServlet {

    public CartServlet() {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String productId = request.getParameter("productId");
        if (Objects.equals("/cart/cart.do", request.getServletPath())) {
            if (productId != null) {
                Product product = LocalCache.getProduct(Long.valueOf(productId));
                LocalCache.addCartItem(product);
            }
            response.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/list.do", request.getServletPath())) {
            request.setAttribute("carts", LocalCache.getCartItems());
            request.getRequestDispatcher("/WEB-INF/views/business/cart.jsp").forward(request, response);
        } else if (Objects.equals("/cart/increment.do", request.getServletPath())) {
            LocalCache.incrementCartItem(Long.valueOf(productId));
            response.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/decrement.do", request.getServletPath())) {
            LocalCache.decrementCartItem(Long.valueOf(productId));
            response.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/delete.do", request.getServletPath())) {
            LocalCache.removeCartItem(Long.valueOf(productId));
            response.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/check.do", request.getServletPath())) {
            String[] carts = request.getParameterValues("carts");
            int totalPrice = 0;
            for (String cart : carts) {
                CartItem cartItem = LocalCache.getCartItem(Long.valueOf(cart));
                totalPrice += cartItem.getTotalPrice();
                LocalCache.removeCartItem(Long.valueOf(cart));
            }
            request.setAttribute("totalPrice", totalPrice);
            request.getRequestDispatcher("/WEB-INF/views/business/check.jsp").forward(request, response);
        }
    }
}
