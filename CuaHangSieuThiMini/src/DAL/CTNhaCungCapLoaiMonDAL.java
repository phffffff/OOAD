/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 
package DAL;
import java.util.ArrayList;
import java.util.List;
import DTO.CTNhaCungCapLoaiMonDTO;
import DataProvider.DataProvider;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author niek
 */
public class CTNhaCungCapLoaiMonDAL {
    List <CTNhaCungCapLoaiMonDTO> listCTNccLM = new ArrayList<>();
    DataProvider  dataProvider = new DataProvider();
    
    public  List<CTNhaCungCapLoaiMonDTO> getData(String ma_ncc){
        try{
            String query = "SELECT * FROM `chi_tiet_ncc_loai_mon` WHERE `ma_ncc` = '"+ma_ncc+"' "
                    + "ORDER BY `ma_ncc` ASC";
            
            ResultSet rs = dataProvider.excuteQuery(query);
            while(rs.next()){
                listCTNccLM.add(new CTNhaCungCapLoaiMonDTO(
                    rs.getString("ma_ncc"),
                    rs.getString("ma_loai")
                ));
            }
            dataProvider.closeConnect();
        }catch(Exception e){
            e.printStackTrace();
            listCTNccLM = null;
        }
        return listCTNccLM;
    }
    public void addData(String []arr, StringBuilder tb){
        try {
            String query = "INSERT INTO `chi_tiet_ncc_loai_mon`(`ma_ncc`, `ma_loai`) "
                + "VALUES ('"+arr[0]+"','"+arr[1]+"')";
            
            int kq = dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
            if(kq == 0){
                tb.append("Sản phẩm đã tồn tại");
                return;
            }
        } catch (Exception e) {
        }
        
    }
    public void delData(String []arr){
        try {
            String query = "DELETE FROM `chi_tiet_ncc_loai_mon` WHERE `ma_ncc` = '"+arr[0]+"' AND `ma_loai` = '"+arr[1]+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
        }
    }
    public void updateData(String[]str,StringBuilder t){
        try {
            String query = "UPDATE `chi_tiet_ncc_loai_mon` "
                    + "SET `ma_loai`='"+str[2]+"' WHERE  `ma_ncc`= '"+str[0]+"' AND `ma_loai` = '"+str[1]+"'";
            int kq = dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
            if(kq == 0){
                t.append("Sản phẩm đã tồn tại");
                return;
            }
        } catch (Exception e) {
        }
    }
}
