package com.ms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
