package com.zluo.hibernate.util;

import org.hibernate.Session;
import org.junit.Test;

import com.zluo.hibernate.po.User;

/**
 * 
 * 项目名称：hibernate-hql-boolean <br> 
 * 类名称：HibernateUtilTest  <br>
 * 类描述：  <br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年5月25日 下午1:03:15  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年5月25日 下午1:03:15  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class HibernateUtilTest {

	@Test
	public void testGetCurrentSession(){
		HibernateUtil.getCurrentSession();
	}
	
	@Test
	public void testSave(){
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		User user = new User();
		user.setName("xiaoming");
		user.setStudent(false);
		user.setTeacher(true);
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testfind_01(){
		Session session = HibernateUtil.getCurrentSession();
//		String hql = "from com.zluo.hibernate.po.User u where u.student = ?";
		String hql = "from com.zluo.hibernate.po.User u where u.isStudent = ?";
		User user = (User)session.createQuery(hql).setParameter(0, false).uniqueResult();
		session.close();
		System.out.println(user.getName());
	}
	
	@Test
	public void testfind_02(){
		Session session = HibernateUtil.getCurrentSession();
//		String hql = "from com.zluo.hibernate.po.User u where u.teacher = ?";
		String hql = "from com.zluo.hibernate.po.User u where u.teacher = ?";
		User user = (User)session.createQuery(hql).setParameter(0, true).uniqueResult();
		session.close();
		System.out.println(user.getName());
	}
	
	@Test
	public void testfind_03(){
		Session session = HibernateUtil.getCurrentSession();
//		String hql = "from com.zluo.hibernate.po.User u where u.teacher = ?";
		String hql = "from com.zluo.hibernate.po.User";
		User user = (User)session.createQuery(hql).uniqueResult();
		session.close();
		System.out.println(user.getName());
	}
	
}
