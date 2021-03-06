package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	// 입력 10. 책 입력 기능 컨트롤러 서비스 빈 추가 : 입력 기능 서비스 호출 위한것.
	/*
	 * 서비스 호출 위해 BookService 의존성 주입
	 * 이때 BookService 인터페이스가 사용되었음.
	 * 
	 * */
	@Autowired
	BookService bookService;
	
	// 세팅 0. Get 방식 정의
	// /create 주소가 GET방식으로 입력될때
	// book/create 경로 뷰 보여줌.
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
	    return new ModelAndView("book/create");
	}
	
	
	// 입력 11. 책 입력 기능 컨트롤러 메소드 추가 
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    String bookId = this.bookService.create(map);
	    if (bookId == null) {
	        mav.setViewName("redirect:/create");
	    }else {
	        mav.setViewName("redirect:/detail?bookId=" + bookId); 
	    }  

	    return mav;
	}
	
	
}
