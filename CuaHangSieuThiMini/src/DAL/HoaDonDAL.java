/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import DTO.HoaDonDTO;
import DataProvider.*; 
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author mizuk
 */
public class HoaDonDAL {
    List <HoaDonDTO> listBill = new ArrayList<HoaDonDTO>();
    DataProvider dataProvider = new DataProvider();
    
    public  List<HoaDonDTO> getData(){
        try{
            String query = "SELECT * FROM `hoa_don` ORDER BY ma_hoa_don ASC";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            while(rs.next()){
                listBill.add(new HoaDonDTO(
                    rs.getString("ma_hoa_don"),
                    rs.getDate("ngay_xuat"),
                    rs.getString("ma_nhan_vien"),
                    rs.getString("ma_thanh_vien"),
                    rs.getInt("tong_tien"),
                    rs.getInt("tien_giam"),
                    rs.getInt("tien_con_lai"),
                    rs.getString("ma_phieu_giam_gia"),
                    rs.getInt("diem")                     
                ));
            }
            dataProvider.closeConnect();
            return listBill;
        }catch(Exception e){
            e.printStackTrace();            
        }
        return null;
    }
    public String getMaMax(){
        try {
            String query = "SELECT MAX(`ma_hoa_don`) as ma_hoa_don FROM `hoa_don` ORDER BY ma_hoa_don ASC";
            ResultSet rs = dataProvider.excuteQuery(query);
            String ma = null;
            while(rs.next()){
                ma = rs.getString("ma_hoa_don");
            }       
            dataProvider.closeConnect();
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //lấy BillId từ những Bill đã chưa checkout (status = 0)
    public void addData(String []arr){
        try {
            String query = "INSERT INTO `hoa_don`(`ma_hoa_don`, `ngay_xuat`, `ma_nhan_vien`, `ma_thanh_vien`, `tong_tien`, `tien_giam`, `tien_con_lai`, `ma_phieu_giam_gia`, `diem`) "
            + "VALUES ('"+arr[0]+"','"+arr[8]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"','"+arr[4]+"','"+arr[5]+"','"+arr[6]+"','"+arr[7]+"')";

            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delData(String ma_hoa_don){
        try {
            String query = "DELETE FROM `hoa_don` WHERE `ma_hoa_don` = '"+ma_hoa_don+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

