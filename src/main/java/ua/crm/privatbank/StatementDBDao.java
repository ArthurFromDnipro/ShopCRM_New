package ua.crm.privatbank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 19.10.2016.
 */
public interface StatementDBDao extends JpaRepository<StatementDB, String> {
    @Query("SELECT s FROM StatementDB s where s.trandate>=:from and s.trandate<=:to and s.amount>0 order by s.trandate ASC")
    List<StatementDB> getByDate(@Param("from") Date from, @Param("to") Date to);
}
