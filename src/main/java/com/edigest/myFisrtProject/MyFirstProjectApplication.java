package com.edigest.myFisrtProject;

import com.edigest.myFisrtProject.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyFirstProjectApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(MyFisrtProjectApplication.class, args);
        ApplicationContext applicationContext = SpringApplication.run(MyFirstProjectApplication.class, args);
//        var repository = applicationContext.getBean(UserRepository.class);
        var service = applicationContext.getBean(UserService.class);
//        service.showEntityStates();
//        service.showRelatedEntities();
//        service.fetchAddress();
//        service.persistRelated();
//        service.removeUser();
//        service.createNewProduct();
//        service.addProductsToUserWishlist();
//        service.deletingProducts();
//        service.updateProductsPrice();
//        service.fetchProducts();
//        service.fetchUsers();
//        service.findProductsByPriceThroughProcedure();
//        service.findAllProfiles();
//        service.findByLoyaltyPointsGreaterThanOrderByEmail();
//        service.findByLoyalUsers();
//        service.fetchProductsByExampleQuery();
//        service.fetchProductsBySpecifications("Prod",null,null);
//        service.fetchSortedProducts();
//        service.fetchPaginatedProducts(0,10);
        service.fetchProductsByCategory((byte) 1);
//        repository.deleteAll();
//        var getUser = repository.findById(3L).orElseThrow();
//        repository.findAll().forEach(user -> {
//            System.out.println(user.getEmail());
//        });

//        var user = User.builder()
//                .name("Ali")
//                .email("ali@edigest.com")
//                .password("123456")
//                .build();
//        repository.save(user);

        //        var notifyService = applicationContext.getBean(NotificationManager.class);
//        var orderService = applicationContext.getBean(OrderService.class);
//        var orderService2 = applicationContext.getBean(OrderService.class);
//        var order = new OrderService(new StripePaymentService());
//        var order = new OrderService();
//        order.setPaymentService(new StripePaymentService());
//        order.setPaymentService(new PaypalPaymentService());
//        notifyService.sendNotification("Hello World!");
//        applicationContext.close();

//        ApplicationContext applicationContext = SpringApplication.run(MyFirstProjectApplication.class, args);
//        var userService = applicationContext.getBean(UserService.class);
//        userService.registerUser(new User(1L, "haroon.asif@gmail.com", "1234", "Haroon"));
//        userService.registerUser(new User(2L, "haroon.asif@gmail.com", "1234", "Haroon"));

//        var user = new User(1L,"haroon","haroon","haroon@edigest.com");
//        user.setName("haroon");
//        user.setEmail("haroon@edigest.com");
//        user.setPassword("haroon");

//        var user = User.builder().name("Edigest").email("edigest@edigest.com").password("edigest").build();
//
//        var userProfile = Profile.builder().bio("Edigest").build();
//        user.setProfile(userProfile);
//        userProfile.setUser(user);
//
//        System.out.println("User: " + user);
//        System.out.println("Profile: " + userProfile);
//        System.out.println("Profile's User: " + userProfile.getUser());

//        user.addTag("tag1");
//        user.addTag("tag2");
//        user.addTag("tag3");

//        System.out.println(user);
//        user.removeTag("tag1");
//        System.out.println(user);

//        var address = Address.builder()
//                .street("B1 township lahore")
//                .zip("54000")
//                .city("Lahore")
//                .build();
//
//        var address2 = Address.builder()
//                .street("B2 township lahore")
//                .zip("54000")
//                .city("Karachi")
//                .build();


    }


}

