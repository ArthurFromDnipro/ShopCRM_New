package ua.crm.novaposhta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
public interface NPWarehousesDao  extends JpaRepository<NPWarehouses, String> {
    @Query("SELECT w FROM NPWarehouses w where w.npCities.ref = :cities ORDER BY w.number ASC")
    List<NPWarehouses> findByCities(@Param("cities") String cities);

    @Query("SELECT w FROM NPWarehouses w where w.npCities.ref = :cities and w.number=:number ORDER BY w.number ASC")
    NPWarehouses findByCitiesNum(@Param("cities") String cities, @Param("number") Integer number);
}
