/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.NhaCungCapDAL;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author thanh
 */
public class NhaCungCapBLL {
    public static List<NhaCungCapDTO> listNCC = new ArrayList<>();
    NhaCungCapDAL nhaCungCapDAL = new NhaCungCapDAL();
    
    public NhaCungCapBLL() {
    }
    public void resetListNCC(){
        while(listNCC.size() > 0){
            listNCC.remove(0);
        }
    }
    public void loadListNCC(){
        listNCC = nhaCungCapDAL.getData();
    }
    //set list lên table list
    public  void setListNCC(DefaultTableModel model){
        this.resetListNCC();
        this.loadListNCC();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        
        for (NhaCungCapDTO nhaCungCapDTO : listNCC) {
            model.addRow(new Object[]{
                nhaCungCapDTO.getMa_ncc(),
                nhaCungCapDTO.getTen_ncc(),
                nhaCungCapDTO.getDia_chi()
            });
        }
        model.fireTableDataChanged();
    }
   
    
    public void ThemNCC(String []str){
        nhaCungCapDAL.addData(str);
        this.resetListNCC();
        this.loadListNCC();
    }
    public void suaNCC(String []str){
        nhaCungCapDAL.updateData(str);
        this.resetListNCC();
        this.loadListNCC();
    }
    public void delNCC(String maNV){
        nhaCungCapDAL.delData(maNV);
        this.resetListNCC();
        this.loadListNCC();
    }
    //Tìm NCC theo mã ncc
    public NhaCungCapDTO getNccByMaNcc(String ma_ncc) {
        this.resetListNCC();
        this.loadListNCC();
        
        for (NhaCungCapDTO nhaCungCapDTO : listNCC) {
            if(nhaCungCapDTO.getMa_ncc().equals(ma_ncc)){
                return nhaCungCapDTO;
            }
        }
        return null;
    }
    public String getTenNccByMaNcc(String ma_ncc){
        this.resetListNCC();
        this.loadListNCC();
        
        for (NhaCungCapDTO nhaCungCapDTO : listNCC) {
            if(nhaCungCapDTO.getMa_ncc().equals(ma_ncc)){
                return nhaCungCapDTO.getTen_ncc();
            }
        }
        return null;
    }
    
    public void setTenNccToCombobox(DefaultComboBoxModel model){
        this.resetListNCC();
        this.loadListNCC();
        
        for (NhaCungCapDTO nhaCungCapDTO : listNCC) {
            model.addElement(nhaCungCapDTO.getTen_ncc());
        }
    }
    
    public String getMaNccByTenNcc(String ten_ncc){
        this.resetListNCC();
        this.loadListNCC();
        
        for (NhaCungCapDTO nhaCungCapDTO : listNCC) {
            if(nhaCungCapDTO.getTen_ncc().equals(ten_ncc)){
                return nhaCungCapDTO.getMa_ncc();
            }
        }
        return null;
    }
    
    public String maMoi() {
        String ma = nhaCungCapDAL.getMaMax();
        
        if(ma!=null){
            int size = ma.length();


            int maHienTai = Integer.parseInt(ma.substring(3,size));
            int maMoi = maHienTai + 1;
            if(maMoi < 10){
                return "0" + maMoi;
            }
            return maMoi+"";
        }
        return "01";
    }

    public void timKiemNccTheoMa(DefaultTableModel modelNCC, String search) {
        this.resetListNCC();
        this.loadListNCC();
        
        while(modelNCC.getRowCount() > 0){
            modelNCC.removeRow(0);
        }
        for (NhaCungCapDTO nhaCungCapDTO : listNCC) {
            if(nhaCungCapDTO.getMa_ncc().contains(search)){
                modelNCC.addRow(new Object[]{
                    nhaCungCapDTO.getMa_ncc(),
                    nhaCungCapDTO.getTen_ncc(),
                    nhaCungCapDTO.getDia_chi(),
                });
            }
        }
        modelNCC.fireTableDataChanged();
    }

    public void timKiemNccTheoTen(DefaultTableModel modelNCC, String search) {
        this.resetListNCC();
        this.loadListNCC();
        
        while(modelNCC.getRowCount() > 0){
            modelNCC.removeRow(0);
        }
        for (NhaCungCapDTO nhaCungCapDTO : listNCC) {
            if(nhaCungCapDTO.getTen_ncc().contains(search)){
                modelNCC.addRow(new Object[]{
                    nhaCungCapDTO.getMa_ncc(),
                    nhaCungCapDTO.getTen_ncc(),
                    nhaCungCapDTO.getDia_chi(),
                });
            }
        }
        modelNCC.fireTableDataChanged();
    }

    public void timKiemNccTheoDC(DefaultTableModel modelNCC, String search) {
        this.resetListNCC();
        this.loadListNCC();
        
        while(modelNCC.getRowCount() > 0){
            modelNCC.removeRow(0);
        }
        for (NhaCungCapDTO nhaCungCapDTO : listNCC) {
            if(nhaCungCapDTO.getDia_chi().contains(search)){
                modelNCC.addRow(new Object[]{
                    nhaCungCapDTO.getMa_ncc(),
                    nhaCungCapDTO.getTen_ncc(),
                    nhaCungCapDTO.getDia_chi(),
                });
            }
        }
        modelNCC.fireTableDataChanged();
    }

    public int getTongNVV() {
        this.resetListNCC();
        this.loadListNCC();
        
        int size = listNCC.size();
        
        return size;
                
    }
}
