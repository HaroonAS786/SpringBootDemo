package com.edigest.myFisrtProject.services;

import com.edigest.myFisrtProject.models.Address;
import com.edigest.myFisrtProject.models.Category;
import com.edigest.myFisrtProject.models.Product;
import com.edigest.myFisrtProject.models.User;
import com.edigest.myFisrtProject.repositories.*;
import com.edigest.myFisrtProject.repositories.specifications.ProductSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service("user_service")
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void showEntityStates() {
        var createUser = User.builder().name("admin").email("admin@edigest.com").password("123456").build();
        if (entityManager.contains(createUser)) {
            System.out.println("Persistent State");
        } else {
            System.out.println("Transient / Detached State");
        }
        userRepository.save(createUser);
        if (entityManager.contains(createUser)) {
            System.out.println("Persistent State");
        } else {
            System.out.println("Transient / Detached State");
        }
    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getBio());
    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated() {
        var user = User.builder().name("Jia").email("jia@edigest.com").password("122323").build();
        var address = Address.builder().street("Jia Street").city("Jia City").build();
        user.addAddress(address);
        userRepository.save(user);
//        addressRepository.save(address); // we can achieve this behavior through cascading
    }

    @Transactional
    public void removeUser() {
        var user = userRepository.findById(4L).orElseThrow();
        var address = user.getAddresses().get(0);
//        System.out.println(address);
        user.removeAddress(address);
        userRepository.save(user);
    }


    @Transactional
    public void createNewProduct() {
//        var category = categoryRepository.findById((byte) 1).orElseThrow();
//        categoryRepository.save(category);
        var category = new Category("Category3");
//        categoryRepository.save(category);  // save category first
        Product product = Product.builder().name("Monitor").price(new BigDecimal("100.00")).description("monitor").category(category).build();

        System.out.println(product);
        productRepository.save(product);
    }

    @Transactional
    public void addProductsToUserWishlist() {
        var user = userRepository.findById(1L).orElseThrow();
        var products = productRepository.findAll();
        products.forEach(user::addProducts);
        userRepository.save(user);
    }

    @Transactional
    public void deletingProducts() {
        productRepository.deleteAll();
    }

    @Transactional
    public void updateProductsPrice() {
        productRepository.updatePriceByCategory(BigDecimal.valueOf(20.00), (byte) 1);
    }

    public void fetchProducts() {
        var products = productRepository.findByCategory(new Category((byte) 1));
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchProductsByExampleQuery() {
        var product = new Product();
        product.setName("product");
        var matcher = ExampleMatcher.matching().withIncludeNullValues().withIgnorePaths("id", "description").withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        var example = Example.of(product, matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUsers() {
//        var user = userRepository.findByEmail("haroon.asif@tkxel.com").orElseThrow();
//        var users = userRepository.findAll();
        var users = userRepository.findAllWithTags();
//        System.out.println(user.get().getId());
        users.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }

    @Transactional
    public void findProductsByPriceThroughProcedure() {
        var products = productRepository.findProductByPrice(BigDecimal.valueOf(10.00), BigDecimal.valueOf(60));

        System.out.println(products);
    }

    public void findAllProfiles() {
        var profiles = profileRepository.findAllProfiles(2);
        profiles.forEach(profile -> System.out.println(profile.getId() + ":" + profile.getUser().getEmail()));
    }

    public void findByLoyaltyPointsGreaterThanOrderByEmail() {
//        var profiles = profileRepository.findByLoyaltyPointsGreaterThanOrderByEmail(2);
        var profiles = profileRepository.findByLoyaltyPointsGreaterThanOrderByEmail(2);
        profiles.forEach(profile -> System.out.println(profile.getId() + ":" + profile.getUser().getEmail()));
    }

    public void findByLoyalUsers() {
        var users = userRepository.findUsersByLoyal(2);
        users.forEach(user -> System.out.println((user.getId() + ":" + user.getEmail())));
    }

    //Composable Queries
    public void fetchProductsBySpecifications(String name, BigDecimal minPrice, BigDecimal maxPrice) {

        Specification<Product> spec = Specification.where(null);

        if (name != null) {
            spec = spec.and(ProductSpec.hasName(name));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpec.hasPriceLessThanOrEqualTo(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(maxPrice));
        }
        productRepository.findAll(spec).forEach(System.out::println);
    }

    public void fetchSortedProducts() {
        var sort = Sort.by("name").and(Sort.by("price").descending());
        productRepository.findAll(sort).forEach(System.out::println);
    }

    public void fetchPaginatedProducts(int pageNumber, int size) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
        Page<Product> page = productRepository.findAll(pageRequest);

        var products = page.getContent();
        products.forEach(System.out::println);

        var totalPages = page.getTotalPages();
        var totalElements = page.getTotalElements();

        System.out.println("Total Pages: " + totalPages);
        System.out.println("Total Elements: " + totalElements);
    }

    public void fetchProductsByCategory(byte categoryId) {
        Specification<Product> spec = Specification.where(null);
        spec = spec.and(ProductSpec.hasCategoryId(categoryId));
        productRepository.findAll(spec).forEach(System.out::println);
    }
}

