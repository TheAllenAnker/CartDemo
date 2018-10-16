package com.shadder.cart.servlet;

import com.shadder.cart.data.LocalCache;
import com.shadder.cart.data.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
            request.setAttribute("title", request.getParameter("title"));
            request.setAttribute("products", LocalCache.getPageProducts(page, size));
            request.getRequestDispatcher("/WEB-INF/views/business/list.jsp").forward(request, response);
        } else if (Objects.equals("/product/search_list.do", request.getServletPath())) {
            String currPage = request.getParameter("page");
            String keyword = request.getParameter("title");
            int page = 1;
            if (currPage != null && !"".equals(currPage)) {
                page = Integer.parseInt(currPage);
            }
            int size = 12;
            List<Product> searchProduct = LocalCache.getSearchProducts(keyword);
            int productSize = searchProduct.size();
            int totalPage = productSize % 12 == 0 ? productSize / 12 : productSize / 12 + 1;
            request.setAttribute("currPage", page);
            request.setAttribute("prePage", page > 1 ? page - 1 : page);
            request.setAttribute("nextPage", page < totalPage ? page + 1 : page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("title", request.getParameter("title"));
            request.setAttribute("products", LocalCache.getPageProducts(page, size, searchProduct));
            request.getRequestDispatcher("/WEB-INF/views/business/search_list.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
