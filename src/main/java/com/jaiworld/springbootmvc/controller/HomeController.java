/**
 * 
 */
package com.jaiworld.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jaideepvish
 *
 */

@Controller
public class HomeController {	
	
	@RequestMapping("home")
	public ModelAndView onHome() {		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

}
