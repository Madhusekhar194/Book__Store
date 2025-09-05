package com.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ms.entity.Book;
import com.ms.repo.BookRepo;
@Service
@Primary
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo repo;

	public List<Book> getAllBooks() {
		List<Book> all = repo.findAll();
		return all;
	}

	public boolean saveBook(Book book) {
		Book savedBook = repo.save(book);
		if(savedBook.getBookId() != null) {
			return true;			
		}
		else {
			return false;
		}
	}

	

}
