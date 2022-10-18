/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 
package DAL;
import DTO.*;
import DataProvider.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thanh
 */
public class NhaCungCapDAL {
    List <NhaCungCapDTO> listNCC = new ArrayList <NhaCungCapDTO>();

    DataProvider dataProvider = new DataProvider();
    
    public NhaCungCapDAL(){
    }

    public List<NhaCungCapDTO> getData(){
        try{
            String query = "SELECT * FROM `nha_cung_cap`";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            
            while(rs.next()){
                NhaCungCapDTO data = new NhaCungCapDTO(
                    rs.getString("ma_ncc"),
                    rs.getString("ten_ncc"),
                    rs.getString("dia_chi")
                );
                listNCC.add(data);
            }
            dataProvider.closeConnect();
            return listNCC;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void addData(String []arr){
        try {
            String query = "INSERT INTO `nha_cung_cap` (`ma_ncc`, `ten_ncc`, `dia_chi`) "
                + "VALUES ('"+arr[0]+"', '"+arr[1]+"', '"+arr[2]+"')";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delData(String ma_ncc){
        try {
            String query = "DELETE FROM `nha_cung_cap` WHERE `ma_ncc` = '"+ma_ncc+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `nha_cung_cap` "
                + "SET `ten_ncc`='"+arr[1]+"',`dia_chi`='"+arr[2]+"' WHERE `ma_ncc`='"+arr[0]+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public String getMaMax(){
        try{
            String query = "SELECT MAX(ma_ncc) as ma_ncc FROM `nha_cung_cap`";
            ResultSet rs =  dataProvider.excuteQuery(query);
            String ma = null;
            while(rs.next()){
                 ma = rs.getString("ma_ncc");
            }
            dataProvider.closeConnect();
            return ma;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
}
