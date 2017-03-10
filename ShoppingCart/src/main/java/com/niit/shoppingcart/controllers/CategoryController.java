package com.niit.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {

	// category.jsp -addCategory,deleteCategory, showCatrgoryList,
	// updateCategory,editCategory
	// to get all categories from database

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;

	/*public ModelAndView getAllCategories() {
		ModelAndView mv = new ModelAndView("/AdminHome");
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		mv.addObject("isUserClickedCategory", true);
		return mv;
	}*/

	@PostMapping("/manage_category_create")

	public ModelAndView createCategory(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		if (categoryDAO.save(category)) {
			mv.addObject("message", "seccessfully created the category");
		} else {
			mv.addObject("message", "Not able to create Cateory. please contact Adminstrator");
		}
		return mv;
	}

	@GetMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)

	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		Category category = (Category)categoryDAO.getCategoryByID(id);
		if (categoryDAO.delete(category)) {
			mv.addObject("message", "Successfuly deleted the category");
		} else {
			mv.addObject("message", "Not able to delete the category so please contact adminstrator");
		}
		return mv;
	}
}
