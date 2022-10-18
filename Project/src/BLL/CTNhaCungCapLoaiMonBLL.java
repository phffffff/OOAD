/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
package BLL;
import DAL.CTNhaCungCapLoaiMonDAL;
import DTO.CTNhaCungCapLoaiMonDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class CTNhaCungCapLoaiMonBLL {
    public static List<CTNhaCungCapLoaiMonDTO> listCTNccLM = new ArrayList<>();
    CTNhaCungCapLoaiMonDAL cTNhaCungCapLoaiMonDAL = new CTNhaCungCapLoaiMonDAL();
    
    public CTNhaCungCapLoaiMonBLL(){
    }
    
    public void resetListCTNccLM(){
        while(listCTNccLM.size()>0){
            listCTNccLM.remove(0);
        }
    }
    public void loadListCTNccLM(String ma_ncc){
        listCTNccLM = cTNhaCungCapLoaiMonDAL.getData(ma_ncc);
    }
    public void setTenLoaiToComboboxByMaNcc(DefaultComboBoxModel model, String ma_ncc){
        this.resetListCTNccLM();
        this.loadListCTNccLM(ma_ncc);
        
        for (CTNhaCungCapLoaiMonDTO cTNhaCungCapLoaiMonDTO : listCTNccLM) {
            model.addElement(new LoaiMonAnBLL().getTenLoaiByMaLoai(cTNhaCungCapLoaiMonDTO.getMa_loai()));
        }
    }
    public void setTableCTNCCLM(DefaultTableModel model,String ma_ncc){
        this.resetListCTNccLM();
        this.loadListCTNccLM(ma_ncc);
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (CTNhaCungCapLoaiMonDTO cTNhaCungCapLoaiMonDTO : listCTNccLM) {
            model.addRow(new Object[]{
                cTNhaCungCapLoaiMonDTO.getMa_loai(),
                new LoaiMonAnBLL().getTenLoaiByMaLoai(cTNhaCungCapLoaiMonDTO.getMa_loai())
            });
        }
        model.fireTableDataChanged();
    }
    public void addLM(String []str,StringBuilder tb){
        cTNhaCungCapLoaiMonDAL.addData(str,tb);
        this.resetListCTNccLM();
        this.loadListCTNccLM(str[0]);
    }
    public void updateLM(String []str, StringBuilder tb){
        cTNhaCungCapLoaiMonDAL.updateData(str,tb);
        this.resetListCTNccLM();
        this.loadListCTNccLM(str[0]);
    }
    public void delLM(String []str){
        cTNhaCungCapLoaiMonDAL.delData(str);
        this.resetListCTNccLM();
        this.loadListCTNccLM(str[0]);
    }
}
