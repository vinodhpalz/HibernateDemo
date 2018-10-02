package controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import model.IPoductDAO;
import model.Product;
import model.ProductDAO;
import model.User;

@Controller
public class ProductControllers {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView productsPage() {
		ModelAndView view = new ModelAndView("Product");
		return view;
	}
	
	@RequestMapping(value="/success", method=RequestMethod.POST)
	public ModelAndView productSuccess(@ModelAttribute("product1") Product product, BindingResult result) throws Exception {
			
		/* exceptionOccured = "IO_EXCEPTION";
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException(" Null Pointer Exception");
		}
		else if(exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) {
			throw new IOException("IO Exception");
		}*/
		ModelAndView view = new ModelAndView("success");
		view.addObject("productName",product.getPname());
		
		IPoductDAO pd = new ProductDAO();
		pd.insertProduct(product);
		
		return view;
		
	}
	
	@RequestMapping(value="/productsss", method=RequestMethod.GET)
	public ModelAndView getProductList(){
		IPoductDAO pd = new ProductDAO();
		ArrayList<Product> al = pd.getProducts();
		ModelAndView mv = new ModelAndView("listproducts");
		mv.addObject("arl",al);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/productss", method=RequestMethod.GET)
	public ArrayList<Product> JSonProductList(){
		IPoductDAO pd = new ProductDAO();
		ArrayList<Product> al = pd.getProducts();	
		return al;
		
	}
	
	
	@RequestMapping(value="/privatePage", method=RequestMethod.GET)
	public ModelAndView getProductPrivateList(Principal p){
		ModelAndView mv = new ModelAndView("privatePage");
		
		mv.addObject("user", p.getName());
		return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage() {
		
		return "login";
	}	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutPage() {
		
		return "Product";
	}	
}
