package it.distributedsystemsm.controller;

import it.distributedsystemsm.model.Product;
import it.distributedsystemsm.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

//	@GetMapping("/")
//	public String productForm(Locale locale, Model model) {
//		model.addAttribute("products", productService.list());
//		return "editUsers";
//	}
	
//	@ModelAttribute("product")
//    public Product formBackingObject() {
//        return new Product();
//    }

	@PostMapping("/addProduct")
	public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("products", productService.list());
			return "editUsers";
		}

		productService.save(product);
		return "redirect:/manageProducts";
	}

	// delete product
	@RequestMapping(value = "/products/{name}/deleteName", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("name") String name, final RedirectAttributes redirectAttributes) {

		System.out.println("deleteProduct() : " + name);

		productService.delete(name);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("productmsg", "Product is deleted!");

		return "redirect:/manageProducts";
	}

	@RequestMapping(value = "/products/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		System.out.println("deleteProduct() : " + id);

		productService.delete(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("productmsg", "Product is deleted!");

		return "redirect:/manageProducts";

	}
}
