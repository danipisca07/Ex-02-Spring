package it.distributedsystemsm.controller;

import it.distributedsystemsm.model.*;
import it.distributedsystemsm.service.*;

import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


@Controller
public class HomeController {

	final static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProducerService producerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String homePage(Locale locale, Model model) {

		logger.info("==============>>		Redirecting to the home page		<<==============");

//		HashMap<String, List> attributes = new HashMap<String, List>();
//		attributes.put("producers",producerService.list());
//		attributes.put("customers", customerService.list());
//		attributes.put("products", productService.list());
//		attributes.put("purchases", purchaseService.list());
//		attributes.put("users", userService.list());
//		model.addAllAttributes(attributes);

		model.addAttribute("producers", producerService.list());
		logger.info("Model: " + model.toString() );

		model.addAttribute("customers", customerService.list());
		logger.info("Model: " + model.toString() );

		model.addAttribute("products", productService.list());
		logger.info("Model: " + model.toString() );

//		model.addAttribute("purchases", purchaseService.list());
//		logger.info("Model: " + model.toString() );

		model.addAttribute("users", userService.list());
		logger.info("Model: " + model.toString() );

		return "editUsers";
	}

	//==================================================================================================================

	@GetMapping("/manageCustomers")
	public String customersPage(Locale locale, Model model) {

		logger.info("==============>>		Redirecting to the customers page		<<==============");

		model.addAttribute("customers", customerService.list());
		logger.info("Model: " + model.toString() );

		return "manageCustomers";
	}

	@GetMapping("/manageProducts")
	public String productsPage(Locale locale, Model model) {

		logger.info("==============>>		Redirecting to the products page		<<==============");

		model.addAttribute("products", productService.list());
		logger.info("Model: " + model.toString() );

		return "manageProducts";
	}

	@GetMapping("/manageProducers")
	public String producersPage(Locale locale, Model model) {

		logger.info("==============>>		Redirecting to the producers page		<<==============");

		model.addAttribute("producers", producerService.list());
		logger.info("Model: " + model.toString() );

		return "manageProducers";
	}

	@GetMapping("/managePurchases")
	public String purchasesPage(Locale locale, Model model) {

		logger.info("==============>>		Redirecting to the purchases page		<<==============");

		model.addAttribute("purchases", purchaseService.list());
		logger.info("Model: " + model.toString() );

		return "managePurchases";
	}

	//==================================================================================================================

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userList(final RedirectAttributes redirectAttributes, Model model) {

		logger.info("==============>>		Loading Users		<<==============");

		model.addAttribute("users", userService.list());

		logger.info("Model: " + model.toString() );

		return "redirect:/";
	}

	@RequestMapping(value = "/producerList", method = RequestMethod.GET)
	public String producerList(final RedirectAttributes redirectAttributes, Model model) {

		logger.info("==============>>		Loading Producers		<<==============");

		model.addAttribute("producers", producerService.list());

		logger.info("Model: " + model.toString() );

		return "redirect:/";
	}

	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String productList(final RedirectAttributes redirectAttributes, Model model) {

		logger.info("==============>>		Loading Products		<<==============");

		model.addAttribute("products", productService.list());

		logger.info("Model: " + model.toString() );

		return "redirect:/";
	}

	@RequestMapping(value = "/purchaseList", method = RequestMethod.GET)
	public String purchaseList(final RedirectAttributes redirectAttributes, Model model) {

		logger.info("==============>>		Loading Purchases		<<==============");

		model.addAttribute("purchases", purchaseService.list());

		logger.info("Model: " + model.toString() );

		return "redirect:/";
	}

	@RequestMapping(value = "/customerList", method = RequestMethod.GET)
	public String customerList(final RedirectAttributes redirectAttributes, Model model) {

		logger.info("==============>>		Loading Customers		<<==============");

		model.addAttribute("customers", purchaseService.list());

		logger.info("Model: " + model.toString() );

		return "redirect:/";
	}


	@ModelAttribute("user")
	public User formBackingUser() {	return new User(); }

	@ModelAttribute("customer")
	public Customer formBackingCustomer() {	return new Customer();	}

	@ModelAttribute("product")
	public Product formBackingProduct() {
		return new Product();
	}

	@ModelAttribute("producer")
	public Producer formBackingProducer() {
		return new Producer();
	}

	@ModelAttribute("purchase")
	public Purchase formBackingPurchase() {
		return new Purchase();
	}
}
