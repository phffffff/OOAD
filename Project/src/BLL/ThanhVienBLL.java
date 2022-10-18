/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ThanhVienDAL;
import DTO.ThanhVienDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/** 
 *
 * @author Acer
 */
public class ThanhVienBLL {

    public static List<ThanhVienDTO> listTV = new ArrayList<>();
    ThanhVienDAL thanhVienDAL = new ThanhVienDAL();
    
    public ThanhVienBLL() {
    }

    public void resetListTV() {
        while (listTV.size() > 0) {
            listTV.remove(0);
        }
    }

    public void loadListTV() {
        listTV = new ThanhVienDAL().getData();
    }

    public void ThemTV(String[] str) {
        thanhVienDAL.addData(str);
        this.resetListTV();
        this.loadListTV();
    }

    public void suaTV(String[] str) {
        thanhVienDAL.updateData(str);
        this.resetListTV();
        this.loadListTV();
    }
    public void delTV(String ma_thanh_vien) {
        thanhVienDAL.delData(ma_thanh_vien);
        this.resetListTV();
        this.loadListTV();
    }
    public void setTableListTV(DefaultTableModel model){
        this.resetListTV();
        this.loadListTV();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (ThanhVienDTO thanhVienDTO : listTV) {
            model.addRow(new Object[]{
                thanhVienDTO.getMa_thanh_vien(),
                thanhVienDTO.getMat_khau(),
                thanhVienDTO.getTen_thanh_vien(),
                thanhVienDTO.getNgay_sinh(),
                thanhVienDTO.getSdt(),
                thanhVienDTO.getMail(),
                thanhVienDTO.getPoint()
            });
        }
        model.fireTableDataChanged();
    }
    public ThanhVienDTO getTvByMaTV(String ma_thanh_vien){
        this.resetListTV();
        this.loadListTV();
        
        for (ThanhVienDTO thanhVienDTO : listTV) {
            if(thanhVienDTO.getMa_thanh_vien().equals(ma_thanh_vien)){
                return thanhVienDTO;
            }
        }
        return null;
    }
    public String maMoi(){
        this.resetListTV();
        this.loadListTV();
        
        String ma = thanhVienDAL.getMaMax();
        if(ma != null){
            int size = ma.length();
            int ma_hien_tai = Integer.parseInt(ma.substring(2,size));
            int ma_moi = ma_hien_tai + 1;
            if(ma_moi < 10){
                return "0"+ma_moi;
            }
            return ""+ma_moi;
        }
        return "01";
    }
    public boolean checkMaThanhVien(String ma_thanh_vien){
        this.resetListTV();
        this.loadListTV();
        
        for (ThanhVienDTO thanhVienDTO : listTV) {
            if(thanhVienDTO.getMa_thanh_vien().equals(ma_thanh_vien)){
                return true;
            }
        }
        return false;
    }
    public boolean checkMatKhau(String mat_khau){
        this.loadListTV();
        this.loadListTV();
        
        for (ThanhVienDTO thanhVienDTO : listTV) {
            if(thanhVienDTO.getMat_khau().equals(mat_khau)){
                return true;
            }
        }
        return false;
    }
    public void capNhatDiemTichLuy(String []str){
        thanhVienDAL.updatePoint(str);
        this.resetListTV();
        this.loadListTV();
    }
    
    public void timKiemThanhVienTheoMaTv(DefaultTableModel modelTV, String search) {
        this.resetListTV();
        this.loadListTV();
        
        while(modelTV.getRowCount() > 0){
            modelTV.removeRow(0);
        }
        for (ThanhVienDTO thanhVienDTO : listTV) {
            if(thanhVienDTO.getMa_thanh_vien().contains(search)){
                modelTV.addRow(new Object[]{
                    thanhVienDTO.getMa_thanh_vien(),
                    thanhVienDTO.getMat_khau(),
                    thanhVienDTO.getTen_thanh_vien(),
                    thanhVienDTO.getNgay_sinh(),
                    thanhVienDTO.getSdt(),
                    thanhVienDTO.getMail(),
                    thanhVienDTO.getPoint(),
                });
            }
        }
        modelTV.fireTableDataChanged();
    }

    public void timKiemThanhVienTheoTenTV(DefaultTableModel modelTV, String search) {
        this.resetListTV();
        this.loadListTV();
        
        while(modelTV.getRowCount() > 0){
            modelTV.removeRow(0);
        }
        for (ThanhVienDTO thanhVienDTO : listTV) {
            if(thanhVienDTO.getTen_thanh_vien().contains(search)){
                modelTV.addRow(new Object[]{
                    thanhVienDTO.getMa_thanh_vien(),
                    thanhVienDTO.getMat_khau(),
                    thanhVienDTO.getTen_thanh_vien(),
                    thanhVienDTO.getNgay_sinh(),
                    thanhVienDTO.getSdt(),
                    thanhVienDTO.getMail(),
                    thanhVienDTO.getPoint(),
                });
            }
        }
        modelTV.fireTableDataChanged();
    }

    public void timKiemThanhVienTheoSDT(DefaultTableModel modelTV, String search) {
        this.resetListTV();
        this.loadListTV();
        
        while(modelTV.getRowCount() > 0){
            modelTV.removeRow(0);
        }
        for (ThanhVienDTO thanhVienDTO : listTV) {
            if(thanhVienDTO.getSdt().contains(search)){
                modelTV.addRow(new Object[]{
                    thanhVienDTO.getMa_thanh_vien(),
                    thanhVienDTO.getMat_khau(),
                    thanhVienDTO.getTen_thanh_vien(),
                    thanhVienDTO.getNgay_sinh(),
                    thanhVienDTO.getSdt(),
                    thanhVienDTO.getMail(),
                    thanhVienDTO.getPoint(),
                });
            }
        }
        modelTV.fireTableDataChanged();
    }

    public void timKiemThanhVienTheoMail(DefaultTableModel modelTV, String search) {
        this.resetListTV();
        this.loadListTV();
        
        while(modelTV.getRowCount() > 0){
            modelTV.removeRow(0);
        }
        for (ThanhVienDTO thanhVienDTO : listTV) {
            if(thanhVienDTO.getMail().contains(search)){
                modelTV.addRow(new Object[]{
                    thanhVienDTO.getMa_thanh_vien(),
                    thanhVienDTO.getMat_khau(),
                    thanhVienDTO.getTen_thanh_vien(),
                    thanhVienDTO.getNgay_sinh(),
                    thanhVienDTO.getSdt(),
                    thanhVienDTO.getMail(),
                    thanhVienDTO.getPoint(),
                });
            }
        }
        modelTV.fireTableDataChanged();
    }

    public void timKiemThanhVienTheoKhoanDiem(DefaultTableModel modelTV, int diemFrom, int diemTo) {
        this.resetListTV();
        this.loadListTV();
        
        while(modelTV.getRowCount() > 0){
            modelTV.removeRow(0);
        }
        for (ThanhVienDTO thanhVienDTO : listTV) {
            if(thanhVienDTO.getPoint()>diemFrom && thanhVienDTO.getPoint()<diemTo){
                modelTV.addRow(new Object[]{
                    thanhVienDTO.getMa_thanh_vien(),
                    thanhVienDTO.getMat_khau(),
                    thanhVienDTO.getTen_thanh_vien(),
                    thanhVienDTO.getNgay_sinh(),
                    thanhVienDTO.getSdt(),
                    thanhVienDTO.getMail(),
                    thanhVienDTO.getPoint(),
                });
            }
        }
        modelTV.fireTableDataChanged();
    }

    public void timKiemThanhVienTheoKhoanNS(DefaultTableModel modelTV, Date NgayFrom, Date NgayTo) {
        this.resetListTV();
        this.loadListTV();
        
        while(modelTV.getRowCount() > 0){
            modelTV.removeRow(0);
        }
        for (ThanhVienDTO thanhVienDTO : listTV) {
            if(thanhVienDTO.getNgay_sinh().before(NgayTo) && thanhVienDTO.getNgay_sinh().after(NgayFrom)){
                modelTV.addRow(new Object[]{
                    thanhVienDTO.getMa_thanh_vien(),
                    thanhVienDTO.getMat_khau(),
                    thanhVienDTO.getTen_thanh_vien(),
                    thanhVienDTO.getNgay_sinh(),
                    thanhVienDTO.getSdt(),
                    thanhVienDTO.getMail(),
                    thanhVienDTO.getPoint(),
                });
            }
        }
        modelTV.fireTableDataChanged();
    }

    public int getTongTV() {
        this.resetListTV();
        this.loadListTV();
        
        int size = listTV.size();
        
        return size;
    }
}
