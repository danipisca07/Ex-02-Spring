package it.distributedsystemsm.controller;

import it.distributedsystemsm.model.Producer;
import it.distributedsystemsm.service.ProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProducerController {

	@Autowired
	private ProducerService producerService;

//	@GetMapping("/")
//	public String producerForm(Locale locale, Model model) {
//		model.addAttribute("producers", producerService.list());
//		return "editUsers";
//	}
	
//	@ModelAttribute("producer")
//    public Producer formBackingObject() {
//        return new Producer();
//    }

	@PostMapping("/addProducer")
	public String saveProducer(@ModelAttribute("producer") @Valid Producer producer, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("producers", producerService.list());
			return "editUsers";
		}

		producerService.save(producer);
//		return "editUsers";
		return "redirect:/manageProducers";
	}

	// delete producer
	@RequestMapping(value = "/producers/{name}/deleteName", method = RequestMethod.GET)
	public String deleteProducerbyName(@PathVariable("name") String name, final RedirectAttributes redirectAttributes) {

		System.out.println("deleteProducer() : " + name);

		producerService.delete(name);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("producermsg", "Producer is deleted!");

		return "redirect:/manageProducers";
	}

	@RequestMapping(value = "/producers/{id}/delete", method = RequestMethod.GET)
	public String deleteProducerbyId(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		System.out.println("deleteProducer() :" + id);

		producerService.delete(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("producermsg", "Producer is deleted!");

		return "redirect:/manageProducers";
	}
}
