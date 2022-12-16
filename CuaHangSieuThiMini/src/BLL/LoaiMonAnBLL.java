/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL; 
import DAL.LoaiMonDAL;
import DTO.LoaiMonDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mizuk
 */
public class LoaiMonAnBLL {
    List <LoaiMonDTO> listLM = new ArrayList<LoaiMonDTO>();
    LoaiMonDAL loaiMonDAL = new LoaiMonDAL();
    
    public void resetListLM(){
        while(listLM.size() > 0){
            listLM.remove(0);
        }
    }
    public void loadListLM(){
        listLM = new LoaiMonDAL().getData();
    }
    
    public void setListLM(DefaultTableModel model){
        this.resetListLM();
        this.loadListLM();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (LoaiMonDTO loaiMonDTO : listLM) {
            model.addRow(new Object[]{
                loaiMonDTO.getMa_loai(),
                loaiMonDTO.getTen_loai()
            });
        }
        model.fireTableDataChanged();
    }
    public void ThemLM(String []str){
        loaiMonDAL.addData(str);
        this.resetListLM();
        this.loadListLM();
    }
    public void suaLM(String []str){
        loaiMonDAL.updateData(str);
        
        this.resetListLM();
        this.loadListLM();
    }
    public void delLM(String maNV){
        loaiMonDAL.delData(maNV);
        this.resetListLM();
        this.loadListLM();
    }
    //Tìm nhân viên theo mã nhân viên
    public LoaiMonDTO getLoaiByMaLoai(String ma_loai) {
        this.resetListLM();
        this.loadListLM();
        
        for (LoaiMonDTO loaiMonDTO : listLM) {
            if(loaiMonDTO.getMa_loai().equals(ma_loai)){
                return loaiMonDTO;
            }
        }
        return null;
    }

    public String maMoi() {
        String ma = loaiMonDAL.getMaMax();
        
        if(ma!=null){
            int size = ma.length();


            int maHienTai = Integer.parseInt(ma.substring(2,size));
            int maMoi = maHienTai + 1;
            if(maMoi < 10){
                return "0" + maMoi;
            }
            return maMoi+"";
        }
        return "01";
    }
    
    public String getTenLoaiByMaLoai(String ma_loai){
        this.resetListLM();
        this.loadListLM();
        for (LoaiMonDTO loaiMonDTO : listLM) {
            if(loaiMonDTO.getMa_loai().equals(ma_loai)){
                return loaiMonDTO.getTen_loai();
            }
        }
        return null;
    }
    
    public String getMaLoaiByTenLoai(String ten_loai){
        this.resetListLM();
        this.loadListLM();
        for (LoaiMonDTO loaiMonDTO : listLM) {
            if(loaiMonDTO.getTen_loai().equals(ten_loai)){
                return loaiMonDTO.getMa_loai();
            }
        }
        return null;
    }
    //thiết lập tên loại dựa trên mã loại
    public void setTenLoaiByMaLoai(DefaultComboBoxModel cbx, String ma_loai){
        this.resetListLM();
        this.loadListLM();
        
        for (LoaiMonDTO loaiMonDTO : listLM) {
            if(loaiMonDTO.getMa_loai().equals(ma_loai)){
                cbx.addElement(loaiMonDTO.getTen_loai());
                return;
            }
        }
    }
    //thiết lập tên loại cho combobox
    public void setTenLoaiToComboBox(DefaultComboBoxModel cbx){
        this.resetListLM();
        this.loadListLM();
        for (LoaiMonDTO loaiMonDTO : listLM){
            cbx.addElement(loaiMonDTO.getTen_loai());
        }
    }
    public void timLMTheoMa(DefaultTableModel model,String ma_loai){
        this.resetListLM();
        this.loadListLM();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (LoaiMonDTO loaiMonDTO : listLM) {
            if(loaiMonDTO.getMa_loai().contains(ma_loai)){
                model.addRow(new Object[]{
                    loaiMonDTO.getMa_loai(),
                    loaiMonDTO.getTen_loai()
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timLMTheoTen(DefaultTableModel model,String ten_loai){
        this.resetListLM();
        this.loadListLM();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (LoaiMonDTO loaiMonDTO : listLM) {
            if(loaiMonDTO.getTen_loai().contains(ten_loai)){
                model.addRow(new Object[]{
                    loaiMonDTO.getMa_loai(),
                    loaiMonDTO.getTen_loai()
                });
            }
        }
        model.fireTableDataChanged();
    }

    public int getTongLM() {
        this.resetListLM();
        this.loadListLM();
        
        int size = listLM.size();
        return size;
    }
    
}
