package com.bookStore.service;


import com.bookStore.entity.MyBooks;
import com.bookStore.repository.MyBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybooksService {


    @Autowired
    MyBooksRepository mybooksrepo;
    public void saveMyBooks(MyBooks mb){
        mybooksrepo.save(mb);
    }

    public List<MyBooks> getMyBooks(){
        return mybooksrepo.findAll();
    }


    public void deleteByid(int id){
        mybooksrepo.deleteById(id);
    }

}
