package ua.crm.opencart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 13.10.2016.
 */
public interface OrderDao extends JpaRepository<Currency, Integer> {
    @Query("SELECT o FROM Order o left join o.orders c where day(o.dateAdded) = day(:importDate) and  month(o.dateAdded) = month(:importDate) and year(o.dateAdded) = year(:importDate) and c.order is null ORDER BY o.orderId ASC")
    List<Order> findNotImportedByDate(@Param("importDate") Date importDate);

}
