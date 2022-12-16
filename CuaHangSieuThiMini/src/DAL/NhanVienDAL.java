/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.*;
import DataProvider.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList; 
import java.util.List;
/**
 *
 * @author mizuk
 */
public class NhanVienDAL {
    private List <NhanVienDTO> listNV = new ArrayList <NhanVienDTO>();
    DataProvider dataProvider = new DataProvider();
    
    public NhanVienDAL(){
    }

    public List<NhanVienDTO> getData(){
        try{
            String query = "SELECT * FROM `nhan_vien`";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            
            while(rs.next()){
                NhanVienDTO data = new NhanVienDTO(
                    rs.getString("ma_nhan_vien"),
                    rs.getString("ten_nhan_vien"),
                    rs.getDate("ngay_sinh"),
                    rs.getString("sdt"),
                    rs.getString("mail"),
                    rs.getInt("tai_khoan")
                );
                listNV.add(data);
            }
            dataProvider.closeConnect();
            return listNV;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void addData(String []arr){
        try {
            String query = "INSERT INTO `nhan_vien`(`ma_nhan_vien`, `ten_nhan_vien`, ngay_sinh, `sdt`, `mail`, `tai_khoan`) "
                + "VALUES ('"+arr[0]+"', '"+arr[1]+"', '"+arr[2]+"','"+arr[3]+"','"+arr[4]+"', '"+arr[5]+"')";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delData(String ma_nhan_vien){
        try {
            String query = "DELETE FROM `nhan_vien` WHERE `ma_nhan_vien` = '"+ma_nhan_vien+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `nhan_vien` SET `ten_nhan_vien` = '"+arr[1]+"',`ngay_sinh` = '"+arr[2]+"', `sdt` = '"+arr[3]+"' "
                + " ,`mail` ='"+arr[4]+"' ,`tai_khoan` = '"+arr[5]+"' WHERE `ma_nhan_vien` = '"+arr[0]+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getMaMax(){
        try{
            String query = "SELECT MAX(ma_nhan_vien) as ma_nv FROM `nhan_vien`";
            
            ResultSet rs =  dataProvider.excuteQuery(query);
            String ma = null;
            while(rs.next()){
                 ma = rs.getString("ma_nv");
            }
            dataProvider.closeConnect();
            return ma;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
}