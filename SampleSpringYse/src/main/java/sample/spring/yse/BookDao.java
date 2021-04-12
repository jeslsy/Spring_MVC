package sample.spring.yse;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



// 입력 4. 책 DAO 클래스 생성
@Repository
public class BookDao {
	 @Autowired
	 SqlSessionTemplate sqlSessionTemplate;
	 
	 // 입력 5. 책 데이터 입력 쿼리 실행하는 DAO메소드 만듬
	 public int insert(Map<String, Object> map) {
		  return this.sqlSessionTemplate.insert("book.insert", map);
		}
	 
	 
	 // 상세 3. 책 상세 DAO 메소드 작성
	 public Map<String, Object> selectDetail(Map<String, Object> map) {
		 	// selectOne = 한개만 가져오는 메소드 (없으면 null, 여러개면 TooManyResultsException 예외 던짐.)
		    return this.sqlSessionTemplate.selectOne("book.select_detail", map);
		}
	 
	 
}
