package DAL;
import DTO.LoaiMonDTO;
import DataProvider.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

/**
 *
 * @author mizuk
 */
public class LoaiMonDAL {
    List <LoaiMonDTO> listCategory = new ArrayList<>();
    List <LoaiMonDTO> listCategoryName = new ArrayList<>();
    DataProvider dataProvider = new DataProvider();
    
    public List<LoaiMonDTO> getData(){
        try{
            String query = "SELECT * FROM `loai_thuc_an` ORDER BY ma_loai ASC";
            
            ResultSet rs =  dataProvider.excuteQuery(query);
            while(rs.next()){
                listCategory.add(new LoaiMonDTO(
                    rs.getString("ma_loai"),
                    rs.getString("ten_loai")
                ));
            }
            dataProvider.closeConnect();
            return listCategory;
        }catch(Exception e){
            return null;
        }    
    }
    public String getMaMax(){
        try{
            String query = "SELECT MAX(ma_loai) as ma_loai FROM `loai_thuc_an`";
            
            ResultSet rs =  dataProvider.excuteQuery(query);
            String ma = null;
            while(rs.next()){
                 ma = rs.getString("ma_loai");
            }
            dataProvider.closeConnect();
            return ma;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
    public void addData(String []arr){
        try {
            String query = "INSERT INTO `loai_thuc_an`(`ma_loai`, `ten_loai`) VALUES ('"+arr[0]+"','"+arr[1]+"')";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void delData(String ma_loai){
        try {
            String query = "DELETE FROM `loai_thuc_an` WHERE `ma_loai` = '"+ma_loai+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `loai_thuc_an` SET `ten_loai`='"+arr[0]+"' WHERE `ma_loai` = '"+arr[1]+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
