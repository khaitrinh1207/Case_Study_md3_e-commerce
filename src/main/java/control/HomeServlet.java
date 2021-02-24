package control;

import model.Category;
import model.Shoes;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "")
public class HomeServlet extends HttpServlet {
    IProductService productService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                listProductsAndCategory(request, response);
            break;
        }
    }



    private void listProductsAndCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shoes> shoesList = productService.selectAllShoes();
        List<Category> categories = productService.selectAllCate();
        request.setAttribute("categoryList",categories);
        request.setAttribute("shoesList", shoesList);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                showFindByName(request, response);
                break;
        }
    }

    private void showFindByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("nameSearch");
        List<Shoes> listFindByName = productService.findByNameShoes(name);
        List<Category> categories = productService.selectAllCate();
        request.setAttribute("categoryList",categories);
        request.setAttribute("listFindByName", listFindByName);
        RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
        rd.forward(request, response);
    }

}
