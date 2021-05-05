package Cyberknights.Pidev.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Cyberknights.Pidev.Model.Categoryproduct;
import Cyberknights.Pidev.Model.Product;
import Cyberknights.Pidev.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository<Product> productRepository;

	@Transactional
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	@Transactional
	public List<Product> findByBarcode(String barcode) {
		return productRepository.findByBarcode(barcode);
	}
	


	@Transactional
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll(Sort.by("name").ascending());
	}

	@Transactional
	public void deleteProduct(Long productId)  {
	
		 productRepository.deleteById(productId);

	}

	@Transactional
	public  Product addProduct(Product product) {
		return  productRepository.save(product) ;
	}

	@Transactional
	public Product updateProduct(Product product) {
		return productRepository.save(product) ;
	}

	@Transactional
	public Product Addlikes(Product product)  {
		
	product.setLikes(product.getLikes()+1);
		return productRepository.save(product);
	}
	
	@Transactional
	public Product Dislike(Product p) 
		p.setLikes(p.getLikes()-1);
		return productRepository.save(p) ;
	}
	
	
	
	@Transactional
	public Long count() {

		return productRepository.count();
	}

	

}
