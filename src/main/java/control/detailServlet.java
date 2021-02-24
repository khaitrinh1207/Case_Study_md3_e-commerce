package control;

import model.Shoes;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "detailServlet", value = "/detail")
public class detailServlet extends HttpServlet {
    IProductService productService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_id = request.getParameter("s_id");
        Shoes shoes = productService.selectShoesById(s_id);
        String trademark = "";
        for (int i = 0; i < productService.selectAllCate().size(); i++) {
            if(shoes.getId_category()==productService.selectAllCate().get(i).getCate_id()){
                trademark = productService.selectAllCate().get(i).getCate_name();
            }
        }
        request.setAttribute("trademark",trademark);
        request.setAttribute("shoeDetail", shoes);
        request.getRequestDispatcher("detail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
