/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
 
import DAL.ChuongTrinhKMDAL;
import DTO.ChuongTrinhKMDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author niek
 */
public class CTKhuyenMaiBLL {
    public static List<ChuongTrinhKMDTO> listKM = new ArrayList<>();
    ChuongTrinhKMDAL chuongTrinhKMDAL = new ChuongTrinhKMDAL();
    
    public CTKhuyenMaiBLL(){
    }
    
    public void resetListKM(){
        while(listKM.size()>0){
            listKM.remove(0);
        }
    }
    public void loadListKM(){
        listKM = chuongTrinhKMDAL.getData();
    }
    public void setListTableKM(DefaultTableModel model){
        this.resetListKM();
        this.loadListKM();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (ChuongTrinhKMDTO chuongTrinhKMDTO : listKM) {
            model.addRow(new Object[]{
                chuongTrinhKMDTO.getMa_ctkm(),
                chuongTrinhKMDTO.getTen_ctkm(),
                chuongTrinhKMDTO.getNgay_bat_dau(),
                chuongTrinhKMDTO.getNgay_ket_thuc(),
                chuongTrinhKMDTO.getTrang_thai()
            });
        }
        model.fireTableDataChanged();
    }
    public void doiTrangThai(int ma_ctkm,String tt){
        chuongTrinhKMDAL.updateStatus(ma_ctkm,tt);
        this.resetListKM();
        this.loadListKM();
    }
    public void themCTKM(String []str){
        chuongTrinhKMDAL.addData(str);
        this.resetListKM();
        this.loadListKM();
    }
    public void suaCTKM(String arr[]){
        chuongTrinhKMDAL.updateData(arr);
        this.resetListKM();
        this.loadListKM();
    }
    public  void xoaCTKM(int ma_ctkm){
        chuongTrinhKMDAL.delData(ma_ctkm);
        this.resetListKM();
        this.loadListKM();
    }
    public int maMoi(){
       int maHienTai = chuongTrinhKMDAL.getMaMax();
       
       if(maHienTai!=-1){
            int maMoi = maHienTai + 1;
            return maMoi;
       }
       return 1;
    }
    public ChuongTrinhKMDTO getCtkmByMaCTKM(int ma_ctkm){
        this.resetListKM();
        this.loadListKM();
        
        for (ChuongTrinhKMDTO chuongTrinhKMDTO : listKM) {
            if(chuongTrinhKMDTO.getMa_ctkm() == ma_ctkm){
                return chuongTrinhKMDTO;
            }
        }
        return null;
    }
    public boolean checkKm(){
        this.resetListKM();
        this.loadListKM();
        
        boolean flag = false;
        for (ChuongTrinhKMDTO chuongTrinhKMDTO : listKM) {
            if(chuongTrinhKMDTO.getTrang_thai() == 1){
                flag = true;
            }
        }
        return flag;
    }

    public void timKiemCtkmTheoMa(DefaultTableModel modelCTKM, String search) {
        this.resetListKM();
        this.loadListKM();
        
        while(modelCTKM.getRowCount() > 0){
            modelCTKM.removeRow(0);
        }
        for (ChuongTrinhKMDTO chuongTrinhKMDTO : listKM) {
            if(String.valueOf(chuongTrinhKMDTO.getMa_ctkm()).contains(search)){
                modelCTKM.addRow(new Object[]{
                    chuongTrinhKMDTO.getMa_ctkm(),
                    chuongTrinhKMDTO.getTen_ctkm(),
                    chuongTrinhKMDTO.getNgay_bat_dau(),
                    chuongTrinhKMDTO.getNgay_ket_thuc(),
                    chuongTrinhKMDTO.getTrang_thai()
                });
            }
        }
        modelCTKM.fireTableDataChanged();
    }

    public void timKiemCtkmTheoTen(DefaultTableModel modelCTKM, String search) {
        this.resetListKM();
        this.loadListKM();
        
        while(modelCTKM.getRowCount() > 0){
            modelCTKM.removeRow(0);
        }
        for (ChuongTrinhKMDTO chuongTrinhKMDTO : listKM) {
            if(chuongTrinhKMDTO.getTen_ctkm().contains(search)){
                modelCTKM.addRow(new Object[]{
                    chuongTrinhKMDTO.getMa_ctkm(),
                    chuongTrinhKMDTO.getTen_ctkm(),
                    chuongTrinhKMDTO.getNgay_bat_dau(),
                    chuongTrinhKMDTO.getNgay_ket_thuc(),
                    chuongTrinhKMDTO.getTrang_thai()
                });
            }
        }
        modelCTKM.fireTableDataChanged();
    }
    public void timKiemCtkmTheoTT(DefaultTableModel modelCTKM, String search) {
        this.resetListKM();
        this.loadListKM();
        
        while(modelCTKM.getRowCount() > 0){
            modelCTKM.removeRow(0);
        }
        for (ChuongTrinhKMDTO chuongTrinhKMDTO : listKM) {
            if(String.valueOf(chuongTrinhKMDTO.getTrang_thai()).equals(search)){
                modelCTKM.addRow(new Object[]{
                    chuongTrinhKMDTO.getMa_ctkm(),
                    chuongTrinhKMDTO.getTen_ctkm(),
                    chuongTrinhKMDTO.getNgay_bat_dau(),
                    chuongTrinhKMDTO.getNgay_ket_thuc(),
                    chuongTrinhKMDTO.getTrang_thai()
                });
            }
        }
        modelCTKM.fireTableDataChanged();
    }       

    public void timKiemCtkmTheoNgay(DefaultTableModel modelCTKM, String search) throws ParseException {
        Date ngay =  new SimpleDateFormat("yyyy/MM/dd").parse(search);
        this.resetListKM();
        this.loadListKM();
        
        while(modelCTKM.getRowCount() > 0){
            modelCTKM.removeRow(0);
        }
        for (ChuongTrinhKMDTO chuongTrinhKMDTO : listKM) {
            if(chuongTrinhKMDTO.getNgay_bat_dau().before(ngay) && chuongTrinhKMDTO.getNgay_ket_thuc().after(ngay)){
                modelCTKM.addRow(new Object[]{
                    chuongTrinhKMDTO.getMa_ctkm(),
                    chuongTrinhKMDTO.getTen_ctkm(),
                    chuongTrinhKMDTO.getNgay_bat_dau().toString(),
                    chuongTrinhKMDTO.getNgay_ket_thuc().toString(),
                    chuongTrinhKMDTO.getTrang_thai()
                });
            }
        }
        modelCTKM.fireTableDataChanged();
    }

    public void timKiemKMTheoKhoanNgay(DefaultTableModel model, Date ngayTu, Date ngayDen) {
        this.loadListKM();
        this.resetListKM();
//        System.out.println(ngayTu.before(ngayDen));
        
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (ChuongTrinhKMDTO chuongTrinhKMDTO : listKM) {
            if( (ngayTu.before(chuongTrinhKMDTO.getNgay_bat_dau()) || ngayTu.before(chuongTrinhKMDTO.getNgay_ket_thuc())) && (ngayDen.after(chuongTrinhKMDTO.getNgay_ket_thuc()) || ngayDen.after(chuongTrinhKMDTO.getNgay_bat_dau())) && ngayTu.before(ngayDen)){
                model.addRow(new Object[]{
                    chuongTrinhKMDTO.getMa_ctkm(),
                    chuongTrinhKMDTO.getTen_ctkm(),
                    chuongTrinhKMDTO.getNgay_bat_dau(),
                    chuongTrinhKMDTO.getNgay_ket_thuc(),
                    chuongTrinhKMDTO.getTrang_thai()
                });
            }
        }
        model.fireTableDataChanged();
    }

    public int getTongCTKM() {
        this.resetListKM();
        this.loadListKM();
        
        int size = listKM.size();
        return size;
    }
}