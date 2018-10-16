package com.shadder.cart.servlet;

import com.shadder.cart.data.LocalCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class ProductServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        if (Objects.equals("/product/list.do", request.getServletPath())) {
            String currPage = request.getParameter("page");
            int page = 1;
            if (currPage != null && !"".equals(currPage)) {
                page = Integer.parseInt(currPage);
            }
            int size = 12;
            int productSize = LocalCache.getProductSize();
            int totalPage = productSize % 12 == 0 ? productSize / 12 : productSize / 12 + 1;
            request.setAttribute("currPage", page);
            request.setAttribute("prePage", page > 1 ? page - 1 : page);
            request.setAttribute("nextPage", page < totalPage ? page + 1 : page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("products", LocalCache.getPageProducts(page, size));
            request.getRequestDispatcher("/WEB-INF/views/business/list.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
