package Cyberknights.Pidev.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Cyberknights.Pidev.Model.Categoryproduct;
import Cyberknights.Pidev.Model.Product;
import Cyberknights.Pidev.Repository.CategoryproductRepository;

@Service
public class CategoryproductService {

	@Autowired
	CategoryproductRepository<Categoryproduct> CategoryRepository;


	@Transactional
	public List<Categoryproduct> getAllCategory() {
		return (List<Categoryproduct>) CategoryRepository.findAll(Sort.by("id").ascending());
	}

	@Transactional
	public  Categoryproduct addCategory(Categoryproduct Categoryproduct) {
		return CategoryRepository.save(Categoryproduct) ;
	}

	@Transactional
	public  Categoryproduct updateCategory(Categoryproduct Categoryproduct) {
		return CategoryRepository.save(Categoryproduct) ;
	}

	@Transactional
	public boolean deleteCategory(Long CategoryId) {
		CategoryRepository.deleteById(CategoryId);
		return !CategoryRepository.existsById(CategoryId);

	}

}
