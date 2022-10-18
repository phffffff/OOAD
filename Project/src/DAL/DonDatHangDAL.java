package DAL;
 
import DTO.DonDatHangDTO;
import DataProvider.DataProvider;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class DonDatHangDAL {
    List <DonDatHangDTO> listDDH = new ArrayList<>();
    
    DataProvider dataProvider = new DataProvider();
    
    public  List<DonDatHangDTO> getData(){
        try{
            String query = "SELECT * FROM `don_dat_hang`";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            while(rs.next()){
                listDDH.add(new DonDatHangDTO(
                    rs.getString("ma_don_dat"),
                    rs.getString("ma_ncc"),
                    rs.getDate("ngay_dat"),
                    rs.getInt("tong_tien_dat")
                ));
            }
            dataProvider.closeConnect();
        }catch(Exception e){
            e.printStackTrace();
            listDDH = null;
        }
        return listDDH;
    }
    public void addData(String []str){
        try {
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            
            String query = "INSERT INTO `don_dat_hang`(`ma_don_dat`, `ngay_dat`, `ma_ncc`, `tong_tien_dat`) "
            + "VALUES ('"+str[0]+"','"+date+"','"+str[1]+"','"+str[2]+"')";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delData(String ma_don_dat){
        try {
            String query = "DELETE FROM `don_dat_hang` WHERE `ma_don_dat` = '"+ma_don_dat+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getMaMax(){
        try{
            String query = "SELECT MAX(ma_don_dat) as ma_don_dat FROM `don_dat_hang`";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            String ma = null;
            while(rs.next()){
                 ma = rs.getString("ma_don_dat");
            }
            dataProvider.closeConnect();
            return ma;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }  
    }
}
