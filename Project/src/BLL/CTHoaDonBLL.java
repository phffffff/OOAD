/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 
package BLL;

import DAL.CTHoaDonDAL;
import DTO.CTHoaDonDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author niek
 */
public class CTHoaDonBLL {
    private static List<CTHoaDonDTO> listCTHD = new ArrayList<>();
    CTHoaDonDAL cTHoaDonDAL = new CTHoaDonDAL();
    
    public CTHoaDonBLL(){
    }
    public void resetListCTHD(){
        while(!listCTHD.isEmpty()){
            listCTHD.remove(0);
        }
    }
    public void loadListCTHD(String ma_hd){
        listCTHD = cTHoaDonDAL.getData(ma_hd);
    }
    public void taoCTHoaDonToHoaDon(DefaultTableModel model,String ma_hd){
        for(int i = 0 ; i < model.getRowCount() ; i++){
            String ma_mon = (String) model.getValueAt(i,0);
            String ten_mon = (String) model.getValueAt(i,1);
            String gia = String.valueOf(model.getValueAt(i,2));
            String so_luong = String.valueOf(model.getValueAt(i,3));
            String thanh_tien = String.valueOf(model.getValueAt(i,4));
            
            cTHoaDonDAL.insertData(new String[]{ma_hd,ma_mon,ten_mon,so_luong,gia,thanh_tien});
            new MonAnBLL().updateSoLuongSauKhiKhachMua(ma_mon,Integer.parseInt(so_luong));
        }
        this.resetListCTHD();
        this.loadListCTHD(ma_hd);
    }
    public void setTableCTHD(DefaultTableModel model,String ma_hd){
        this.resetListCTHD();
        this.loadListCTHD(ma_hd);
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        
        for (CTHoaDonDTO cTHoaDonDTO : listCTHD) {
            model.addRow(new Object[]{
                cTHoaDonDTO.getMa_mon(),
                cTHoaDonDTO.getTen_mon(),
                cTHoaDonDTO.getSo_luong(),
                cTHoaDonDTO.getGia_mon(),
                cTHoaDonDTO.getThanh_tien()
            });
        }
        model.fireTableDataChanged();
    }
    public void xoaCTHD(String []str){
        cTHoaDonDAL.delData(str);
        this.resetListCTHD();
        this.loadListCTHD(str[0]);
    }
    public void timKiemCTHDTheoMaMon(DefaultTableModel modelCT, String search,String ma_hd) {
        this.resetListCTHD();
        this.loadListCTHD(ma_hd);
        
        while(modelCT.getRowCount() > 0){
            modelCT.removeRow(0);
        }
        for (CTHoaDonDTO cTHoaDonDTO : listCTHD) {
            if(cTHoaDonDTO.getMa_mon().contains(search)){
                modelCT.addRow(new Object[]{
                    cTHoaDonDTO.getMa_mon(),
                    cTHoaDonDTO.getTen_mon(),
                    cTHoaDonDTO.getSo_luong(),
                    cTHoaDonDTO.getGia_mon(),
                    cTHoaDonDTO.getThanh_tien()
                });
            }
        }
        modelCT.fireTableDataChanged();
    }

    public void timKiemCTHDTheoTenMon(DefaultTableModel modelCT, String search, String ma_hd) {
        this.resetListCTHD();
        this.loadListCTHD(ma_hd);
        
        while(modelCT.getRowCount() > 0){
            modelCT.removeRow(0);
        }
        for (CTHoaDonDTO cTHoaDonDTO : listCTHD) {
            if(cTHoaDonDTO.getTen_mon().contains(search)){
                modelCT.addRow(new Object[]{
                    cTHoaDonDTO.getMa_mon(),
                    cTHoaDonDTO.getTen_mon(),
                    cTHoaDonDTO.getSo_luong(),
                    cTHoaDonDTO.getGia_mon(),
                    cTHoaDonDTO.getThanh_tien()
                });
            }
        }
        modelCT.fireTableDataChanged();
    }

    public void timKiemTheoKhoanGia(DefaultTableModel modelCT, int SearchTu, int searchDen, String ma_hd) {
        this.resetListCTHD();
        this.loadListCTHD(ma_hd);
        
        while(modelCT.getRowCount() > 0){
            modelCT.removeRow(0);
        }
        for (CTHoaDonDTO cTHoaDonDTO : listCTHD) {
            if(cTHoaDonDTO.getGia_mon() < searchDen && cTHoaDonDTO.getGia_mon() > SearchTu){
                modelCT.addRow(new Object[]{
                    cTHoaDonDTO.getMa_mon(),
                    cTHoaDonDTO.getTen_mon(),
                    cTHoaDonDTO.getSo_luong(),
                    cTHoaDonDTO.getGia_mon(),
                    cTHoaDonDTO.getThanh_tien()
                });
            }
        }
        modelCT.fireTableDataChanged();
    }

    public void timKiemTheoKhoanSL(DefaultTableModel modelCT, int SearchTu, int searchDen, String ma_hd) {
        this.resetListCTHD();
        this.loadListCTHD(ma_hd);
        
        while(modelCT.getRowCount() > 0){
            modelCT.removeRow(0);
        }
        for (CTHoaDonDTO cTHoaDonDTO : listCTHD) {
            if(cTHoaDonDTO.getSo_luong() < searchDen && cTHoaDonDTO.getSo_luong() > SearchTu){
                modelCT.addRow(new Object[]{
                    cTHoaDonDTO.getMa_mon(),
                    cTHoaDonDTO.getTen_mon(),
                    cTHoaDonDTO.getSo_luong(),
                    cTHoaDonDTO.getGia_mon(),
                    cTHoaDonDTO.getThanh_tien()
                });
            }
        }
        modelCT.fireTableDataChanged();
    }

    public void timKiemTheoKhoanTT(DefaultTableModel modelCT, int SearchTu, int searchDen, String ma_hd) {
        this.resetListCTHD();
        this.loadListCTHD(ma_hd);
        
        while(modelCT.getRowCount() > 0){
            modelCT.removeRow(0);
        }
        for (CTHoaDonDTO cTHoaDonDTO : listCTHD) {
            if(cTHoaDonDTO.getThanh_tien() < searchDen && cTHoaDonDTO.getThanh_tien()> SearchTu){
                modelCT.addRow(new Object[]{
                    cTHoaDonDTO.getMa_mon(),
                    cTHoaDonDTO.getTen_mon(),
                    cTHoaDonDTO.getSo_luong(),
                    cTHoaDonDTO.getGia_mon(),
                    cTHoaDonDTO.getThanh_tien()
                });
            }
        }
        modelCT.fireTableDataChanged();
    }
}