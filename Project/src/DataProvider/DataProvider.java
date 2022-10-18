/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataProvider;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author mizuk
 */
public class DataProvider {
    private static final String url = "jdbc:mysql://localhost:3306/do_an_java";
    private static final String user = "root";
    private static final String password  = "";
    
    public static Connection connect;
    public static Statement st = null;
    public static ResultSet rs = null;
    
//    public static ResultSet connect(String query, boolean flag){
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//            
//            Statement st = conn.createStatement();
//            
//            if(flag)
//                return st.executeQuery(query);
//            else
//                st.executeUpdate(query);
//        } catch (SQLException ex) {
//            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    public static void close(){
//        try {
//            
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    
    public DataProvider()
    {
    }
    // sử dụng lớp 
    public Connection getConnect() 
    {
	connect = null;
	try {
                connect =  (Connection) DriverManager.getConnection(url,user,password);
            }catch(SQLException er){
                    System.out.println(er.toString());
              }
	return (Connection) connect;
    
    }

    public Statement getStatement() throws Exception{
        try{
            if(this.st == null ? true : this.st.isClosed()){
                this.st = this.getConnect().createStatement();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
    }
        return this.st;
    }
     public ResultSet excuteQuery(String qry) throws Exception{
        try{
            this.rs = this.getStatement().executeQuery(qry);
        } catch (Exception ex){
            throw new Exception("Error: "+ex.getMessage()+"-"+qry);
    }
        return this.rs;
    }
    public int ExecuteUpdate(String qry) throws Exception{
        int res = 0;
        try{
            res = this.getStatement().executeUpdate(qry);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }
    public void closeConnect() throws SQLException{
        if(this.rs != null && !this.rs.isClosed()){
            this.rs.close();
            this.rs = null;
        }
        if(this.st != null && !this.st.isClosed()){
            this.st.close();
            this.st = null;
    }
        if(this.connect != null && !this.connect.isClosed()){
            this.connect.close();
            this.connect = null;
        }
    }
}   
