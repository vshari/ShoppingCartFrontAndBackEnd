package com.niit.shoppingcart.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Controller
public class HomeController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	@Autowired

	private HttpSession session;

	// http://localhost:8080/ShopppingCart/

	@RequestMapping("/")
	public ModelAndView showHomePage()

	{
		System.out.println("Starting the method home page");

		ModelAndView mv = new ModelAndView("/home");

		mv.addObject("msg", "Welcome to Shopping Cart");

		return mv;

	}

	@RequestMapping("/login")

	public ModelAndView showLoginPage()

	{

		System.out.println("clicked login page");

		ModelAndView mv = new ModelAndView("/home");

		mv.addObject("hasClickedLogin", "true");

		return mv;

	}

	@RequestMapping("/register")

	public ModelAndView showRegistrationPage()

	{

		System.out.println("clicked registration page");

		ModelAndView mv = new ModelAndView("/home");

		mv.addObject("hasClickedRegistration", "true");

		return mv;

	}

	@RequestMapping("/validate")

	public ModelAndView validateCredentials(@RequestParam("userID") String id,

			@RequestParam("password") String pwd)

	{

		// Actually you have to get the data from database

		// temp user->niit password = niit@123

		ModelAndView mv = new ModelAndView("/home");
		// march 8th below line
		mv.addObject("isUserLoggedIn", "false");

		// if (id.equals("niit") && pwd.equals("niit@123"))
		if (userDAO.validate(id, pwd) == true)

		{
			// mv.addObject("msg", "Welcome to Shopping Cart");-->march 8th TL
			mv.addObject("isUserLoggedIn", "true");
			user = userDAO.getUser(id);
			if (user.getRole().equals("ROLE_ADMIN")) {
				mv.addObject("isAdmin", "true");
			}

			else {
				mv.addObject("isAdmin", "false");
			}
			mv.addObject("successMessage", "Valid Credentials");

			session.setAttribute("loginMessage", "Welcome :" + id);

		}

		else

		{

			mv.addObject("errorMessage", "InValid Credentials , please try again ");

		}

		return mv;

	}

	@RequestMapping("/logout")

	public ModelAndView logout()

	{

		ModelAndView mv = new ModelAndView("/home");

		// session.invalidate();

		session.removeAttribute("loginMessage");

		return mv;

	}

}