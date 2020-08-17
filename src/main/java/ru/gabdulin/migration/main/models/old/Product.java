package ru.gabdulin.migration.main.models.old;


import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gabdulin.migration.main.models.old.cart.CartItem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

@Entity(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = -1530468945225710892L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "product_country")
    private String productCountry;

    @Column(name = "product_region")
    private String productRegion;

    @Column(name = "product_alcohol_degree")
    private String productAlcoholDegree;

    @Column(name = "product_alcohol_color")
    private String productAlcoholColor;

    @Column(name = "product_alcohol_sugar")
    private String productAlcoholSugar;

    @Column(name = "product_alcohol_temperature")
    private String productAlcoholTemperature;

    @Column(name = "product_alcohol_sort")
    private String productAlcoholSort;

    @Column(name = "product_manufacturer")
    private String productManufacturer;

    @Column(name = "product_description", length = 5000)
    private String productDescription;

    @Column(name = "product_volume")
    private String productVolume;

    @Column(name = "product_mature")
    private String productMature;

    @Column(name = "product_taste")
    private String productTaste;


    public Set<ProductImage> getProductImageSet() {
        return productImageSet;
    }

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "product_unit_in_stock")
    private String productUnitInStock;

    @Column(name = "sale_price")
    private String salePrice;

    @Column(name = "discount")
    private int discount;

    @Transient
    private String dataImg;


    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER
    )
    @JsonIgnore
    private Set<ProductImage> productImageSet;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartItem> cartItems;


    public void setProductImageSet(Set<ProductImage> productImageSet) {
        this.productImageSet = productImageSet;
    }

    public Long getId() {
        return id;
    }

    public Product() {
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        if (this.cartItems == null) {
            this.cartItems = cartItems;
        } else {
            this.cartItems.retainAll(cartItems);
            this.cartItems.addAll(cartItems);
        }

    }

    public String getDataImg() {
        setDataImg();
        return dataImg;
    }

    public byte[] getByteArrayImage() {
        List<ProductImage> images = new ArrayList<>(productImageSet);
        return images.get(0).getFileData();
    }

    public void setDataImg() {
        List<ProductImage> images = new ArrayList<>(productImageSet);
        if (images.size() != 0) {
            this.dataImg = Base64.getEncoder().encodeToString(images.get(0).getFileData());
        }
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getProductCountry() {
        return productCountry;
    }

    public void setProductCountry(String productCountry) {
        this.productCountry = productCountry;
    }

    public String getProductRegion() {
        return productRegion;
    }

    public void setProductRegion(String productRegion) {
        this.productRegion = productRegion;
    }

    public String getProductVolume() {
        return productVolume;
    }

    public void setProductVolume(String productVolume) {
        this.productVolume = productVolume;
    }

    public String getProductAlcoholDegree() {
        return productAlcoholDegree;
    }

    public void setProductAlcoholDegree(String productAlcoholDegree) {
        this.productAlcoholDegree = productAlcoholDegree;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductAlcoholColor() {
        return productAlcoholColor;
    }

    public void setProductAlcoholColor(String productAlcoholColor) {
        this.productAlcoholColor = productAlcoholColor;
    }

    public String getProductAlcoholSugar() {
        return productAlcoholSugar;
    }

    public void setProductAlcoholSugar(String productAlcoholSugar) {
        this.productAlcoholSugar = productAlcoholSugar;
    }

    public String getProductAlcoholTemperature() {
        return productAlcoholTemperature;
    }

    public void setProductAlcoholTemperature(String productAlcoholTemperature) {
        this.productAlcoholTemperature = productAlcoholTemperature;
    }

    public String getProductAlcoholSort() {
        return productAlcoholSort;
    }

    public void setProductAlcoholSort(String productAlcoholSort) {
        this.productAlcoholSort = productAlcoholSort;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductMature() {
        return productMature;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public void setProductMature(String productMature) {
        this.productMature = productMature;
    }

    public String getProductTaste() {
        return productTaste;
    }

    public void setProductTaste(String productTaste) {
        this.productTaste = productTaste;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductUnitInStock() {
        return productUnitInStock;
    }

    public void setProductUnitInStock(String productUnitInStock) {
        this.productUnitInStock = productUnitInStock;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productUnitInStock='" + productUnitInStock + '\'' +
                '}';
    }
}
