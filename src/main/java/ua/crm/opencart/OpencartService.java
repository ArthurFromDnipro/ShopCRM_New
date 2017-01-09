package ua.crm.opencart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 04.10.2016.
 */
@Service
public class OpencartService {
    @Autowired
    private CaregoryDao caregoryDao;

    @Autowired
    private ProductDao productDao;
    @Autowired
    private CurrencyDao currencyDao;
    @Autowired
    private OrderDao orderDao;

    public List<Order> findOrdersNotImportedByDate(Date date) {
        return orderDao.findNotImportedByDate(date);
    }

    public List<Category> findCategoryWithParent() {
        return caregoryDao.findAllWithParent();
    }

    public List<Product> findProductWithFilterCategoryName(Integer category, String name) {
        return productDao.findWithFilterCategoryName(category, name);
    }

    public Category getOneCategory(Integer i) {
        return caregoryDao.getOne(i);
    }

    public Currency getOneCurrence(int i) {
        return currencyDao.getOne(i);
    }

    public Product getOneProduct(int i) {
        return productDao.getOne(i);

    }
}
