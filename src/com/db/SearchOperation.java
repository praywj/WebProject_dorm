package com.db;

import java.util.List;

import com.entity.Search;

public class SearchOperation {
	
	/**
	 * ����dbo
	 */
	private DBOperation dbo;
	/**
	 * ���Ե�get��set����
	 * @return
	 */
	public DBOperation getDbo() {
		return dbo;
	}

	public void setDbo(DBOperation dbo) {
		this.dbo = dbo;
	}
	/**
	 * ���ݿ�ĳ�ʼ��
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
	 * ��ѯ����
	 * @return
	 */
	public static List<Search> select(){
		SearchOperation db=new SearchOperation();
		db.setDbo(db.getDB());
		return db.dbo.selectSearch();	
	}
	/**
	 * ���²���
	 */
	public static boolean update(Search search){
		Boolean update=false;
		SearchOperation db=new SearchOperation();
		db.setDbo(db.getDB());
		update=db.dbo.updateSearch(search);
		
		return update;
	}
	/**
	 * �������
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
	 * ɾ������
	 */
	public static boolean delete(Search search){
		Boolean delete=null;
		SearchOperation db=new SearchOperation();
		db.setDbo(db.getDB());
		delete=db.dbo.deleteSearch(search);
		return delete;
		
	}
}
