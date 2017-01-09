package ua.crm.opencart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 05.10.2016.
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query("SELECT DISTINCT p FROM Product p inner join p.productDescriptions pd inner join p.productToCategory pc inner join pc.category c  where pd.language.languageId=3 and c.status=true and p.status=true and c.categoryId=CASE :category WHEN 0 THEN c.categoryId ELSE :category END and lower(concat(pd.name,' ',p.model)) LIKE :name")
    List<Product> findWithFilterCategoryName(@Param("category") Integer category, @Param("name") String name);

}