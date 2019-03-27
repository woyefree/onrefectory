package com.cjl.onrefectory.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;



public class D {
	
	private static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
	
	private static Logger log = Logger.getLogger(D.class);
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			log.info("数据库连接失败");
			throw new RuntimeException("数据库连接失败",e);
		}
	}
	/**
	 * 打开数据库
	 * @return
	 */
	public static SqlSession open() {
		SqlSession sqlSession = local.get();
		if(sqlSession == null) {
			sqlSession = sqlSessionFactory.openSession();
			local.set(sqlSession);
			log.info("创建数据库连接。。");
		}
		return sqlSession;
	}
	/**
	 * 关闭数据库
	 */
	public static void close() {
		SqlSession sqlSession = local.get();
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
			local.remove();
			log.info("关闭数据库连接。。");
		}
	}
	
	/**
	 * 出现异常，数据回滚操作
	 */
	public static void rollBack() {
		SqlSession sqlSession = local.get();
		if(sqlSession != null) {
			sqlSession.rollback();
			sqlSession.close();
			local.remove();
			log.info("出现异常，数据回滚");
		}
	}
}
