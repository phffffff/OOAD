package BLL;

import DAL.DonDatHangDAL;
import DTO.DonDatHangDTO;
import DTO.NhaCungCapDTO;
 
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class DonDatHangBLL {
    private static List<DonDatHangDTO> listDDH = new ArrayList();
    private static List <DonDatHangDTO> listDDHExcel = new ArrayList<>();
    
    DonDatHangDAL donDatHangDAL = new DonDatHangDAL();
    
    public DonDatHangBLL() {
    }
    
    public List<DonDatHangDTO>getListExcel(){
        return this.listDDHExcel;
    }
    public List<DonDatHangDTO>getList(){
        return this.listDDH;
    }
    public void resetListDDH() {
        while(!listDDH.isEmpty())
            listDDH.remove(0);
    }
    
    public void loadListDDH() {
        listDDH = new DonDatHangDAL().getData();
    }

    public void resetListExcel() {
        while(!listDDHExcel.isEmpty()){
            listDDHExcel.remove(0);
        }
    }

    public void updateListExcel(DonDatHangDTO donDatHangDTO) {
        listDDHExcel.add(new DonDatHangDTO(
                donDatHangDTO.getMa_don_dat(),
                donDatHangDTO.getMa_ncc(),
                donDatHangDTO.getNgay_dat(),
                donDatHangDTO.getTong_tien_dat()
        ));
    }
    
    public void taoDonDat(String []str) {
       donDatHangDAL.addData(str);
       this.resetListDDH();
       this.loadListDDH();
    }    
    public void xoaDonDat(String ma_don_dat) {
        donDatHangDAL.delData(ma_don_dat);
        this.resetListDDH();
        this.loadListDDH();
    }
    public String MaMoi(){
        String ma = donDatHangDAL.getMaMax();
        if(ma != null){
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
    public void setTableDN(DefaultTableModel model){
        this.resetListDDH();
        this.loadListDDH();
        
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        resetListExcel();
        for (DonDatHangDTO donDatHangDTO : listDDH) {
            model.addRow(new Object[]{
                donDatHangDTO.getMa_don_dat(),
                donDatHangDTO.getMa_ncc(),
                new NhaCungCapBLL().getNccByMaNcc(donDatHangDTO.getMa_ncc()).getTen_ncc(),
                donDatHangDTO.getNgay_dat(),
                donDatHangDTO.getTong_tien_dat()
            });
            updateListExcel(donDatHangDTO);
        }
        model.fireTableDataChanged();
    }

    public int getDonNhapCoGiaMin() {
        this.resetListDDH();
        this.loadListDDH();
        
        int min = listDDH.get(0).getTong_tien_dat();
        for(int i = 1 ; i < listDDH.size() ; i++){
            if(listDDH.get(i).getTong_tien_dat() < min){
                min = listDDH.get(i).getTong_tien_dat();
            }
        }
        return min;
    }

    public int getDonNhapCoGiaMax() {
        this.resetListDDH();
        this.loadListDDH();
        
        int max = listDDH.get(0).getTong_tien_dat();
        for(int i = 1 ; i < listDDH.size() ; i++){
            if(listDDH.get(i).getTong_tien_dat() > max){
                max = listDDH.get(i).getTong_tien_dat();
            }
        }
        return max;
    }

    public int getChiPhiNamHienTai(){
        this.resetListDDH();
        this.loadListDDH();
        
        int tong = 0;
        String yearNow = java.time.LocalDate.now().toString().split("-")[0];
        for (DonDatHangDTO donDatHangDTO : listDDH) {
            System.out.println(donDatHangDTO.getNgay_dat().toString().split("-")[1]);
            if(donDatHangDTO.getNgay_dat().toString().split("-")[0].equals(yearNow)){
                tong += donDatHangDTO.getTong_tien_dat();
            }
        }
        return tong;      
    }

    public int getChiPhiThangHienTai() {
        this.resetListDDH();
        this.loadListDDH();
        
        int tong = 0;
        String dateNow = java.time.LocalDate.now().toString();
        String mountNow = dateNow.split("-")[1];
        String YearNow = dateNow.split("-")[0];
        
        System.out.println(dateNow);
        System.out.println(mountNow);
        System.out.println(YearNow);
        
        for (DonDatHangDTO donDatHangDTO : listDDH){
            if(donDatHangDTO.getNgay_dat().toString().split("-")[0].equals(YearNow)){
                if(donDatHangDTO.getNgay_dat().toString().split("-")[1].equals(mountNow)){
                    tong += donDatHangDTO.getTong_tien_dat();
                }
            }
        }
        return tong;  
    }

    public int getChiPhiNgayHienTai() {
        this.resetListDDH();
        this.loadListDDH();
        
        int tong = 0;
        
        String yearNow = java.time.LocalDate.now().toString().split("-")[0];
        String mountNow = java.time.LocalDate.now().toString().split("-")[1];
        String dayNow = java.time.LocalDate.now().toString().split("-")[2];
        
        for (DonDatHangDTO donDatHangDTO : listDDH) {
            if(donDatHangDTO.getNgay_dat().toString().split("-")[0].equals(yearNow)){
                if(donDatHangDTO.getNgay_dat().toString().split("-")[1].equals(mountNow)){
                    if(donDatHangDTO.getNgay_dat().toString().split("-")[2].equals(dayNow)){
                        tong += donDatHangDTO.getTong_tien_dat();
                    }
                }
            }
        }
        return tong;
    }
    public void timKiemDonNhapTheoMaDN(DefaultTableModel modelDN, String search) {
        this.resetListDDH();
        this.loadListDDH();
        
        while(modelDN.getRowCount() > 0){
            modelDN.removeRow(0);
        }
        resetListExcel();
        for (DonDatHangDTO donDatHangDTO : listDDH) {
            if(donDatHangDTO.getMa_don_dat().contains(search)){
                modelDN.addRow(new Object[]{
                    donDatHangDTO.getMa_don_dat(),
                    donDatHangDTO.getMa_ncc(),
                    new NhaCungCapBLL().getTenNccByMaNcc(donDatHangDTO.getMa_ncc()),
                    donDatHangDTO.getNgay_dat(),
                    donDatHangDTO.getTong_tien_dat()
                });
                updateListExcel(donDatHangDTO);
            }
        }
        modelDN.fireTableDataChanged();
    }

    public void thongKeDonNhapTheoMaNCC(DefaultTableModel modelDN, String search) {
        this.resetListDDH();
        this.loadListDDH();
        
        while(modelDN.getRowCount() > 0){
            modelDN.removeRow(0);
        }
        resetListExcel();
        for (DonDatHangDTO donDatHangDTO : listDDH) {
            if(donDatHangDTO.getMa_ncc().contains(search)){
                modelDN.addRow(new Object[]{
                    donDatHangDTO.getMa_don_dat(),
                    donDatHangDTO.getMa_ncc(),
                    new NhaCungCapBLL().getTenNccByMaNcc(donDatHangDTO.getMa_ncc()),
                    donDatHangDTO.getNgay_dat(),
                    donDatHangDTO.getTong_tien_dat()
                });
                updateListExcel(donDatHangDTO);
            }
        }
        modelDN.fireTableDataChanged();
    }
    public void thongKeDonNhapTheoTenNCC(DefaultTableModel modelDN, String search) {
        this.resetListDDH();
        this.loadListDDH();
        
        while(modelDN.getRowCount() > 0){
            modelDN.removeRow(0);
        }
        resetListExcel();
        NhaCungCapDTO nhaCungCapDTO = null;
        for (DonDatHangDTO donDatHangDTO : listDDH) {
            nhaCungCapDTO = new NhaCungCapBLL().getNccByMaNcc(donDatHangDTO.getMa_ncc());
            if(nhaCungCapDTO.getTen_ncc().contains(search)){
                modelDN.addRow(new Object[]{
                    donDatHangDTO.getMa_don_dat(),
                    donDatHangDTO.getMa_ncc(),
                    new NhaCungCapBLL().getTenNccByMaNcc(donDatHangDTO.getMa_ncc()),
                    donDatHangDTO.getNgay_dat(),
                    donDatHangDTO.getTong_tien_dat()
                });
                updateListExcel(donDatHangDTO);
            }
        }
        modelDN.fireTableDataChanged();
    }

    public void thongKeDonNhapTheoNgay(DefaultTableModel modelDN, String search) {
        this.resetListDDH();
        this.loadListDDH();
        
        while(modelDN.getRowCount() > 0){
            modelDN.removeRow(0);
        }
        resetListExcel();
        for (DonDatHangDTO donDatHangDTO : listDDH) {
            if(donDatHangDTO.getNgay_dat().toString().contains(search)){
                modelDN.addRow(new Object[]{
                    donDatHangDTO.getMa_don_dat(),
                    donDatHangDTO.getMa_ncc(),
                    new NhaCungCapBLL().getTenNccByMaNcc(donDatHangDTO.getMa_ncc()),
                    donDatHangDTO.getNgay_dat(),
                    donDatHangDTO.getTong_tien_dat()
                });
                updateListExcel(donDatHangDTO);
            }
        }
        modelDN.fireTableDataChanged();
    }
    public void thongKeDonNhapTheoTT(DefaultTableModel modelDN, int tongTienTu, int tongTienDen) {
        this.resetListDDH();
        this.loadListDDH();
        
        while(modelDN.getRowCount() > 0){
            modelDN.removeRow(0);
        }
        resetListExcel();
        for (DonDatHangDTO donDatHangDTO : listDDH) {
            if(donDatHangDTO.getTong_tien_dat() > tongTienTu && donDatHangDTO.getTong_tien_dat() < tongTienDen){
                modelDN.addRow(new Object[]{
                    donDatHangDTO.getMa_don_dat(),
                    donDatHangDTO.getMa_ncc(),
                    new NhaCungCapBLL().getTenNccByMaNcc(donDatHangDTO.getMa_ncc()),
                    donDatHangDTO.getNgay_dat(),
                    donDatHangDTO.getTong_tien_dat()
                });
                updateListExcel(donDatHangDTO);
            }
        }
        modelDN.fireTableDataChanged();
    }
//    public int getDoanhthutheoQuy(){
//        this.resetListDDH();
//        this.loadListDDH();
//        int quy = Integer.parseInt(java.time.LocalDate.now().toString().split("-")[1]);
//        int tong_1 = 0;
//        int tong_2 = 0;
//        int tong_3 = 0;
//        int tong_4 = 0;
//        
//        for(int i = 1 ; i < listDDH.size() ; i++){
//            if(Integer.parseInt(listDDH.get(i).toString().split("-")[1]) <= 3 && Integer.parseInt(listDDH.get(i).toString().split("-")[1]) >=1 ){
//                tong_1 += listDDH.get(i).getTong_tien_dat();
//            }
//            if(Integer.parseInt(listDDH.get(i).toString().split("-")[1]) <= 6 && Integer.parseInt(listDDH.get(i).toString().split("-")[1]) >= 4){
//                tong_2 += listDDH.get(i).getTong_tien_dat();
//            }
//            if(Integer.parseInt(listDDH.get(i).toString().split("-")[1]) <= 9 && Integer.parseInt(listDDH.get(i).toString().split("-")[1]) >= 6){
//                tong_3 += listDDH.get(i).getTong_tien_dat();
//            }
//            if(Integer.parseInt(listDDH.get(i).toString().split("-")[1]) <= 12 && Integer.parseInt(listDDH.get(i).toString().split("-")[1]) >= 9){
//                tong_4 += listDDH.get(i).getTong_tien_dat();
//            }
//        }
//        return min;
        
//    }
    
    public void thongKeDonNhapTheoKhoanTG(DefaultTableModel modelDN, Date DNTuNgay, Date DNDenNgay) {
        this.resetListDDH();
        this.loadListDDH();
        
        while(modelDN.getRowCount() > 0){
            modelDN.removeRow(0);
        }
        resetListExcel();
        for (DonDatHangDTO donDatHangDTO : listDDH) {
            if(donDatHangDTO.getNgay_dat().after(DNTuNgay) && donDatHangDTO.getNgay_dat().before(DNDenNgay)){
                modelDN.addRow(new Object[]{
                    donDatHangDTO.getMa_don_dat(),
                    donDatHangDTO.getMa_ncc(),
                    new NhaCungCapBLL().getTenNccByMaNcc(donDatHangDTO.getMa_ncc()),
                    donDatHangDTO.getNgay_dat(),
                    donDatHangDTO.getTong_tien_dat()
                });
                updateListExcel(donDatHangDTO);
            }
        }
        modelDN.fireTableDataChanged();
    }
}
