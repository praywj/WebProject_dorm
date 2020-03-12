package com.db;

import java.util.List;

import com.entity.Search;

public class SearchOperation {
	
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
	public static List<Search> select(){
		SearchOperation db=new SearchOperation();
		db.setDbo(db.getDB());
		return db.dbo.selectSearch();	
	}
	/**
	 * 更新操作
	 */
	public static boolean update(Search search){
		Boolean update=false;
		SearchOperation db=new SearchOperation();
		db.setDbo(db.getDB());
		update=db.dbo.updateSearch(search);
		
		return update;
	}
	/**
	 * 插入操作
	 * @param 
	 * @return
	 */
	public static boolean insert(Search search){
		Boolean insert=null;
		SearchOperation db=new SearchOperation();
		db.setDbo(db.getDB());
		insert=db.dbo.insertSearch(search);
		return insert;
	}
	/**
	 * 删除操作
	 */
	public static boolean delete(Search search){
		Boolean delete=null;
		SearchOperation db=new SearchOperation();
		db.setDbo(db.getDB());
		delete=db.dbo.deleteSearch(search);
		return delete;
		
	}
}
