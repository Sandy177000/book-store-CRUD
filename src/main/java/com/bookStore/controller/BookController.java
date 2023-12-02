package com.bookStore.controller;


import com.bookStore.entity.Book;
import com.bookStore.entity.MyBooks;
import com.bookStore.service.MybooksService;
import com.bookStore.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private Service bookService ;
    @Autowired
    private MybooksService MybooksService ;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("book_register")
    public String bookRegister(){
        // displaying the form to register new books
        return "book_register"; // this string name should match with the html page you want to display
    }

    @GetMapping("available_books")
    public ModelAndView getAllBooks(){
        // getting all the records from the db and
        // sending it as a model to available_books endpoint which is then processed
        // to render each item from the list as rows

        List<Book> list = bookService.getListOfBooks();
        return new ModelAndView("available_books","book",list);

    }

    @GetMapping("my_books")
    public String getmyBooks(Model model){
        // display all the selected "my books"
        List<MyBooks> list = MybooksService.getMyBooks();
        model.addAttribute("book",list);
        return "my_books";
    }


    @PostMapping("save")
    public String addBook(@ModelAttribute Book b){
        //saving data from form to db
        bookService.save(b);
        return "redirect:available_books";
    }

    @RequestMapping("mylist/{id}")
    public String getMyList(@PathVariable("id") int id){

        // getting the id of the selected book from the url using the @PathVariable
        Book b = bookService.getBookByid(id);
        // converting it to MyBooks data type and saving it to mybooks table in db
        MyBooks mb = new MyBooks(b.getId(), b.getName(), b.getAuthor(),b.getPrice());
        MybooksService.saveMyBooks(mb);
        return "redirect:/my_books";
    }


    @RequestMapping("delete/{id}")
    public String deleteMybook(@PathVariable("id") int id){
        MybooksService.deleteByid(id);

        return  "redirect:/my_books";
    }
    @RequestMapping("deleteDB/{id}")
    public String deletebook(@PathVariable("id") int id){

        bookService.deleteByid(id);
        return "redirect:/available_books";
    }




}
