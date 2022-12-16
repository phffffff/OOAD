///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package DAL; 
import java.util.List;
import java.util.ArrayList;
import DTO.PhanQuyenDTO;
import java.sql.ResultSet;
import DataProvider.DataProvider;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger; 
import javax.swing.JComboBox;

/**
 *
 * @author mizuk
 */
public class PhanQuyenDAL {
    List <PhanQuyenDTO> listQuyen = new ArrayList<PhanQuyenDTO>();
    DataProvider dataProvider = new DataProvider();
    
    public List<PhanQuyenDTO> getData(){
        
        try {
            String query = "SELECT * FROM `phan_quyen` ORDER BY `ma_quyen` ASC";
            ResultSet rs = dataProvider.excuteQuery(query);
            
            while(rs.next()){
                listQuyen.add(new PhanQuyenDTO(
                    rs.getInt("ma_quyen"),
                    rs.getString("quyen")
                ));
            }
            dataProvider.closeConnect();
            return listQuyen;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void addData(String []arr){
        try {
            String query = "INSERT INTO `phan_quyen`(`ma_quyen`, `quyen`) "
                + "VALUES ("+Integer.parseInt(arr[0])+",'"+arr[1]+"')";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delData(int ma_quyen){
        try {
            String query = "DELETE FROM `phan_quyen` WHERE `ma_quyen` = "+ma_quyen;
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `phan_quyen` "
                + "SET `ma_quyen`= "+Integer.parseInt(arr[0])+",`quyen`='"+arr[1]+"' "
                + "WHERE `ma_quyen` = "+Integer.parseInt(arr[0]);
//            dataProvider.getStatement();
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
}
