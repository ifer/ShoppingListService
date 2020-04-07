package ifer.web.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifer.web.shopping.db.Category;
import ifer.web.shopping.form.CategoryForm;
import ifer.web.shopping.repo.CategoryRepo;
import ifer.web.shopping.repo.ProductRepo;
import ifer.web.shopping.repo.ShoplistRepo;


@RestController
public class ShoppingListController {
	private static final Logger log = LogManager.getLogger(ShoppingListController.class.getName());
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ShoplistRepo shoplistRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	@RequestMapping(method=RequestMethod.GET, value={"", "/", "/**", "/patients/**"})
	public String index() {
		return "index";
	}	
	
  	@RequestMapping(method=RequestMethod.GET, value = "/api/category")
  	public Category getCategoryById (@RequestParam("id") int catid){
  		Category category = categoryRepo.findByCatid(catid);
  		return category;
  	}
  	
  	@RequestMapping(method=RequestMethod.GET, value = "/api/categorylist")
  	public List<CategoryForm> getCategoryList (){
		List<Category> catlist = categoryRepo.findAll();
		List<CategoryForm> catformList = new ArrayList<CategoryForm>();
		for (Category cat : catlist) {
			CategoryForm cf = new CategoryForm(cat);
			catformList.add(cf);
		}
		return catformList;
  	}
  	
	
}
