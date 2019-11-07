package it.distributedsystemsm.controller;

import it.distributedsystemsm.model.Customer;
import it.distributedsystemsm.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

//	@GetMapping("/")
//	public String customerForm(Locale locale, Model model) {
//		model.addAttribute("customers", customerService.list());
//		return "editUsers";
//	}
	
//	@ModelAttribute("customer")
//    public Customer formBackingObject() {
//        return new Customer();
//    }

	@PostMapping("/addCustomer")
	public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			model.addAttribute("customers", customerService.list());
			return "editUsers";
		}

		customerService.save(customer);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("customermsg", "Customer is correctly added!");

		return "redirect:/manageCustomers";
	}

	// delete customer
	@RequestMapping(value = "/customers/{name}/deleteName", method = RequestMethod.GET)
	public String deleteUserbyName(@PathVariable("name") String name, final RedirectAttributes redirectAttributes) {

		System.out.println("deleteCustomer() : {}" + name);

		customerService.delete(name);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("customermsg", "Customer is deleted!");

		return "redirect:/manageCustomers";

	}

	// delete customer
	@RequestMapping(value = "/customers/{id}/delete", method = RequestMethod.GET)
	public String deleteUserbyId(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		System.out.println("deleteCustomer() : {}" + id);

		customerService.delete(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("customermsg", "Customer is deleted!");

		return "redirect:/manageCustomers";

	}
}
