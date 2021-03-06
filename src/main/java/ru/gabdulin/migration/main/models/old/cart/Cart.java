package ru.gabdulin.migration.main.models.old.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gabdulin.migration.main.models.old.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1154447935307492308L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToMany(mappedBy = "cart", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    private Integer grandTotal;
    private String sessionId;

    @OneToOne(cascade = {CascadeType.ALL})
    @JsonIgnore
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Cart() {
        grandTotal = 0;
    }


    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Integer getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
