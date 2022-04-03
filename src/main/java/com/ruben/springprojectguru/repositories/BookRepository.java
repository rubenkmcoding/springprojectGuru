package com.ruben.springprojectguru.repositories;


import com.ruben.springprojectguru.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
}
