package ua.crm.opencart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Oleg on 04.10.2016.
 */
public interface CaregoryDao extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c where c.top=false and c.status=true")
    List<Category> findAllWithParent();
}
