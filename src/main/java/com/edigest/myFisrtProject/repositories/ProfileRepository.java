package com.edigest.myFisrtProject.repositories;

import com.edigest.myFisrtProject.dtos.UserSummary;
import com.edigest.myFisrtProject.models.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    @EntityGraph(attributePaths = "user")
    @Query("select p from Profile p where p.loyaltyPoints > :loyalty_points")
    List<Profile> findAllProfiles(@Param("loyalty_points") Integer loyalty_points);

    @EntityGraph(attributePaths = "user")
    @Query("select p from Profile p where p.loyaltyPoints > :loyalty_points order by p.user.email")
    List<Profile> findByLoyaltyPointsGreaterThanOrderByEmail(@Param("loyalty_points") Integer loyalty_points);

}