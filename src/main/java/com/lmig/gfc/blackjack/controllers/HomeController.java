package com.lmig.gfc.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.BlackJackGame;

@Controller
public class HomeController {
	
	private BlackJackGame blackjackGame; 
	
	public HomeController() {
		blackjackGame = new BlackJackGame();
	}

	@GetMapping("/")
	public ModelAndView showApp() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("default");
		mv.addObject("blackjackGame", blackjackGame);
		return mv;
	}
	
	@PostMapping("/placeBet")
	public ModelAndView dealCards(int betAmount) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("default");
		mv.addObject("blackjackGame", blackjackGame);
		return mv;
	}
	
}
