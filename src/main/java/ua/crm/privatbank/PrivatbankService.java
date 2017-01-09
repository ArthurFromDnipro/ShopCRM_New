package ua.crm.privatbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 26.08.2016.
 */
@Service
public class PrivatbankService {
    @Autowired
    private StatementDao statementDao;
    @Autowired
    private StatementDBDao statementDBDao;
    @Autowired
    private PrivatBank pb;

    @Transactional
    public void delStatement() {

        statementDao.deleteAllInBatch();
        statementDao.flush();
    }


    @Transactional
    public void updatePrivaBank() throws IOException, JAXBException {
        //statementDBDao.findAll().forEach(n -> System.out.println(n));

        delStatement();


        Calendar c1 = Calendar.getInstance();
        DateFormat day = new SimpleDateFormat("dd.MM.yyyy");

        String today = day.format(c1.getTime());

        c1.add(Calendar.DAY_OF_MONTH, -7);
        String from = day.format(c1.getTime());


        pb.accountDetails(from, today);

        pb.getDataResponse().getInfo().getStatements().getStatement().forEach(n -> {
            statementDao.save(n);
        });
        System.out.println("Statement temp updated");
        statementDao.flush();


    }

    @Transactional
    public void getNewStatement() {
        statementDao.getNewStatement().forEach(n -> {
            statementDBDao.save(n.getNewStatement());
//            statementDBDao.flush();
            statementDao.save(n);
  //          statementDao.flush();


        });

        ;

    }

    @Transactional(readOnly = true)
    public List<StatementDB> getStatementDBbyDate() {
        Calendar c1 = Calendar.getInstance();
        Date to = c1.getTime();
        c1.add(Calendar.DAY_OF_MONTH, -7);
        Date from = c1.getTime();

        return statementDBDao.getByDate(from, to);
    }

    public StatementDB getOneStatementDB(String appcode) {
        return statementDBDao.getOne(appcode);
    }

    public void saveStatementDB(StatementDB statementDB) {
        statementDBDao.save(statementDB);
    }


}
