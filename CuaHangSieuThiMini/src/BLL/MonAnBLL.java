/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.MonAnDAL;
import DTO.MonAnDTO;
//import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author mizuk
 */
public class MonAnBLL {
    public static List<MonAnDTO> listMA = new ArrayList<>();
    MonAnDAL monAnDAL = new MonAnDAL();
    
    public MonAnBLL(){
    }
    
    public void resetListMA(){
        while(listMA.size()>0){
            listMA.remove(0);
        }
    }
    public void loadListMA(){
        listMA = monAnDAL.getData();
    }
    
    public void setListTableMA(DefaultTableModel model){
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        
        for (MonAnDTO monAnDTO : listMA) {
            model.addRow(new Object[]{
                monAnDTO.getMa_mon(),
                monAnDTO.getTen_mon(),
                monAnDTO.getSo_luong(),
                monAnDTO.getGia(),
                monAnDTO.getGia_giam(),
                (int)(monAnDTO.getGia()-monAnDTO.getGia_giam()),
                new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
            });
        }
        model.fireTableDataChanged();
    }
    //Thêm món mới
    public void ThemMon(String []arr){
        monAnDAL.addData(arr);
        this.resetListMA();
        this.loadListMA();
    }
    //SỬa món
    public void SuaMon(String []arr){
        monAnDAL.updateData(arr);
        this.resetListMA();
        this.loadListMA();
    }
    //Xóa Món ăn
    public void XoaMon(String arr){
        monAnDAL.delData(arr);
        this.resetListMA();
        this.loadListMA();
    }
    public String maMoi(){
       
       String ma = monAnDAL.getMaMax();
       
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
    //Lấy số lượng món tối đa theo maMon
    public int getCountFood(String maMon){
        this.resetListMA();
        this.loadListMA();
        
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getMa_mon().equals(maMon)){
                return monAnDTO.getSo_luong();
            }
        }
        return -1;
    }
    // Tìm món theo maMon
    public MonAnDTO getFoodByMaMon(String maMon){
        this.resetListMA();
        this.loadListMA();
        
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getMa_mon().equals(maMon)){
                return monAnDTO;
            }
        }
        return null;
    }
    public String getMaMonByTenMon(String ten_mon){
        this.resetListMA();
        this.loadListMA();
        
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getTen_mon().equals(ten_mon)){
                return monAnDTO.getMa_mon();
            }
        }
        return null;
    }
    public void suaGiaMonTheoKM(String ma_mon, int gia_giam){
        monAnDAL.updatePriceFromData(ma_mon,gia_giam);
        this.resetListMA();
        this.loadListMA();
    }
    public void setListFoodByMaLoai(DefaultTableModel model, String maLoai){
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getMa_loai().equals(maLoai)){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getGia(),
                    monAnDTO.getSo_luong()
                });
            }
            model.fireTableDataChanged();
        }   
    }
    public void setMonAnToComboboxByMaLoai(DefaultComboBoxModel<String> model, String maLoai){
        this.resetListMA();
        this.loadListMA();
        
        while (model.getSize() > 0) {
            model.removeElementAt(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getMa_loai().equals(maLoai)){
                model.addElement(monAnDTO.getTen_mon());
            }
        }
    }
    public void updateSoLuongSauKhiNhapHang(String ma_mon,int so_luong){
        this.resetListMA();
        this.loadListMA();
        int soLuongCu = this.getFoodByMaMon(ma_mon).getSo_luong();
        int soLuongUpdate = soLuongCu + so_luong;
        monAnDAL.updateCountFromData(ma_mon, soLuongUpdate);
        this.resetListMA();
        this.loadListMA();
    }
    public void updateSoLuongSauKhiKhachMua(String ma_mon,int so_luong){
        this.resetListMA();
        this.loadListMA();
        int soLuongCu = this.getFoodByMaMon(ma_mon).getSo_luong();
        int soLuongMoi = soLuongCu - so_luong;
        monAnDAL.updateCountFromData(ma_mon, soLuongMoi);
        this.resetListMA();
        this.loadListMA();
    }
            
    public void timkiemMonAnTheoMa(DefaultTableModel model, String ma_mon){
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getMa_mon().contains(ma_mon)){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getSo_luong(),
                    monAnDTO.getGia(),
                    monAnDTO.getGia_giam(),
                    monAnDTO.getGia()-monAnDTO.getGia_giam(),
                    new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timkiemMonAnTheoten(DefaultTableModel model, String ten_mon) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getTen_mon().contains(ten_mon)){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getSo_luong(),
                    monAnDTO.getGia(),
                    monAnDTO.getGia_giam(),
                    monAnDTO.getGia()-monAnDTO.getGia_giam(),
                    new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timkiemMonAnTheoSL(DefaultTableModel model, String so_luong) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(String.valueOf(monAnDTO.getSo_luong()).contains(so_luong)){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getSo_luong(),
                    monAnDTO.getGia(),
                    monAnDTO.getGia_giam(),
                    monAnDTO.getGia()-monAnDTO.getGia_giam(),
                    new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timkiemMonAnTheoGia(DefaultTableModel model, String gia) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(String.valueOf(monAnDTO.getGia()).contains(gia)){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getSo_luong(),
                    monAnDTO.getGia(),
                    monAnDTO.getGia_giam(),
                    monAnDTO.getGia()-monAnDTO.getGia_giam(),
                    new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timkiemMonAnTheoGiaGiam(DefaultTableModel model, String gia_giam) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(String.valueOf(monAnDTO.getGia_giam()).contains(gia_giam)){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getSo_luong(),
                    monAnDTO.getGia(),
                    monAnDTO.getGia_giam(),
                    monAnDTO.getGia()-monAnDTO.getGia_giam(),
                    new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timkiemMonAnTheoGiaHT(DefaultTableModel model, String gia_hien_tai) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(String.valueOf(monAnDTO.getGia()-monAnDTO.getGia_giam()).contains(gia_hien_tai)){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getSo_luong(),
                    monAnDTO.getGia(),
                    monAnDTO.getGia_giam(),
                    monAnDTO.getGia()-monAnDTO.getGia_giam(),
                    new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timkiemMonAnTheoTenLoai(DefaultTableModel model, String ten_loai) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai()).contains(ten_loai)){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getSo_luong(),
                    monAnDTO.getGia(),
                    monAnDTO.getGia_giam(),
                    monAnDTO.getGia()-monAnDTO.getGia_giam(),
                    new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timkiemMonAnTheoKhoangGia(DefaultTableModel model, int giaFrom, int giaTo) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getGia() > giaFrom && monAnDTO.getGia() < giaTo){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getSo_luong(),
                    monAnDTO.getGia(),
                    monAnDTO.getGia_giam(),
                    monAnDTO.getGia()-monAnDTO.getGia_giam(),
                    new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
                });
            }
        }
        model.fireTableDataChanged();
    }
    public  void timkiemMonAnTheoKhoangSL(DefaultTableModel model, int soLuongFrom, int soLuongTo){
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getSo_luong() > soLuongFrom && monAnDTO.getSo_luong() < soLuongTo){
                model.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getSo_luong(),
                    monAnDTO.getGia(),
                    monAnDTO.getGia_giam(),
                    monAnDTO.getGia()-monAnDTO.getGia_giam(),
                    new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timkiemMonAnDNTheoMa(DefaultTableModel model, String search, String ma_loai) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getMa_loai().equals(ma_loai)){
                if(monAnDTO.getMa_mon().contains(search)){
                    model.addRow(new Object[]{
                        monAnDTO.getMa_mon(),
                        monAnDTO.getTen_mon(),
                        monAnDTO.getGia(),
                    });
                }
            }
        }
        model.fireTableDataChanged();
    }

    public void timkiemMonAnDNTheoTen(DefaultTableModel model, String search, String ma_loai) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getMa_loai().equals(ma_loai)){
                if(monAnDTO.getTen_mon().contains(search)){
                    model.addRow(new Object[]{
                        monAnDTO.getMa_mon(),
                        monAnDTO.getTen_mon(),
                        monAnDTO.getGia(),
                    });
                }
            }
        }
        model.fireTableDataChanged();
    }

    public void timkiemMonAnDNTheoKhoangGia(DefaultTableModel model, int giaFrom, int giaTo, String ma_loai) {
        this.resetListMA();
        this.loadListMA();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for (MonAnDTO monAnDTO : listMA) {
            if(monAnDTO.getMa_loai().equals(ma_loai)){
                if(monAnDTO.getGia() > giaFrom && monAnDTO.getGia() < giaTo){
                    model.addRow(new Object[]{
                        monAnDTO.getMa_mon(),
                        monAnDTO.getTen_mon(),
                        monAnDTO.getGia(),
                    });
                }
            }
        }
        model.fireTableDataChanged();
    }

    public int getTongMA() {
        this.resetListMA();
        this.loadListMA();
        
        int size = listMA.size();
        
        return size;
        
    }
}
