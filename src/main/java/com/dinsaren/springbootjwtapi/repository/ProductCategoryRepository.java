package com.dinsaren.springbootjwtapi.repository;

import com.dinsaren.springbootjwtapi.models.product.ProductCategory;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

}
