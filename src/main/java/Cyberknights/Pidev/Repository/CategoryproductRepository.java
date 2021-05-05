package Cyberknights.Pidev.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Cyberknights.Pidev.Model.Categoryproduct;
import Cyberknights.Pidev.Model.Product;

public interface CategoryproductRepository<C> extends JpaRepository<Categoryproduct, Long> {


}
