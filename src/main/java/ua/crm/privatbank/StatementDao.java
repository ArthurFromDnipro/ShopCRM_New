package ua.crm.privatbank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.crm.privatbank.Statement;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 07.09.2016.
 */
public interface StatementDao extends JpaRepository<Statement, Integer> {
    @Query("SELECT s FROM Statement s left join s.statementDB d where d.appcode is null")
    List<Statement> getNewStatement();
}

