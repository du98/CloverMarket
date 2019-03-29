package com.syc.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;


public class Te {
@Test
	public  void getSession() {
		//使用日志对象输出信息
		Logger log=Logger.getLogger(Te.class);
		SqlSessionFactory sf = null;
		SqlSession ss = null;
		try {
			// 生成字符输入流对象 传入sessionFactory
			Reader rd = Resources.getResourceAsReader("my.xml");
			// 创建一个session Factory的实现类对象
			sf = new SqlSessionFactoryBuilder().build(rd);
			ss = sf.openSession();
			log.info("连接成功");
			System.out.println("ok");
		} catch (IOException e) {
			log.info("连接失败");
			e.printStackTrace();
		}
	}//
}
