

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest2 {
	
	Book new_book;

	@BeforeEach
	void setUp(){
		new_book = new Book();
	}

	@Test
	void testTestAddBook() {
		System.out.println("");
		System.out.println("::: Add Book Test :::");
		assertEquals(0, new_book.testAddBook(1, "자바 기초", "Jane", 2021), "SUCESS 01");
		assertEquals(1, new_book.testAddBook(1, "자바 기초", "Jane", 2021), "SUCESS 02");
		assertEquals(0, new_book.testSearchBook(1, "자바 기초", "Jane", 2021), "SUCESS 03");
		

	}

	@Test
	void testTestSearchBook() {
		System.out.println("");
		System.out.println("::: Search Book Test :::");
		
		assertEquals(0, new_book.testAddBook(1, "자바 기초", "Jane", 2021), "add book 1");
		assertEquals(0, new_book.testAddBook(2, "소프트웨어 공학", "Tom", 2014), "add book 2");
		assertEquals(0, new_book.testAddBook(3, "분산 컴퓨팅", "Yoon", 2024), "add book 3");
		
		assertEquals(0, new_book.testSearchBook(1, "자바 기초", "Jane", 2021), "SUCESS 01");
		assertEquals(0, new_book.testSearchBook(2, "소프트웨어 공학", "Tom", 2014), "SUCESS 02");
		assertEquals(0, new_book.testSearchBook(3, "분산 컴퓨팅", "Yoon", 2024), "SUCESS 03");
		assertEquals(1, new_book.testSearchBook(4, "파이썬 기초", "Jack", 2021), "SUCESS 04");
		

	}

	@Test
	void testTestRemoveBook() {
		System.out.println("");
		System.out.println("::: Remove Book Test :::");
		assertEquals(0, new_book.testAddBook(1, "자바 기초", "Jane", 2021), "SUCESS 01");
		
		assertEquals(0, new_book.testSearchBook(1, "자바 기초", "Jane", 2021), "SUCESS 02");
		assertEquals(0, new_book.testRemoveBook(1, "자바 기초", "Jane", 2021), "SUCESS 03");
		assertEquals(1, new_book.testRemoveBook(1, "자바 기초", "Jane", 2021), "SUCESS 04");
		
	}

}
