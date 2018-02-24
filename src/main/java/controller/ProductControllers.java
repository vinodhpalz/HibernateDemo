package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Product;
import model.ProductDAO;

@Controller
public class ProductControllers {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView productsPage() {
		ModelAndView view = new ModelAndView("Product");
		
		return view;
	}
	
	@RequestMapping(value="/success", method=RequestMethod.POST)
	public ModelAndView productSuccess(@ModelAttribute("product1") Product product, BindingResult result) {
			
		ModelAndView view = new ModelAndView("success");
		view.addObject("productName",product.getPname());
		
		ProductDAO pd = new ProductDAO();
		pd.insertProduct(product);
		
		
		return view;
		
	}
}
