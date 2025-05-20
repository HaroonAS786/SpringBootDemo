package com.edigest.myFisrtProject.repositories;

import com.edigest.myFisrtProject.dtos.UserSummary;
import com.edigest.myFisrtProject.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email);

    @Query("select u from User u")
    @EntityGraph(attributePaths = "addresses")
    List<User> findAllWithTags();

//    @EntityGraph(attributePaths = "user")
    @Query("select u.id as id, u.email as email from User u where u.profile.loyaltyPoints > :loyalty_points order by u.email")
    List<UserSummary> findUsersByLoyal(@Param("loyalty_points") Integer loyalty_points);

}
