/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import DataProvider.*; 
import DTO.CTHoaDonDTO;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author mizuk
 */
public class CTHoaDonDAL {
    List <CTHoaDonDTO> listBillInfo = new ArrayList<CTHoaDonDTO>();
    DataProvider dataProvider = new DataProvider();
    
    public List<CTHoaDonDTO> getData(String ma_hd){
        try{
            String query = "SELECT * FROM `chi_tiet_hoa_don` WHERE `ma_hoa_don` = '"+ma_hd+"' "
                    + "ORDER BY `ma_hoa_don` ASC";
            
            ResultSet rs  = dataProvider.excuteQuery(query);
            while(rs.next()){
                listBillInfo.add(new CTHoaDonDTO(
                    rs.getString("ma_hoa_don"),
                    rs.getString("ma_mon"),
                    rs.getString("ten_mon"),
                    rs.getInt("so_luong"),
                    rs.getInt("gia_mon"),
                    rs.getInt("thanh_tien")
                ));
            }
            dataProvider.closeConnect();
            return listBillInfo;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void insertData(String []str){
        try {
            String query = "INSERT INTO `chi_tiet_hoa_don`(`ma_hoa_don`, `ma_mon`, `ten_mon`, `so_luong`, `gia_mon`, `thanh_tien`) "
                + "VALUES ('"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"')";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delData(String []str){
        try {
            String query = "DELETE FROM `chi_tiet_hoa_don` WHERE `ma_hoa_don` = '"+str[0]+"' AND `ma_mon` = '"+str[1]+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
