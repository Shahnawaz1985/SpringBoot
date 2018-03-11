package com.bac.service;

import java.util.List;

import com.bac.domain.Book;

public interface ReadingListService {
	
	public List<Book> findAll();
	public void saveBook(Book book);
	public Book findOne(long id);
	public void delete(long id);
	public List<Book> findByName(String name);
	public List<Book> findByNameAndAuthor(String name, String author);
	public List<Book> findByPrice(long price);
	public List<Book> findByReader(String reader);

}
