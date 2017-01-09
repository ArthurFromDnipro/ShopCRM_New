package ua.crm.DB;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Oleg on 09.09.2016.
 */
public interface RefusedOrdersDao extends JpaRepository<RefusedOrders, Integer> {
}
