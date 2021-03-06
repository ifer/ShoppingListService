package ifer.web.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import ifer.web.shopping.db.Category;
import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Shopitem;
import ifer.web.shopping.db.User;
import ifer.web.shopping.form.CategoryForm;
import ifer.web.shopping.form.CurrentUserForm;
import ifer.web.shopping.form.ProductForm;
import ifer.web.shopping.form.ShopitemForm;
import ifer.web.shopping.form.ShopitemPrintForm;
import ifer.web.shopping.form.UserForm;
import ifer.web.shopping.repo.CategoryRepo;
import ifer.web.shopping.repo.ProductRepo;
import ifer.web.shopping.repo.ShopitemRepo;
import ifer.web.shopping.repo.UserRepo;
import ifer.web.shopping.util.DataException;


@RestController
public class ShoppingListController {
	private static final Logger log = LogManager.getLogger(ShoppingListController.class.getName());
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ShopitemRepo shopitemRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private UserRepo userRepo;

	
//	@RequestMapping(method=RequestMethod.GET, value={"", "/", "/**", "/patients/**"})
//	public String index() {
//		return "index";
//	}	
	
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
  	
	@RequestMapping(method = RequestMethod.POST, value = "/api/updatecategory")
	public  ResponseMessage addOrUpdateCategory (@RequestBody CategoryForm catform) {
		Category category = null;
		try {
			category = categoryRepo.addOrUpdateCategory(catform);
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		if (category != null){
			return (new ResponseMessage (0, "OK", String.valueOf(category.getCatid())));
		}
		else
			return (new ResponseMessage (-1, "UKNOWN ERROR"));
	
	}  	
  	
	@RequestMapping(method = RequestMethod.POST, value = "/api/delcategory")
	public  ResponseMessage deleteCategory (@RequestBody CategoryForm catform) {
//		Category category = null;
		try {
			categoryRepo.deleteCategory(catform.getCatid());
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		return (new ResponseMessage (0, "OK"));
		
	}	
	
 	@RequestMapping(method=RequestMethod.GET, value = "/api/product")
  	public Product getProductById (@RequestParam("id") int prodid){
  		Product product = productRepo.findByProdid(prodid);
  		return product;
  	}
  	
  	@RequestMapping(method=RequestMethod.GET, value = "/api/productlist")
  	public List<ProductForm> getProductList (){
		List<Product> prodlist = productRepo.findAll();
		List<ProductForm> prodformList = new ArrayList<ProductForm>();
		for (Product prod : prodlist) {
			ProductForm pf = new ProductForm(prod);
			prodformList.add(pf);
		}
		return prodformList;
  	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/updateproduct")
	public  ResponseMessage addOrUpdateProduct (@RequestBody ProductForm prodform) {
		Product product = null;
		try {
			product = productRepo.addOrUpdateProduct(prodform);
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		if (product != null){
			return (new ResponseMessage (0, "OK", String.valueOf(product.getProdid())));
		}
		else
			return (new ResponseMessage (-1, "UKNOWN ERROR"));
	
	}  	
  	
	@RequestMapping(method = RequestMethod.POST, value = "/api/delproduct")
	public  ResponseMessage deleteProduct (@RequestBody ProductForm prodform) {
		try {
			productRepo.deleteProduct(prodform.getProdid());
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		return (new ResponseMessage (0, "OK"));
		
	}	
  	
  	@RequestMapping(method=RequestMethod.GET, value = "/api/shopitem")
  	public Shopitem getShopitemById (@RequestParam("id") int itemid){
  		Shopitem shopitem = shopitemRepo.findByItemid(itemid);
  		return shopitem;
  	}
  	
  	@RequestMapping(method=RequestMethod.GET, value = "/api/shopitemlist")
  	public List<ShopitemForm> getShopitemList (){
		List<Shopitem> shopitemList = shopitemRepo.findAll();
		List<ShopitemForm> shopitemformList = new ArrayList<ShopitemForm>();
		for (Shopitem si : shopitemList) {
			ShopitemForm sif = new ShopitemForm(si);
			shopitemformList.add(sif);
		}
		return shopitemformList;
  	}
  	
	  	@RequestMapping(method=RequestMethod.GET, value = "/api/shopitemprintlist")
	  	public List<ShopitemPrintForm> getShopitemPrintList (){
	  			List<Shopitem> shopitemList = shopitemRepo.findShopitemPrintList();
	  			List<ShopitemPrintForm> spfList = new ArrayList<ShopitemPrintForm>();
	
	  			for (Shopitem si : shopitemList) {
	  				ShopitemPrintForm spf = new ShopitemPrintForm();
	  				spf.setProductName(si.getProduct().getDescr());
	  				spf.setCategoryName(si.getProduct().getCategory().getDescr());
	  				spf.setQuantity(si.getQuantity());
	  				
	  				spfList.add(spf);
	  			}
	  			
	  			
	  			return (spfList);
	  	}

//  	@RequestMapping(method=RequestMethod.GET, value = "/api/shopitemprintlist")
//  	public List<ShopitemPrintForm> getShopitemPrintList (){
//  			List<Shopitem> shopitemList = shopitemRepo.findShopitemPrintList();
//  			List<ShopitemPrintForm> spfList = new ArrayList<ShopitemPrintForm>();
//
//  			String prevCategory = "";
//  			for (Shopitem si : shopitemList) {
//  				ShopitemPrintForm spf = new ShopitemPrintForm();
//  				if (! si.getProduct().getCategory().getDescr().equals(prevCategory)){
//  					spf.setCategoryName(si.getProduct().getCategory().getDescr());
//  					spfList.add(spf);
//  					prevCategory = si.getProduct().getCategory().getDescr();
//  					spf = new ShopitemPrintForm();
//  				}
//				spf.setProductName(si.getProduct().getDescr());
//  				spf.setCategoryName(si.getProduct().getCategory().getDescr());
//  				spf.setQuantity(si.getQuantity());
//				prevCategory = si.getProduct().getCategory().getDescr();
// 				
//  				spfList.add(spf);
//  			}
//  			
//  			
//  			return (spfList);
//  	}
	
  	
	@RequestMapping(method = RequestMethod.POST, value = "/api/updateshopitem")
	public  ResponseMessage addOrUpdateShopitem (@RequestBody ShopitemForm shopitemform) {
		Shopitem shopitem = null;
		try {
			shopitem = shopitemRepo.addOrUpdateShopitem (shopitemform);
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		if (shopitem != null){
			return (new ResponseMessage (0, "OK", String.valueOf(shopitem.getItemid())));
		}
		else
			return (new ResponseMessage (-1, "UKNOWN ERROR"));
	
	}  	
  	
	@RequestMapping(method = RequestMethod.POST, value = "/api/delshopitem")
	public  ResponseMessage deleteShopitem (@RequestBody ShopitemForm siform) {
		try {
			shopitemRepo.deleteShopitem(siform.getItemid());
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		return (new ResponseMessage (0, "OK"));
		
	}	
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/addshopitemlist")
	public  ResponseMessage addShopitemList (@RequestBody List<ShopitemForm> shopitemList) {
		try {
			shopitemRepo.addShopitemList (shopitemList);
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		return (new ResponseMessage (0, "OK", String.valueOf(shopitemList.size())));
	
	}  	

	@RequestMapping(method = RequestMethod.POST, value = "/api/delshopitemlist")
	public  ResponseMessage deleteShopitemList (@RequestBody List<ShopitemForm> shopitemList) {
		try {
			shopitemRepo.deleteShopitemList (shopitemList);
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		return (new ResponseMessage (0, "OK", String.valueOf(shopitemList.size())));
	
	}  	
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/delallshopitems")
	public  ResponseMessage deleteAllShopitems () {
		try {
			shopitemRepo.deleteAll ();
		} catch (Exception e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		return (new ResponseMessage (0, "OK", null));
	
	}  
	
	@RequestMapping(value="/api/currentuserdata", method = RequestMethod.GET)
	public @ResponseBody CurrentUserForm getCurrentUserData() {

	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      
	      CurrentUserForm cuf = new CurrentUserForm();
	      
	      
	      cuf.setName(auth.getName()); //logged in username
	      
	      List<String> roleList = new ArrayList<String>();
	      
	       for (GrantedAuthority ga : auth.getAuthorities()) {
//	    	   System.out.println("Authority: " + ga.getAuthority());
	    	   roleList.add(ga.getAuthority());
	        }	      
	      cuf.setRoles(roleList);
	      return (cuf);

	  }		 

	 
	 @RequestMapping(method = RequestMethod.GET, value="/api/logout")
	 public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     if (auth != null){    
	    	 SecurityContextLogoutHandler sclh = new SecurityContextLogoutHandler();
	    	 sclh.setInvalidateHttpSession(true);
	    	 sclh.logout(request, response, auth);
	     }
	     return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//	     return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	 }	 
	
	 
	@RequestMapping(method = RequestMethod.GET, value = "/api/users")
	public @ResponseBody List<User> getUsers () {
		
		List<User> userList = null;
		userList = (List<User>) userRepo.findAll();

		return (userList);
		
	}  		 

	@RequestMapping(method = RequestMethod.POST, value = "/api/updateuser")
	public @ResponseBody ResponseMessage updateUser (@RequestBody UserForm userForm) {
			
		User user;
		try {
			user = userRepo.addOrUpdateUser(userForm);
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}
		
		if (user != null)
			return (new ResponseMessage (0, "OK"));
		else
			return (new ResponseMessage (-1, "UKNOWN ERROR"));
		
	}	
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/updatepassword")
	public @ResponseBody ResponseMessage updatePassword (@RequestBody UserForm userForm) {
			
		User user = null;
		try {
			user = userRepo.updatePassword(userForm);
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}
		
		if (user != null)
			return (new ResponseMessage (0, "OK"));
		else
			return (new ResponseMessage (-1, "UKNOWN ERROR"));
		
	}	
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/deluser")
	public @ResponseBody ResponseMessage deleteUser (@RequestBody UserForm userForm) {
		
		if (userForm == null){
			return (new ResponseMessage (-1, "User form is Null"));
		}
		
		try {
			userRepo.deleteUser(userForm.getUserid());;
		} catch (DataException e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}
		return (new ResponseMessage (0, "OK"));
		
	} 			
	
	
}
