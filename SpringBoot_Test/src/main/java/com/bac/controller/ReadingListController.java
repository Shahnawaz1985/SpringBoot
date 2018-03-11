package com.bac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bac.domain.Book;
import com.bac.service.ReadingListService;

@Controller
@RequestMapping("/readers")
public class ReadingListController {
	
	@Autowired
	@Qualifier("readingListService")
	private ReadingListService readingListService;
		
	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {
		System.out.println("Searching for {"+reader+"} in database");		
		List<Book> readingList = readingListService.findByReader(reader);
		System.out.println("Search result for books collection: "+readingList);
		if(readingList != null && !readingList.isEmpty()) {
			model.addAttribute("books", readingList);
		}
		return "readingList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addToReadingList(Book book) {
		book.setReader("");
		readingListService.saveBook(book);
		return null;
	}

}
