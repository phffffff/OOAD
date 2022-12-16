/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
 
/**
 *
 * @author Acer
 */
public class NhanVienBLL {
    public static List<NhanVienDTO> listNV = new ArrayList<>();
    NhanVienDAL nhanVienDAL = new NhanVienDAL();
    
    public NhanVienBLL() {
    }
    public void resetListNV(){
        while(listNV.size() > 0){
            listNV.remove(0);
        }
    }
    public void loadListNV(){
        listNV = new NhanVienDAL().getData();
    }
    //set list lên table list
    public  void setListNV(DefaultTableModel model){
        this.resetListNV();
        this.loadListNV();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        
        for (NhanVienDTO nhanVienDTO : listNV) {
            model.addRow(new Object[]{
                nhanVienDTO.getMa_nhan_vien(),
                nhanVienDTO.getTen_nhan_vien(),
                nhanVienDTO.getNgay_sinh(),
                nhanVienDTO.getSdt(),
                nhanVienDTO.getMail(),
                nhanVienDTO.getTai_khoan()
            });
        }
        model.fireTableDataChanged();
    }
   
    
    public void ThemNV(String []str){
        nhanVienDAL.addData(str);
        this.resetListNV();
        this.loadListNV();
    }
    public void suaNV(String []str){
        nhanVienDAL.updateData(str);
        
        this.resetListNV();
        this.loadListNV();
    }
    public void delNV(String maNV){
        nhanVienDAL.delData(maNV);
        this.resetListNV();
        this.loadListNV();
    }
    //Tìm nhân viên theo mã nhân viên
    public NhanVienDTO getNvByMaNV(String ma_nhan_vien) {
        this.resetListNV();
        this.loadListNV();
        
        for (NhanVienDTO nhanVienDTO : listNV) {
            if(nhanVienDTO.getMa_nhan_vien().equals(ma_nhan_vien)){
                return nhanVienDTO;
            }
        }
        return null;
    }

    public String maMoi() {
        String ma = nhanVienDAL.getMaMax();
        
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

    public void timkiemNVTheoMa(DefaultTableModel model, String ma_nv) {
        this.resetListNV();
        this.loadListNV();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (NhanVienDTO nhanVienDTO : listNV) {
            if(nhanVienDTO.getMa_nhan_vien().contains(ma_nv)){
                model.addRow(new Object[]{
                    nhanVienDTO.getMa_nhan_vien(),
                    nhanVienDTO.getTen_nhan_vien(),
                    nhanVienDTO.getNgay_sinh(),
                    nhanVienDTO.getSdt(),
                    nhanVienDTO.getMail(),
                    nhanVienDTO.getTai_khoan(),
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timkiemNVTheoTen(DefaultTableModel model, String ten_nv) {
        this.resetListNV();
        this.loadListNV();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (NhanVienDTO nhanVienDTO : listNV) {
            if(nhanVienDTO.getTen_nhan_vien().contains(ten_nv)){
                model.addRow(new Object[]{
                    nhanVienDTO.getMa_nhan_vien(),
                    nhanVienDTO.getTen_nhan_vien(),
                    nhanVienDTO.getNgay_sinh(),
                    nhanVienDTO.getSdt(),
                    nhanVienDTO.getMail(),
                    nhanVienDTO.getTai_khoan(),
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timkiemNVTheoSDT(DefaultTableModel model, String sdt) {
        this.resetListNV();
        this.loadListNV();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (NhanVienDTO nhanVienDTO : listNV) {
            if(nhanVienDTO.getSdt().contains(sdt)){
                model.addRow(new Object[]{
                    nhanVienDTO.getMa_nhan_vien(),
                    nhanVienDTO.getTen_nhan_vien(),
                    nhanVienDTO.getNgay_sinh(),
                    nhanVienDTO.getSdt(),
                    nhanVienDTO.getMail(),
                    nhanVienDTO.getTai_khoan(),
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timkiemNVTheoMail(DefaultTableModel model, String mail) {
        this.resetListNV();
        this.loadListNV();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (NhanVienDTO nhanVienDTO : listNV) {
            if(nhanVienDTO.getMail().contains(mail)){
                model.addRow(new Object[]{
                    nhanVienDTO.getMa_nhan_vien(),
                    nhanVienDTO.getTen_nhan_vien(),
                    nhanVienDTO.getNgay_sinh(),
                    nhanVienDTO.getSdt(),
                    nhanVienDTO.getMail(),
                    nhanVienDTO.getTai_khoan(),
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timkiemNVTheoTK(DefaultTableModel model, String tk) {
        this.resetListNV();
        this.loadListNV();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (NhanVienDTO nhanVienDTO : listNV) {
            if(String.valueOf(nhanVienDTO.getTai_khoan()).contains(tk)){
                model.addRow(new Object[]{
                    nhanVienDTO.getMa_nhan_vien(),
                    nhanVienDTO.getTai_khoan(),
                    nhanVienDTO.getNgay_sinh(),
                    nhanVienDTO.getSdt(),
                    nhanVienDTO.getMail(),
                    nhanVienDTO.getTai_khoan(),
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timkiemNVTheoNS(DefaultTableModel model, Date ngayPd, Date ngayKt) {
        this.resetListNV();
        this.loadListNV();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        
        for (NhanVienDTO nhanVienDTO : listNV) {
            if(nhanVienDTO.getNgay_sinh().before(ngayKt) && nhanVienDTO.getNgay_sinh().after(ngayPd)){
               model.addRow(new Object[]{
                    nhanVienDTO.getMa_nhan_vien(),
                    nhanVienDTO.getTai_khoan(),
                    nhanVienDTO.getNgay_sinh(),
                    nhanVienDTO.getSdt(),
                    nhanVienDTO.getMail(),
                    nhanVienDTO.getTai_khoan(),
                });
            }
        }
        model.fireTableDataChanged();
    }
    public String getMaNvByMaTk(int ma_tk){
        this.resetListNV();
        this.loadListNV();
        
        for (NhanVienDTO nhanVienDTO : listNV) {
            if(ma_tk == nhanVienDTO.getTai_khoan()){
                return nhanVienDTO.getMa_nhan_vien();
            }
        }
        return null;
    }

    public int getTongNV() {
        this.resetListNV();
        this.loadListNV();
        
        int size = listNV.size();
        
        return size;
    }
}

