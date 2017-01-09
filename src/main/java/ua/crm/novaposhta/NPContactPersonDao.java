package ua.crm.novaposhta;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Oleg on 02.09.2016.
 */
public interface NPContactPersonDao  extends JpaRepository<NPContactPerson, String> {

}
