package ifer.web.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifer.web.shopping.db.Category;
import ifer.web.shopping.db.Product;
import ifer.web.shopping.db.Shoplist;
import ifer.web.shopping.form.CategoryForm;
import ifer.web.shopping.form.ProductForm;
import ifer.web.shopping.form.ShoplistForm;
import ifer.web.shopping.repo.CategoryRepo;
import ifer.web.shopping.repo.ProductRepo;
import ifer.web.shopping.repo.ShoplistRepo;
import ifer.web.shopping.util.DataException;


@RestController
public class ShoppingListController {
	private static final Logger log = LogManager.getLogger(ShoppingListController.class.getName());
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ShoplistRepo shoplistRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
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
  	
  	@RequestMapping(method=RequestMethod.GET, value = "/api/shoplist")
  	public Shoplist getShoplistById (@RequestParam("id") int listid){
  		Shoplist shoplist = shoplistRepo.findByListid(listid);
  		return shoplist;
  	}
  	
  	@RequestMapping(method=RequestMethod.GET, value = "/api/shoplistlist")
  	public List<ShoplistForm> getShoplistList (){
		List<Shoplist> shoplistList = shoplistRepo.findAll();
		List<ShoplistForm> shoplistformList = new ArrayList<ShoplistForm>();
		for (Shoplist sl : shoplistList) {
			ShoplistForm slf = new ShoplistForm(sl);
			shoplistformList.add(slf);
		}
		return shoplistformList;
  	}


	@RequestMapping(method = RequestMethod.POST, value = "/api/updateshoplist")
	public  ResponseMessage addOrUpdateShoplist (@RequestBody ShoplistForm shoplistform) {
		Shoplist shoplist = null;
		try {
			shoplist = shoplistRepo.addOrUpdateShoplist(shoplistform);
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		if (shoplist != null){
			return (new ResponseMessage (0, "OK", String.valueOf(shoplist.getListid())));
		}
		else
			return (new ResponseMessage (-1, "UKNOWN ERROR"));
	
	}  	
  	
	@RequestMapping(method = RequestMethod.POST, value = "/api/delshoplist")
	public  ResponseMessage deleteShoplist (@RequestBody ShoplistForm slform) {
//		Shoplist shoplist = null;
		try {
			shoplistRepo.deleteShoplist(slform.getListid());
		} catch (DataException e) {
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			return (new ResponseMessage (-1, e.getLocalizedMessage()));
		}		
		
		return (new ResponseMessage (0, "OK"));
		
	}	
  	
	
}
