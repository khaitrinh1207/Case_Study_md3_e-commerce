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

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cate_id = request.getParameter("cate_id");
        List<Shoes> shoesList2 = productService.CategoryByID(cate_id);
        List<Category> categories = productService.selectAllCate();
        request.setAttribute("categoryList",categories);
        request.setAttribute("shoesList",shoesList2);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
