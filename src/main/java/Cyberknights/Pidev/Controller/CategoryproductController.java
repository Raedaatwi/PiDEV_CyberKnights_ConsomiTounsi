package Cyberknights.Pidev.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import Cyberknights.Pidev.Model.CategoryPDFExporter;
import Cyberknights.Pidev.Model.Categoryproduct;
import Cyberknights.Pidev.Model.Product;
import Cyberknights.Pidev.Model.ProductPDFExporter;
import Cyberknights.Pidev.Repository.CategoryproductRepository;
import Cyberknights.Pidev.Service.CategoryproductService;
import Cyberknights.Pidev.Service.ProductService;
import org.springframework.http.ResponseEntity;  

@RestController
public class CategoryproductController {

	@Autowired
	CategoryproductService CategoryService;
	ProductService productService;

	
	
	
	
	  @GetMapping("/Categoryproduct/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=CategoryService_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue); 
	         
	        List<Categoryproduct> listCategories = CategoryService.getAllCategory();
	         
	        CategoryPDFExporter exporter = new CategoryPDFExporter(listCategories);
	        exporter.export(response);
	         
	    }
	// Affichage all products
	@RequestMapping(value = "/DisplayAllCategory", method = RequestMethod.GET)
	public List<Categoryproduct> getAll() {
		return CategoryService.getAllCategory();
	}
	
   
	
	@RequestMapping(value = "/AddCategory", method = RequestMethod.POST)
	public boolean addCategory(@RequestBody Categoryproduct Categoryproduct) {
		return CategoryService.addCategory(Categoryproduct) ;
	}

	@RequestMapping(value = "/DeleteCategory/{id}", method = RequestMethod.DELETE)
	public boolean deleteCategory(@PathVariable Long id) {
		return CategoryService.deleteCategory(id) ;

	}

	@PutMapping(value = "/ModifyCategory")
	public boolean updateCategory(@RequestBody Categoryproduct Categoryproduct) {
		return CategoryService.updateCategory(Categoryproduct) ;
	}

}
