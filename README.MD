###通过hql以对象的boolean类型字段作为条件进行查询遇到的问题:
这是在做项目时遇到的一个问题,当时琢磨了蛮久的,觉得有点神奇吧,特地做了一个小demo作记录
po:
	成员变量为`private boolean isStudent;`
数据库:手动建表
	字段名为`isStudent`
	
查询的hql:
	`from com.zluo.hibernate.po.User u where u.isStudent = ?`
执行后的报错信息如下:
	`org.hibernate.QueryException: could not resolve property: isStudent of: com.zluo.hibernate.po.User [from com.zluo.hibernate.po.User u where u.isStudent = ?]`
	当时就在想怎么会出现这个错误呢,在User当中明明是有这个属性的,为什么会找不到?但如果是用下面的语句`select * from com.zluo.hibernate.po.User u`就能够查找出来,一次偶然的机会^_^,在查找全部的返回数据的时候,发现hibernate把isStudent处理成了student,那时我就猜想:hql会不会也是这样处理,测试之后发现果然如此,哈哈哈
	
	在做这个小demo我特地使用了让hibernate自动建表的方式去生成数据库的表,发现它真的把isStudent的这个属性,映射到了数据库中的student字段,而不是isStudent,即使使用`@column`指定了字段名,但在用hql的时候还是要把is这个前缀给去掉
	
	做这个小demo遇到的问题:之前一直是让spring管理事务,单独使用hibernate竟然忘记了提交事务,导致每次junit测试都成功,但数据库里面就是没有数据,晕啊~~
	
	还有一个知识点就是:以前一直以为hibernate是在web项目启动的时候就帮我们创建好了表,但通过这次的测试发现它是在我们获取那个sessionFactory的时候才会帮我们生成的 

	