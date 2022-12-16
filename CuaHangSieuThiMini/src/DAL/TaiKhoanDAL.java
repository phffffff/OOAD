/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.*;
import DataProvider.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mizuk
 */
public class TaiKhoanDAL {
    private List <TaiKhoanDTO> listTK = new ArrayList <TaiKhoanDTO>();
    DataProvider dataProvider = new DataProvider();
    
    public TaiKhoanDAL(){
    }
    public List<TaiKhoanDTO> getData(){
        
        try {
            String query = "SELECT * FROM `tai_khoan`";
            ResultSet rs = dataProvider.excuteQuery(query);
            while(rs.next()){
                TaiKhoanDTO data = new TaiKhoanDTO(
                    rs.getInt("ma_tai_khoan"),
                    rs.getString("ten_tai_khoan"),
                    rs.getString("mat_khau"),
                    rs.getInt("phan_quyen"),
                    rs.getInt("trang_thai")
                );
                listTK.add(data);
            }
            dataProvider.closeConnect();
            return listTK;
        } catch (Exception ex) {
            Logger.getLogger(TaiKhoanDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public int getMaMax(){
        try{
            
            String query = "SELECT MAX(ma_tai_khoan) as ma_tk FROM `tai_khoan`";
            
            ResultSet rs =  dataProvider.excuteQuery(query);
            int ma = 0;
            while(rs.next()){
                 ma = rs.getInt("ma_tk");
            }
            dataProvider.closeConnect();
            return ma;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }        
    }
    
    public void addData(String []arr){
        try{
            String query = "INSERT INTO `tai_khoan` (`ma_tai_khoan`, `ten_tai_khoan`, `mat_khau`, `phan_quyen`,`trang_thai`) "
                + "VALUES ('"+arr[0]+"', '"+arr[1]+"', '"+arr[2]+"', '"+arr[3]+"','"+arr[4]+"')";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void delData(int ma_tai_khoan){
        try {
            String query = "DELETE FROM `tai_khoan` WHERE `ma_tai_khoan` = '"+ma_tai_khoan+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `tai_khoan` SET"
                    + " `ten_tai_khoan` = '"+arr[1]+"',`mat_khau` = '"+arr[2]+"',`phan_quyen` = '"+arr[3]+"',`trang_thai` = '"+arr[4]+"' "
                    + "WHERE `ma_tai_khoan` = '"+arr[0]+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
        }
    }
    public void updateUsernameAndPass(String []str){
        try {
            String query = "UPDATE `tai_khoan` SET"
                    + " `ten_tai_khoan` = '"+str[1]+"', `mat_khau` = '"+str[2]+"' "
                    + "WHERE `ma_tai_khoan` = '"+str[0]+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
        }
    }
    public void updateStatus(String ma_tk,String trang_thai){
        try {
            String query = "UPDATE `tai_khoan` SET `trang_thai` = '"+trang_thai+"' WHERE `ma_tai_khoan` = "+ma_tk;
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
