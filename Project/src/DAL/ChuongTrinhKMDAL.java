package DAL;

import DTO.ChuongTrinhKMDTO;
import DataProvider.DataProvider;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class ChuongTrinhKMDAL {
    List <ChuongTrinhKMDTO> listKM = new ArrayList<>(); 
    DataProvider dataProvider = new DataProvider();
    
    public  List<ChuongTrinhKMDTO> getData(){
        try{
            String query = "SELECT * FROM `chuong_trinh_khuyen_mai`";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            while(rs.next()){
                listKM.add(new ChuongTrinhKMDTO(
                    rs.getInt("ma_ctkm"),
                    rs.getString("ten_ctkm"),
                    rs.getDate("ngay_bat_dau"),
                    rs.getDate("ngay_ket_thuc"),
                    rs.getInt("trang_thai")
                ));
            }
            dataProvider.closeConnect();
        }catch(Exception e){
            e.printStackTrace();
            listKM = null;
        }
        return listKM;
    }
    public int getMaMax(){
        try{
            String query = "SELECT MAX(ma_ctkm) as ma_ctkm FROM `chuong_trinh_khuyen_mai`";
            
            ResultSet rs =  dataProvider.excuteQuery(query);
            int ma = 0;
            while(rs.next()){
                 ma = rs.getInt("ma_ctkm");
            }
            dataProvider.closeConnect();
            return ma;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        } 
    }
    public void addData(String []arr){
        try {
            String query = "INSERT INTO `chuong_trinh_khuyen_mai`(`ma_ctkm`, `ten_ctkm`, `ngay_bat_dau`, `ngay_ket_thuc`,`trang_thai`) "
                + "VALUES ('"+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"','0')";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void delData(int ma_ctkm){
        try {
            String query = "DELETE FROM `chuong_trinh_khuyen_mai` WHERE `ma_ctkm` = '"+ma_ctkm+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `chuong_trinh_khuyen_mai` SET"
                + " `ten_ctkm`='"+arr[1]+"',`ngay_bat_dau`='"+arr[2]+"',`ngay_ket_thuc`='"+arr[3]+"'"
                + " WHERE `ma_ctkm`='"+arr[0]+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void updateStatus(int ma_ctkm,String tt){
        try {
            String query = "UPDATE `chuong_trinh_khuyen_mai` SET `trang_thai` = '"+tt+"' WHERE `ma_ctkm`='"+ma_ctkm+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
