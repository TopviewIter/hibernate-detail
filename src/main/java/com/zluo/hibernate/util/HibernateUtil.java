package com.zluo.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * 项目名称：hibernate-hql-boolean <br> 
 * 类名称：HibernateUtil  <br>
 * 类描述：  工具类<br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年5月25日 下午12:47:35  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年5月25日 下午12:47:35  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class HibernateUtil {

	private static SessionFactory sf = null;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	private HibernateUtil(){
		
	}
	
	public static Session openSession(){
		return sf.openSession();
	}
	
	public static Session getCurrentSession(){
		Session s = threadLocal.get();
		if(s == null){
			s = sf.openSession();
		}
		return s;
	}
	
}
