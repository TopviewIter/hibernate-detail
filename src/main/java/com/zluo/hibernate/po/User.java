package com.zluo.hibernate.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * 项目名称：hibernate-hql-boolean <br> 
 * 类名称：User  <br>
 * 类描述：  测试类<br>
 * 创建人：louzhangjie  <br>
 * 创建时间：2015年5月25日 下午12:44:31  <br>
 * 修改人：louzhangjie <br>
 * 修改时间：2015年5月25日 下午12:44:31  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
@Table(name = "user")
@Entity
public class User {

	private String id;
	private String name;
	private boolean isStudent;
	private boolean teacher;
	
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid")
	@GeneratedValue(generator = "generator")
	@Column
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isStudent")
	public boolean isStudent() {
		return isStudent;
	}
	
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}

	public boolean getTeacher() {
		return teacher;
	}

	public void setTeacher(boolean teacher) {
		this.teacher = teacher;
	}
	
}
