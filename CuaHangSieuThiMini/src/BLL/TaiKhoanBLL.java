/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.TaiKhoanDAL;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
 
/**
 *
 * @author mizuk
 */
public class TaiKhoanBLL {
    public static List<TaiKhoanDTO> listTK = new ArrayList<>();
    TaiKhoanDAL taiKhoanDAL = new TaiKhoanDAL();

    public TaiKhoanBLL() {
    }
    public void resetListTk(){
        while(listTK.size() > 0){
            listTK.remove(0);
        }
    }
    public void loadListTk(){
        listTK = new TaiKhoanDAL().getData();
    }
    //thiết lập danh sách tài khoản của ĐefaultTableModel
    public void setListTk(DefaultTableModel model){
        this.resetListTk();
        this.loadListTk();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            model.addRow(new Object[]{
                taiKhoanDTO.getMa_tai_khoan(),
                taiKhoanDTO.getTen_tai_khoan(),
                taiKhoanDTO.getMat_khau(),
                new PhanQuyenBLL().getQuyenByMaQuyen(taiKhoanDTO.getPhan_quyen()),
                (taiKhoanDTO.getTrang_thai()!= 0 ? "Đã sở hữu" : "Chưa sở hữu")
            });
        }
        model.fireTableDataChanged();
    }
    //Thiết lập compopox theo tình trnagj
    public void setTkToCombobox(DefaultComboBoxModel model){
        this.resetListTk();
        this.loadListTk();
        
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            model.addElement(taiKhoanDTO.getMa_tai_khoan());
        }
    }
    public void setTkToComboboxbyTT(DefaultComboBoxModel model){
        this.resetListTk();
        this.loadListTk();
        
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            if(taiKhoanDTO.getTrang_thai() == 0){
                model.addElement(taiKhoanDTO.getMa_tai_khoan());
            }
        }
    }
    
    public void setTkToComboboxbyMaNvHt(DefaultComboBoxModel model, int ma_nv){
        this.resetListTk();
        this.loadListTk();
        
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            if(taiKhoanDTO.getMa_tai_khoan() == ma_nv){
                model.addElement(taiKhoanDTO.getMa_tai_khoan());
            }                
        }
    }
    
    
    
    public void CapNhatTrangThaiTK(String ma_tk,String trang_thai){
        taiKhoanDAL.updateStatus(ma_tk,trang_thai);
        this.resetListTk();
        this.loadListTk();
    }
//    lấy danh sách tài khoản từ ma_tk
    public TaiKhoanDTO getTkByMaTK(int ma_tk){
        this.resetListTk();
        this.loadListTk();
        
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            if(taiKhoanDTO.getMa_tai_khoan() == ma_tk){
                return taiKhoanDTO;
            }
        }
        return null;
    }
//    Thêm tài khoản
    public void ThemTK(String []arr){
        taiKhoanDAL.addData(arr);
        this.resetListTk();
        this.loadListTk();
    }
//    sửa tk
    public void SuaTk(String []arr){
        taiKhoanDAL.updateData(arr);
        this.resetListTk();
        this.loadListTk();
    }
//    Xóa tài khoản
    public void XoaTK(int ma_tk){
        taiKhoanDAL.delData(ma_tk);
        this.resetListTk();
        this.loadListTk();
    }
    public int maMoi(){
       int ma = taiKhoanDAL.getMaMax();
       if(ma!=-1){
           return ma+1;
       }
       return 1;
       
       
    }
    //Login
    public boolean login(String username, String password){
        this.resetListTk();
        this.loadListTk();
        
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            if(taiKhoanDTO.getTen_tai_khoan().equals(username) && taiKhoanDTO.getMat_khau().equals(password)){
                return true;
            }
        }
        return false;
    }
    public int getMaTkAfterLogin(String username, String password){
        this.resetListTk();
        this.loadListTk();
        
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            if(taiKhoanDTO.getTen_tai_khoan().equals(username) && taiKhoanDTO.getMat_khau().equals(password)){
                return taiKhoanDTO.getMa_tai_khoan();
            }
        }
        return -1;
    }
    public void timkiemTKTheoMa(DefaultTableModel model, String ma_tk){
        this.resetListTk();
        this.loadListTk();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            if(String.valueOf(taiKhoanDTO.getMa_tai_khoan()).contains(ma_tk)){
                model.addRow(new Object[]{
                    taiKhoanDTO.getMa_tai_khoan(),
                    taiKhoanDTO.getTen_tai_khoan(),
                    taiKhoanDTO.getMat_khau(),
                    new PhanQuyenBLL().getQuyenByMaQuyen(taiKhoanDTO.getPhan_quyen()),
                    (taiKhoanDTO.getTrang_thai() == 1 ? "Đã sở hữu" : "Chưa sở hữu")
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timkiemTKTheoTen(DefaultTableModel model, String ten_tk){
        this.resetListTk();
        this.loadListTk();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            if(taiKhoanDTO.getTen_tai_khoan().contains(ten_tk)){
                model.addRow(new Object[]{
                    taiKhoanDTO.getMa_tai_khoan(),
                    taiKhoanDTO.getTen_tai_khoan(),
                    taiKhoanDTO.getMat_khau(),
                    new PhanQuyenBLL().getQuyenByMaQuyen(taiKhoanDTO.getPhan_quyen()),
                    (taiKhoanDTO.getTrang_thai() == 1 ? "Đã sở hữu" : "Chưa sở hữu")
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timkiemTKTheoPQ(DefaultTableModel model, String quyen){
        this.resetListTk();
        this.loadListTk();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            if(new PhanQuyenBLL().getQuyenByMaQuyen(taiKhoanDTO.getPhan_quyen()).contains(quyen)){
                model.addRow(new Object[]{
                    taiKhoanDTO.getMa_tai_khoan(),
                    taiKhoanDTO.getTen_tai_khoan(),
                    taiKhoanDTO.getMat_khau(),
                    new PhanQuyenBLL().getQuyenByMaQuyen(taiKhoanDTO.getPhan_quyen()),
                    (taiKhoanDTO.getTrang_thai() == 1 ? "Đã sở hữu" : "Chưa sở hữu")
                });
            }
        }
        model.fireTableDataChanged();
    }
    public void timkiemTKTheoTT(DefaultTableModel model, String trang_thai){
        this.resetListTk();
        this.loadListTk();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (TaiKhoanDTO taiKhoanDTO : listTK) {
            if((taiKhoanDTO.getMa_tai_khoan()==1?"Đã sở hữu":"Chưa sở hữu").contains(trang_thai)){
                model.addRow(new Object[]{
                    taiKhoanDTO.getMa_tai_khoan(),
                    taiKhoanDTO.getTen_tai_khoan(),
                    taiKhoanDTO.getMat_khau(),
                    new PhanQuyenBLL().getQuyenByMaQuyen(taiKhoanDTO.getPhan_quyen()),
                    (taiKhoanDTO.getTrang_thai() == 1 ? "Đã sở hữu" : "Chưa sở hữu")
                });
            }
        }
        model.fireTableDataChanged();
    }

    public int getTongTK() {
        this.resetListTk();
        this.loadListTk();
        
        int size = listTK.size();
        
        return size;
    }
}
