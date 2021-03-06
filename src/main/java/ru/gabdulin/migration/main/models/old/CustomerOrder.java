package ru.gabdulin.migration.main.models.old;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gabdulin.migration.main.models.old.address.BillingAddress;
import ru.gabdulin.migration.main.models.old.address.ShippingAddress;
import ru.gabdulin.migration.main.models.old.cart.Cart;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 5906767062695827006L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerOrderId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;


    private Timestamp timestamp;

    //can be created or confirmed or canceled
    private String status;



    public CustomerOrder() {
        this.status = "created";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }




}
