package DAL;
import DTO.CTDonDatHangDTO;
import DataProvider.DataProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 
 
public class CTDonDatHangDAL {
    List <CTDonDatHangDTO> listCTDonDatHang = new ArrayList<>();
    DataProvider dataProvider = new DataProvider();
    
    public  List<CTDonDatHangDTO> getData(String ma_don_dat){
        try{
            String query = "SELECT * FROM `chi_tiet_don_dat` WHERE `ma_don_dat` = '"+ma_don_dat+"'"
                    + " ORDER BY `ma_don_dat` ASC";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            while(rs.next()){
                listCTDonDatHang.add(new CTDonDatHangDTO(
                    rs.getString("ma_don_dat"),
                    rs.getString("ma_mon"),
                    rs.getString("ten_mon"),
                    rs.getInt("so_luong"),
                    rs.getInt("gia"),
                    (int)(rs.getInt("so_luong")*rs.getInt("gia"))
                ));
            }
            dataProvider.closeConnect();
        }catch(Exception e){
            e.printStackTrace();
            listCTDonDatHang = null;
        }
        return listCTDonDatHang;
    }
    public void addData(String []str){
        try {
            String query = "INSERT INTO `chi_tiet_don_dat`(`ma_don_dat`, `ma_mon`,`ten_mon`, `so_luong`, `gia`, `thanh_tien`) "
                + "VALUES ('"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"','"+str[5]+"')";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delData(String []str){
        try {
            String query = "DELETE FROM `chi_tiet_don_dat` WHERE `ma_don_dat` = '"+str[0]+"' AND `ma_mon` = '"+str[1]+"'";
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
