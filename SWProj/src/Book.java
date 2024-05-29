
import java.util.ArrayList;
import java.util.Iterator;

public class Book {

	int id; 
	String title;
	String author;
	int publishedYear;
	
	private ArrayList<Book> bookDB; // DB
	
	// 생성자 
	public Book() {bookDB = new ArrayList<Book>();}

	// 생성자 : Book(int id, String title, String author, int publishedYear)
	public Book(int id, String title, String author, int publishedYear) {
		
		bookDB = new ArrayList<Book>();
		Book info = new Book();
		
		info.id = id;
		info.title = title;
		info.author = author;
		info.publishedYear = publishedYear;
		
		bookDB.add(info);
		
	}

	// testAddBook(int id, String title, String author, int publishedYear)
	// DB에서 도서를 추가하는 함수.
	// RETURN : 도서를 정상적으로 추가하면 0 return, 도서가 없어서 추가하지 못하면(id가 동일한 도서가 있으면) 1을 반환
	public int testAddBook(int id, String title, String author, int publishedYear) {
		
		Iterator<Book> it = bookDB.iterator();
		
		while (it.hasNext())
		{
			Book i = it.next();
			if (i.id == id) {
				System.out.println("해당 id : (" + id + ")는 이미 존재합니다. ");
				return (1);
			}
		}
		
		Book info = new Book();
		
		info.id = id;
		info.title = title;
		info.author = author;
		info.publishedYear = publishedYear;
		System.out.println("Book{id : " + id +  ", title : " + title + ", author : " + author + ", published Year : " + publishedYear + "} 도서가 추가되었습니다.");
		
		bookDB.add(info);
		
		return (0);
		
	}
	
	// testSearchBook(int id, String title, String author, int publishedYear)
	// DB에서 도서를 검색하는 함수.
	// RETURN : 도서를 정상적으로 검색하면 0 return, 도서가 없어서 검색하지 못하면(도서가 없으면) 1을 반환
	public int testSearchBook(int id, String title, String author, int publishedYear) {

		Iterator<Book> it = bookDB.iterator();
		
		while (it.hasNext())
		{
			Book i = it.next();
		
			if (i.id == id) {
				System.out.println("검색 결과: ");
				System.out.println("Book{id : '" + id +  "', title : '" + title + "', author : '" + author + "', published Year : " + publishedYear + "}");
				return (0);
			}
		}
		System.out.println("검색된 도서가 없습니다.");
		return (1);
	}
	
	// testRemoveBook(int id, String title, String author, int publishedYear)
	// DB에서 도서를 삭제하는 함수.
	// RETURN : 도서를 정상적으로 삭제하면 0 return, 도서가 없어서 삭제하지 못하면 1을 반환
	public int testRemoveBook(int id, String title, String author, int publishedYear) {
		
		Iterator<Book> it = bookDB.iterator();
		
		while (it.hasNext())
		{
			Book i = it.next();
			if (i.id == id) {
				it.remove();
				System.out.println("Book{id : " + id +  ", title : " + title + ", author : " + author + ", published Year : " + publishedYear + "} 도서를 삭제했습니다. ");
				return (0);
			}
		}
		
		System.out.println("검색된 도서가 없습니다.");
		return (1);

	}
	
	// search_bs(int id)
	// DB에서 id로 도서를 binary search로 검색하는 함수.
	// RETURN : 도서를 정상적으로 검색하면 0 return, 도서가 없어서 검색하지 못하면 1을 반환
	public int search_bs(int id){
		int left = 0;
		int right = bookDB.size() - 1;

		while (left <= right)
		{
			int middle = left + (right - left) / 2;

			if (bookDB.get(middle).id == id)
			{
				System.out.println("검색 결과: ");
				System.out.println("Book2{id : '" + bookDB.get(middle).id +  "', title : '" + bookDB.get(middle).title + "', author : '" + bookDB.get(middle).author + "', published Year : " + bookDB.get(middle).publishedYear + "}");
				return 0;
			}
			if (bookDB.get(middle).id < id)
				left = middle + 1;
			else
				right = middle - 1;
		}

		System.out.println("검색된 책이 없습니다.");
		return (-1);
	}
	
//	// test case code
//	public static void main(String[] args)
//	{
//
//	// added new class : Book
//	Book new_book = new Book();
//	
//	// value input
//	System.out.println("\n[0] input value");
//	new_book.testAddBook(1, "자바 기초", "Jane", 2021);
//	new_book.testAddBook(1, "자바 기초", "Jane", 2021);
//	new_book.testSearchBook(1, "자바 기초", "Jane", 2021);
//
//	// add book test
//	System.out.println("\n[1] test ~ add book");
//	new_book.testAddBook(2, "소프트웨어 공학", "Tom", 2014);
//	new_book.testAddBook(3, "분산 컴퓨팅", "Yoon", 2024);
//
//	// search book test
//	System.out.println("\n[2] test ~ search book");
//	new_book.testSearchBook(1, "자바 기초", "Jane", 2021);
//	new_book.testSearchBook(2, "소프트웨어 공학", "Tom", 2014);
//	new_book.testSearchBook(3, "분산 컴퓨팅", "Yoon", 2024);
//
//	// can't find book test
//	System.out.println("\n[3] test ~ can't find book");
//	new_book.testSearchBook(4, "파이썬 기초", "Jack", 2021); // 검색된 도서가 없습니다.
//
//	// remove book test
//	System.out.println("\n[4] test ~ remove & can't book");
//	new_book.testRemoveBook(1, "자바 기초", "Jane", 2021);
//	new_book.testRemoveBook(1, "자바 기초", "Jane", 2021);
//	
//  // binary search searching test case
//	new_book.testAddBook(1, "a", "Tom", 2014);
//	new_book.testAddBook(2, "b", "Kate", 2014);
//	new_book.testAddBook(3, "c", "Yoon", 2024);
//	new_book.testAddBook(5, "d", "Dan", 2014);
//	new_book.testAddBook(10, "e", "Yoon", 2024);
//	new_book.testAddBook(8, "f", "Max", 2014);
//	new_book.testAddBook(7, "g", "Jack", 2024);
//
//	System.out.println("<도서 검색>");
//	new_book.testSearchBook(5, "d", "Dan", 2014);
//
//	System.out.println("<이진 검색>");
//	new_book.search_bs(5);
//	}

}



