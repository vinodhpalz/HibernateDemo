package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductDAO;
import model.Supplier;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("t1"));
		String pname = request.getParameter("t2");
		int pcost = Integer.parseInt(request.getParameter("t3"));
		String sname = request.getParameter("t4");
		int p2id = Integer.parseInt(request.getParameter("p1"));
		String p2name = request.getParameter("p2");
		int p2cost = Integer.parseInt(request.getParameter("p3"));
		if(pid != 0)
		{
			Product p = new Product();
			p.setPid(pid);
			p.setPname(pname);
			p.setPcost(pcost);
			
			Product p1 = new Product();
			p1.setPid(p2id);
			p1.setPname(p2name);
			p1.setPcost(p2cost);
			
			Supplier s = new Supplier();
			s.setSupplierName(sname);
			s.getProduct().add(p);
			s.getProduct().add(p1);
			
			p.setSuppier(s);
			p1.setSuppier(s);
			
			ProductDAO pd = new ProductDAO();
			boolean b = pd.insertProduct(p,p1,s);
			//request.setAttribute("products", pd.getProducts());
			pd.getProducts();
			if(b)
			{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Product.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
