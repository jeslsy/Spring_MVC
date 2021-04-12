package sample.spring.yse;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



// �Է� 4. å DAO Ŭ���� ����
@Repository
public class BookDao {
	 @Autowired
	 SqlSessionTemplate sqlSessionTemplate;
	 
	 // �Է� 5. å ������ �Է� ���� �����ϴ� DAO�޼ҵ� ����
	 public int insert(Map<String, Object> map) {
		  return this.sqlSessionTemplate.insert("book.insert", map);
		}
	 
	 
	 // �� 3. å �� DAO �޼ҵ� �ۼ�
	 public Map<String, Object> selectDetail(Map<String, Object> map) {
		 	// selectOne = �Ѱ��� �������� �޼ҵ� (������ null, �������� TooManyResultsException ���� ����.)
		    return this.sqlSessionTemplate.selectOne("book.select_detail", map);
		}
	 
	 
}
