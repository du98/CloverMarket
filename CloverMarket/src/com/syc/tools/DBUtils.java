package com.syc.tools;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class DBUtils {
	/**
	 * @author XPS13
	 * @date 2019-3-26 15:45
	 * @detail ʵ��mybatis���ݿ����Ӳ���
	 */

	public static SqlSession getSession() {
		//ʹ����־���������Ϣ
		Logger log=Logger.getLogger(DBUtils.class);
		SqlSessionFactory sf = null;
		SqlSession ss = null;
		try {
			// �����ַ����������� ����sessionFactory
			Reader rd = Resources.getResourceAsReader("my.xml");
			// ����һ��session Factory��ʵ�������
			sf = new SqlSessionFactoryBuilder().build(rd);
			ss = sf.openSession();
			log.info("���ӳɹ�");
			//System.out.println("ok");
		} catch (IOException e) {
			log.info("����ʧ��");
			e.printStackTrace();
		}
		return ss;
	}//
	public static void closeSession(SqlSession ss){
		if(ss!=null){
			ss.close();
		}
	}//
}
