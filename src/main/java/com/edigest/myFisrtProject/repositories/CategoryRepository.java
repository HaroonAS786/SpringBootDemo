package com.edigest.myFisrtProject.repositories;

import com.edigest.myFisrtProject.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}