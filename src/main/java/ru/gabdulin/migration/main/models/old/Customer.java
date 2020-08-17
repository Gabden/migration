package ru.gabdulin.migration.main.models.old;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gabdulin.migration.main.models.old.address.BillingAddress;
import ru.gabdulin.migration.main.models.old.address.ShippingAddress;
import ru.gabdulin.migration.main.models.old.cart.Cart;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 7692196695514198213L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_password")
    private String customerPassword;


    @Transient
    private String customerPasswordAccept;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "enabled")
    private boolean enabled;




    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Favorites> favorites;

    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrder;

    @Column(name = "fiofirst")
    private String FIOfirst;
    @Column(name = "fiomiddle")
    private String FIOmiddle;
    @Column(name = "fiolast")
    private String FIOlast;

    public Customer() {
    }

    public String getFIOfirst() {
        return FIOfirst;
    }

    public void setFIOfirst(String FIOfirst) {
        this.FIOfirst = FIOfirst;
    }

    public String getFIOmiddle() {
        return FIOmiddle;
    }

    public void setFIOmiddle(String FIOmiddle) {
        this.FIOmiddle = FIOmiddle;
    }

    public String getFIOlast() {
        return FIOlast;
    }

    public void setFIOlast(String FIOlast) {
        this.FIOlast = FIOlast;
    }

    public List<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorites> favorites) {
        this.favorites = favorites;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPasswordAccept() {
        return customerPasswordAccept;
    }

    public List<CustomerOrder> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(List<CustomerOrder> customerOrder) {
        this.customerOrder = customerOrder;
    }

    public void setCustomerPasswordAccept(String customerPasswordAccept) {
        this.customerPasswordAccept = customerPasswordAccept;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



}
