package com.bac.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bac.domain.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByReader(String reader);
}
