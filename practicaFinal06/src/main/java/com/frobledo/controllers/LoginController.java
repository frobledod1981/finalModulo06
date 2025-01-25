package com.frobledo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.frobledo.dto.UsuarioDTO;
import com.frobledo.service.AlumnoFrontService;
import com.frobledo.service.AuthService;
import com.frobledo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private AuthService authRestService;
	@Autowired
	private AlumnoFrontService alumnoRestService;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new UsuarioDTO());
		return "login";
	}

	@PostMapping("/signin")
	public String signin(@ModelAttribute UsuarioDTO user, HttpSession session, Model model) {
		String token = authRestService.signin(user);
		session.setAttribute("token", token);
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		String token = (String) session.getAttribute("token");
		model.addAttribute("alumnos", alumnoRestService.findAll(token));
		return "home";
	}

}
