package com.ms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ms.entity.Book;
import com.ms.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BookController {

    @Autowired
    private BookService bookservice;

    @GetMapping("/addBook")
    public ModelAndView addBook() {
    	
    	 ModelAndView mav = new ModelAndView();
    	 mav.addObject("book",new Book());
    	 mav.setViewName("addBook");
    	 return mav;
    }
    
    @PostMapping("/save")
    public ModelAndView saveBook(Book book) {
    		ModelAndView mav = new ModelAndView();
    		boolean status = bookservice.saveBook(book);
    		if(status) {
    			mav.addObject("succMsg","Book Saved");
    		}
    		else {
    			mav.addObject("errMsg","Failed To save");
    		}
    		mav.setViewName("addBook");
    		return mav;
    }
    @GetMapping("/books")
    public ModelAndView getBooks() {
        ModelAndView mav = new ModelAndView();
        List<Book> list = bookservice.getAllBooks();
        mav.addObject("books", list);
        mav.setViewName("index");
        return mav;
    }
    
    
}
