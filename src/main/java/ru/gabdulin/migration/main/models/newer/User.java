package ru.gabdulin.migration.main.models.newer;


import ru.gabdulin.migration.main.models.newer.address.BillingAddress;
import ru.gabdulin.migration.main.models.newer.address.ShippingAddress;
import ru.gabdulin.migration.main.models.newer.cart.Cart;
import ru.gabdulin.migration.main.models.newer.favorites.Favorite;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int active;

    private String roles = "";

    private String permissions = "";

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "details_id")
    private UserDetailsDescription userDetailsDescription;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "shipping_address_id")
    private ShippingAddress shippingAddress;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "billing_address_id")
    private BillingAddress billingAddress;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Favorite> favorites;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Transient
    private String token;

    public User(String username, String password, String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }

    public User() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public UserDetailsDescription getUserDetailsDescription() {
        return userDetailsDescription;
    }

    public void setUserDetailsDescription(UserDetailsDescription userDetailsDescription) {
        this.userDetailsDescription = userDetailsDescription;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                ", permissions='" + permissions + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}