package com.bookStore.repository;


import com.bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
   // implementing the JPA repository which makes a table made of the attributes of Data Type Book class
}
