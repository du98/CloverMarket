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
		//ʹ����־���������Ϣ
		Logger log=Logger.getLogger(Te.class);
		SqlSessionFactory sf = null;
		SqlSession ss = null;
		try {
			// �����ַ����������� ����sessionFactory
			Reader rd = Resources.getResourceAsReader("my.xml");
			// ����һ��session Factory��ʵ�������
			sf = new SqlSessionFactoryBuilder().build(rd);
			ss = sf.openSession();
			log.info("���ӳɹ�");
			System.out.println("ok");
		} catch (IOException e) {
			log.info("����ʧ��");
			e.printStackTrace();
		}
	}//
}
