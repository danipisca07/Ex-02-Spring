package it.distributedsystemsm.controller;

import it.distributedsystemsm.model.User;
import it.distributedsystemsm.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

//	@GetMapping("/")
//	public String userForm(Locale locale, Model model) {
//		model.addAttribute("users", userService.list());
//		return "editUsers";
//	}

//	@ModelAttribute("user")
//    public User formBackingObject() {
//        return new User();
//    }

	@PostMapping("/addUser")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("users", userService.list());
			return "editUsers";
		}

		userService.save(user);
//		return "editUsers";
		return "redirect:/userList";
	}

//	@PostMapping("/refreshUsers")
//	public String refreshUsers(Model model) {
//
//		model.addAttribute("users", userService.list());
//
//		return "redirect:/userList";
//	}

	// delete user
	@RequestMapping(value = "/users/{name}/deleteName", method = RequestMethod.GET)

	public String deleteUserByName(@PathVariable("name") String name, final RedirectAttributes redirectAttributes) {

		System.out.println("deleteUser() : " + name);

		userService.delete(name);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("usermsg", "User is deleted!");

//		return "editUsers";
		return "redirect:/userList";
	}

	// delete user
	@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)

	public String deleteUserById(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		System.out.println("deleteUser() : " + id);

		userService.delete(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("usermsg", "User is deleted!");

//		return "editUsers";
		return "redirect:/userList";
	}
}
