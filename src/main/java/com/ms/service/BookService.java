package com.ms.service;

import java.util.List;

import com.ms.entity.Book;

public interface BookService{
	public List<Book> getAllBooks();
	public boolean saveBook(Book book);
}
