package com.wind.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wind.model.User;

public class Test {
	
	public static void main(String[] args) {	
		String resourse = "mybatis-config.xml";
		InputStream in = Test.class.getClassLoader().getResourceAsStream(resourse);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		String sql = "com.wind.mapping.userMapper.getUser";
		User user = session.selectOne(sql,1);
		System.out.printf("name={%s},password={%s}",user.getName(),user.getPassword());
	}

}
