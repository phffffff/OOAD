/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PhieuGiamGiaDAL;
import DTO.PhieuGiamGiaDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/** 
 *
 * @author Acer
 */
public class PhieuGiamGiaBLL {

    public static List<PhieuGiamGiaDTO> listPGG = new ArrayList<>();
    PhieuGiamGiaDAL phieuGiamGiaDAL = new PhieuGiamGiaDAL();
    
    public PhieuGiamGiaBLL() {
    }

    public void resetListPGG() {
        while (listPGG.size() > 0) {
            listPGG.remove(0);
        }
    }

    public void loadListPGG() {
        listPGG = phieuGiamGiaDAL.getData();
    }

    public void ThemPGG(String[] str) {
        phieuGiamGiaDAL.addData(str);
        this.resetListPGG();
        this.loadListPGG();
    }

    public void suaPGG(String[] str) {
        phieuGiamGiaDAL.updateData(str);
        this.resetListPGG();
        this.loadListPGG();
    }

    public void delPGG(String maPGG) {
        phieuGiamGiaDAL.delData(maPGG);
        this.resetListPGG();
        this.loadListPGG();
    }
    public String MaMoi(){
        String ma = phieuGiamGiaDAL.getMaMax();
        if(ma!=null){
            int size = ma.length();
            int ma_hien_tai = Integer.parseInt(ma.substring(3,size));
            int ma_moi = ma_hien_tai + 1;
            if(ma_moi < 10){
                return "0"+ma_moi;
            }
            return ""+ma_moi;
        }
        return "01";
    }
    public void setTablePGG(DefaultTableModel model){
        this.resetListPGG();
        this.loadListPGG();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (PhieuGiamGiaDTO phieuGiamGiaDTO : listPGG) {
            model.addRow(new Object[]{
                phieuGiamGiaDTO.getMa_phieu_giam_gia(),
                phieuGiamGiaDTO.getTen_phieu_giam_gia(),
                phieuGiamGiaDTO.getGiam(),
                phieuGiamGiaDTO.getNgay_bat_dau(),
                phieuGiamGiaDTO.getNgay_ket_thuc(),
                (phieuGiamGiaDTO.getTrang_thai()==1 ? "Chưa sử dụng" : "Đã sử dụng")
            });
        }
        model.fireTableDataChanged();
    }
    public PhieuGiamGiaDTO getPGGbyMaPGG(String ma_PGG){
        this.resetListPGG();
        this.loadListPGG();
        
        for (PhieuGiamGiaDTO phieuGiamGiaDTO : listPGG) {
            if(phieuGiamGiaDTO.getMa_phieu_giam_gia().equals(ma_PGG)){
                return phieuGiamGiaDTO;
            }
        }
        return null;
    }
    public PhieuGiamGiaDTO getPGGbyTenPGG(String ten_PGG){
        this.resetListPGG();
        this.loadListPGG();
        
        for (PhieuGiamGiaDTO phieuGiamGiaDTO : listPGG) {
            if(phieuGiamGiaDTO.getTen_phieu_giam_gia().equals(ten_PGG)){
                return phieuGiamGiaDTO;
            }
        }
        return null;
    }
    public boolean checkDate(PhieuGiamGiaDTO x){
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        
        if(date.before(x.getNgay_ket_thuc()) && date.after(x.getNgay_bat_dau())){
            return true;
        }
        return false;
    }
    public void timKiemPhieuTheoKhoanGia(DefaultTableModel modelPGG, int giamTu, int giamDen) {
        this.resetListPGG();
        this.loadListPGG();
        
        while(modelPGG.getRowCount() > 0){
            modelPGG.removeRow(0);
        }
        for (PhieuGiamGiaDTO phieuGiamGiaDTO : listPGG){
            if(phieuGiamGiaDTO.getGiam() > giamTu && phieuGiamGiaDTO.getGiam() < giamDen){
                modelPGG.addRow(new Object[]{
                    phieuGiamGiaDTO.getMa_phieu_giam_gia(),
                    phieuGiamGiaDTO.getTen_phieu_giam_gia(),
                    phieuGiamGiaDTO.getGiam(),
                    phieuGiamGiaDTO.getNgay_bat_dau().toString(),
                    phieuGiamGiaDTO.getNgay_ket_thuc().toString(),
                    (phieuGiamGiaDTO.getTrang_thai()==1?"Chưa sử dụng":"Đã sử dụng")
                });
            }
        }
        modelPGG.fireTableDataChanged();
    }

    public void timKiemPhieuGiamGiaTheoTen(DefaultTableModel modelPGG, String search) {
        this.resetListPGG();
        this.loadListPGG();
        
        while(modelPGG.getRowCount() > 0){
            modelPGG.removeRow(0);
        }
        for (PhieuGiamGiaDTO phieuGiamGiaDTO : listPGG) {
            if(phieuGiamGiaDTO.getTen_phieu_giam_gia().contains(search)){
                modelPGG.addRow(new Object[]{
                    phieuGiamGiaDTO.getMa_phieu_giam_gia(),
                    phieuGiamGiaDTO.getTen_phieu_giam_gia(),
                    phieuGiamGiaDTO.getGiam(),
                    phieuGiamGiaDTO.getNgay_bat_dau().toString(),
                    phieuGiamGiaDTO.getNgay_ket_thuc().toString(),
                    (phieuGiamGiaDTO.getTrang_thai()==1?"Chưa sử dụng":"Đã sử dụng")
                });
            }
        }
        modelPGG.fireTableDataChanged();
    }

    public void timKiemPhieuTheoKhoanNgay(DefaultTableModel modelPGG, Date ngayTu, Date ngayDen) {
        this.resetListPGG();
        this.loadListPGG();
        
        while(modelPGG.getRowCount() > 0){
            modelPGG.removeRow(0);
        }
        for (PhieuGiamGiaDTO phieuGiamGiaDTO : listPGG) {
            if((ngayTu.before(phieuGiamGiaDTO.getNgay_bat_dau()) || ngayTu.before(phieuGiamGiaDTO.getNgay_ket_thuc())) && (ngayDen.after(phieuGiamGiaDTO.getNgay_ket_thuc()) || ngayDen.after(phieuGiamGiaDTO.getNgay_bat_dau())) && ngayTu.before(ngayDen)){
                modelPGG.addRow(new Object[]{
                    phieuGiamGiaDTO.getMa_phieu_giam_gia(),
                    phieuGiamGiaDTO.getTen_phieu_giam_gia(),
                    phieuGiamGiaDTO.getGiam(),
                    phieuGiamGiaDTO.getNgay_bat_dau().toString(),
                    phieuGiamGiaDTO.getNgay_ket_thuc().toString(),
                    (phieuGiamGiaDTO.getTrang_thai()==1?"Chưa sử dụng":"Đã sử dung")
                });
            }
        }
        modelPGG.fireTableDataChanged();
    }

    public void updateTrangThai(String ma_phieu_giam) { 
        phieuGiamGiaDAL.updateTrangThaiPhieu(ma_phieu_giam);
        this.resetListPGG();
        this.loadListPGG();
    }

    public void timKiemPhieuGiamGiaTheoMaPGG(DefaultTableModel modelPGG, String search) {
        this.resetListPGG();
        this.loadListPGG();
        
        while(modelPGG.getRowCount() > 0){
            modelPGG.removeRow(0);
        }
        for (PhieuGiamGiaDTO phieuGiamGiaDTO : listPGG) {
            if(phieuGiamGiaDTO.getMa_phieu_giam_gia().contains(search)){
                modelPGG.addRow(new Object[]{
                    phieuGiamGiaDTO.getMa_phieu_giam_gia(),
                    phieuGiamGiaDTO.getTen_phieu_giam_gia(),
                    phieuGiamGiaDTO.getGiam(),
                    phieuGiamGiaDTO.getNgay_bat_dau(),
                    phieuGiamGiaDTO.getNgay_ket_thuc(),
                    (phieuGiamGiaDTO.getTrang_thai()==1?"Chưa sử dụng":"Đã sử dụng")
                });
            }
        }
        modelPGG.fireTableDataChanged();
    }

    public void timKiemPhieuGiamGiaTheoTTPGG(DefaultTableModel modelPGG, String search) {
        this.resetListPGG();
        this.loadListPGG();
        
        while(modelPGG.getRowCount() > 0){
            modelPGG.removeRow(0);
        }
        for (PhieuGiamGiaDTO phieuGiamGiaDTO : listPGG) {
            if((phieuGiamGiaDTO.getTrang_thai()==1?"Chưa sử dụng":"Đã sử dụng").contains(search)){
                modelPGG.addRow(new Object[]{
                    phieuGiamGiaDTO.getMa_phieu_giam_gia(),
                    phieuGiamGiaDTO.getTen_phieu_giam_gia(),
                    phieuGiamGiaDTO.getGiam(),
                    phieuGiamGiaDTO.getNgay_bat_dau(),
                    phieuGiamGiaDTO.getNgay_ket_thuc(),
                    (phieuGiamGiaDTO.getTrang_thai()==1?"Chưa sử dụng":"Đã sử dụng")
                });
            }
        }
        modelPGG.fireTableDataChanged();
    }

    public int getTongPGG() {
        this.resetListPGG();
        this.loadListPGG();
        
        int size = listPGG.size();
        return size;
    }
}
