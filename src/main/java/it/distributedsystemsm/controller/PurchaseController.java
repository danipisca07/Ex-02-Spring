package it.distributedsystemsm.controller;

import it.distributedsystemsm.model.Purchase;

import it.distributedsystemsm.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

//	@GetMapping("/")
//	public String purchaseForm(Locale locale, Model model) {
//		model.addAttribute("purchases", purchaseService.list());
//		return "editUsers";
//	}
	
//	@ModelAttribute("purchase")
//    public Purchase formBackingObject() {
//        return new Purchase();
//    }

	@PostMapping("/addPurchase")
	public String savePurchase(@ModelAttribute("purchase") @Valid Purchase purchase, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("purchases", purchaseService.list());
			return "editUsers";
		}

		purchaseService.save(purchase);
		return "redirect:/managePurchases";
	}

	// delete purchase
	@RequestMapping(value = "/purchases/{id}/delete", method = RequestMethod.GET)
	public String deletePurchase(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		System.out.println("deletePurchase() : " + id);

		purchaseService.delete(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("purchasemsg", "Purchase is deleted!");

		return "redirect:/managePurchases";

	}
}
