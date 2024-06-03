import java.util.Random;

public class PerformanceTest {

    Book test_Book;

    public PerformanceTest(){
        test_Book = new Book();
    }

    public void makeBooks(){
        // 100,000개의 Book 객체를 생성하여 bookDB에 추가
        // 책의 인덱스 : 0 ~ 99,999
        for(int i = 0; i < 100000; i++){
            test_Book.testAddBook(i, "Title" + i, "Author" + i, 2000 + (i%20));
        }
    }

    // testSearchBook 함수 실행 시간 측정
    // 함수 시작하기 전의 시간과 함수 실행 후의 시간을 ms (밀리초) 단위로 구한 후 전체 실행 시간 계산
    public long measureTestSearchBook(int id, String title, String auhor, int publishedYear){
        long startTime = System.currentTimeMillis();
        test_Book.testSearchBook(id, title, auhor, publishedYear);
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    // search_bs 함수 실행 시간 측정
    // 함수 시작하기 전의 시간과 함수 실행 후의 시간을 ms (밀리초) 단위로 구한 후 전체 실행 시간 계산
    public long measureSearchBs(int id){
        long startTime = System.currentTimeMillis();
        test_Book.search_bs(id);
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public void runTest(){
        // Book 의 DB를 생성함
        makeBooks();

        // 검색할 Book 객체의 id 랜덤 생성
        // 0 ~ 99999 까지의 무작위의 값 리턴하여 찾고 싶은 책의 id 설정.    
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int bookId = random.nextInt(99999); 


        // durationTestSearchBook 과 durationSearchBs 변수에 각각의 함수 실행 시간을 저장
        long durationTestSearchBook = measureTestSearchBook(bookId, "Title" + bookId, "Author" + bookId, 2000+(bookId % 20));
        long durationSearchBs = measureSearchBs(bookId);

        // 결과 출력
        System.out.println("testSearchBook 함수와 search_bs 함수의 실행 시간 비교");
        System.out.println("testSearchBook 실행 시간: " + durationTestSearchBook + " ms");
        System.out.println("search_bs 실행 시간: " + durationSearchBs + " ms");
    }
}
