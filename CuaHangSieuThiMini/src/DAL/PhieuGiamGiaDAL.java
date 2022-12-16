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
 

/**
 *
 * @author mizuk
 */
public class PhieuGiamGiaDAL {
    private List <PhieuGiamGiaDTO> listPGG = new ArrayList <PhieuGiamGiaDTO>();
    DataProvider dataProvider = new DataProvider();
    
    public PhieuGiamGiaDAL(){
    }

    public List<PhieuGiamGiaDTO> getData(){
        try{
            String query = "SELECT * FROM `phieu_giam_gia`";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            
            while(rs.next()){
                PhieuGiamGiaDTO data = new PhieuGiamGiaDTO(
                    rs.getString("ma_phieu_giam_gia"),
                    rs.getString("ten_phieu_giam_gia"),
                    rs.getInt("giam"),
                    rs.getDate("ngay_bat_dau"),
                    rs.getDate("ngay_ket_thuc"),
                    rs.getInt("trang_thai")
                );
                listPGG.add(data);
            }
            dataProvider.closeConnect();
            return listPGG;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public void addData(String []arr){
        try {
            String query = "INSERT INTO`phieu_giam_gia`(`ma_phieu_giam_gia`, `ten_phieu_giam_gia`, `giam`, `ngay_bat_dau`, `ngay_ket_thuc`, `trang_thai`) "
                + "VALUES ('"+arr[0]+"', '"+arr[1]+"', '"+arr[2]+"','"+arr[3]+"','"+arr[4]+"','"+arr[5]+"')";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delData(String ma_phieu_giam_gia){
        try {
            String query = "DELETE FROM `phieu_giam_gia` WHERE `ma_phieu_giam_gia` = '"+ma_phieu_giam_gia+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `phieu_giam_gia` SET `ten_phieu_giam_gia` = '"+arr[1]+"', `giam` = '"+arr[2]+"', `ngay_bat_dau` = '"+arr[3]+"', `ngay_ket_thuc` = '"+arr[4]+"' "
                + " WHERE `ma_phieu_giam_gia` = '"+arr[0]+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getMaMax(){
        try{
            
            String query = "SELECT MAX(ma_phieu_giam_gia) as ma_phieu_giam_gia FROM `phieu_giam_gia`";
            
            ResultSet rs =  dataProvider.excuteQuery(query);
            String ma = null;
            while(rs.next()){
                 ma = rs.getString("ma_phieu_giam_gia");
            }
            dataProvider.closeConnect();
            return ma;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
    public void updateTrangThaiPhieu(String ma_pgg){
        try {
            String query = "UPDATE `phieu_giam_gia` SET `trang_thai` = '0'  WHERE `ma_phieu_giam_gia` = '"+ma_pgg+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}