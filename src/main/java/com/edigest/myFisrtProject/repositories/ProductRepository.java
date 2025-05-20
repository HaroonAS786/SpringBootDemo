package com.edigest.myFisrtProject.repositories;

import com.edigest.myFisrtProject.dtos.ProductSummaryClass;
import com.edigest.myFisrtProject.models.Category;
import com.edigest.myFisrtProject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

//public interface ProductRepository extends CrudRepository<Product, Long> {
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    // String
    List<Product> findByName(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByNameNotLike(String name);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameStartsWith(String name);

    List<Product> findByNameEndsWith(String name);

    List<Product> findByNameEndingWithIgnoreCase(String name);

    //Numbers
    List<Product> findByPrice(BigDecimal price);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceGreaterThanEqual(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByPriceLessThanEqual(BigDecimal price);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    //Null
    List<Product> findByDescriptionNull();

    List<Product> findByDescriptionNotNull();


    // MultipleConditions
    List<Product> findByDescriptionNullAndNameNotNull();


    // Sort (OrderBy)
    List<Product> findTop5ByNameOrderByPrice(String name);

    //Limit
    List<Product> findFirst5ByNameLikeOrderByPrice(String name);

    // Find products whose prices are in a given range and sort by name
    // SQL and JPQL
//    @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
//    @Query("select p from Product p where p.price between :min and :max order by p.name")

//    @Query("select p from Product p join p.category where p.price between :min and :max order by p.name")
//    List<Product> findByPriceBetweenOrderByName(@Param("min") BigDecimal min, @Param("max") BigDecimal max);


    @Procedure("findProductByID")
    List<Product> findProductByPrice(BigDecimal min, BigDecimal max);

    @Query("select count(p) from Product p where p.price between :min and :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);


    @Modifying
    @Query("update Product p set p.price = :price where p.category.id = :categoryId")
    void updatePriceByCategory(@Param("price") BigDecimal price, @Param("categoryId") Byte categoryId);


    //fetch partial data through projections
//    List<Product> findByCategory(Category category);

//    @Query("select p.id,p.name from Product p where p.category = :category")
//    List<ProductSummary> findByCategory(Category category);   // with projections through interface

    @Query("select new com.edigest.myFisrtProject.dtos.ProductSummaryClass(p.id,p.name) from Product p where p.category = :category")
    List<ProductSummaryClass> findByCategory(Category category);   // with projections through class

}