package ua.crm.novaposhta;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Oleg on 26.08.2016.
 */
public interface NPAreaDao extends JpaRepository<NPArea, String> {
//    @Query("SELECT m FROM Message m where m.date > :fromDate ORDER BY m.date ASC")
//     List<Message> findByDate(@Param("fromDate") Date from);
}
