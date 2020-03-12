package com.db;

import java.util.List;

import com.entity.Storey;

public class StoreyOperation {
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
	public static List<Storey> selectStorey(){
		StoreyOperation db=new StoreyOperation();
		db.setDbo(db.getDB());
		return db.dbo.selectStorey();	
	}
	/**
	 * ���²���
	 */
	public static boolean isUpdate(Storey storey){
		Boolean update=null;
		StoreyOperation db=new StoreyOperation();
		db.setDbo(db.getDB());
		update=db.dbo.updateStorey(storey);
		return update;
	}
	/**
	 * �������
	 * @param 
	 * @return
	 */
	public static boolean isInsert(Storey storey){
		Boolean insert=null;
		StoreyOperation db=new StoreyOperation();
		db.setDbo(db.getDB());
		insert=db.dbo.insertStorey(storey);
		return insert;
	}
	/**
	 * ɾ������
	 */
	public static boolean isDelete(Storey storey){
		Boolean delete=null;
		StoreyOperation db=new StoreyOperation();
		db.setDbo(db.getDB());
		delete=db.dbo.deleteStorey(storey);
		return delete;
		
	}

}
