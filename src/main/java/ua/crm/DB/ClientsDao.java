package ua.crm.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Oleg on 07.09.2016.
 */
public interface ClientsDao extends JpaRepository<Clients, Integer> {

    @Query("SELECT c FROM Clients c where lower(concat(c.firstName,' ',c.lastName)) LIKE :name and c.tel LIKE :tel ORDER BY c.lastName ASC")
    List<Clients> findByNameTel(@Param("name") String name, @Param("tel") String tel);

    @Query("SELECT c FROM Clients c where c.tel=:tel and c.firstName<>'###fastorder###'")
    Clients getOneByTel(@Param("tel") String tel);


}
