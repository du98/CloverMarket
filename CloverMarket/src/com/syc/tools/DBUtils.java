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
	 * @detail 实现mybatis数据库连接操作
	 */

	public static SqlSession getSession() {
		//使用日志对象输出信息
		Logger log=Logger.getLogger(DBUtils.class);
		SqlSessionFactory sf = null;
		SqlSession ss = null;
		try {
			// 生成字符输入流对象 传入sessionFactory
			Reader rd = Resources.getResourceAsReader("my.xml");
			// 创建一个session Factory的实现类对象
			sf = new SqlSessionFactoryBuilder().build(rd);
			ss = sf.openSession();
			log.info("连接成功");
			//System.out.println("ok");
		} catch (IOException e) {
			log.info("连接失败");
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
