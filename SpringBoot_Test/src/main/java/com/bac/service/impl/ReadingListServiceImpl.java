package com.bac.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bac.domain.Book;
import com.bac.repositories.ReadingListRepository;
import com.bac.service.ReadingListService;

@Service("readingListService")
@Repository
@Transactional
public class ReadingListServiceImpl implements ReadingListService {
	
	@Autowired
	private ReadingListRepository readingListRepository;

	@Override
	public List<Book> findAll() {
		return readingListRepository.findAll();
	}

	@Override
	public void saveBook(Book book) {
		readingListRepository.save(book);
	}

	@Override
	public Book findOne(long id) {
		return readingListRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		readingListRepository.delete(id);

	}

	@Override
	public List<Book> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByNameAndAuthor(String name, String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByPrice(long price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByReader(String reader) {
		return readingListRepository.findByReader(reader);
	}

}
