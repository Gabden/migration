package ru.gabdulin.migration.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gabdulin.migration.main.models.newer.UserDetailsDescription;
import ru.gabdulin.migration.main.models.newer.address.BillingAddress;
import ru.gabdulin.migration.main.models.newer.address.ShippingAddress;
import ru.gabdulin.migration.main.models.newer.cart.Cart;
import ru.gabdulin.migration.main.models.old.Customer;
import ru.gabdulin.migration.main.models.old.Product;
import ru.gabdulin.migration.main.models.old.User;
import ru.gabdulin.migration.main.repos.newa.NewBillingRepo;
import ru.gabdulin.migration.main.repos.newa.NewShippingRepo;
import ru.gabdulin.migration.main.repos.newa.NewUserRepository;
import ru.gabdulin.migration.main.repos.newa.UserDescriptionRepo;
import ru.gabdulin.migration.main.repos.old.CustomerRepository;
import ru.gabdulin.migration.main.repos.old.ProductRepository;
import ru.gabdulin.migration.main.repos.old.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class MigrationController {
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CustomerRepository customerRepository;

    private NewUserRepository newUserRepository;
    private NewBillingRepo newBillingRepo;
    private NewShippingRepo newShippingRepo;
    private UserDescriptionRepo userDescriptionRepo;

    public MigrationController(UserDescriptionRepo userDescriptionRepo, NewShippingRepo newShippingRepo, NewBillingRepo newBillingRepo, ProductRepository productRepository, UserRepository userRepository, CustomerRepository customerRepository, NewUserRepository newUserRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.newUserRepository = newUserRepository;
        this.newBillingRepo = newBillingRepo;
        this.newShippingRepo = newShippingRepo;
        this.userDescriptionRepo = userDescriptionRepo;
    }

    @RequestMapping("/migration")
    public ResponseEntity<List<User>> migrate() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @RequestMapping("/product")
    public ResponseEntity<Product> pre() {
        Optional<Product> users = productRepository.findById(836L);
        return ResponseEntity.ok(users.get());
    }

    @RequestMapping("/migration/users")
    public ResponseEntity migrateUser() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            Long customerId = user.getCustomerId();
            Optional<Customer> customer = customerRepository.findById(customerId);
            System.out.println(customer);
            if (customer.isPresent()) {
                BillingAddress billingAddress = new BillingAddress();
                billingAddress.setCountry("Россия");
                billingAddress.setCity("Рязань");
                billingAddress.setStreetName("Свободы");
                billingAddress.setApartmentNumber("24a");
                billingAddress.setZipCode("390000");


                ShippingAddress shippingAddress = new ShippingAddress();
                shippingAddress.setCountry("Россия");
                shippingAddress.setCity("Рязань");
                shippingAddress.setStreetName("Свободы");
                shippingAddress.setApartmentNumber("24a");
                shippingAddress.setZipCode("390000");


                UserDetailsDescription description = new UserDetailsDescription();
                description.setFIOfirst(customer.get().getFIOfirst());
                description.setFIOlast(customer.get().getFIOlast());
                description.setFIOmiddle(customer.get().getFIOmiddle());
                description.setPhone(customer.get().getCustomerPhone());

                Cart cart = new Cart();

                ru.gabdulin.migration.main.models.newer.User newUser = new ru.gabdulin.migration.main.models.newer.User();
                newUser.setUsername(user.getUsername());
                newUser.setPassword(user.getPassword());
                newUser.setActive(user.getActive());
                newUser.setPermissions(user.getPermissions());
                newUser.setRoles(user.getRoles());
                newUser.setBillingAddress(billingAddress);
                newUser.setShippingAddress(shippingAddress);
                newUser.setUserDetailsDescription(description);
                newUser.setCart(cart);



                cart.setUser(newUser);
                billingAddress.setUser(newUser);
                shippingAddress.setUser(newUser);

                newUserRepository.save(newUser);

            }
        });
        return ResponseEntity.ok("Migrated");
    }
}
