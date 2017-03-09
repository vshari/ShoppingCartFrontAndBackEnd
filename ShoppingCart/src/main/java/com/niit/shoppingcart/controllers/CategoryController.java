package com.niit.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {
	
	//category.jsp -addCategory,deleteCategory, showCatrgoryList, updateCategory,editCategory
	//to get all categories from database
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	
	public ModelAndView getAllCategories()
	{
		ModelAndView mv = new ModelAndView("/AdminHome");
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList",categoryList);
		mv.addObject("isUserClickedCategory",true);
		return mv;
		
	}

}
