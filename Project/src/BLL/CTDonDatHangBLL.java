package BLL;

 
import DAL.CTDonDatHangDAL;
import DTO.CTDonDatHangDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CTDonDatHangBLL {
    private static List<CTDonDatHangDTO> listCtDdh = new ArrayList<>();
    CTDonDatHangDAL cTDonDatHangDAL = new CTDonDatHangDAL();
    
    
    public CTDonDatHangBLL() {
    }

    public void resetListCtDdh() {
        while(!listCtDdh.isEmpty())
            listCtDdh.remove(0);
    }

    public void loadListCtDdh(String ma_dn) {
        listCtDdh = new CTDonDatHangDAL().getData(ma_dn);
    }
    public void setTableCTDN(DefaultTableModel model, String ma_dn){
        this.resetListCtDdh();
        this.loadListCtDdh(ma_dn);
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (CTDonDatHangDTO cTDonDatHangDTO : listCtDdh) {
            model.addRow(new Object[]{
                cTDonDatHangDTO.getMa_mon(),
                cTDonDatHangDTO.getTen_mon(),
                cTDonDatHangDTO.getSo_luong(),
                cTDonDatHangDTO.getGia_mon(),
                cTDonDatHangDTO.getThanh_tien()
            });
        }
        model.fireTableDataChanged();
    }
    public void taoCTDonDatToDonDat(DefaultTableModel model,String ma_ddh){
        for(int i = 0 ; i < model.getRowCount() ; i++){
            String ma_mon = (String) model.getValueAt(i,0);
            String ten_mon = (String) model.getValueAt(i,1);
            String gia = String.valueOf(model.getValueAt(i,2));
            String so_luong = String.valueOf(model.getValueAt(i,3));
            String thanh_tien = String.valueOf(model.getValueAt(i,4));
            
            cTDonDatHangDAL.addData(new String[]{ma_ddh,ma_mon,ten_mon,so_luong,gia,thanh_tien});
            new MonAnBLL().updateSoLuongSauKhiNhapHang(ma_mon,Integer.parseInt(so_luong));
        }
        this.resetListCtDdh();
        this.loadListCtDdh(ma_ddh);
    }
    
    public void taoCTDonDatHang(String []str) {
        cTDonDatHangDAL.addData(str);
        this.resetListCtDdh();
        this.loadListCtDdh(str[0]);
    }

//    public CTDonDatHangDTO[] readCTDonDat() {
//        updateList();
//        return listCTDonDatHang.toArray(new CTDonDatHangDTO[0]);
//    }


    public void xoaCTDonDat(String []str) {
        cTDonDatHangDAL.delData(str);
        this.loadListCtDdh(str[0]);
        this.resetListCtDdh();
    }

    public void timKiemCTNDTheoMaMon(DefaultTableModel model, String search, String ma_dn) {
        this.resetListCtDdh();
        this.loadListCtDdh(ma_dn);
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (CTDonDatHangDTO ctddhdto : listCtDdh) {
            if(ctddhdto.getMa_mon().contains(search)){
                model.addRow(new Object[]{
                    ctddhdto.getMa_mon(),
                    ctddhdto.getTen_mon(),
                    ctddhdto.getSo_luong(),
                    ctddhdto.getGia_mon(),
                    ctddhdto.getThanh_tien()
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timKiemCTHDTheoTenMon(DefaultTableModel model, String search, String ma_dn) {
        this.resetListCtDdh();
        this.loadListCtDdh(ma_dn);
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (CTDonDatHangDTO ctddhdto : listCtDdh) {
            if(ctddhdto.getTen_mon().contains(search)){
                model.addRow(new Object[]{
                    ctddhdto.getMa_mon(),
                    ctddhdto.getTen_mon(),
                    ctddhdto.getSo_luong(),
                    ctddhdto.getGia_mon(),
                    ctddhdto.getThanh_tien()
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timKiemTheoKhoanGia(DefaultTableModel model, int SearchTu, int searchDen, String ma_dn) {
        this.resetListCtDdh();
        this.loadListCtDdh(ma_dn);
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (CTDonDatHangDTO ctddhdto : listCtDdh) {
            if(ctddhdto.getGia_mon() > SearchTu && ctddhdto.getGia_mon() < searchDen){
                model.addRow(new Object[]{
                    ctddhdto.getMa_mon(),
                    ctddhdto.getTen_mon(),
                    ctddhdto.getSo_luong(),
                    ctddhdto.getGia_mon(),
                    ctddhdto.getThanh_tien()
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timKiemTheoKhoanTT(DefaultTableModel model, int SearchTu, int searchDen, String ma_dn) {
        this.resetListCtDdh();
        this.loadListCtDdh(ma_dn);
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (CTDonDatHangDTO ctddhdto : listCtDdh) {
            if(ctddhdto.getThanh_tien() < searchDen && ctddhdto.getThanh_tien() > SearchTu){
                model.addRow(new Object[]{
                    ctddhdto.getMa_mon(),
                    ctddhdto.getTen_mon(),
                    ctddhdto.getSo_luong(),
                    ctddhdto.getGia_mon(),
                    ctddhdto.getThanh_tien()
                });
            }
        }
        model.fireTableDataChanged();
    }

    public void timKiemTheoKhoanSL(DefaultTableModel model, int SearchTu, int searchDen, String ma_dn) {
        this.resetListCtDdh();
        this.loadListCtDdh(ma_dn);
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (CTDonDatHangDTO ctddhdto : listCtDdh) {
            if(ctddhdto.getSo_luong() > SearchTu && ctddhdto.getSo_luong() < searchDen){
                model.addRow(new Object[]{
                    ctddhdto.getMa_mon(),
                    ctddhdto.getTen_mon(),
                    ctddhdto.getSo_luong(),
                    ctddhdto.getGia_mon(),
                    ctddhdto.getThanh_tien()
                });
            }
        }
        model.fireTableDataChanged();
    }
}
