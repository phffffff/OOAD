/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JForm;

import BLL.*;
import DTO.*;
import EXCEL.XuatExcel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author mizuk
 */
public class AdminForm extends javax.swing.JFrame {
    
    String xoa = "Bạn có thật sự muốn xóa";
    String xoaTC = "Xóa thành công";
    String sua = "sửa thành công";
    String them = "Thêm thành công";
    String thongBao = "Thông báo";
    
    public static String ncc_current = null;
    
    TaiKhoanBLL taiKhoanBLL = new TaiKhoanBLL();
    NhanVienBLL nhanVienBLL = new NhanVienBLL();
    NhaCungCapBLL nhaCungCapBLL = new NhaCungCapBLL();
    LoaiMonAnBLL loaiMonAnBLL = new LoaiMonAnBLL();
    CTKhuyenMaiBLL cTKhuyenMaiBLL = new CTKhuyenMaiBLL();
    CTChuongTrinhKMBLL cTChuongTrinhKMBLL = new CTChuongTrinhKMBLL();
    MonAnBLL monAnBLL = new MonAnBLL();
    CTNhaCungCapLoaiMonBLL cTNhaCungCapLoaiMonBLL = new CTNhaCungCapLoaiMonBLL();
    DonDatHangBLL donDatHangBLL = new DonDatHangBLL();
    CTDonDatHangBLL cTDonDatHangBLL = new CTDonDatHangBLL();
    ThanhVienBLL thanhVienBLL = new ThanhVienBLL();
    PhieuGiamGiaBLL phieuGiamGiaBLL = new PhieuGiamGiaBLL();
    HoaDonBLL hoaDonBLL = new HoaDonBLL();
    
    private DefaultTableModel modelTK = null;
    private DefaultTableModel modelMA = null;
    private DefaultTableModel modelNV = null;
    private DefaultTableModel modelNCC = null;
    private DefaultTableModel modelLMA = null;
    private DefaultTableModel modelCTDN = null;
    private DefaultTableModel modelFood = null;
    private DefaultTableModel modelCTKM = null;
    private DefaultTableModel modelTV = null;
    private DefaultTableModel modelPGG = null;
    private DefaultTableModel modelHD = null;
    private DefaultTableModel modelDN = null;
            
    private DefaultComboBoxModel<String> modelCbxLM = null;
    private DefaultComboBoxModel<String> modelCbxTK = null;
    private DefaultComboBoxModel<String> modelCbxTkOfNn = null;
    private DefaultComboBoxModel<String> modelCbxLmOfDN = null;
    private DefaultComboBoxModel<String> modelCbxNcc = null;
    
    public AdminForm() {
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        
        TaiKhoan();
        MonAn();
        NhanVien();
        NhaCungCap();
        LoaiThucAn();
        NhapHang();
        CTKM();
        ThanhVien();
        PhieuGiamGia();
        ThongKe();
//        load();
    }
    //tài khoản
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    private void TaiKhoan(){
        initTableTK();
        loadListTK();
        loadLoaiTkToComboBox();
        loadComboboxSeachTK();
    }
    private void setNullTk() {
        lblMaTk.setText("");
        txtTenTK.setText("");
        txtMk.setText("");
    }
    public void initTableTK(){
        modelTK = new DefaultTableModel();
        String []title = {"Mã tài khoản","Tài khoản","Mật khẩu","Phân quyền","Trạng thái"};
        modelTK.setColumnIdentifiers(title);
        tblTaiKhoan.setModel(modelTK);
        
    }
    public void loadListTK(){
        taiKhoanBLL.setListTk(modelTK);
    }
    private void loadLoaiTkToComboBox(){
        modelCbxTK = new DefaultComboBoxModel();
        new PhanQuyenBLL().setLoaiTkToComboBox(modelCbxTK);
        cbbLoaiTk.setModel(modelCbxTK);
    }
    private void loadComboboxSeachTK(){
        cbxSearchTK.removeAllItems();
        cbxSearchTK.addItem("Mã TK");
        cbxSearchTK.addItem("Tên TK");
        cbxSearchTK.addItem("Phân quyền");
        cbxSearchTK.addItem("Trạng thái");
    }
    // </editor-fold>                        
   
    //Món án
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    public void MonAn(){
        initTableMonAn();
        loadListMA();
        loadLoaiMonToComboBox();
        loadComboboxSearchMonAn();
    }
    private void initTableMonAn(){
        modelMA = new DefaultTableModel();
        String []title = {"Mã món ăn","Tên món","Số lượng","Giá","Giá giảm","Giá hiện tại","Danh mục"};
        modelMA.setColumnIdentifiers(title);
        tblThucAn.setModel(modelMA);
    }
    private void loadListMA(){
        new MonAnBLL().setListTableMA(modelMA);
    }
    private void loadComboboxSearchMonAn(){
        cbxSearchMA.removeAllItems();
        cbxSearchMA.addItem("Mã món");
        cbxSearchMA.addItem("Tên món");
        cbxSearchMA.addItem("Số lượng");
        cbxSearchMA.addItem("Giá");
        cbxSearchMA.addItem("Giá giảm");
        cbxSearchMA.addItem("Giá hiện tại");
        cbxSearchMA.addItem("Loại món");
    }
    private void loadLoaiMonToComboBox(){
        modelCbxLM = new DefaultComboBoxModel();
        new LoaiMonAnBLL().setTenLoaiToComboBox(modelCbxLM);
        cbbLoaiMon.setModel(modelCbxLM);
    }
    private void setNullMonAn() {
        lblMaMon.setText("");
        txtTenMon.setText("");
        txtGia.setText("");
        lblSoLuong.setText("0");
        cbbLoaiMon.setModel(modelCbxLM);
        txtSearchGiaFrom.setText("");
        txtSearchGiaTo.setText("");
        txtSearchSLFrom.setText("");
        txtSearchSLTo.setText("");
        txtSearchMA.setText("");
    }
    // </editor-fold> 
    
    //Nhân viên
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    public void NhanVien(){
        initTableNV();
        loadListNV();
        loadTkToComboBox();
        loadComboBoxSearchNV();
    }
    private void loadComboBoxSearchNV(){
        cbxSearchNV.removeAllItems();
        cbxSearchNV.addItem("Mã NV");
        cbxSearchNV.addItem("Tên NV");
        cbxSearchNV.addItem("SDT");
        cbxSearchNV.addItem("Mail");
        cbxSearchNV.addItem("Tài khoản");
    }
    public void initTableNV(){
        modelNV = new DefaultTableModel();
        
        modelNV.setColumnIdentifiers(new String[]{
            "Mã nhân viên","Tên nhân viên","Ngày sinh","SĐT","Mail","Tài khoản"
        });
        tblNhanVien.setModel(modelNV);
    }
    public void loadListNV(){
        nhanVienBLL.setListNV(modelNV);
    }
    public void loadTkToComboBox(){
        modelCbxTkOfNn = new DefaultComboBoxModel();
        taiKhoanBLL.setTkToCombobox(modelCbxTkOfNn);
        cbbTkNv.setModel(modelCbxTkOfNn);
    }
    public void loadTkToComboBoxByTT(){
        modelCbxTkOfNn = new DefaultComboBoxModel();
        taiKhoanBLL.setTkToComboboxbyTT(modelCbxTkOfNn);
        cbbTkNv.setModel(modelCbxTkOfNn);
    }
    public void loadTkToComboBoxByMaNv_TT(int ma_nv){
        modelCbxTkOfNn = new DefaultComboBoxModel();
        taiKhoanBLL.setTkToComboboxbyMaNvHt(modelCbxTkOfNn, ma_nv);
        taiKhoanBLL.setTkToComboboxbyTT(modelCbxTkOfNn);
        cbbTkNv.setModel(modelCbxTkOfNn);
    }
    
    public void setNullNv(){
        lblMaNV.setText("");
        txtTenNV.setText("");
        dPNgaySinhNV.setText("");
        txtSdt.setText("");
        txtMail.setText("");
        txtSearchNV.setText("");
        txtNVNgayKt.setText("");
        txtNVNgayKt.setText("");
    }
    // </editor-fold> 
    
    //Nhà cung cấp
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    public void NhaCungCap(){
        initTableNCC();
        loadListNCC();
        loadComboboxSearchNCC();
    }
    public  void loadComboboxSearchNCC(){
        cbxSearchNCC.removeAllItems();
        cbxSearchNCC.addItem("Mã NCC");
        cbxSearchNCC.addItem("Tên NCC");
        cbxSearchNCC.addItem("Địa chỉ");
    }
    private void initTableNCC(){
        modelNCC = new DefaultTableModel();
        String[] title = {"Mã NCC","Tên NCC","Địa chỉ"};
        modelNCC.setColumnIdentifiers(title);
        tblNhaCC.setModel(modelNCC);
    }
    private void loadListNCC(){
        nhaCungCapBLL.setListNCC(modelNCC);
    }
    private void setNullNCC(){
        lblMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtSearchNCC.setText("");
    }
    // </editor-fold> 
    
    //Loại món ăn
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    public void LoaiThucAn(){
        initTableLMA();
        loadListLMA();
        loadComboboxSearch();
    }
    private void initTableLMA(){
        modelLMA = new DefaultTableModel();
        String[] title = {"Mã loại","Tên loại thức ăn"};
        modelLMA.setColumnIdentifiers(title);
        tblLoaiMA.setModel(modelLMA);
    }
    private void loadListLMA(){
        loaiMonAnBLL.setListLM(modelLMA);
    }
    private void setNullLMA(){
        lblMaLoai.setText("");
        txtTenLoai.setText("");
        txtSearchLM.setText("");
    }
    private void loadComboboxSearch(){
        cbxSearchLM.removeAllItems();
        cbxSearchLM.addItem("Mã loại");
        cbxSearchLM.addItem("Tên loại");
    }
    // </editor-fold> 
                   
    //Nhập hàng
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    public void NhapHang(){
        initTableFood();
        initTableCTDonNhap();
        loadToComboboxCategoryDefault();
        loadToComboboxNcc();
        loadComboboxSearchDN();
    }
    private void loadComboboxSearchDN(){
        cbxSearchDH.removeAllItems();
        cbxSearchDH.addItem("Mã món");
        cbxSearchDH.addItem("Tên món");
    }
    private void initTableFood(){
        modelFood = new DefaultTableModel();
        String[] title = {"Mã món","Tên món","Giá"};
        modelFood.setColumnIdentifiers(title);
        tblFood.setModel(modelFood);
    }
    private void initTableCTDonNhap(){
        modelCTDN = new DefaultTableModel();
        String[] title = {"Mã món","Tên món","Giá","Số lượng","Thành tiền"};
        modelCTDN.setColumnIdentifiers(title);
        tblICTDonNhap.setModel(modelCTDN);
    }
    private void loadToComboboxCategoryDefault(){
        modelCbxLmOfDN = new DefaultComboBoxModel();
        loaiMonAnBLL.setTenLoaiToComboBox(modelCbxLmOfDN);
        cbxCategory.setModel(modelCbxLmOfDN);
    }
    private void loadToComboboxNcc(){
        modelCbxNcc = new DefaultComboBoxModel();
        nhaCungCapBLL.setTenNccToCombobox(modelCbxNcc);
        cbxNcc.setModel(modelCbxNcc);
    }
    
    // </editor-fold> 
    
    //CTKM
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    public void CTKM(){
        initTableCTKM();
        loadCTKM();
        loadComboboxSearchCTKM();
    }
    public void loadComboboxSearchCTKM(){
        cbxSearchCTKM.removeAllItems();
        cbxSearchCTKM.addItem("Mã CTKM");
        cbxSearchCTKM.addItem("Tên CTKM");
        cbxSearchCTKM.addItem("Kiểm tra ngày");
        cbxSearchCTKM.addItem("Trạng thái");
    }
    public void initTableCTKM(){
        String []str = {"Mã CTKM", "Tên chương trình", "Ngày bắt đầu", "Ngày kết thúc","Trạng thái"};
        modelCTKM = new DefaultTableModel();
        modelCTKM.setColumnIdentifiers(str);
        tblCTKM.setModel(modelCTKM);
    }
    public void loadCTKM(){
        cTKhuyenMaiBLL.setListTableKM(modelCTKM);
    }
    public void setNullCtkm(){
        lblTtCtkm.setText("");
        txtTenCTKM.setText("");
        dpNgaybd.setText("");
        dpNgaykt.setText("");
        lblTtCtkm.setText("");
        txtSearchCTKM.setText("");
        txtKMNgayDen.setText("");
        txtKMNgayTu.setText("");
    }
    // </editor-fold> 
    
    //Thành viên
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    public void ThanhVien(){
        initTableTV();
        loadTV();
        loadComboboxSearchTV();
    }
    public void loadComboboxSearchTV(){
        cbxSearchTV.removeAllItems();
        cbxSearchTV.addItem("Mã TV");
        cbxSearchTV.addItem("Tên TV");
        cbxSearchTV.addItem("Số điện thoại");
        cbxSearchTV.addItem("mail");
    }
    public void initTableTV(){
        String []str = {"Mã TV", "Mã xác nhận", "Tên thành viên", "Ngày sinh","SĐT","Mail","Điểm"};
        modelTV = new DefaultTableModel();
        modelTV.setColumnIdentifiers(str);
        tblThanhVien.setModel(modelTV);
    }
    public void loadTV(){
        thanhVienBLL.setTableListTV(modelTV);
    }
    public void setNullTV(){
        lblMaTV.setText("");
        txtTenTv.setText("");
        dPNgaySinhTV.setText("");
        txtMkTv.setText("");
        txtSdtTV.setText("");
        txtMailTV.setText("");
        lblPointTv.setText("");
        txtSearchDiemTo.setText("");
        txtSearchGiaTo.setText("");
        txtSearchTV.setText("");
        txtSearchTVNSFrom.setText("");
        txtSearchTVNSTo.setText("");
    }
    // </editor-fold> 

    //Phiếu giảm giá
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    public void PhieuGiamGia(){
        setInitTable();
        loadTablePGG();
        loadComboboxSearchPGG();
    }
    public void loadComboboxSearchPGG(){
        cbxSearchPGG.removeAllItems();
        cbxSearchPGG.addItem("Mã phiếu");
        cbxSearchPGG.addItem("Mã voucher");
        cbxSearchPGG.addItem("Trạng thái");
    }
    public void setInitTable(){
        modelPGG = new DefaultTableModel();
        modelPGG.setColumnIdentifiers(new String[]{
            "Mã phiếu giảm","Giảm","Tên","Ngày bắt đầu","Ngày kết thúc","Trạng thái"
        });
        tblPGG.setModel(modelPGG);
    }
    public void loadTablePGG(){
        phieuGiamGiaBLL.setTablePGG(modelPGG);
    }
    public void setNullPGG(){
        lblMaPGG.setText("");
        txtTenPGG.setText("");
        txtGiamTien.setText("");
        dpNgayPGGbd.setText("");
        dpNgayPGGkt.setText("");
        txtSearchPhieuGiam.setText("");
        txtPGGNgayTu.setText("");
        txtPGGNgayDen.setText("");
        txtPGGGiamDen.setText("");
        txtPGGGiamTu.setText("");
    }
    // </editor-fold> 
    
    //Thống kê
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    public void ThongKe(){
        initTableListHD();
        loadTableHD();
        loadThongKeHD();
        
        initTableListDN();
        loadTableDN();
        loadThongKeDH();
        
        loadThongKeTongQuat();
    }
    void initTableListHD(){
        modelHD = new DefaultTableModel();
        modelHD.setColumnIdentifiers(new String[]{
            "Mã hóa đơn","Ngày xuất","Mã nhân viên","Nhân viên xuất","Mã TV(Nếu có)","Tên thành viên(Nếu có)","Tổng tiền","Giảm(Nếu có)","Tiền còn lại","Mã phiếu giảm(Nếu có)","Điểm"
        });
        tblHoaDon.setModel(modelHD);
    }
    void loadTableHD(){
        hoaDonBLL.setTableHD(modelHD);
    }
    void loadThongKeHD(){
        lblHDMin.setText(String.valueOf(hoaDonBLL.getHoaDonCoGiaMin()));
        lblHDMax.setText(String.valueOf(hoaDonBLL.getHoaDonCoGiaMax()));
        lblDHNam.setText(String.valueOf(hoaDonBLL.getDoanhThuNamHienTai()));
        lblDTThang.setText(String.valueOf(hoaDonBLL.getDoanhThuThangHienTai()));
        lblDTNgay.setText(String.valueOf(hoaDonBLL.getDoanhThuNgayHienTai()));
    }
    void initTableListDN(){
        modelDN = new DefaultTableModel();
        modelDN.setColumnIdentifiers(new String[]{
            "Mã đơn đặt","Mã NCC","Tên NCC","Ngày đặt","Tổng tiền đặt"
        });
        tblDonNhap.setModel(modelDN);
    }
    void loadTableDN(){
        donDatHangBLL.setTableDN(modelDN);
    }
    void loadThongKeDH(){
        lblDNMin.setText(String.valueOf(donDatHangBLL.getDonNhapCoGiaMin()));
        lblDNMax.setText(String.valueOf(donDatHangBLL.getDonNhapCoGiaMax()));
        lblCPNamDN.setText(String.valueOf(donDatHangBLL.getChiPhiNamHienTai()));
        lblCPNgayDN.setText(String.valueOf(donDatHangBLL.getChiPhiNgayHienTai()));
        lblCPThangDN.setText(String.valueOf(donDatHangBLL.getChiPhiThangHienTai()));
    }
    void loadThongKeTongQuat(){
        lblTongTK.setText(String.valueOf(taiKhoanBLL.getTongTK()));
        lblTongNV.setText(String.valueOf(nhanVienBLL.getTongNV()));
        lblTongTV.setText(String.valueOf(thanhVienBLL.getTongTV()));
        lblTongLM.setText(String.valueOf(loaiMonAnBLL.getTongLM()));
        lblTongMA.setText(String.valueOf(monAnBLL.getTongMA()));
        lblTongNCC.setText(String.valueOf(nhaCungCapBLL.getTongNVV()));
        lblTongPGG.setText(String.valueOf(phieuGiamGiaBLL.getTongPGG()));
        lblTongCTKM.setText(String.valueOf(cTKhuyenMaiBLL.getTongCTKM()));
    }
   
    // </editor-fold> 
    
    
    public void load(){
        loadListLMA();
        loadListMA();
        loadListNCC();
        loadListNV();
        loadListTK();
        loadLoaiMonToComboBox();
        loadLoaiTkToComboBox();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel58 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblTongMA = new javax.swing.JLabel();
        lblTongLM = new javax.swing.JLabel();
        lblTongNV = new javax.swing.JLabel();
        lblTongTK = new javax.swing.JLabel();
        lblTongNCC = new javax.swing.JLabel();
        lblTongTV = new javax.swing.JLabel();
        lblTongCTKM = new javax.swing.JLabel();
        lblTongPGG = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        dPHDNgayDen = new com.github.lgooddatepicker.components.DatePicker();
        btnThongKe = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel68 = new javax.swing.JPanel();
        dPHDNgayTu = new com.github.lgooddatepicker.components.DatePicker();
        btnReLoad = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel69 = new javax.swing.JPanel();
        cbxSearchHD = new javax.swing.JComboBox<>();
        txtSearchHD = new javax.swing.JTextField();
        cbxSearchHDGia = new javax.swing.JComboBox<>();
        txtSearchHDGiaTu = new javax.swing.JTextField();
        txtSearchHDGiaDen = new javax.swing.JTextField();
        jPanel71 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel72 = new javax.swing.JPanel();
        lblDTThang = new javax.swing.JLabel();
        lblHDMax = new javax.swing.JLabel();
        lblHDMin = new javax.swing.JLabel();
        lblDHNam = new javax.swing.JLabel();
        lblDTNgay = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        dPDNNgayDen = new com.github.lgooddatepicker.components.DatePicker();
        btnThongKeDN = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel77 = new javax.swing.JPanel();
        dPDNNgayTu = new com.github.lgooddatepicker.components.DatePicker();
        btnReLoadDN = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel78 = new javax.swing.JPanel();
        cbxSearchDN = new javax.swing.JComboBox<>();
        txtSearchDN = new javax.swing.JTextField();
        txtSearchDNTongTienTU = new javax.swing.JTextField();
        txtSearchDNTongTienDen = new javax.swing.JTextField();
        jPanel79 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblDonNhap = new javax.swing.JTable();
        jPanel80 = new javax.swing.JPanel();
        lblCPThangDN = new javax.swing.JLabel();
        lblDNMax = new javax.swing.JLabel();
        lblDNMin = new javax.swing.JLabel();
        lblCPNamDN = new javax.swing.JLabel();
        lblCPNgayDN = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiMA = new javax.swing.JTable();
        jPanel63 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnNewLMA = new javax.swing.JButton();
        btnUpdateLMA = new javax.swing.JButton();
        btnAddLMA = new javax.swing.JButton();
        btnDelLMA = new javax.swing.JButton();
        btnloadLM = new javax.swing.JButton();
        txtSearchLM = new javax.swing.JTextField();
        cbxSearchLM = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtTenLoai = new javax.swing.JTextField();
        lblMaLoai = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThucAn = new javax.swing.JTable();
        jPanel64 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnNewMA = new javax.swing.JButton();
        btnAddMA = new javax.swing.JButton();
        btnUpdateMA = new javax.swing.JButton();
        btnDelMA = new javax.swing.JButton();
        cbxSearchMA = new javax.swing.JComboBox<>();
        txtSearchMA = new javax.swing.JTextField();
        btnloadMA = new javax.swing.JButton();
        txtSearchGiaFrom = new javax.swing.JTextField();
        txtSearchGiaTo = new javax.swing.JTextField();
        txtSearchSLFrom = new javax.swing.JTextField();
        txtSearchSLTo = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        txtTenMon = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        cbbLoaiMon = new javax.swing.JComboBox<>();
        lblMaMon = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jPanel65 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        btnNewTK = new javax.swing.JButton();
        btnAddTK = new javax.swing.JButton();
        btnUpdateTK = new javax.swing.JButton();
        btnDelTk = new javax.swing.JButton();
        cbxSearchTK = new javax.swing.JComboBox<>();
        txtSearchTK = new javax.swing.JTextField();
        btnloadMA1 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        txtTenTK = new javax.swing.JTextField();
        cbbLoaiTk = new javax.swing.JComboBox<>();
        txtMk = new javax.swing.JTextField();
        lblMaTk = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        btnTaoMoi = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnThemNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        cbxSearchNV = new javax.swing.JComboBox<>();
        txtSearchNV = new javax.swing.JTextField();
        btnloadNV = new javax.swing.JButton();
        txtNVNgayPd = new javax.swing.JTextField();
        txtNVNgayKt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        txtTenNV = new javax.swing.JTextField();
        cbbTkNv = new javax.swing.JComboBox<>();
        txtSdt = new javax.swing.JTextField();
        lblMaNV = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        dPNgaySinhNV = new com.github.lgooddatepicker.components.DatePicker();
        jPanel61 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        txtTenCTKM = new javax.swing.JTextField();
        dpNgaybd = new com.github.lgooddatepicker.components.DatePicker();
        dpNgaykt = new com.github.lgooddatepicker.components.DatePicker();
        lblMaKM = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        btnTaoMoiCTKM = new javax.swing.JButton();
        btnXoaCTKM = new javax.swing.JButton();
        btnSuaCTKM = new javax.swing.JButton();
        btnThemCTKM = new javax.swing.JButton();
        btnXemCTKM = new javax.swing.JButton();
        btnApDung = new javax.swing.JButton();
        lblTtCtkm = new javax.swing.JLabel();
        btnDungAD = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCTKM = new javax.swing.JTable();
        jPanel62 = new javax.swing.JPanel();
        cbxSearchCTKM = new javax.swing.JComboBox<>();
        txtSearchCTKM = new javax.swing.JTextField();
        btnLoadCTKM = new javax.swing.JButton();
        txtKMNgayTu = new javax.swing.JTextField();
        txtKMNgayDen = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        btnDat = new javax.swing.JButton();
        spnCount = new javax.swing.JSpinner();
        cbxCategory = new javax.swing.JComboBox<>();
        cbxNcc = new javax.swing.JComboBox<>();
        btnXoaMonDN = new javax.swing.JButton();
        cbxSearchDH = new javax.swing.JComboBox<>();
        txtSearchDH = new javax.swing.JTextField();
        txtSearchDHGiaFrom = new javax.swing.JTextField();
        txtSearchDHGiaTo = new javax.swing.JTextField();
        btnLoadMAOfDN = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        btnChotDon = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblFood = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblICTDonNhap = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblNhaCC = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        btnNewNCC = new javax.swing.JButton();
        btnUpdateNCC = new javax.swing.JButton();
        btnAddNCC = new javax.swing.JButton();
        btnDelNCC = new javax.swing.JButton();
        cbxSearchNCC = new javax.swing.JComboBox<>();
        txtSearchNCC = new javax.swing.JTextField();
        btnloadNCC = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        txtTenNCC = new javax.swing.JTextField();
        lblMaNCC = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jPanel66 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblThanhVien = new javax.swing.JTable();
        jPanel67 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        btnUpdateTV = new javax.swing.JButton();
        btnDelTV = new javax.swing.JButton();
        btnloadTV = new javax.swing.JButton();
        cbxSearchTV = new javax.swing.JComboBox<>();
        txtSearchTV = new javax.swing.JTextField();
        txtSearchDiemFrom = new javax.swing.JTextField();
        txtSearchDiemTo = new javax.swing.JTextField();
        txtSearchTVNSFrom = new javax.swing.JTextField();
        txtSearchTVNSTo = new javax.swing.JTextField();
        jPanel60 = new javax.swing.JPanel();
        txtTenTv = new javax.swing.JTextField();
        lblMaTV = new javax.swing.JLabel();
        txtSdtTV = new javax.swing.JTextField();
        txtMailTV = new javax.swing.JTextField();
        lblPointTv = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        dPNgaySinhTV = new com.github.lgooddatepicker.components.DatePicker();
        jLabel38 = new javax.swing.JLabel();
        txtMkTv = new javax.swing.JTextField();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        txtGiamTien = new javax.swing.JTextField();
        lblMaPGG = new javax.swing.JLabel();
        dpNgayPGGbd = new com.github.lgooddatepicker.components.DatePicker();
        dpNgayPGGkt = new com.github.lgooddatepicker.components.DatePicker();
        txtTenPGG = new javax.swing.JTextField();
        jPanel51 = new javax.swing.JPanel();
        btnTaoMoiCTKM1 = new javax.swing.JButton();
        btnXoaCTKM1 = new javax.swing.JButton();
        btnSuaCTKM1 = new javax.swing.JButton();
        btnThemCTKM1 = new javax.swing.JButton();
        txtSearchPhieuGiam = new javax.swing.JTextField();
        btnloadPGG = new javax.swing.JButton();
        txtPGGGiamTu = new javax.swing.JTextField();
        txtPGGGiamDen = new javax.swing.JTextField();
        txtPGGNgayTu = new javax.swing.JTextField();
        txtPGGNgayDen = new javax.swing.JTextField();
        cbxSearchPGG = new javax.swing.JComboBox<>();
        jPanel52 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblPGG = new javax.swing.JTable();

        setTitle("Admin");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 700));
        setPreferredSize(new java.awt.Dimension(800, 700));

        lblTongMA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongMA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Món", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        lblTongMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblTongLM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongLM.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại món", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        lblTongLM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblTongNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongNV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        lblTongNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblTongTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongTK.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        lblTongTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblTongNCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongNCC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhà cung cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        lblTongNCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblTongTV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongTV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thành viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        lblTongTV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblTongCTKM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongCTKM.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chương trình khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        lblTongCTKM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblTongPGG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongPGG.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu giảm giá", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        lblTongPGG.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTongLM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTongPGG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTongTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTongNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTongMA, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTongNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTongTV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTongCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblTongTK, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lblTongLM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblTongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lblTongMA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblTongTV, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lblTongNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTongPGG, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lblTongCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Tổng quát", jPanel58);

        dPHDNgayDen.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến ngày"));

        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thongke-30.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_ms_excel_30px.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThongKe))
                    .addGroup(jPanel70Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dPHDNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dPHDNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dPHDNgayTu.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ ngày"));

        btnReLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lammoi-30.png"))); // NOI18N
        btnReLoad.setText("Reload");
        btnReLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReLoadActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xemchitiet-30.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel68Layout.createSequentialGroup()
                        .addComponent(btnReLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel68Layout.createSequentialGroup()
                        .addComponent(dPHDNgayTu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel68Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dPHDNgayTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cbxSearchHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã hóa đơn", "Ngày xuất", "Mã nhân viên", "Tên nhân viên", "Mã thành viên", "Tên thành viên", "Mã voucher" }));
        cbxSearchHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê theo"));

        txtSearchHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        txtSearchHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchHDKeyReleased(evt);
            }
        });

        cbxSearchHDGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổng tiền", "Tiền giảm", "Phải thanh toán", "Điểm" }));
        cbxSearchHDGia.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê theo giá"));

        txtSearchHDGiaTu.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ"));

        txtSearchHDGiaDen.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtSearchHDGiaDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchHDGiaDenKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxSearchHD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxSearchHDGia, 0, 145, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel69Layout.createSequentialGroup()
                        .addComponent(txtSearchHDGiaTu, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchHDGiaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSearchHDGiaDen, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxSearchHDGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchHDGiaTu, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
            .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
            .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
        );

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        lblDTThang.setBorder(javax.swing.BorderFactory.createTitledBorder("Doanh thu tháng hiện tại"));
        lblDTThang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblHDMax.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn lớn nhất"));
        lblHDMax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblHDMin.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn nhỏ nhất"));
        lblHDMin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblDHNam.setBorder(javax.swing.BorderFactory.createTitledBorder("Doanh thu năm hiện tại"));
        lblDHNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblDTNgay.setBorder(javax.swing.BorderFactory.createTitledBorder("Doanh thu ngày hiện tại"));
        lblDTNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHDMax, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHDMin, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDHNam, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDTThang, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDTNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDHNam, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(lblDTThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHDMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDTNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHDMax, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Hóa đơn", jPanel59);

        dPDNNgayDen.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến ngày"));

        btnThongKeDN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thongke-30.png"))); // NOI18N
        btnThongKeDN.setText("Thống kê");
        btnThongKeDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeDNActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_ms_excel_30px.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dPDNNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThongKeDN)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel76Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dPDNNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThongKeDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dPDNNgayTu.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ ngày"));

        btnReLoadDN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lammoi-30.png"))); // NOI18N
        btnReLoadDN.setText("Reload");
        btnReLoadDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReLoadDNActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xemchitiet-30.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addComponent(btnReLoadDN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dPDNNgayTu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dPDNNgayTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReLoadDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cbxSearchDN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã đơn nhập", "Mã nhà cung cấp", "Tên nhà cung cấp", "Ngày đặt" }));
        cbxSearchDN.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê theo"));

        txtSearchDN.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        txtSearchDN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDNKeyReleased(evt);
            }
        });

        txtSearchDNTongTienTU.setBorder(javax.swing.BorderFactory.createTitledBorder("Tổng tiền từ"));

        txtSearchDNTongTienDen.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtSearchDNTongTienDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDNTongTienDenKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxSearchDN, 0, 156, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchDN, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(txtSearchDNTongTienTU, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchDNTongTienDen, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchDN)
                    .addComponent(cbxSearchDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchDNTongTienTU, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(txtSearchDNTongTienDen))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(jPanel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
            .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
            .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
        );

        tblDonNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tblDonNhap);

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12)
                .addContainerGap())
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        lblCPThangDN.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi phí nhập trong tháng hiện tại"));
        lblCPThangDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblDNMax.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn nhập lớn nhất"));
        lblDNMax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblDNMin.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn nhập nhỏ nhất"));
        lblDNMin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblCPNamDN.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi phí nhập trong năm hiện tại"));
        lblCPNamDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblCPNgayDN.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi phí nhập trong ngày"));
        lblCPNgayDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel80Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDNMax, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDNMin, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPNamDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPThangDN, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCPNgayDN, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCPNamDN, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(lblCPThangDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDNMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCPNgayDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDNMax, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Đơn nhập", jPanel74);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Doanh thu", jPanel2);

        tblLoaiMA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLoaiMA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiMAMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiMA);

        jLabel11.setText("DANH SÁCH LOẠI MÓN");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel11)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        btnNewLMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-key-2-30.png"))); // NOI18N
        btnNewLMA.setText("Tạo mới");
        btnNewLMA.setBackground(new java.awt.Color(153, 153, 255));
        btnNewLMA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNewLMA.setForeground(new java.awt.Color(255, 255, 255));
        btnNewLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewLMAActionPerformed(evt);
            }
        });

        btnUpdateLMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sua2-30.png"))); // NOI18N
        btnUpdateLMA.setText("Sửa");
        btnUpdateLMA.setBackground(new java.awt.Color(153, 153, 255));
        btnUpdateLMA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateLMA.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLMAActionPerformed(evt);
            }
        });

        btnAddLMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_add_30px.png"))); // NOI18N
        btnAddLMA.setText("Thêm");
        btnAddLMA.setBackground(new java.awt.Color(153, 153, 255));
        btnAddLMA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddLMA.setForeground(new java.awt.Color(255, 255, 255));
        btnAddLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLMAActionPerformed(evt);
            }
        });

        btnDelLMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete1-30.png"))); // NOI18N
        btnDelLMA.setText("Xóa");
        btnDelLMA.setBackground(new java.awt.Color(153, 153, 255));
        btnDelLMA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelLMA.setForeground(new java.awt.Color(255, 255, 255));
        btnDelLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelLMAActionPerformed(evt);
            }
        });

        btnloadLM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_replay_30px.png"))); // NOI18N
        btnloadLM.setText("Load");
        btnloadLM.setBackground(new java.awt.Color(153, 153, 255));
        btnloadLM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnloadLM.setForeground(new java.awt.Color(255, 255, 255));
        btnloadLM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadLMActionPerformed(evt);
            }
        });

        txtSearchLM.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        txtSearchLM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchLMKeyReleased(evt);
            }
        });

        cbxSearchLM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSearchLM.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo"));
        cbxSearchLM.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnNewLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelLMA, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(cbxSearchLM, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchLM, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnloadLM, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNewLMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddLMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateLMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelLMA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchLM)
                    .addComponent(btnloadLM, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSearchLM, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel3.setText("Mã loại thức ăn");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setText("Tên loại thức ăn");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTenLoai.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên loại"));

        lblMaLoai.setBackground(new java.awt.Color(255, 255, 255));
        lblMaLoai.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã loại"));
        lblMaLoai.setOpaque(true);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenLoai, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Danh mục thức ăn", jPanel3);

        tblThucAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblThucAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThucAnMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblThucAn);

        jLabel22.setText("DANH SÁCH MÓN ĂN");
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNewMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-key-2-30.png"))); // NOI18N
        btnNewMA.setBackground(new java.awt.Color(153, 153, 255));
        btnNewMA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNewMA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewMAActionPerformed(evt);
            }
        });

        btnAddMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_add_30px.png"))); // NOI18N
        btnAddMA.setBackground(new java.awt.Color(153, 153, 255));
        btnAddMA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddMA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMAActionPerformed(evt);
            }
        });

        btnUpdateMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_settings_30px.png"))); // NOI18N
        btnUpdateMA.setBackground(new java.awt.Color(153, 153, 255));
        btnUpdateMA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdateMA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdateMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMAActionPerformed(evt);
            }
        });

        btnDelMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete1-30.png"))); // NOI18N
        btnDelMA.setBackground(new java.awt.Color(153, 153, 255));
        btnDelMA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelMA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMAActionPerformed(evt);
            }
        });

        cbxSearchMA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSearchMA.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo"));
        cbxSearchMA.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N

        txtSearchMA.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        txtSearchMA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchMAKeyReleased(evt);
            }
        });

        btnloadMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_replay_30px.png"))); // NOI18N
        btnloadMA.setBackground(new java.awt.Color(153, 153, 255));
        btnloadMA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnloadMA.setForeground(new java.awt.Color(255, 255, 255));
        btnloadMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadMAActionPerformed(evt);
            }
        });

        txtSearchGiaFrom.setBorder(javax.swing.BorderFactory.createTitledBorder("Giá từ"));

        txtSearchGiaTo.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtSearchGiaTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchGiaToKeyReleased(evt);
            }
        });

        txtSearchSLFrom.setBorder(javax.swing.BorderFactory.createTitledBorder("Số lượng từ"));

        txtSearchSLTo.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtSearchSLTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSLToKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(btnNewMA, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddMA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateMA, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(cbxSearchMA, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearchMA, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnloadMA, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(txtSearchGiaFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchGiaTo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchSLFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchSLTo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnUpdateMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchMA)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnloadMA))
                    .addComponent(cbxSearchMA, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchGiaFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchGiaTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchSLFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchSLTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setText("Mã món");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setText("Tên món");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setText("Giá");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setText("Danh mục món");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setText("Số Lượng");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTenMon.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên món"));

        txtGia.setBorder(javax.swing.BorderFactory.createTitledBorder("Giá"));

        cbbLoaiMon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoaiMon.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh mục loại món"));
        cbbLoaiMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbLoaiMonMouseClicked(evt);
            }
        });
        cbbLoaiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiMonActionPerformed(evt);
            }
        });

        lblMaMon.setBackground(new java.awt.Color(255, 255, 255));
        lblMaMon.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã món"));
        lblMaMon.setOpaque(true);

        lblSoLuong.setText("0");
        lblSoLuong.setBackground(new java.awt.Color(255, 255, 255));
        lblSoLuong.setBorder(javax.swing.BorderFactory.createTitledBorder("Số lượng"));
        lblSoLuong.setOpaque(true);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbLoaiMon, 0, 197, Short.MAX_VALUE)
                    .addComponent(txtTenMon)
                    .addComponent(lblMaMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGia))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbLoaiMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSoLuong)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thức ăn", jPanel4);

        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblTaiKhoan);

        jLabel26.setText("DANH SÁCH TÀI KHOẢN");
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel26)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNewTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-key-2-30.png"))); // NOI18N
        btnNewTK.setText("Tạo mới");
        btnNewTK.setBackground(new java.awt.Color(153, 153, 255));
        btnNewTK.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNewTK.setForeground(new java.awt.Color(255, 255, 255));
        btnNewTK.setMaximumSize(new java.awt.Dimension(67, 29));
        btnNewTK.setMinimumSize(new java.awt.Dimension(67, 29));
        btnNewTK.setPreferredSize(new java.awt.Dimension(67, 29));
        btnNewTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTKActionPerformed(evt);
            }
        });

        btnAddTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_add_30px.png"))); // NOI18N
        btnAddTK.setText("Thêm");
        btnAddTK.setBackground(new java.awt.Color(153, 153, 255));
        btnAddTK.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAddTK.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTKActionPerformed(evt);
            }
        });

        btnUpdateTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_settings_30px.png"))); // NOI18N
        btnUpdateTK.setText("Sửa");
        btnUpdateTK.setBackground(new java.awt.Color(153, 153, 255));
        btnUpdateTK.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUpdateTK.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateTK.setMaximumSize(new java.awt.Dimension(67, 29));
        btnUpdateTK.setMinimumSize(new java.awt.Dimension(67, 29));
        btnUpdateTK.setPreferredSize(new java.awt.Dimension(67, 29));
        btnUpdateTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTKActionPerformed(evt);
            }
        });

        btnDelTk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete1-30.png"))); // NOI18N
        btnDelTk.setText("Xóa");
        btnDelTk.setBackground(new java.awt.Color(153, 153, 255));
        btnDelTk.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDelTk.setForeground(new java.awt.Color(255, 255, 255));
        btnDelTk.setMaximumSize(new java.awt.Dimension(67, 29));
        btnDelTk.setMinimumSize(new java.awt.Dimension(67, 29));
        btnDelTk.setPreferredSize(new java.awt.Dimension(67, 29));
        btnDelTk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelTkActionPerformed(evt);
            }
        });

        cbxSearchTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSearchTK.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo"));
        cbxSearchTK.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N

        txtSearchTK.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        txtSearchTK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTKKeyReleased(evt);
            }
        });

        btnloadMA1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_replay_30px.png"))); // NOI18N
        btnloadMA1.setText("Load");
        btnloadMA1.setBackground(new java.awt.Color(153, 153, 255));
        btnloadMA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnloadMA1.setForeground(new java.awt.Color(255, 255, 255));
        btnloadMA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadMA1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxSearchTK, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNewTK, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(txtSearchTK, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnloadMA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(btnAddTK, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateTK, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelTk, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelTk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNewTK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddTK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdateTK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSearchTK, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtSearchTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(btnloadMA1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel9.setText("Tên tài khoản");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel10.setText("Loại tài khoản");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel12.setText("Mã tài khoản");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel13.setText("Mật khẩu");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addGap(29, 29, 29)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addGap(26, 26, 26)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtTenTK.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên tài khoản"));

        cbbLoaiTk.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại tài khoản"));

        txtMk.setText("1");
        txtMk.setBorder(javax.swing.BorderFactory.createTitledBorder("Mật khẩu"));

        lblMaTk.setBackground(new java.awt.Color(255, 255, 255));
        lblMaTk.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã tài khoản"));
        lblMaTk.setOpaque(true);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbLoaiTk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenTK, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMk)
                    .addComponent(lblMaTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(lblMaTk, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMk, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbLoaiTk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 437, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tài khoản", jPanel6);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblNhanVien);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnTaoMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-key-2-30.png"))); // NOI18N
        btnTaoMoi.setText("Tạo mã mới");
        btnTaoMoi.setBackground(new java.awt.Color(153, 153, 255));
        btnTaoMoi.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTaoMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        btnSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_settings_30px.png"))); // NOI18N
        btnSuaNV.setText("Sửa");
        btnSuaNV.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaNV.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSuaNV.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaNV.setMaximumSize(new java.awt.Dimension(67, 29));
        btnSuaNV.setMinimumSize(new java.awt.Dimension(67, 29));
        btnSuaNV.setPreferredSize(new java.awt.Dimension(67, 29));
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_add_30px.png"))); // NOI18N
        btnThemNV.setText("Thêm");
        btnThemNV.setBackground(new java.awt.Color(153, 153, 255));
        btnThemNV.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnThemNV.setForeground(new java.awt.Color(255, 255, 255));
        btnThemNV.setMaximumSize(new java.awt.Dimension(67, 29));
        btnThemNV.setMinimumSize(new java.awt.Dimension(67, 29));
        btnThemNV.setPreferredSize(new java.awt.Dimension(67, 29));
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete1-30.png"))); // NOI18N
        btnXoaNV.setText("Xóa");
        btnXoaNV.setBackground(new java.awt.Color(153, 153, 255));
        btnXoaNV.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnXoaNV.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaNV.setMaximumSize(new java.awt.Dimension(67, 29));
        btnXoaNV.setMinimumSize(new java.awt.Dimension(67, 29));
        btnXoaNV.setPreferredSize(new java.awt.Dimension(67, 29));
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        cbxSearchNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSearchNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo"));
        cbxSearchNV.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N

        txtSearchNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        txtSearchNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNVKeyReleased(evt);
            }
        });

        btnloadNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_replay_30px.png"))); // NOI18N
        btnloadNV.setText("Load");
        btnloadNV.setBackground(new java.awt.Color(153, 153, 255));
        btnloadNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnloadNV.setForeground(new java.awt.Color(255, 255, 255));
        btnloadNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadNVActionPerformed(evt);
            }
        });

        txtNVNgayPd.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ ngày"));

        txtNVNgayKt.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến ngày"));
        txtNVNgayKt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNVNgayKtKeyReleased(evt);
            }
        });

        jLabel29.setText("Tìm kiếm ngày sinh");
        jLabel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo ngày"));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaoMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxSearchNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(txtNVNgayPd, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNVNgayKt, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSearchNV))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnloadNV, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(btnXoaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSuaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaoMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnXoaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchNV)
                    .addComponent(cbxSearchNV, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnloadNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNVNgayPd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNVNgayKt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setText("Tên nhân viên");
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel16.setText("Mail");
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel17.setText("Ngày sinh");
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel18.setText("Mã nhân viên");
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel19.setText("SĐT");
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel20.setText("Tài khoản");
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTenNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên nhân viên"));

        cbbTkNv.setBorder(javax.swing.BorderFactory.createTitledBorder("Tài khoản"));

        txtSdt.setBorder(javax.swing.BorderFactory.createTitledBorder("Số điện thoại"));

        lblMaNV.setBackground(new java.awt.Color(255, 255, 255));
        lblMaNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã nhân viên"));
        lblMaNV.setOpaque(true);

        txtMail.setBorder(javax.swing.BorderFactory.createTitledBorder("Mail"));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTkNv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSdt)
                    .addComponent(txtMail)
                    .addComponent(lblMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenNV)
                    .addComponent(dPNgaySinhNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dPNgaySinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbTkNv))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel14.setText("DANH SÁCH NHÂN VIÊN");
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(74, 74, 74))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addComponent(jLabel14))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhân viên", jPanel5);

        jLabel21.setText("Mã CTKM");
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel23.setText("Ngày bắt đầu");
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel24.setText("Tên CTKM");
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel25.setText("Ngày kết thúc");
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTenCTKM.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên CTKM"));

        lblMaKM.setBackground(new java.awt.Color(255, 255, 255));
        lblMaKM.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã CTKM"));
        lblMaKM.setOpaque(true);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dpNgaykt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpNgaybd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenCTKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtTenCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dpNgaybd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dpNgaykt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnTaoMoiCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-key-2-30.png"))); // NOI18N
        btnTaoMoiCTKM.setText("Tạo mã mới");
        btnTaoMoiCTKM.setBackground(new java.awt.Color(153, 153, 255));
        btnTaoMoiCTKM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTaoMoiCTKM.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoMoiCTKM.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTaoMoiCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiCTKMActionPerformed(evt);
            }
        });

        btnXoaCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete1-30.png"))); // NOI18N
        btnXoaCTKM.setText("Xóa");
        btnXoaCTKM.setBackground(new java.awt.Color(153, 153, 255));
        btnXoaCTKM.setDisabledSelectedIcon(null);
        btnXoaCTKM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnXoaCTKM.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaCTKM.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnXoaCTKM.setMaximumSize(new java.awt.Dimension(67, 29));
        btnXoaCTKM.setMinimumSize(new java.awt.Dimension(67, 29));
        btnXoaCTKM.setPreferredSize(new java.awt.Dimension(67, 29));
        btnXoaCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTKMActionPerformed(evt);
            }
        });

        btnSuaCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_settings_30px.png"))); // NOI18N
        btnSuaCTKM.setText("Sửa");
        btnSuaCTKM.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaCTKM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSuaCTKM.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaCTKM.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSuaCTKM.setMaximumSize(new java.awt.Dimension(67, 29));
        btnSuaCTKM.setMinimumSize(new java.awt.Dimension(67, 29));
        btnSuaCTKM.setPreferredSize(new java.awt.Dimension(67, 29));
        btnSuaCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTKMActionPerformed(evt);
            }
        });

        btnThemCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_add_30px.png"))); // NOI18N
        btnThemCTKM.setText("Thêm");
        btnThemCTKM.setBackground(new java.awt.Color(153, 153, 255));
        btnThemCTKM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnThemCTKM.setForeground(new java.awt.Color(255, 255, 255));
        btnThemCTKM.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThemCTKM.setMaximumSize(new java.awt.Dimension(67, 29));
        btnThemCTKM.setMinimumSize(new java.awt.Dimension(67, 29));
        btnThemCTKM.setPreferredSize(new java.awt.Dimension(67, 29));
        btnThemCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTKMActionPerformed(evt);
            }
        });

        btnXemCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_show_property_30px.png"))); // NOI18N
        btnXemCTKM.setText("Xem chi tiết");
        btnXemCTKM.setBackground(new java.awt.Color(153, 153, 255));
        btnXemCTKM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnXemCTKM.setForeground(new java.awt.Color(255, 255, 255));
        btnXemCTKM.setMaximumSize(new java.awt.Dimension(67, 29));
        btnXemCTKM.setMinimumSize(new java.awt.Dimension(67, 29));
        btnXemCTKM.setPreferredSize(new java.awt.Dimension(67, 29));
        btnXemCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemCTKMActionPerformed(evt);
            }
        });

        btnApDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_ok_30px.png"))); // NOI18N
        btnApDung.setText("Áp Dụng");
        btnApDung.setBackground(new java.awt.Color(153, 153, 255));
        btnApDung.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnApDung.setForeground(new java.awt.Color(255, 255, 255));
        btnApDung.setMaximumSize(new java.awt.Dimension(67, 29));
        btnApDung.setMinimumSize(new java.awt.Dimension(67, 29));
        btnApDung.setPreferredSize(new java.awt.Dimension(67, 29));
        btnApDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApDungActionPerformed(evt);
            }
        });

        lblTtCtkm.setBackground(new java.awt.Color(255, 255, 255));
        lblTtCtkm.setBorder(javax.swing.BorderFactory.createTitledBorder("Trạng thái khuyến mãi"));
        lblTtCtkm.setOpaque(true);

        btnDungAD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_30px_1.png"))); // NOI18N
        btnDungAD.setText("Ngưng");
        btnDungAD.setBackground(new java.awt.Color(153, 153, 255));
        btnDungAD.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDungAD.setForeground(new java.awt.Color(255, 255, 255));
        btnDungAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDungADActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaoMoiCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTtCtkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDungAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXemCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaoMoiCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXemCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btnApDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSuaCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDungAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(lblTtCtkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblCTKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCTKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTKMMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblCTKM);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbxSearchCTKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSearchCTKM.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo"));

        txtSearchCTKM.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        txtSearchCTKM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCTKMKeyReleased(evt);
            }
        });

        btnLoadCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_replay_30px.png"))); // NOI18N
        btnLoadCTKM.setText("LOAD");
        btnLoadCTKM.setBackground(new java.awt.Color(153, 153, 255));
        btnLoadCTKM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLoadCTKM.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadCTKMActionPerformed(evt);
            }
        });

        txtKMNgayTu.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày KM từ"));

        txtKMNgayDen.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtKMNgayDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKMNgayDenKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxSearchCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKMNgayTu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKMNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoadCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoadCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxSearchCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtKMNgayDen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtKMNgayTu, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chương trình khuyến mãi", jPanel19);

        jPanel35.setPreferredSize(new java.awt.Dimension(766, 500));

        btnDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_add_30px.png"))); // NOI18N
        btnDat.setText("Thêm món");
        btnDat.setBackground(new java.awt.Color(153, 153, 255));
        btnDat.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDat.setForeground(new java.awt.Color(255, 255, 255));
        btnDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatActionPerformed(evt);
            }
        });

        spnCount.setBorder(javax.swing.BorderFactory.createTitledBorder("Số lượng"));

        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCategory.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại món"));
        cbxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoryActionPerformed(evt);
            }
        });

        cbxNcc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxNcc.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhà cung cấp"));
        cbxNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNccActionPerformed(evt);
            }
        });

        btnXoaMonDN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete1-30.png"))); // NOI18N
        btnXoaMonDN.setText("Xóa món");
        btnXoaMonDN.setBackground(new java.awt.Color(153, 153, 255));
        btnXoaMonDN.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnXoaMonDN.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaMonDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonDNActionPerformed(evt);
            }
        });

        cbxSearchDH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSearchDH.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo"));
        cbxSearchDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSearchDHActionPerformed(evt);
            }
        });

        txtSearchDH.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        txtSearchDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDHKeyReleased(evt);
            }
        });

        txtSearchDHGiaFrom.setBorder(javax.swing.BorderFactory.createTitledBorder("Giá từ"));
        txtSearchDHGiaFrom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDHGiaFromKeyReleased(evt);
            }
        });

        txtSearchDHGiaTo.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtSearchDHGiaTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDHGiaToKeyReleased(evt);
            }
        });

        btnLoadMAOfDN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_replay_30px.png"))); // NOI18N
        btnLoadMAOfDN.setText("Load");
        btnLoadMAOfDN.setBackground(new java.awt.Color(153, 153, 255));
        btnLoadMAOfDN.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLoadMAOfDN.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadMAOfDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadMAOfDNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(spnCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchDHGiaFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchDHGiaTo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxNcc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoaMonDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDat, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearchDH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxSearchDH, javax.swing.GroupLayout.Alignment.LEADING, 0, 121, Short.MAX_VALUE)
                    .addComponent(btnLoadMAOfDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbxNcc)
                        .addComponent(btnDat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxSearchDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCategory)
                    .addComponent(btnXoaMonDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchDH, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchDHGiaFrom)
                    .addComponent(spnCount)
                    .addComponent(txtSearchDHGiaTo)
                    .addComponent(btnLoadMAOfDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnChotDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_us_dollar_30px.png"))); // NOI18N
        btnChotDon.setText("Thanh toán");
        btnChotDon.setBackground(new java.awt.Color(153, 153, 255));
        btnChotDon.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnChotDon.setForeground(new java.awt.Color(255, 255, 255));
        btnChotDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChotDonActionPerformed(evt);
            }
        });

        lblTotalPrice.setBackground(new java.awt.Color(0, 0, 0));
        lblTotalPrice.setBorder(javax.swing.BorderFactory.createTitledBorder("Tổng tiền"));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChotDon, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChotDon, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lblTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblFood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFoodMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblFood);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblICTDonNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tblICTDonNhap);

        jLabel30.setText("CHI TIẾT NHẬP HÀNG");
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(133, 133, 133))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Nhập hàng", jPanel35);

        tblNhaCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCCMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblNhaCC);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        btnNewNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-key-2-30.png"))); // NOI18N
        btnNewNCC.setText("Tạo mới");
        btnNewNCC.setBackground(new java.awt.Color(153, 153, 255));
        btnNewNCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNewNCC.setForeground(new java.awt.Color(255, 255, 255));
        btnNewNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewNCCActionPerformed(evt);
            }
        });

        btnUpdateNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_settings_30px.png"))); // NOI18N
        btnUpdateNCC.setText("Sửa");
        btnUpdateNCC.setBackground(new java.awt.Color(153, 153, 255));
        btnUpdateNCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateNCC.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNCCActionPerformed(evt);
            }
        });

        btnAddNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_add_30px.png"))); // NOI18N
        btnAddNCC.setText("Thêm");
        btnAddNCC.setBackground(new java.awt.Color(153, 153, 255));
        btnAddNCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddNCC.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNCCActionPerformed(evt);
            }
        });

        btnDelNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete1-30.png"))); // NOI18N
        btnDelNCC.setText("Xóa");
        btnDelNCC.setBackground(new java.awt.Color(153, 153, 255));
        btnDelNCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelNCC.setForeground(new java.awt.Color(255, 255, 255));
        btnDelNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelNCCActionPerformed(evt);
            }
        });

        cbxSearchNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSearchNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo"));
        cbxSearchNCC.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N

        txtSearchNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        txtSearchNCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNCCKeyReleased(evt);
            }
        });

        btnloadNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_replay_30px.png"))); // NOI18N
        btnloadNCC.setText("Load");
        btnloadNCC.setBackground(new java.awt.Color(153, 153, 255));
        btnloadNCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnloadNCC.setForeground(new java.awt.Color(255, 255, 255));
        btnloadNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadNCCActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xemchitiet-30.png"))); // NOI18N
        jButton3.setText("Chi tiết");
        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxSearchNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnloadNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewNCC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdateNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtSearchNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnloadNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchNCC)
                    .addComponent(cbxSearchNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel31.setText("Mã NCC");
        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel32.setText("Tên NCC");
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel33.setText("Địa chỉ");
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTenNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên nhà cung cấp"));

        lblMaNCC.setBackground(new java.awt.Color(255, 255, 255));
        lblMaNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã nhà cung cấp"));
        lblMaNCC.setOpaque(true);

        txtDiaChi.setBorder(javax.swing.BorderFactory.createTitledBorder("Địa chỉ"));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiaChi)
                    .addComponent(txtTenNCC)
                    .addComponent(lblMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel8.setText("DANH SÁCH NHÀ CUNG CẤP");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(55, 55, 55))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Nhà cung cấp", jPanel40);

        tblThanhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblThanhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThanhVienMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblThanhVien);

        jLabel27.setText("DANH SÁCH THÀNH VIÊN");
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel67Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(90, 90, 90))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel67Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jLabel27))
        );

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdateTV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_settings_30px.png"))); // NOI18N
        btnUpdateTV.setText("Sửa");
        btnUpdateTV.setBackground(new java.awt.Color(153, 153, 255));
        btnUpdateTV.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUpdateTV.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTVActionPerformed(evt);
            }
        });

        btnDelTV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete1-30.png"))); // NOI18N
        btnDelTV.setText("Xóa");
        btnDelTV.setBackground(new java.awt.Color(153, 153, 255));
        btnDelTV.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDelTV.setForeground(new java.awt.Color(255, 255, 255));
        btnDelTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelTVActionPerformed(evt);
            }
        });

        btnloadTV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_replay_30px.png"))); // NOI18N
        btnloadTV.setText("Load");
        btnloadTV.setBackground(new java.awt.Color(153, 153, 255));
        btnloadTV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnloadTV.setForeground(new java.awt.Color(255, 255, 255));
        btnloadTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadTVActionPerformed(evt);
            }
        });

        cbxSearchTV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSearchTV.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo"));
        cbxSearchTV.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N

        txtSearchTV.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        txtSearchTV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTVKeyReleased(evt);
            }
        });

        txtSearchDiemFrom.setBorder(javax.swing.BorderFactory.createTitledBorder("Điểm từ"));

        txtSearchDiemTo.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtSearchDiemTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDiemToKeyReleased(evt);
            }
        });

        txtSearchTVNSFrom.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày sinh từ"));

        txtSearchTVNSTo.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtSearchTVNSTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTVNSToKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(btnUpdateTV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelTV, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnloadTV, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxSearchTV, 0, 108, Short.MAX_VALUE)
                            .addComponent(txtSearchDiemFrom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchTV, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(txtSearchDiemTo))
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(txtSearchTVNSTo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSearchTVNSFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelTV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnUpdateTV)
                    .addComponent(btnloadTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbxSearchTV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchTV)
                        .addComponent(txtSearchTVNSFrom)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchDiemTo)
                        .addComponent(txtSearchTVNSTo))
                    .addComponent(txtSearchDiemFrom))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        txtTenTv.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên thành viên"));
        txtTenTv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTvActionPerformed(evt);
            }
        });

        lblMaTV.setBackground(new java.awt.Color(255, 255, 255));
        lblMaTV.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã thành viên"));
        lblMaTV.setOpaque(true);

        txtSdtTV.setBorder(javax.swing.BorderFactory.createTitledBorder("Số điện thoại"));

        txtMailTV.setBorder(javax.swing.BorderFactory.createTitledBorder("Mail"));

        lblPointTv.setBackground(new java.awt.Color(255, 255, 255));
        lblPointTv.setBorder(javax.swing.BorderFactory.createTitledBorder("Điểm"));
        lblPointTv.setOpaque(true);

        jLabel44.setText("Mã thành viên");

        jLabel45.setText("Tên thành viên");

        jLabel46.setText("Số điện thoại");
        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel47.setText("Mail");
        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel48.setText("Điểm");
        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel28.setText("Ngày sinh");

        dPNgaySinhTV.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày sinh"));

        jLabel38.setText("Mã xác nhận");

        txtMkTv.setBorder(javax.swing.BorderFactory.createTitledBorder("Mật khẩu"));

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
                            .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
                            .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel38))
                            .addGap(58, 58, 58)))
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTenTv, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblMaTV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMailTV)
                        .addComponent(txtSdtTV)
                        .addComponent(dPNgaySinhTV, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblPointTv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMkTv, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMaTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenTv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dPNgaySinhTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdtTV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMailTV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPointTv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMkTv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thành viên", jPanel53);

        jLabel34.setText("Mã phiếu");
        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel35.setText("Ngày bất đầu");
        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel36.setText("Giảm");
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel37.setText("Ngày kết thúc");
        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel39.setText("Tên phiếu");
        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                            .addComponent(jLabel34)
                            .addGap(53, 53, 53))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                            .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36)
                                .addComponent(jLabel35))
                            .addContainerGap()))))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        txtGiamTien.setBorder(javax.swing.BorderFactory.createTitledBorder("Giảm"));

        lblMaPGG.setBackground(new java.awt.Color(255, 255, 255));
        lblMaPGG.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã giảm giá"));
        lblMaPGG.setOpaque(true);

        txtTenPGG.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên phiếu"));

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenPGG)
                    .addComponent(lblMaPGG, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(txtGiamTien, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dpNgayPGGkt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpNgayPGGbd, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblMaPGG, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenPGG, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGiamTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dpNgayPGGbd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dpNgayPGGkt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTaoMoiCTKM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-key-2-30.png"))); // NOI18N
        btnTaoMoiCTKM1.setText("Tạo mới");
        btnTaoMoiCTKM1.setBackground(new java.awt.Color(153, 153, 255));
        btnTaoMoiCTKM1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTaoMoiCTKM1.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoMoiCTKM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiCTKM1ActionPerformed(evt);
            }
        });

        btnXoaCTKM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete1-30.png"))); // NOI18N
        btnXoaCTKM1.setText("Xóa");
        btnXoaCTKM1.setBackground(new java.awt.Color(153, 153, 255));
        btnXoaCTKM1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnXoaCTKM1.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaCTKM1.setMaximumSize(new java.awt.Dimension(67, 29));
        btnXoaCTKM1.setMinimumSize(new java.awt.Dimension(67, 29));
        btnXoaCTKM1.setPreferredSize(new java.awt.Dimension(67, 29));
        btnXoaCTKM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTKM1ActionPerformed(evt);
            }
        });

        btnSuaCTKM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_settings_30px.png"))); // NOI18N
        btnSuaCTKM1.setText("Sửa");
        btnSuaCTKM1.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaCTKM1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSuaCTKM1.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaCTKM1.setMaximumSize(new java.awt.Dimension(67, 29));
        btnSuaCTKM1.setMinimumSize(new java.awt.Dimension(67, 29));
        btnSuaCTKM1.setPreferredSize(new java.awt.Dimension(67, 29));
        btnSuaCTKM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTKM1ActionPerformed(evt);
            }
        });

        btnThemCTKM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_add_30px.png"))); // NOI18N
        btnThemCTKM1.setText("Thêm");
        btnThemCTKM1.setBackground(new java.awt.Color(153, 153, 255));
        btnThemCTKM1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnThemCTKM1.setForeground(new java.awt.Color(255, 255, 255));
        btnThemCTKM1.setMaximumSize(new java.awt.Dimension(67, 29));
        btnThemCTKM1.setMinimumSize(new java.awt.Dimension(67, 29));
        btnThemCTKM1.setPreferredSize(new java.awt.Dimension(67, 29));
        btnThemCTKM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTKM1ActionPerformed(evt);
            }
        });

        txtSearchPhieuGiam.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        txtSearchPhieuGiam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchPhieuGiamKeyReleased(evt);
            }
        });

        btnloadPGG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_replay_30px.png"))); // NOI18N
        btnloadPGG.setText("Load");
        btnloadPGG.setBackground(new java.awt.Color(153, 153, 255));
        btnloadPGG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnloadPGG.setForeground(new java.awt.Color(255, 255, 255));
        btnloadPGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadPGGActionPerformed(evt);
            }
        });

        txtPGGGiamTu.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiền giảm từ"));

        txtPGGGiamDen.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtPGGGiamDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPGGGiamDenKeyReleased(evt);
            }
        });

        txtPGGNgayTu.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày từ"));

        txtPGGNgayDen.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến"));
        txtPGGNgayDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPGGNgayDenKeyReleased(evt);
            }
        });

        cbxSearchPGG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSearchPGG.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo"));

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnTaoMoiCTKM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaCTKM1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoaCTKM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemCTKM1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnloadPGG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                        .addComponent(cbxSearchPGG, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchPhieuGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPGGGiamTu)
                    .addComponent(txtPGGNgayTu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPGGNgayDen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPGGGiamDen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoMoiCTKM1)
                    .addComponent(btnThemCTKM1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSuaCTKM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaCTKM1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnloadPGG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchPhieuGiam)
                    .addComponent(cbxSearchPGG))
                .addGap(12, 12, 12)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPGGNgayTu)
                    .addComponent(txtPGGNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPGGGiamTu, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(txtPGGGiamDen))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblPGG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPGG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPGGMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblPGG);

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10)
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phiếu giảm giá", jPanel47);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(879, 598));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnDelTkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelTkActionPerformed

        int kq = JOptionPane.showConfirmDialog(this,xoa,thongBao,JOptionPane.YES_OPTION);
        if(kq == 0){
            int ma_tk = Integer.valueOf(lblMaTk.getText());
            taiKhoanBLL.XoaTK(ma_tk);
            JOptionPane.showMessageDialog(this,xoaTC,thongBao,JOptionPane.INFORMATION_MESSAGE);
            loadListTK();
            setNullTk();
        }
        
    }//GEN-LAST:event_btnDelTkActionPerformed

    private void btnUpdateTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTKActionPerformed
        String []str = {
            lblMaTk.getText(),
            txtTenTK.getText(),
            txtMk.getText(),
            new PhanQuyenBLL().getMaQuyenByQuyen(String.valueOf(cbbLoaiTk.getSelectedItem()))+"",
            "0"
        };
        
        taiKhoanBLL.SuaTk(str);
        JOptionPane.showMessageDialog(this,sua,thongBao,JOptionPane.INFORMATION_MESSAGE);
        loadListTK();
        
        setNullTk();
    }//GEN-LAST:event_btnUpdateTKActionPerformed

    private void btnAddTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTKActionPerformed
        String []str = {
            lblMaTk.getText(),
            txtTenTK.getText(),
            txtMk.getText(),
            String.valueOf(new PhanQuyenBLL().getMaQuyenByQuyen(String.valueOf(cbbLoaiTk.getSelectedItem()))),
            "0"
        };
        taiKhoanBLL.ThemTK(str);
        JOptionPane.showMessageDialog(this,them,thongBao,JOptionPane.INFORMATION_MESSAGE);
        loadListTK();
        setNullTk();
    }//GEN-LAST:event_btnAddTKActionPerformed

    private void btnDelMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMAActionPerformed

        int kq = JOptionPane.showConfirmDialog(this,xoa,thongBao,JOptionPane.YES_OPTION);
        if(kq == 0){
            String str = lblMaMon.getText();
            new MonAnBLL().XoaMon(str);
            JOptionPane.showMessageDialog(this,xoaTC,thongBao,JOptionPane.INFORMATION_MESSAGE);
            loadListMA();
            setNullMonAn();
        }
    }//GEN-LAST:event_btnDelMAActionPerformed

    private void btnUpdateMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMAActionPerformed
        String []str = {
            lblMaMon.getText(),//arr[0]
            txtTenMon.getText(),//arr[1]
            txtGia.getText(),//arr[2]
            new LoaiMonAnBLL().getMaLoaiByTenLoai(String.valueOf(cbbLoaiMon.getSelectedItem()))//arr[3]
        };
        new MonAnBLL().SuaMon(str);
        JOptionPane.showMessageDialog(this,"Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        loadListMA();
        
        setNullMonAn();
    }//GEN-LAST:event_btnUpdateMAActionPerformed

    private void tblThucAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThucAnMouseClicked
        int click = tblThucAn.getSelectedRow();
        if(click >= 0){
            String maLoai = (String) tblThucAn.getValueAt(click,6);
            String maMon = (String) tblThucAn.getValueAt(click, 0);
            
            MonAnDTO monAnDTO = new MonAnBLL().getFoodByMaMon(maMon);
            
            lblMaMon.setText(monAnDTO.getMa_mon());
            txtTenMon.setText(monAnDTO.getTen_mon());
            txtGia.setText(String.valueOf(monAnDTO.getGia()));
            lblSoLuong.setText(""+monAnDTO.getSo_luong());
            cbbLoaiMon.setSelectedItem((new LoaiMonAnBLL().getTenLoaiByMaLoai(monAnDTO.getMa_loai())));
        }
        
    }//GEN-LAST:event_tblThucAnMouseClicked

    private void btnDelLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelLMAActionPerformed

        int kq = JOptionPane.showConfirmDialog(this,xoa,thongBao,JOptionPane.YES_OPTION);
        if(kq==0){
            String ma_loai = lblMaLoai.getText();
            loaiMonAnBLL.delLM(ma_loai);
            JOptionPane.showMessageDialog(this,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            setNullLMA();
            loadListLMA();
            loadLoaiMonToComboBox();
        }
    }//GEN-LAST:event_btnDelLMAActionPerformed

    private void btnUpdateLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLMAActionPerformed
        String []str = {
            txtTenLoai.getText(),//arr[0]
            lblMaLoai.getText(),//arr[1]
        };
        
        loaiMonAnBLL.suaLM(str);
        JOptionPane.showMessageDialog(this,"Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        setNullLMA();
        loadListLMA();
        loadLoaiMonToComboBox();
    }//GEN-LAST:event_btnUpdateLMAActionPerformed

    private void btnNewTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTKActionPerformed
        lblMaTk.setText(new TaiKhoanBLL().maMoi()+"");
        txtTenTK.setText("");
        txtMk.setText("1");
    }//GEN-LAST:event_btnNewTKActionPerformed

    private void btnSuaCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTKMActionPerformed
        String []str = {
            lblMaKM.getText(),
            txtTenCTKM.getText(),
            String.valueOf(dpNgaybd.getDate()),
            String.valueOf(dpNgaykt.getDate())
        };
        cTKhuyenMaiBLL.suaCTKM(str);
        JOptionPane.showMessageDialog(this,sua,thongBao,JOptionPane.INFORMATION_MESSAGE);
        loadCTKM();
        setNullCtkm();
    }//GEN-LAST:event_btnSuaCTKMActionPerformed

    private void btnThemCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTKMActionPerformed
        String []str = {
            lblMaKM.getText(),
            txtTenCTKM.getText(),
            String.valueOf(dpNgaybd.getDate()),
            String.valueOf(dpNgaykt.getDate())
        };
        cTKhuyenMaiBLL.themCTKM(str);
        JOptionPane.showMessageDialog(this,them,thongBao,JOptionPane.INFORMATION_MESSAGE);
        loadCTKM();
        setNullCtkm();
    }//GEN-LAST:event_btnThemCTKMActionPerformed
    
    private void tinhtong(){
        int tong = 0;
        for(int i = 0; i< modelCTDN.getRowCount(); i++){
            tong += (int)modelCTDN.getValueAt(i,4);
        }
        lblTotalPrice.setText(String.valueOf(tong));
    }
    
    private void btnDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatActionPerformed
        
        int select = tblFood.getSelectedRow();
        if(select >= 0){
            int soLuongMua = (int) spnCount.getValue();
            String maMon  = (String) tblFood.getValueAt(select, 0);
            if(modelCTDN.getRowCount() == 0){
                MonAnDTO monAnDTO = new MonAnBLL().getFoodByMaMon(maMon);
                modelCTDN.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getGia(),
                    soLuongMua,
                    (int)(monAnDTO.getGia()*soLuongMua)
                });
                modelCTDN.fireTableDataChanged();
                
                tinhtong();
            }
            else{
                for(int i = 0 ; i < modelCTDN.getRowCount() ; i++){
                    if(modelCTDN.getValueAt(i, 0).equals(maMon)){
                        int soluong = ((int) modelCTDN.getValueAt(i,3)+ soLuongMua);
                        int thanhtien = (int)(modelCTDN.getValueAt(i,2))*soluong;
                        modelCTDN.setValueAt(soluong, i,3);
                        modelCTDN.setValueAt(thanhtien, i,4);
                        modelCTDN.fireTableDataChanged();
                        
                        tinhtong();
                        
                        int soLuongTru = (int)modelCTDN.getValueAt(i,3);
//                        System.out.println(soLuongConLai);
                        SpinnerModel spinnerModel = new SpinnerNumberModel(
                            1,
                            0-soLuongTru,
                            100,
                            1);
                        spnCount.setModel(spinnerModel);
                        if((int)modelCTDN.getValueAt(i,3) == 0){
                            modelCTDN.removeRow(i);
                        }
                        return;
                    }
                }
                MonAnDTO monAnDTO = new MonAnBLL().getFoodByMaMon(maMon);
                modelCTDN.addRow(new Object[]{
                    monAnDTO.getMa_mon(),
                    monAnDTO.getTen_mon(),
                    monAnDTO.getGia(),
                    soLuongMua,
                    (int)(soLuongMua*monAnDTO.getGia())
                });
                modelCTDN.fireTableDataChanged();
                
                tinhtong();
            }
            for(int i = 0; i < modelCTDN.getRowCount(); i++){
                if(modelCTDN.getValueAt(i,0).equals(maMon)){
                    int soLuongTru = (int)modelCTDN.getValueAt(i,3);
//                    System.out.println(soLuongConLai);
                    SpinnerModel spinnerModel = new SpinnerNumberModel(
                        1,
                        0-soLuongTru,
                        100,
                        1);
                    spnCount.setModel(spinnerModel);
                    if((int)modelCTDN.getValueAt(i,3) == 0){
                        modelCTDN.removeRow(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnDatActionPerformed

    private void cbxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoryActionPerformed
              
        String ten_loai = (String) cbxCategory.getSelectedItem();
        
        String ma_loai = loaiMonAnBLL.getMaLoaiByTenLoai(ten_loai);
        
        monAnBLL.setListFoodByMaLoai(modelFood,ma_loai);
    }//GEN-LAST:event_cbxCategoryActionPerformed

    private void tblFoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFoodMouseClicked
        int select = tblFood.getSelectedRow();
        if(select >= 0){
            String ma_mon = (String) tblFood.getValueAt(select,0);
            for(int i = 0; i < modelCTDN.getRowCount();i++){
                if(modelCTDN.getValueAt(i,0).equals(ma_mon)){
                    int soluong = (int) modelCTDN.getValueAt(i,3);
                    SpinnerModel spinnerModel = new SpinnerNumberModel(
                        1, // initial value
                        0-soluong, // min
                        100, // max
                        1);// step
                    spnCount.setModel(spinnerModel);  
                    return;
                }
            }
            SpinnerModel spinnerModel = new SpinnerNumberModel(
                1, // initial value
                1, // min
                100, // max
                1);// step
            spnCount.setModel(spinnerModel);  
        }
    }//GEN-LAST:event_tblFoodMouseClicked

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        int kq = JOptionPane.showConfirmDialog(this,xoa,thongBao,JOptionPane.YES_OPTION);
        if(kq == 0){
            String ma_nv = lblMaNV.getText();
            NhanVienDTO nhanVienCanXoa = new NhanVienBLL().getNvByMaNV(ma_nv);
            int ma_tk = nhanVienCanXoa.getTai_khoan();
            JOptionPane.showMessageDialog(this, xoaTC,thongBao,JOptionPane.INFORMATION_MESSAGE);
            taiKhoanBLL.CapNhatTrangThaiTK(String.valueOf(ma_tk), "0");
            nhanVienBLL.delNV(ma_nv);


            loadTkToComboBoxByTT();

            loadListNV();
            loadListTK();

            setNullNv();
        }

    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        String []str = {
            lblMaNV.getText(),
            txtTenNV.getText(),
            dPNgaySinhNV.getDate().toString(),
            txtSdt.getText(),
            txtMail.getText(),
            String.valueOf(cbbTkNv.getSelectedItem()),
        };
        nhanVienBLL.ThemNV(str);
        JOptionPane.showMessageDialog(this,them,thongBao,JOptionPane.INFORMATION_MESSAGE);
        String ma_tk = String.valueOf(cbbTkNv.getSelectedItem());
        taiKhoanBLL.CapNhatTrangThaiTK(ma_tk,"1");
        
        loadTkToComboBoxByTT();
        loadListTK();
        
        loadListNV();
        setNullNv();
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        String []str = {
            lblMaNV.getText(),
            txtTenNV.getText(),
            dPNgaySinhNV.getDate().toString(),
            txtSdt.getText(),
            txtMail.getText(),
            String.valueOf(cbbTkNv.getSelectedItem()),
        };
        //tìm đối tượng có mã nv là:
        NhanVienDTO nhanVienCapNhat = new NhanVienBLL().getNvByMaNV(lblMaNV.getText());
        //cập nhật trạng thái tài khoản 
        taiKhoanBLL.CapNhatTrangThaiTK(String.valueOf(nhanVienCapNhat.getTai_khoan()),"0");
        
        //cập nhật nhân viên
        nhanVienBLL.suaNV(str);
        JOptionPane.showMessageDialog(this,sua,thongBao,JOptionPane.INFORMATION_MESSAGE);
        
        //Tài khoản
        String ma_tk = String.valueOf(cbbTkNv.getSelectedItem());
        taiKhoanBLL.CapNhatTrangThaiTK(ma_tk,"1");
        
        loadListNV();
        loadListTK();
        
        setNullNv();
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        setNullNv();
        loadTkToComboBoxByTT();
        lblMaNV.setText("NV"+nhanVienBLL.maMoi());
        
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void btnDelNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelNCCActionPerformed
        int kq = JOptionPane.showConfirmDialog(this,xoa,thongBao,JOptionPane.YES_OPTION);
        if(kq ==0){
            String ma_ncc = lblMaNCC.getText();
        
            nhaCungCapBLL.delNCC(ma_ncc);

            setNullNCC();

            loadListNCC();
        }
        
    }//GEN-LAST:event_btnDelNCCActionPerformed

    private void btnSuaCTKM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTKM1ActionPerformed
        String []str = {
            lblMaPGG.getText(),
            txtTenPGG.getText(),
            txtGiamTien.getText(),
            dpNgayPGGbd.getDate().toString(),
            dpNgayPGGkt.getDate().toString(),
            "1"
        };
        phieuGiamGiaBLL.suaPGG(str);
        JOptionPane.showMessageDialog(rootPane,sua,thongBao,JOptionPane.INFORMATION_MESSAGE);
        setNullPGG();
        loadTablePGG();
    }//GEN-LAST:event_btnSuaCTKM1ActionPerformed

    private void btnThemCTKM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTKM1ActionPerformed
        String []str = {
            lblMaPGG.getText(),
            txtTenPGG.getText(),
            txtGiamTien.getText(),
            dpNgayPGGbd.getDate().toString(),
            dpNgayPGGkt.getDate().toString(),
            "1"
        };
        
        phieuGiamGiaBLL.ThemPGG(str);
        JOptionPane.showMessageDialog(this,them,thongBao,JOptionPane.INFORMATION_MESSAGE);
        setNullPGG();
        loadTablePGG();
    }//GEN-LAST:event_btnThemCTKM1ActionPerformed

    private void btnDelTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelTVActionPerformed
        int kq = JOptionPane.showConfirmDialog(this,xoa,thongBao,JOptionPane.YES_OPTION);
        if(kq ==0){
            String ma_thanh_vien = lblMaTV.getText();
            thanhVienBLL.delTV(ma_thanh_vien);
            JOptionPane.showMessageDialog(this,xoaTC,thongBao,JOptionPane.INFORMATION_MESSAGE);
            loadTV();
            setNullTV();
        }
        
    }//GEN-LAST:event_btnDelTVActionPerformed

//    Sự kiện click vào table tài khoản
    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMouseClicked
        int click = tblTaiKhoan.getSelectedRow();
        
        if(click >= 0){
            int ma_tk = (int) tblTaiKhoan.getValueAt(click,0);
//            System.out.println(click);
//            System.out.println(ma_tk);
            TaiKhoanDTO taiKhoanDTO = taiKhoanBLL.getTkByMaTK(ma_tk);
            
            lblMaTk.setText(String.valueOf(taiKhoanDTO.getMa_tai_khoan()));
            txtTenTK.setText(taiKhoanDTO.getTen_tai_khoan());
            txtMk.setText(taiKhoanDTO.getMat_khau());
            cbbLoaiTk.setSelectedItem(new PhanQuyenBLL().getQuyenByMaQuyen(taiKhoanDTO.getPhan_quyen()));
        }
    }//GEN-LAST:event_tblTaiKhoanMouseClicked

    //tạo mã món ăn mới
    private void btnNewMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewMAActionPerformed
        lblMaMon.setText("MA"+(new MonAnBLL().maMoi()));
        txtTenMon.setText("");
        txtGia.setText("");
        lblSoLuong.setText("0");
        cbbLoaiMon.setModel(modelCbxLM);
    }//GEN-LAST:event_btnNewMAActionPerformed

    private void btnAddMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMAActionPerformed
        String []str = {
            lblMaMon.getText(),//arr[0]
            txtTenMon.getText(),//arr[1]
            lblSoLuong.getText(),//arr[2]
            txtGia.getText(),//arr[3]
            new LoaiMonAnBLL().getMaLoaiByTenLoai(String.valueOf(cbbLoaiMon.getSelectedItem()))//arr[4]
        };
        new MonAnBLL().ThemMon(str);
        JOptionPane.showMessageDialog(this,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        loadListMA();
        
        setNullMonAn();
    }//GEN-LAST:event_btnAddMAActionPerformed

    private void cbbLoaiMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiMonActionPerformed

    private void cbbLoaiMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLoaiMonMouseClicked
        
    }//GEN-LAST:event_cbbLoaiMonMouseClicked

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int click = tblNhanVien.getSelectedRow();
        
        if(click >= 0){
            
            String ma_nhan_vien = (String)tblNhanVien.getValueAt(click,0);

            NhanVienDTO nhanVienDTO = nhanVienBLL.getNvByMaNV(ma_nhan_vien);
            
            lblMaNV.setText(nhanVienDTO.getMa_nhan_vien());
            txtTenNV.setText(nhanVienDTO.getTen_nhan_vien());
            String []arr = nhanVienDTO.getNgay_sinh().toString().split("-");
            dPNgaySinhNV.setDate(LocalDate.of(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2])));
            txtSdt.setText(nhanVienDTO.getSdt());
            txtMail.setText(nhanVienDTO.getMail());
            cbbTkNv.setSelectedItem(nhanVienDTO.getTai_khoan());
            
            loadTkToComboBoxByMaNv_TT(nhanVienDTO.getTai_khoan());
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnNewNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewNCCActionPerformed
        setNullNCC();
        lblMaNCC.setText("NCC"+nhaCungCapBLL.maMoi());
    }//GEN-LAST:event_btnNewNCCActionPerformed

    private void btnAddNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNCCActionPerformed
        String []str = {
            lblMaNCC.getText(),
            txtTenNCC.getText(),
            txtDiaChi.getText()
        };
        
        nhaCungCapBLL.ThemNCC(str);
        JOptionPane.showMessageDialog(this,them,thongBao,JOptionPane.INFORMATION_MESSAGE);
        setNullNCC();
        
        loadListNCC();
    }//GEN-LAST:event_btnAddNCCActionPerformed

    private void btnUpdateNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNCCActionPerformed
        String []str = {
            lblMaNCC.getText(),
            txtTenNCC.getText(),
            txtDiaChi.getText()
        };
        
        nhaCungCapBLL.suaNCC(str);
        JOptionPane.showMessageDialog(this,sua,thongBao,JOptionPane.INFORMATION_MESSAGE);
        setNullNCC();
        
        loadListNCC();
    }//GEN-LAST:event_btnUpdateNCCActionPerformed

    private void tblNhaCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCCMouseClicked
        int click = tblNhaCC.getSelectedRow();
        
        if(click >= 0){
            String ma_ncc = (String) tblNhaCC.getValueAt(click,0);
            
            NhaCungCapDTO nhaCungCapDTO = nhaCungCapBLL.getNccByMaNcc(ma_ncc);
            
            lblMaNCC.setText(nhaCungCapDTO.getMa_ncc());
            txtTenNCC.setText(nhaCungCapDTO.getTen_ncc());
            txtDiaChi.setText(nhaCungCapDTO.getDia_chi());
        }
    }//GEN-LAST:event_tblNhaCCMouseClicked

    private void btnNewLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewLMAActionPerformed
        setNullLMA();
        lblMaLoai.setText("LM"+loaiMonAnBLL.maMoi());
    }//GEN-LAST:event_btnNewLMAActionPerformed

    private void btnAddLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLMAActionPerformed
        String []str = {
            lblMaLoai.getText(),
            txtTenLoai.getText(),
        };
        
        loaiMonAnBLL.ThemLM(str);
        
        setNullLMA();
        loadListLMA();
        loadLoaiMonToComboBox();
        JOptionPane.showMessageDialog(this,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAddLMAActionPerformed

    private void tblLoaiMAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiMAMouseClicked
        int click = tblLoaiMA.getSelectedRow();
        if(click>=0){
            String ma_loai = (String) tblLoaiMA.getValueAt(click,0);
            
            LoaiMonDTO loaiMonDTO = loaiMonAnBLL.getLoaiByMaLoai(ma_loai);
            
            lblMaLoai.setText(loaiMonDTO.getMa_loai());
            txtTenLoai.setText(loaiMonDTO.getTen_loai());
        }
    }//GEN-LAST:event_tblLoaiMAMouseClicked

    private void btnTaoMoiCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiCTKMActionPerformed
        setNullCtkm();
        lblMaKM.setText(cTKhuyenMaiBLL.maMoi()+"");
    }//GEN-LAST:event_btnTaoMoiCTKMActionPerformed

    private void tblCTKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTKMMouseClicked
        int click  = tblCTKM.getSelectedRow();
        if(click >= 0){
            int ma_ctkm = (int) tblCTKM.getValueAt(click,0);
            ChuongTrinhKMDTO chuongTrinhKMDTO = cTKhuyenMaiBLL.getCtkmByMaCTKM(ma_ctkm);
            if(chuongTrinhKMDTO != null){
                lblMaKM.setText(String.valueOf(chuongTrinhKMDTO.getMa_ctkm()));
                txtTenCTKM.setText(chuongTrinhKMDTO.getTen_ctkm());
                String []arr_1 = chuongTrinhKMDTO.getNgay_bat_dau().toString().split("-");
                dpNgaybd.setDate(LocalDate.of(Integer.parseInt(arr_1[0]),Integer.parseInt(arr_1[1]),Integer.parseInt(arr_1[2])));
                String []arr_2 = chuongTrinhKMDTO.getNgay_ket_thuc().toString().split("-");
                dpNgaykt.setDate(LocalDate.of(Integer.parseInt(arr_2[0]),Integer.parseInt(arr_2[1]),Integer.parseInt(arr_2[2])));
                lblTtCtkm.setText((chuongTrinhKMDTO.getTrang_thai() == 1)?"Đang áp dụng":"Không áp dụng");
            }
        }
    }//GEN-LAST:event_tblCTKMMouseClicked

    private void btnXoaCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTKMActionPerformed
        
        int kq = JOptionPane.showConfirmDialog(this,xoa,thongBao,JOptionPane.YES_OPTION);
        if(kq == 0){
            int ma_ctkm = Integer.parseInt(lblMaKM.getText());
            cTKhuyenMaiBLL.xoaCTKM(ma_ctkm);
            JOptionPane.showMessageDialog(this,xoaTC,thongBao,JOptionPane.INFORMATION_MESSAGE);
            loadCTKM();
            setNullCtkm();
        }
        
    }//GEN-LAST:event_btnXoaCTKMActionPerformed

    private void btnXemCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemCTKMActionPerformed
        int ma_ctkm = Integer.parseInt(lblMaKM.getText());
        String ten_ctkm = txtTenCTKM.getText();
        int trang_thai = lblTtCtkm.getText().equals("Đang áp dụng") ? 1 : 0;
        new CtkmForm(ma_ctkm,ten_ctkm,trang_thai).setVisible(true);
    }//GEN-LAST:event_btnXemCTKMActionPerformed

    private void btnApDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApDungActionPerformed
        //kiểm tra có km nào không 
        if(!cTKhuyenMaiBLL.checkKm()){
            boolean flag_1 = java.time.LocalDate.now().isAfter(dpNgaybd.getDate());
            boolean flag_2 = java.time.LocalDate.now().isBefore(dpNgaykt.getDate());
            System.out.println(flag_1);
            System.out.println(flag_2);
            int ma_ctkm = Integer.parseInt(lblMaKM.getText());
            if(flag_1&&flag_2){
                lblTtCtkm.setText("Đang áp dụng");
                cTKhuyenMaiBLL.doiTrangThai(ma_ctkm,"1");
                cTChuongTrinhKMBLL.apdungCTKM(ma_ctkm);
                JOptionPane.showMessageDialog(this,"Áp dụng thành công",thongBao,JOptionPane.INFORMATION_MESSAGE);
                loadCTKM();
                loadListMA();
                return;
            }
            JOptionPane.showMessageDialog(this,"Không nằm trong ngày khuyến mãi","Lỗi",JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this,"Đã áp dụng chương trình khuyến mãi","Lỗi",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnApDungActionPerformed

    private void btnDungADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDungADActionPerformed
        int ma_ctkm = Integer.parseInt(lblMaKM.getText());
        lblTtCtkm.setText("Không áp dụng");
        cTKhuyenMaiBLL.doiTrangThai(ma_ctkm,"0");
        cTChuongTrinhKMBLL.ngungApDung(ma_ctkm);
        JOptionPane.showMessageDialog(this,"Ngưng áp dụng",thongBao,JOptionPane.INFORMATION_MESSAGE);
        loadCTKM();
        loadListMA();
    }//GEN-LAST:event_btnDungADActionPerformed

    private void cbxNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNccActionPerformed
        
        if(modelCTDN.getRowCount() == 0){
            String ten_ncc = String.valueOf(cbxNcc.getSelectedItem());
            ncc_current = ten_ncc;
            String ma_ncc = nhaCungCapBLL.getMaNccByTenNcc(ten_ncc);
            modelCbxLmOfDN = new DefaultComboBoxModel();
            cTNhaCungCapLoaiMonBLL.setTenLoaiToComboboxByMaNcc(modelCbxLmOfDN, ma_ncc);
            cbxCategory.setModel(modelCbxLmOfDN);        
            return;
        }
        System.out.println(ncc_current);
        if(!String.valueOf(cbxNcc.getSelectedItem()).equals(ncc_current)){
            JOptionPane.showMessageDialog(this,"Một đơn nhập chỉ có thể nhập ở 1 nhà cung cấp","Lỗi",JOptionPane.ERROR_MESSAGE);
            cbxNcc.setSelectedItem(ncc_current);
            return;
        }
        
    }//GEN-LAST:event_cbxNccActionPerformed

    private void btnChotDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChotDonActionPerformed
        int kq = JOptionPane.showConfirmDialog(this,"Xác nhận thanh toán",thongBao,JOptionPane.YES_OPTION);
        if(kq == 0){
            String ma_ddh = "DDH" + donDatHangBLL.MaMoi();
            String ma_ncc = nhaCungCapBLL.getMaNccByTenNcc(String.valueOf(cbxNcc.getSelectedItem()));
            String tong_tien = lblTotalPrice.getText();
            System.out.println(ma_ddh);
            System.out.println(ma_ncc);
            System.out.println(tong_tien);

            String []str = {
                ma_ddh,
                ma_ncc,
                tong_tien
            };
            donDatHangBLL.taoDonDat(str);
            cTDonDatHangBLL.taoCTDonDatToDonDat(modelCTDN,ma_ddh);

            JOptionPane.showMessageDialog(this,"Đặt thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            lblTotalPrice.setText("");
            while(modelCTDN.getRowCount() > 0){
                modelCTDN.removeRow(0);
            }        
        }
    }//GEN-LAST:event_btnChotDonActionPerformed

    private void btnXoaMonDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonDNActionPerformed
        int click = tblICTDonNhap.getSelectedRow();
        if(click >= 0){
            int thanhTien = (int)modelCTDN.getValueAt(click,4);
            int totalPrice = Integer.parseInt(lblTotalPrice.getText());
            lblTotalPrice.setText(String.valueOf(totalPrice-thanhTien));
            modelCTDN.removeRow(click);
        }
    }//GEN-LAST:event_btnXoaMonDNActionPerformed

    private void btnloadLMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadLMActionPerformed
        loadListLMA();
    }//GEN-LAST:event_btnloadLMActionPerformed

    private void txtSearchLMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchLMKeyReleased
        String search = txtSearchLM.getText();
        String typeSearch = String.valueOf(cbxSearchLM.getSelectedItem());
        if(typeSearch.equals("Mã loại")){    
            loaiMonAnBLL.timLMTheoMa(modelLMA, search);
        }
        if(typeSearch.equals("Tên loại")){
            loaiMonAnBLL.timLMTheoTen(modelLMA, search);
        }
    }//GEN-LAST:event_txtSearchLMKeyReleased

    private void txtSearchMAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchMAKeyReleased
        String search = txtSearchMA.getText();
        String typeSearch = String.valueOf(cbxSearchMA.getSelectedItem());
        switch (typeSearch) {
            case "Mã món":
                monAnBLL.timkiemMonAnTheoMa(modelMA,search);
                break;
            case "Tên món":
                monAnBLL.timkiemMonAnTheoten(modelMA,search);
                break;
            case "Số lượng":
                monAnBLL.timkiemMonAnTheoSL(modelMA,search);
                break;                
            case "Giá":
                monAnBLL.timkiemMonAnTheoGia(modelMA,search);
                break;                                
            case "Giá giảm":
                monAnBLL.timkiemMonAnTheoGiaGiam(modelMA,search);
                break;                                
            case "Giá hiện tại":
                monAnBLL.timkiemMonAnTheoGiaHT(modelMA,search);
                break;                                
            case "Loại món":
                monAnBLL.timkiemMonAnTheoTenLoai(modelMA, search);
                break;                        
        }
    }//GEN-LAST:event_txtSearchMAKeyReleased

    private void btnloadMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadMAActionPerformed
        loadListMA();
        setNullMonAn();
    }//GEN-LAST:event_btnloadMAActionPerformed

    private void txtSearchTKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTKKeyReleased
        String search = txtSearchTK.getText();
        String typeSearch = String.valueOf(cbxSearchTK.getSelectedItem());
        switch (typeSearch) {
            case "Mã TK":
                taiKhoanBLL.timkiemTKTheoMa(modelTK,search);
                break;
            case "Tên TK":
                taiKhoanBLL.timkiemTKTheoTen(modelTK,search);
                break;
            case "Phân quyền":
                taiKhoanBLL.timkiemTKTheoPQ(modelTK,search);
                break;                
            case "Trạng thái":
                taiKhoanBLL.timkiemTKTheoTT(modelTK,search);
                break;                                
        }
    }//GEN-LAST:event_txtSearchTKKeyReleased

    private void btnloadMA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadMA1ActionPerformed
        loadListTK();
    }//GEN-LAST:event_btnloadMA1ActionPerformed

    private void txtSearchNCCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNCCKeyReleased
        String search = txtSearchNCC.getText();
        String searchType = String.valueOf(cbxSearchNCC.getSelectedItem());
        switch (searchType) {
            case "Mã NCC":
                nhaCungCapBLL.timKiemNccTheoMa(modelNCC,search);
                break;
            case "Tên NCC":
                nhaCungCapBLL.timKiemNccTheoTen(modelNCC,search);
                break;
            case "Địa chỉ":
                nhaCungCapBLL.timKiemNccTheoDC(modelNCC,search);
                break;
        }
    }//GEN-LAST:event_txtSearchNCCKeyReleased

    private void btnloadNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadNCCActionPerformed
        loadListNCC();
        setNullNCC();
    }//GEN-LAST:event_btnloadNCCActionPerformed

    private void txtSearchNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNVKeyReleased
        String search = txtSearchNV.getText();
        String typeSearch = String.valueOf(cbxSearchNV.getSelectedItem());
        switch (typeSearch) {
            case "Mã NV":
                nhanVienBLL.timkiemNVTheoMa(modelNV,search);
                break;
            case "Tên NV":
                nhanVienBLL.timkiemNVTheoTen(modelNV,search);
                break;
            case "SDT":
                nhanVienBLL.timkiemNVTheoSDT(modelNV,search);
                break;                
            case "Mail":
                nhanVienBLL.timkiemNVTheoMail(modelNV,search);
                break;                                
            case "Tài khoản":
                nhanVienBLL.timkiemNVTheoTK(modelNV,search);
                break;
        }
    }//GEN-LAST:event_txtSearchNVKeyReleased

    private void btnloadNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadNVActionPerformed
        setNullNv();
        loadListNV();
        
    }//GEN-LAST:event_btnloadNVActionPerformed

    private void txtSearchPhieuGiamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchPhieuGiamKeyReleased
        String search = txtSearchPhieuGiam.getText();
        String typeSearch = String.valueOf(cbxSearchPGG.getSelectedItem());
        switch (typeSearch) {
            case "Mã voucher":
                phieuGiamGiaBLL.timKiemPhieuGiamGiaTheoTen(modelPGG,search);
                break;
            case "Mã phiếu":
                phieuGiamGiaBLL.timKiemPhieuGiamGiaTheoMaPGG(modelPGG,search);
                break;
            case "Trạng thái":
                phieuGiamGiaBLL.timKiemPhieuGiamGiaTheoTTPGG(modelPGG,search);
                break;
        }
        
    }//GEN-LAST:event_txtSearchPhieuGiamKeyReleased

    private void txtSearchTVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTVKeyReleased
        String search = txtSearchTV.getText();
        String typeSearch = (String) cbxSearchTV.getSelectedItem();
        switch (typeSearch) {
            case "Mã TV":
                thanhVienBLL.timKiemThanhVienTheoMaTv(modelTV,search);
                break;
            case "Tên TV":
                thanhVienBLL.timKiemThanhVienTheoTenTV(modelTV,search);
                break;
            case "Số điện thoại":
                thanhVienBLL.timKiemThanhVienTheoSDT(modelTV,search);
                break;
            case "mail":
                thanhVienBLL.timKiemThanhVienTheoMail(modelTV,search);
                break;
            
        }
    }//GEN-LAST:event_txtSearchTVKeyReleased

    private void txtNVNgayKtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNVNgayKtKeyReleased
        try {
            Date ngayPd =  new SimpleDateFormat("yyyy/MM/dd").parse(txtNVNgayPd.getText());
            Date ngayKt =  new SimpleDateFormat("yyyy/MM/dd").parse(txtNVNgayKt.getText());
            nhanVienBLL.timkiemNVTheoNS(modelNV, ngayPd, ngayKt);
        } catch (ParseException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtNVNgayKtKeyReleased

    private void txtSearchGiaToKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchGiaToKeyReleased
        int giaFrom = Integer.parseInt(txtSearchGiaFrom.getText());
        int giaTo = Integer.parseInt(txtSearchGiaTo.getText());
        monAnBLL.timkiemMonAnTheoKhoangGia(modelMA,giaFrom,giaTo);
        
    }//GEN-LAST:event_txtSearchGiaToKeyReleased

    private void txtSearchSLToKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSLToKeyReleased
        int soLuongFrom = Integer.parseInt(txtSearchSLFrom.getText());
        int soLuongTo = Integer.parseInt(txtSearchSLTo.getText());
        monAnBLL.timkiemMonAnTheoKhoangSL(modelMA, soLuongFrom, soLuongTo);
    }//GEN-LAST:event_txtSearchSLToKeyReleased

    private void txtSearchCTKMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCTKMKeyReleased
        try {
            String search =  txtSearchCTKM.getText();
            String searchType = String.valueOf(cbxSearchCTKM.getSelectedItem());
            switch (searchType) {
                case "Mã CTKM":
                    cTKhuyenMaiBLL.timKiemCtkmTheoMa(modelCTKM,search);
                    break;
                case "Tên CTKM":
                    cTKhuyenMaiBLL.timKiemCtkmTheoTen(modelCTKM,search);
                    break;
                case "Trạng thái":
                    cTKhuyenMaiBLL.timKiemCtkmTheoTT(modelCTKM,search);
                    break;
                case "Kiểm tra ngày":
                    if(search.length() == 10){
                        cTKhuyenMaiBLL.timKiemCtkmTheoNgay(modelCTKM,search);
                    }
                    break;
            }
        } catch (ParseException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_txtSearchCTKMKeyReleased

    private void cbxSearchDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSearchDHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSearchDHActionPerformed

    private void txtSearchDHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDHKeyReleased
        String search = txtSearchDH.getText();
        String searchType = String.valueOf(cbxSearchDH.getSelectedItem());
        String ma_loai = loaiMonAnBLL.getMaLoaiByTenLoai(String.valueOf(cbxCategory.getSelectedItem()));
        switch (searchType) {
            case "Mã món":
                monAnBLL.timkiemMonAnDNTheoMa(modelFood,search,ma_loai);
                break;
            case "Tên món":
                monAnBLL.timkiemMonAnDNTheoTen(modelFood,search,ma_loai);
                break;
        }
        
    }//GEN-LAST:event_txtSearchDHKeyReleased

    private void txtSearchDHGiaFromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDHGiaFromKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchDHGiaFromKeyReleased

    private void txtSearchDHGiaToKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDHGiaToKeyReleased
        int giaFrom = Integer.parseInt(txtSearchDHGiaFrom.getText());
        int giaTo = Integer.parseInt(txtSearchDHGiaTo.getText());
        String ma_loai = loaiMonAnBLL.getMaLoaiByTenLoai(String.valueOf(cbxCategory.getSelectedItem()));
        monAnBLL.timkiemMonAnDNTheoKhoangGia(modelFood, giaFrom, giaTo,ma_loai);
    }//GEN-LAST:event_txtSearchDHGiaToKeyReleased

    private void btnLoadMAOfDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadMAOfDNActionPerformed
        String ten_loai = (String) cbxCategory.getSelectedItem();
        String ma_loai = loaiMonAnBLL.getMaLoaiByTenLoai(ten_loai);
        
        loadToComboboxNcc();
        monAnBLL.setListFoodByMaLoai(modelFood,ma_loai);
        
        txtSearchDH.setText("");
        txtSearchDHGiaFrom.setText("");
        txtSearchDHGiaTo.setText("");
        
    }//GEN-LAST:event_btnLoadMAOfDNActionPerformed

    private void txtTenTvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTvActionPerformed

    private void btnloadTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadTVActionPerformed
        loadTV();
        setNullTV();
    }//GEN-LAST:event_btnloadTVActionPerformed

    private void btnUpdateTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTVActionPerformed
        String []str = {
            lblMaTV.getText(),
            txtTenTv.getText(),
            txtMkTv.getText(),
            dPNgaySinhTV.getDate().toString(),
            txtSdtTV.getText(),
            txtMailTV.getText(),
        };
        
        thanhVienBLL.suaTV(str);
        JOptionPane.showMessageDialog(this,sua,thongBao,JOptionPane.INFORMATION_MESSAGE);
        
        loadTV();
        setNullTV();
    }//GEN-LAST:event_btnUpdateTVActionPerformed

    private void tblThanhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThanhVienMouseClicked
        int click = tblThanhVien.getSelectedRow();
        if(click >= 0){
            String ma_thanh_vien = (String) tblThanhVien.getValueAt(click,0);
            ThanhVienDTO thanhVienDTO = thanhVienBLL.getTvByMaTV(ma_thanh_vien);
            
            if(thanhVienDTO != null){
                txtTenTv.setText(thanhVienDTO.getTen_thanh_vien());
                lblMaTV.setText(thanhVienDTO.getMa_thanh_vien());
                txtMailTV.setText(thanhVienDTO.getMail());
                txtMkTv.setText(thanhVienDTO.getMat_khau());
                txtSdtTV.setText(thanhVienDTO.getSdt());
                lblPointTv.setText(String.valueOf(thanhVienDTO.getPoint()));
                String []str = thanhVienDTO.getNgay_sinh().toString().split("-");
                dPNgaySinhTV.setDate(LocalDate.of(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));
            }
            
        }
    }//GEN-LAST:event_tblThanhVienMouseClicked

    private void txtSearchDiemToKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDiemToKeyReleased
        int diemFrom = Integer.parseInt(txtSearchDiemFrom.getText());
        int diemTo = Integer.parseInt(txtSearchDiemTo.getText());
        thanhVienBLL.timKiemThanhVienTheoKhoanDiem(modelTV, diemFrom, diemTo);
    }//GEN-LAST:event_txtSearchDiemToKeyReleased

    private void txtSearchTVNSToKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTVNSToKeyReleased
        try {
            Date NgayFrom = new SimpleDateFormat("yyyy/MM/dd").parse(txtSearchTVNSFrom.getText());
            Date NgayTo = new SimpleDateFormat("yyyy/MM/dd").parse(txtSearchTVNSTo.getText());
            System.out.println(NgayTo.toString());
            System.out.println(NgayFrom.toString());
            thanhVienBLL.timKiemThanhVienTheoKhoanNS(modelTV, NgayFrom, NgayTo);
        } catch (ParseException ex) {
//            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchTVNSToKeyReleased

    private void btnTaoMoiCTKM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiCTKM1ActionPerformed
        setNullPGG();
        lblMaPGG.setText("PGG"+phieuGiamGiaBLL.MaMoi());
    }//GEN-LAST:event_btnTaoMoiCTKM1ActionPerformed

    private void tblPGGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPGGMouseClicked
        int click = tblPGG.getSelectedRow();
        if(click >= 0){
            String ma_pgg = (String) tblPGG.getValueAt(click, 0);
            PhieuGiamGiaDTO phieuGiamGiaDTO = phieuGiamGiaBLL.getPGGbyMaPGG(ma_pgg);
            if(phieuGiamGiaDTO != null){
                lblMaPGG.setText(phieuGiamGiaDTO.getMa_phieu_giam_gia());
                txtGiamTien.setText(String.valueOf(phieuGiamGiaDTO.getGiam()));
                txtTenPGG.setText(phieuGiamGiaDTO.getTen_phieu_giam_gia());
                String []arr = phieuGiamGiaDTO.getNgay_bat_dau().toString().split("-");
                dpNgayPGGbd.setDate(LocalDate.of(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2])));
                String []arr_1 = phieuGiamGiaDTO.getNgay_ket_thuc().toString().split("-");
                dpNgayPGGkt.setDate(LocalDate.of(Integer.parseInt(arr_1[0]),Integer.parseInt(arr_1[1]),Integer.parseInt(arr_1[2])));
            }
        }
    }//GEN-LAST:event_tblPGGMouseClicked

    private void btnloadPGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadPGGActionPerformed
        loadTablePGG();
        setNullPGG();
    }//GEN-LAST:event_btnloadPGGActionPerformed

    private void btnXoaCTKM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTKM1ActionPerformed
        int kq = JOptionPane.showConfirmDialog(this,xoa,thongBao,JOptionPane.YES_OPTION);
        if(kq==0){
            String ma_pgg = lblMaPGG.getText();
            phieuGiamGiaBLL.delPGG(ma_pgg);
            setNullPGG();
            loadTablePGG();
        }
    }//GEN-LAST:event_btnXoaCTKM1ActionPerformed

    private void txtPGGGiamDenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPGGGiamDenKeyReleased
        int giamTu = Integer.parseInt(txtPGGGiamTu.getText());
        int giamDen = Integer.parseInt(txtPGGGiamDen.getText());
        
        phieuGiamGiaBLL.timKiemPhieuTheoKhoanGia(modelPGG,giamTu,giamDen);
    }//GEN-LAST:event_txtPGGGiamDenKeyReleased

    private void txtPGGNgayDenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPGGNgayDenKeyReleased
        try {
            Date ngayTu = new SimpleDateFormat("yyyy/MM/dd").parse(txtPGGNgayTu.getText());
            Date ngayDen = new SimpleDateFormat("yyyy/MM/dd").parse(txtPGGNgayDen.getText());
            System.out.println(ngayTu.toString());
            System.out.println(ngayDen.toString());
            phieuGiamGiaBLL.timKiemPhieuTheoKhoanNgay(modelPGG,ngayTu,ngayDen);
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_txtPGGNgayDenKeyReleased

    private void btnLoadCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadCTKMActionPerformed
        loadCTKM();
        setNullCtkm();
    }//GEN-LAST:event_btnLoadCTKMActionPerformed

    private void txtKMNgayDenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKMNgayDenKeyReleased
        try {
            Date ngayTu = new SimpleDateFormat("yyyy/MM/dd").parse(txtKMNgayTu.getText());
            Date ngayDen = new SimpleDateFormat("yyyy/MM/dd").parse(txtKMNgayDen.getText());
            System.out.println(ngayTu.toString());
            System.out.println(ngayDen.toString());
            System.out.println(ngayTu.before(ngayDen));
            cTKhuyenMaiBLL.timKiemKMTheoKhoanNgay(modelCTKM, ngayTu, ngayDen);
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_txtKMNgayDenKeyReleased

    private void btnReLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReLoadActionPerformed
        loadTableHD();
        txtSearchHD.setText("");
        txtSearchHDGiaTu.setText("");
        txtSearchHDGiaDen.setText("");
        dPHDNgayTu.setDate(null);
        dPHDNgayTu.setDate(null);
        loadThongKeHD();
    }//GEN-LAST:event_btnReLoadActionPerformed

    private void btnReLoadDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReLoadDNActionPerformed
        loadTableDN();
        txtSearchDN.setText("");
        txtSearchDNTongTienDen.setText("");
        txtSearchDNTongTienTU.setText("");
        dPDNNgayDen.setDate(null);
        dPDNNgayTu.setDate(null);
        loadThongKeDH();
    }//GEN-LAST:event_btnReLoadDNActionPerformed

    private void txtSearchHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchHDKeyReleased
        String search = txtSearchHD.getText();
        String typeSearch = String.valueOf(cbxSearchHD.getSelectedItem());
        switch (typeSearch) {
            case "Mã hóa đơn":
                hoaDonBLL.timKiemHoaDonTheoMaHD(modelHD,search);
                break;
            case "Ngày xuất":
                hoaDonBLL.timKiemHoaDonTheoNgay(modelHD,search);
                break;
            case "Mã nhân viên":
                hoaDonBLL.timKiemHoaDonTheoMaNV(modelHD,search);
                break;
            case "Tên nhân viên":
                hoaDonBLL.timKiemHoaDonTheoTenNV(modelHD,search);
                break;
            case "Mã thành viên":
                hoaDonBLL.timKiemHoaDonTheoMaTV(modelHD,search);
                break;
            case "Tên thành viên":
                hoaDonBLL.timKiemHoaDonTheoTenTV(modelHD,search);
                break;
            case "Mã voucher":
                hoaDonBLL.timKiemHoaDonTheoMaPGG(modelHD,search);
                break;
            
        }
    }//GEN-LAST:event_txtSearchHDKeyReleased

    private void txtSearchHDGiaDenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchHDGiaDenKeyReleased
        int searchHDTu = Integer.parseInt(txtSearchHDGiaTu.getText());
        int searchHDDen = Integer.parseInt(txtSearchHDGiaDen.getText());
        String searchType = String.valueOf(cbxSearchHDGia.getSelectedItem());
        switch (searchType) {
            case "Tổng tiền":
                hoaDonBLL.thongKeHoaDonTheoTongTien(modelHD,searchHDTu,searchHDDen);
                break;
            case "Tiền giảm":
                hoaDonBLL.thongKeHoaDonTheoTienGiam(modelHD,searchHDTu,searchHDDen);
                break;
            case "Phải thanh toán":
                hoaDonBLL.thongKeHoaDonTheoTienConLai(modelHD,searchHDTu,searchHDDen);
                break;
            case "Điểm":
                hoaDonBLL.thongKeHoaDonTheoDiem(modelHD,searchHDTu,searchHDDen);
                break;
        }
    }//GEN-LAST:event_txtSearchHDGiaDenKeyReleased

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        Date dateFrom = java.sql.Date.valueOf(dPHDNgayTu.getDate());
        Date dateTo = java.sql.Date.valueOf(dPHDNgayDen.getDate());
        hoaDonBLL.timKiemHoaDonTheoKhoanTG(modelHD,dateFrom,dateTo);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void txtSearchDNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDNKeyReleased
        String search = String.valueOf(txtSearchDN.getText());
        String searchType = String.valueOf(cbxSearchDN.getSelectedItem());
        switch (searchType) {
            case "Mã đơn nhập":
                donDatHangBLL.timKiemDonNhapTheoMaDN(modelDN,search);
                break;
            case "Mã nhà cung cấp":
                donDatHangBLL.thongKeDonNhapTheoMaNCC(modelDN,search);
                break;
            case "Tên nhà cung cấp":
                donDatHangBLL.thongKeDonNhapTheoTenNCC(modelDN,search);
                break;
            case "Ngày đặt":
                donDatHangBLL.thongKeDonNhapTheoNgay(modelDN,search);
                break;
        }
    }//GEN-LAST:event_txtSearchDNKeyReleased

    private void txtSearchDNTongTienDenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDNTongTienDenKeyReleased
        int tongTienTu = Integer.parseInt(txtSearchDNTongTienTU.getText());
        int tongTienDen = Integer.parseInt(txtSearchDNTongTienDen.getText());
        donDatHangBLL.thongKeDonNhapTheoTT(modelDN,tongTienTu,tongTienDen);
    }//GEN-LAST:event_txtSearchDNTongTienDenKeyReleased

    private void btnThongKeDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeDNActionPerformed
        Date DNTuNgay = java.sql.Date.valueOf(dPDNNgayTu.getDate());
        Date DNDenNgay = java.sql.Date.valueOf(dPDNNgayDen.getDate());
        donDatHangBLL.thongKeDonNhapTheoKhoanTG(modelDN,DNTuNgay,DNDenNgay);
    }//GEN-LAST:event_btnThongKeDNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int click = tblHoaDon.getSelectedRow();
        if(click >= 0){
            String ma_hd = String.valueOf(tblHoaDon.getValueAt(click,0));
            new ChiTietHD(ma_hd).setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int click = tblDonNhap.getSelectedRow();
        if(click >= 0){
            String ma_dn = String.valueOf(tblDonNhap.getValueAt(click,0));
            new ChiTietDN(ma_dn).setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int click = tblNhaCC.getSelectedRow();
        if(click >= 0){
            String ma_ncc = String.valueOf(tblNhaCC.getValueAt(click,0));
            System.out.println(ma_ncc);
            new NhaCungCap_LoaiMonAn(ma_ncc).setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            new XuatExcel().xuatHD();
        } catch (IOException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            new XuatExcel().xuatDN();
        } catch (IOException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    
    
    

//</editor-fold>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            //</editor-fold>
            //</editor-fold>
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLMA;
    private javax.swing.JButton btnAddMA;
    private javax.swing.JButton btnAddNCC;
    private javax.swing.JButton btnAddTK;
    private javax.swing.JButton btnApDung;
    private javax.swing.JButton btnChotDon;
    private javax.swing.JButton btnDat;
    private javax.swing.JButton btnDelLMA;
    private javax.swing.JButton btnDelMA;
    private javax.swing.JButton btnDelNCC;
    private javax.swing.JButton btnDelTV;
    private javax.swing.JButton btnDelTk;
    private javax.swing.JButton btnDungAD;
    private javax.swing.JButton btnLoadCTKM;
    private javax.swing.JButton btnLoadMAOfDN;
    private javax.swing.JButton btnNewLMA;
    private javax.swing.JButton btnNewMA;
    private javax.swing.JButton btnNewNCC;
    private javax.swing.JButton btnNewTK;
    private javax.swing.JButton btnReLoad;
    private javax.swing.JButton btnReLoadDN;
    private javax.swing.JButton btnSuaCTKM;
    private javax.swing.JButton btnSuaCTKM1;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JButton btnTaoMoiCTKM;
    private javax.swing.JButton btnTaoMoiCTKM1;
    private javax.swing.JButton btnThemCTKM;
    private javax.swing.JButton btnThemCTKM1;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnThongKeDN;
    private javax.swing.JButton btnUpdateLMA;
    private javax.swing.JButton btnUpdateMA;
    private javax.swing.JButton btnUpdateNCC;
    private javax.swing.JButton btnUpdateTK;
    private javax.swing.JButton btnUpdateTV;
    private javax.swing.JButton btnXemCTKM;
    private javax.swing.JButton btnXoaCTKM;
    private javax.swing.JButton btnXoaCTKM1;
    private javax.swing.JButton btnXoaMonDN;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JButton btnloadLM;
    private javax.swing.JButton btnloadMA;
    private javax.swing.JButton btnloadMA1;
    private javax.swing.JButton btnloadNCC;
    private javax.swing.JButton btnloadNV;
    private javax.swing.JButton btnloadPGG;
    private javax.swing.JButton btnloadTV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbLoaiMon;
    private javax.swing.JComboBox<String> cbbLoaiTk;
    private javax.swing.JComboBox<String> cbbTkNv;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JComboBox<String> cbxNcc;
    private javax.swing.JComboBox<String> cbxSearchCTKM;
    private javax.swing.JComboBox<String> cbxSearchDH;
    private javax.swing.JComboBox<String> cbxSearchDN;
    private javax.swing.JComboBox<String> cbxSearchHD;
    private javax.swing.JComboBox<String> cbxSearchHDGia;
    private javax.swing.JComboBox<String> cbxSearchLM;
    private javax.swing.JComboBox<String> cbxSearchMA;
    private javax.swing.JComboBox<String> cbxSearchNCC;
    private javax.swing.JComboBox<String> cbxSearchNV;
    private javax.swing.JComboBox<String> cbxSearchPGG;
    private javax.swing.JComboBox<String> cbxSearchTK;
    private javax.swing.JComboBox<String> cbxSearchTV;
    private com.github.lgooddatepicker.components.DatePicker dPDNNgayDen;
    private com.github.lgooddatepicker.components.DatePicker dPDNNgayTu;
    private com.github.lgooddatepicker.components.DatePicker dPHDNgayDen;
    private com.github.lgooddatepicker.components.DatePicker dPHDNgayTu;
    private com.github.lgooddatepicker.components.DatePicker dPNgaySinhNV;
    private com.github.lgooddatepicker.components.DatePicker dPNgaySinhTV;
    private com.github.lgooddatepicker.components.DatePicker dpNgayPGGbd;
    private com.github.lgooddatepicker.components.DatePicker dpNgayPGGkt;
    private com.github.lgooddatepicker.components.DatePicker dpNgaybd;
    private com.github.lgooddatepicker.components.DatePicker dpNgaykt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblCPNamDN;
    private javax.swing.JLabel lblCPNgayDN;
    private javax.swing.JLabel lblCPThangDN;
    private javax.swing.JLabel lblDHNam;
    private javax.swing.JLabel lblDNMax;
    private javax.swing.JLabel lblDNMin;
    private javax.swing.JLabel lblDTNgay;
    private javax.swing.JLabel lblDTThang;
    private javax.swing.JLabel lblHDMax;
    private javax.swing.JLabel lblHDMin;
    private javax.swing.JLabel lblMaKM;
    private javax.swing.JLabel lblMaLoai;
    private javax.swing.JLabel lblMaMon;
    private javax.swing.JLabel lblMaNCC;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaPGG;
    private javax.swing.JLabel lblMaTV;
    private javax.swing.JLabel lblMaTk;
    private javax.swing.JLabel lblPointTv;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTongCTKM;
    private javax.swing.JLabel lblTongLM;
    private javax.swing.JLabel lblTongMA;
    private javax.swing.JLabel lblTongNCC;
    private javax.swing.JLabel lblTongNV;
    private javax.swing.JLabel lblTongPGG;
    private javax.swing.JLabel lblTongTK;
    private javax.swing.JLabel lblTongTV;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblTtCtkm;
    private javax.swing.JSpinner spnCount;
    private javax.swing.JTable tblCTKM;
    private javax.swing.JTable tblDonNhap;
    private javax.swing.JTable tblFood;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblICTDonNhap;
    private javax.swing.JTable tblLoaiMA;
    private javax.swing.JTable tblNhaCC;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblPGG;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTable tblThanhVien;
    private javax.swing.JTable tblThucAn;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiamTien;
    private javax.swing.JTextField txtKMNgayDen;
    private javax.swing.JTextField txtKMNgayTu;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtMailTV;
    private javax.swing.JTextField txtMk;
    private javax.swing.JTextField txtMkTv;
    private javax.swing.JTextField txtNVNgayKt;
    private javax.swing.JTextField txtNVNgayPd;
    private javax.swing.JTextField txtPGGGiamDen;
    private javax.swing.JTextField txtPGGGiamTu;
    private javax.swing.JTextField txtPGGNgayDen;
    private javax.swing.JTextField txtPGGNgayTu;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSdtTV;
    private javax.swing.JTextField txtSearchCTKM;
    private javax.swing.JTextField txtSearchDH;
    private javax.swing.JTextField txtSearchDHGiaFrom;
    private javax.swing.JTextField txtSearchDHGiaTo;
    private javax.swing.JTextField txtSearchDN;
    private javax.swing.JTextField txtSearchDNTongTienDen;
    private javax.swing.JTextField txtSearchDNTongTienTU;
    private javax.swing.JTextField txtSearchDiemFrom;
    private javax.swing.JTextField txtSearchDiemTo;
    private javax.swing.JTextField txtSearchGiaFrom;
    private javax.swing.JTextField txtSearchGiaTo;
    private javax.swing.JTextField txtSearchHD;
    private javax.swing.JTextField txtSearchHDGiaDen;
    private javax.swing.JTextField txtSearchHDGiaTu;
    private javax.swing.JTextField txtSearchLM;
    private javax.swing.JTextField txtSearchMA;
    private javax.swing.JTextField txtSearchNCC;
    private javax.swing.JTextField txtSearchNV;
    private javax.swing.JTextField txtSearchPhieuGiam;
    private javax.swing.JTextField txtSearchSLFrom;
    private javax.swing.JTextField txtSearchSLTo;
    private javax.swing.JTextField txtSearchTK;
    private javax.swing.JTextField txtSearchTV;
    private javax.swing.JTextField txtSearchTVNSFrom;
    private javax.swing.JTextField txtSearchTVNSTo;
    private javax.swing.JTextField txtTenCTKM;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTenMon;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenPGG;
    private javax.swing.JTextField txtTenTK;
    private javax.swing.JTextField txtTenTv;
    // End of variables declaration//GEN-END:variables


}
