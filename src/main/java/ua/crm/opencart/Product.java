package ua.crm.opencart;

import ua.crm.DB.OrderDetails;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oc_product database table.
 */
@Entity
@Table(name = "crm_product")

public class Product {


    @Id
    @Column(name = "product_id")
    private int productId;

    //    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    private Date dateAdded;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_available")
    private Date dateAvailable;

    //    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified")
    private Date dateModified;

    private String ean;

    private BigDecimal height;

    private String image;

    private String isbn;

    private String jan;

    private BigDecimal length;

    @Column(name = "length_class_id")
    private int lengthClassId;

    private String location;

    @Column(name = "manufacturer_id")
    private int manufacturerId;

    private int minimum;

    private String model;

    private String mpn;

    private int points;

    private BigDecimal price;

    private int quantity;

    private boolean shipping;

    private String sku;

    @Column(name = "sort_order")
    private int sortOrder;

    private boolean status;

    @Column(name = "stock_status_id")
    private int stockStatusId;

    private boolean subtract;

    @Column(name = "tax_class_id")
    private int taxClassId;

    private String upc;

    private int viewed;

    private BigDecimal weight;

    @Column(name = "weight_class_id")
    private int weightClassId;

    private BigDecimal width;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REFRESH)
    private List<ProductDescription> productDescriptions = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REFRESH)
    private List<ProductToCategory> productToCategory = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REFRESH)
    private List<ProductSpecial> productSpecial = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REFRESH)
    private List<OrderProduct> orderProduct = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REFRESH)
    private List<OrderDetails> orderDetails = new ArrayList<>();


    public Product() {

    }

    public BigDecimal getCurrentPrice() {
        Date currentDate = new Date();
//        CurrencyDao currencyDao = new CurrencyDao();
//        Currency currency = currencyDao.getOne(1);
        ProductSpecial ps = productSpecial.stream().filter(n -> n.getDateStart().before(currentDate) && n.getDateEnd().after(currentDate)).min((a, b) -> a.getPrice().compareTo(b.getPrice())).get();
//.multiply(BigDecimal.valueOf(currency.getValue()))
        if (ps != null) {
            return ps.getPrice();
        } else {
            return price;
        }
    }

    public BigDecimal getCurrentPriceUAH(float currency) {
        return getCurrentPrice().multiply(BigDecimal.valueOf(currency)).setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public ProductDescription getProductDescriptionsUA() {
        final ProductDescription[] pD = {new ProductDescription()};

        productDescriptions.forEach(n -> {
            if (n.getLanguage().getLanguageId() == 3) {
                pD[0] = n;
            }
        });

        return pD[0];
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateAvailable() {
        return this.dateAvailable;
    }

    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public Date getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getEan() {
        return this.ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public BigDecimal getHeight() {
        return this.height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJan() {
        return this.jan;
    }

    public void setJan(String jan) {
        this.jan = jan;
    }

    public BigDecimal getLength() {
        return this.length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public int getLengthClassId() {
        return this.lengthClassId;
    }

    public void setLengthClassId(int lengthClassId) {
        this.lengthClassId = lengthClassId;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getManufacturerId() {
        return this.manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getMinimum() {
        return this.minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMpn() {
        return this.mpn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getStockStatusId() {
        return this.stockStatusId;
    }

    public void setStockStatusId(int stockStatusId) {
        this.stockStatusId = stockStatusId;
    }

    public int getTaxClassId() {
        return this.taxClassId;
    }

    public void setTaxClassId(int taxClassId) {
        this.taxClassId = taxClassId;
    }

    public String getUpc() {
        return this.upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public int getViewed() {
        return this.viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public BigDecimal getWeight() {
        return this.weight.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public int getWeightClassId() {
        return this.weightClassId;
    }

    public void setWeightClassId(int weightClassId) {
        this.weightClassId = weightClassId;
    }

    public BigDecimal getWidth() {
        return this.width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isSubtract() {
        return subtract;
    }

    public void setSubtract(boolean subtract) {
        this.subtract = subtract;
    }


    public List<ProductDescription> getProductDescriptions() {
        return productDescriptions;
    }

    public void setProductDescriptions(List<ProductDescription> productDescriptions) {
        this.productDescriptions = productDescriptions;
    }

    public List<ProductToCategory> getProductToCategory() {
        return productToCategory;
    }

    public void setProductToCategory(List<ProductToCategory> productToCategory) {
        this.productToCategory = productToCategory;
    }

    public List<ProductSpecial> getProductSpecial() {
        return productSpecial;
    }

    public void setProductSpecial(List<ProductSpecial> productSpecial) {
        this.productSpecial = productSpecial;
    }

    public List<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(List<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}