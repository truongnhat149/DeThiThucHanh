package controller;

import DAO.IProductDAO;
import DAO.ProductDAOImpl;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="SearchServlet",value ="/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        search(request,response);

    }
    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("searchproduct");
        IProductDAO dao = new ProductDAOImpl();

        List<Category> listCategory = dao.getAllCategory();
        List<Product> listSearch = dao.search(name);
        request.setAttribute("listProduct", listSearch);
        request.setAttribute("listCate", listCategory);
        request.getRequestDispatcher("product/search.jsp").forward(request, response);
    }
}
