package com.bookStore.service;


import com.bookStore.entity.Book;
import com.bookStore.entity.MyBooks;
import com.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private BookRepository brepo;
    public void save(Book b){
        // using inbuilt .save() method from jpa (java persistance API)
        // JPA framework helps to map the object data sent to it into databases directly
        brepo.save(b);
    }

    public List<Book> getListOfBooks(){
        // using .findAll() which gets all the records from db in the form of List
        return brepo.findAll();
    }

    public Book getBookByid(int id){
        return brepo.findById(id).get();
    }

    public void deleteByid(int id){
        brepo.deleteById(id);
    }

}
