package com.edigest.myFisrtProject.dependencyInjection.userRegisteration;

public interface UserRepository {

    void save(User user);

    User findByEmail(String email);

}
