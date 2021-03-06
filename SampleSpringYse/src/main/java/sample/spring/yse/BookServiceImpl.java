package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements BookService { // 입력 7. BookService 책 서비스 인터페이스 생성. -> BookService가면 있음.
	// 입력 6. 책서비스 클래스 생성
	@Autowired
	BookDao bookDao;
	
	// 입력8. 책 입력 기능 서비스 클래스 메소드 생성
	/*
	 * BookDao.insert 메소드 실행하는 서비스 메소드 작성
	 * 서비스 구현체인 이 클래스에 작성하면 됨.
	 * 
	 * */
	// 입력 9. 책 입력 기능 서비스 인터페이스 메소드 시그니쳐 생성
	/* 
	 * @override 어노테이션 = 메소드 시그니쳐 없을 때 오류표시, 자동 인터페이스 시그니쳐 생성 기능
	 * 이제 BookService.java가면 서미스 인터페이스에 메소드 시그니쳐가 추가됨
	 * (i mean ㅋㅋ ) String create(Map<String, Object> map);
	 *
	 *  */
	@Override
	public String create(Map<String, Object> map) {
	    int affectRowCount = this.bookDao.insert(map);
	    if (affectRowCount ==  1) {
	        return map.get("book_id").toString();
	    }
	    return null;
	}
}