package com.lmig.gfc.blackjack.controllers; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.BlackJackGame;

@Controller
public class HomeController {
	
	private BlackJackGame blackjackGame; 
	
	public HomeController() {
		startGame();
	}
	
	public void startGame() {
		blackjackGame = new BlackJackGame();
	}

	@GetMapping("/")
	public ModelAndView showApp() {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("default");
		mv.addObject("blackjackGame", blackjackGame);
		return mv;
	}
	
	@PostMapping("/play")
	public ModelAndView play(int betAmount) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");
		blackjackGame.beginPlayActions(betAmount);
		mv.addObject("blackjackGame", blackjackGame); 
		return mv;
	}
	
	@PostMapping("/hit")
	public ModelAndView hit() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");
		blackjackGame.hit();
		mv.addObject("blackjackGame", blackjackGame); 
		return mv;
	}
	
	@PostMapping("/stand")
	public ModelAndView stand() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");
		blackjackGame.stand();
		mv.addObject("blackjackGame", blackjackGame); 
		return mv; 
	}
	
	@PostMapping("/contineGame") 
	public ModelAndView backToDefault() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		blackjackGame.continueGame();
		return mv;
	}
	
	@PostMapping("/restartGame")
	public ModelAndView restartGame() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		startGame();
		return mv;
	}
	
}
