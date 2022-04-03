package com.ruben.springprojectguru.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ruben.springprojectguru.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
