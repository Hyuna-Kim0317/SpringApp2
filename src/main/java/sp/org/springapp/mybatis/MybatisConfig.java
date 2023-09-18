package sp.org.springapp.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//mybatis의 설정파일을 읽어들여, SqlSessionFactory를 얻기 위한 객체 선언
//이 객체는 어플리케이션에서 한번만 인스턴스를 생성해야 하므로, 싱글터으로 선언하자
public class MybatisConfig {
	private static MybatisConfig instance;
	private SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfig() {
		System.out.println("===== mybatisConfig() 실행");
		String resource = "sp/org/springapp/mybatis/config.xml";
		InputStream inputStream=null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("===== sqlSessionFactory builder 실행");
		//sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		System.out.println("===== sqlSessionFactory builder 완료");
		System.out.println(sqlSessionFactory);
		
	}
	
	public static MybatisConfig getInstance() {
		System.out.println("===== getInstance 실행");
		if(instance == null) {
			System.out.println("===== instatnce is null");
			instance = new MybatisConfig();
		}
		System.out.println("===== instatnce is not null");
		System.out.println(instance);
		return instance;
	}
	
	//팩토리부터 SqlSession 반환
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	//SqlSession 반납
	public void release(SqlSession sqlSession) {
		sqlSession.close();
	}
}
