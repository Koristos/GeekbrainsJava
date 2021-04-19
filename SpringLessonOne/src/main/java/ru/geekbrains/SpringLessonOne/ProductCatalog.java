package ru.geekbrains.SpringLessonOne;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "productCatalog", value = "/catalog")
public class ProductCatalog extends HttpServlet {

    private ArrayList<Product> products;

    @Override
    public void init() throws ServletException {
        products=new ArrayList<Product>();
        products.add(new Product(1, "Apple", 1.20));
        products.add(new Product(2, "Banana", 2.20));
        products.add(new Product(3, "Grape", 2.50));
        products.add(new Product(4, "Peach", 1.70));
        products.add(new Product(5, "Pineapple", 0.90));
        products.add(new Product(6, "Plum", 3.20));
        products.add(new Product(7, "Mango", 3.00));
        products.add(new Product(8, "Cherry", 2.16));
        products.add(new Product(9, "Raspberry", 2.80));
        products.add(new Product(10, "Avocado", 2.00));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        StringBuffer list = new StringBuffer();
        resp.getWriter().println("<h1>Product catalog</h1>");
        getServletContext().getRequestDispatcher("/header.html").include(req, resp);
        list.append("<ul>");
        for (Product a: products) {
           list.append(String.format("<li>%1s</li>",a.toString()));
        }
        list.append("</ul>");
        resp.getWriter().println(list);

    }
}
