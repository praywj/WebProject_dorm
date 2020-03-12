package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.entity.*;

/**
 * DBOperation类是连接数据库的类
 * @author Administrator
 *
 */
public class DBOperation {
	/**
	 * 无参的构造方法
	 */
	public DBOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 定义类的属性
	 */
	private String driver=null;//连接数据库的驱动
	private String url=null;//连接数据库所需要的URL
	private String user="sa";//连接数据库时所需要的用户名
	private String passWord="123";//连接数据库时所需要的密码
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	/**
	 * 连接时所需要的工具
	 */
	private Connection  conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	/**
	 * 连接数据库
	 */
	public void connectionDB(){
		try {
			driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			url="jdbc:sqlserver://localhost:1433;databasename=dorm_wj";
			user="sa";
			passWord="123";
			//注册驱动
			Class.forName(driver);
			//建立数据库的连接
			conn=DriverManager.getConnection(url,user,passWord);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}
	/**
	 * 关闭数据库
	 */
	private void closeDB(){
    	try {
			if(rs!=null){
				rs.close();
				}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	/**
	 * 数据库的查询,查询stu表中的信息
	 */
	public List<Stu> selectStu(){
		connectionDB();
		String sql="select * from stu";
		List<Stu> users=new ArrayList<Stu>();
     	try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			Stu user=null;
			while(rs.next()){
				user=new Stu();
				user.setSno(rs.getString("sno"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				
				user.setDno(rs.getString("dno"));
				user.setTno(rs.getString("tno"));
				user.setTel(rs.getString("tel"));
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return users;
	}
	
	
	
	
	
	/**
	 *  对表stu进行更新操作
	 *  
	 */
	public boolean updateStu(Stu b){
		connectionDB();
		boolean  isUpdate=false;
		String sql="update stu set name=?,sex=?,dno=?,tno=?,tel=? where sno=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(6, b.getSno());
			ps.setString(2, b.getSex());
			ps.setString(1, b.getName());
			ps.setString(3, b.getDno());
			ps.setString(4, b.getTno());
			ps.setString(5, b.getTel());
			
			int rows=ps.executeUpdate();
			isUpdate=rows>0?true:false;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return isUpdate;
	}
	/**
	 * 对stu表进行增加操作
	 */
	public boolean insertStu(Stu b){
		connectionDB();
		boolean isUpdate=false;
		String sql="insert into stu values(?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, b.getSno());
			ps.setString(2, b.getSex());
			ps.setString(3, b.getName());
			ps.setString(4, b.getDno());
			ps.setString(5, b.getTno());
			ps.setString(6, b.getTel());
			int rows=ps.executeUpdate();
			isUpdate=rows>0?true:false;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
			
		}
		return isUpdate;
	}
	/**
	 * 对stu表进行删除操作
	 * 
	 */
	public boolean deleteStu(Stu b){
		Boolean isDeleted =null;
		connectionDB();
		String sql="delete from stu where sno=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, b.getSno());
			int rows=ps.executeUpdate();
			isDeleted=rows>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return isDeleted;
	}
	
	/**
	 * 从数据库中查询表dorm
	 */
	public List<Dorm> selectDorm(){
		connectionDB();
		String sql=" select * from dorm";
		List<Dorm> dorms=new ArrayList<Dorm>();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			Dorm dorm=null;
			while(rs.next()){
				dorm=new Dorm();
				dorm.setDno(rs.getString("dno"));
				dorm.setTno(rs.getString("tno"));
				dorm.setSno(rs.getString("sno"));
				dorms.add(dorm);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return dorms;
		
	}
	
	/**
	 * 对dorm表进行update更新操作
	 */
	public boolean updateDorm(Dorm s){
		Boolean isUpdated=null;
		connectionDB();
		String sql=" update dorm set tno=?,sno=? where dno=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(3, s.getDno());
			ps.setString(1, s.getTno());
			ps.setString(2, s.getSno());
			int rows=ps.executeUpdate();
			isUpdated=rows>0?true:false;
			System.out.println(rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
	}
	/**
	 * 对表dorm进行insert操作
	 */
	public boolean insertDorm(Dorm s){
		Boolean isInserted=null;
		connectionDB();
		String sql="insert into dorm values(?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, s.getDno());
			ps.setString(2, s.getTno());
			ps.setString(3, s.getSno());
			int rows=ps.executeUpdate();
			isInserted=rows>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return isInserted;
	}
	/**
	 * 对表dorm进行delete操作
	 */
	public boolean deleteDorm(Dorm s){
		Boolean isDeleted=null;
		connectionDB();
		String sql="delete from dorm where dno=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,s.getDno());
			int rows=ps.executeUpdate();
			isDeleted=rows>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return isDeleted;
	}
	
	/**
	 * 从数据库中查询表search
	 */
	public List<Search> selectSearch(){
		connectionDB();
		String sql=" select * from search";
		List<Search> searchs=new ArrayList<Search>();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			Search search=null;
			while(rs.next()){
				search=new Search();
				search.setDno(rs.getString("dno"));
				search.setTno(rs.getString("tno"));
				search.setSno(rs.getString("sno"));
				search.setName(rs.getString("name"));
				search.setDat(rs.getString("dat"));
				searchs.add(search);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return searchs;
		
	}
	
	/**
	 * 对search表的insert操作
	 */
	
	public  boolean insertSearch(Search user){
		Boolean isInsert=null;
		connectionDB();
		String sql="insert into search values(?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getDat());
			ps.setString(2, user.getSno());
			ps.setString(3, user.getName());
			ps.setString(4, user.getTno());
			ps.setString(5,user.getDno());
			
			int rows=ps.executeUpdate();
			isInsert=rows>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return isInsert;
	}
	/**
	 * 对search  进行更新操作
	 */
	
	public boolean updateSearch(Search user){
		Boolean isUpdate=false;
		connectionDB();
		String sql="update search set dno=?,tno=?,name=? where sno=? and date=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(5, user.getDat());
			ps.setString(4, user.getSno());
			ps.setString(3, user.getName());
			ps.setString(2, user.getTno());
			ps.setString(1,user.getDno());
			
			int rows=ps.executeUpdate();
			
			isUpdate=rows>0 ? true : false ;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return isUpdate;
	}
	
	/**
	 * 对search进行删除
	 */
	public boolean deleteSearch(Search user){
		Boolean isdelete=null;
		connectionDB();
		String sql="delete search where sno=? and date=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(2, user.getDat());
			ps.setString(1, user.getSno());
			int rows=ps.executeUpdate();
			isdelete=rows>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return isdelete;
		
	}


/**
 * 从数据库中查询表storey
 */
public List<Storey> selectStorey(){
	connectionDB();
	String sql=" select * from storey";
	List<Storey> storeys=new ArrayList<Storey>();
	try {
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		Storey storey=null;
		while(rs.next()){
			storey=new Storey();
			storey.setTname(rs.getString("tname"));
			storey.setTno(rs.getString("tno"));
			storey.setTmanager(rs.getString("tmanager"));
			
			storeys.add(storey);		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		closeDB();
	}
	return storeys;
}
/**
 * 对storey  进行插入操作
 */
public  boolean insertStorey(Storey user){
	Boolean isInsert=null;
	connectionDB();
	String sql="insert into storey values(?,?,?)";
	try {
		ps=conn.prepareStatement(sql);
		ps.setString(1, user.getTno());
		ps.setString(2, user.getTname());
		ps.setString(3, user.getTmanager());
		
		
		int rows=ps.executeUpdate();
		isInsert=rows>0?true:false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		closeDB();
	}
	return isInsert;
}
/**
 * 对storey  进行更新操作
 */

public boolean updateStorey(Storey user){
	Boolean isUpdate=null;
	connectionDB();
	String sql=" update storey set tname=?,tmanager=? where tno=?";
	try {
		ps=conn.prepareStatement(sql);
		ps.setString(3, user.getTno());
		ps.setString(1, user.getTname());
		ps.setString(2, user.getTmanager());
		
		int rows=ps.executeUpdate();
		isUpdate=rows>0?true:false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		closeDB();
	}
	return isUpdate;
}

/**
 * 对storey进行删除
 */
public boolean deleteStorey(Storey user){
	Boolean isdelete=null;
	connectionDB();
	String sql="delete storey where tno=?";
	try {
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, user.getTno());
		int rows=ps.executeUpdate();
		isdelete=rows>0?true:false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		closeDB();
	}
	return isdelete;
	
}
}

