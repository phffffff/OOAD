package DAL;

import DTO.CTChuongTrinhKMDTO;
import DataProvider.DataProvider;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List;
 
public class CTChuongTrinhKMDAL {
    List <CTChuongTrinhKMDTO> listChuongTrinhKM = new ArrayList<>();
    DataProvider dataProvider = new DataProvider();
    
    public  List<CTChuongTrinhKMDTO> getDataByID(int ma_ctkm){
        try{
            String query = "SELECT * "
                    + "FROM `chi_tiet_ct_khuyen_mai` as ct,`mon_an` as ma,`loai_thuc_an` as lma "
                    + "WHERE ct.`ma_mon` = ma.`ma_mon` AND ma.`ma_loai` = lma.`ma_loai` "
                    + "AND ct.`ma_ctkm` = '"+ma_ctkm+"' ORDER BY ct.`ma_ctkm` ASC";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            while(rs.next()){
                listChuongTrinhKM.add(new CTChuongTrinhKMDTO(
                    rs.getString("ma_mon"),
                    rs.getString("ten_mon"),
                    rs.getInt("gia"),
                    rs.getInt("tien_giam"),
                    (int)(rs.getInt("gia") - rs.getInt("tien_giam")),
                    rs.getString("ten_loai")
                ));
            }
            dataProvider.closeConnect();
            return listChuongTrinhKM;
        }catch(Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    public void addData(String []arr){
        try {
            String query = "INSERT INTO `chi_tiet_ct_khuyen_mai`(`ma_ctkm`, `ma_mon`, `tien_giam`) "
                + "VALUES ('"+arr[0]+"','"+arr[1]+"','"+arr[2]+"')";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    public void delData(int ma_ctkm, String ma_mon){
        try {
            String query = "DELETE FROM `chi_tiet_ct_khuyen_mai` WHERE `ma_ctkm` = '"+ma_ctkm+"' AND "
                + "`ma_mon` = '"+ma_mon+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `chi_tiet_ct_khuyen_mai` "
                + "SET `tien_giam`='"+arr[2]+"' WHERE `ma_ctkm` = '"+arr[0]+"' AND `ma_mon` = '"+arr[1]+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
}
