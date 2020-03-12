package com.db;

import java.util.List;

import com.entity.Stu;

public class StuOperation {
	/**
	 * 属性dbo
	 */
	private DBOperation dbo;
	/**
	 * 属性的get与set方法
	 * @return
	 */
	public DBOperation getDbo() {
		return dbo;
	}

	public void setDbo(DBOperation dbo) {
		this.dbo = dbo;
	}
	/**
	 * 数据库的初始化
	 * @return
	 */
	private   DBOperation getDB(){
		DBOperation dbo1=new DBOperation();
		dbo1.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dbo1.setUrl("jdbc:sqlserver://localhost:1433;databasename=dorm_wj");
		dbo1.setUser("sa");
		dbo1.setPassWord("123");
		return dbo1;
	}
	/**
	 * 查询操作
	 * @return
	 */
	public static List<Stu> selectStu(){
		StuOperation db=new StuOperation();
		db.setDbo(db.getDB());
		return db.dbo.selectStu();	
	}
	/**
	 * 更新操作
	 */
	public static boolean isUpdate(Stu stu){
		Boolean update=null;
		StuOperation db=new StuOperation();
		db.setDbo(db.getDB());
		update=db.dbo.updateStu(stu);
		return update;
	}
	/**
	 * 插入操作
	 * @param 
	 * @return
	 */
	public static boolean isInsert(Stu stu){
		Boolean insert=null;
		StuOperation db=new StuOperation();
		db.setDbo(db.getDB());
		insert=db.dbo.insertStu(stu);
		return insert;
	}
	/**
	 * 删除操作
	 */
	public static boolean isDelete(Stu stu){
		Boolean delete=null;
		StuOperation db=new StuOperation();
		db.setDbo(db.getDB());
		delete=db.dbo.deleteStu(stu);
		return delete;
		
	}
}
