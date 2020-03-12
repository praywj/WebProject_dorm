package com.db;

import java.util.List;

import com.entity.Dorm;

public class DormOperation {

	/**
	 * @param args
	 */
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
	public static List<Dorm> selectDorm(){
		DormOperation db=new DormOperation();
		db.setDbo(db.getDB());
		return db.dbo.selectDorm();	
	}
	/**
	 * ���²���
	 */
	public static boolean isUpdate(Dorm dor){
		Boolean update=false;
		DormOperation db=new DormOperation();
		db.setDbo(db.getDB());
		update=db.dbo.updateDorm(dor);
		return update;
	}
	/**
	 * �������
	 * @param 
	 * @return
	 */
	public static boolean isInsert(Dorm dor){
		Boolean insert=null;
		DormOperation db=new DormOperation();
		db.setDbo(db.getDB());
		insert=db.dbo.insertDorm(dor);
		return insert;
	}
	/**
	 * ɾ������
	 */
	public static boolean isDelete(Dorm dor){
		Boolean delete=null;
		DormOperation db=new DormOperation();
		db.setDbo(db.getDB());
		delete=db.dbo.deleteDorm(dor);
		return delete;
		
	}

}
