package Cyberknights.Pidev.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Cyberknights.Pidev.Model.Categoryproduct;
import Cyberknights.Pidev.Model.Product;

public interface ProductRepository<P> extends JpaRepository<Product, Long> {

	
	List<Product> findByName(String name);

	List<Product> findByBarcode(String barcode);


	long countByCategory(String category);

	long count();


}
