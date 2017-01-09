package ua.crm.novaposhta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
public interface NPCitiesDao extends JpaRepository<NPCities, String> {
    @Query("SELECT c FROM NPCities c where c.npArea.ref = :area ORDER BY c.description ASC")
    List<NPCities> findByArea(@Param("area") String area);

    @Query("SELECT c FROM NPCities c where LOWER(c.description) = :city or  LOWER(c.descriptionRu) = :city ORDER BY c.description ASC")
    NPCities findByCityName(@Param("city") String city);

}

