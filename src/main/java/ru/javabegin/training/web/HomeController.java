package ru.javabegin.training.web;
import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.javabegin.training.service.Process;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
    private Process process;

	@GetMapping(value="/user")
	public String user(){
        logger.info(process.getMessage());
//		print();
		return"/content/user";
	}
	private void print(){
		UserDetails userDetails=(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.info(userDetails.getUsername());
		logger.info(userDetails.toString());
	}
	
	@GetMapping(value="/admin")
	public String admin(){
		return"/content/admin";
	}
	
	@GetMapping(value="/accessDenied")
	public ModelAndView accessDenied(Principal user){
		System.out.println("--------------------------------------");
		ModelAndView result=new ModelAndView();
		if(user!=null)result.addObject("error","Жаба-крокодила, все дела, "+
		user.getName());else result.addObject("error","Дела пахнут керосином");
		result.setViewName("content/accessDenied");
		return result;
	}
	
	@GetMapping(value ={"/", "/login"})
	public ModelAndView home(@RequestParam(value= "error" ,required = false) String error) {
		logger.info("Welcome home! The client locale is {}.");
		ModelAndView model=new ModelAndView();
		if(error!=null)model.addObject("error","Стрелять-колотить");
		model.setViewName("login");
		return model;
	}	
}
