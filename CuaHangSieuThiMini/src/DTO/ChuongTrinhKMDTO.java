package DTO;

import java.util.Date;
 
public class ChuongTrinhKMDTO {
    private int ma_ctkm; 
    private String ten_ctkm;
    private Date ngay_bat_dau;
    private Date ngay_ket_thuc; 
    private int trang_thai;
    
    public ChuongTrinhKMDTO(int ma_ctkm, String ten_ctkm, Date ngay_bat_dau, Date ngay_ket_thuc, int trang_thai) {
        this.ma_ctkm = ma_ctkm;
        this.ten_ctkm = ten_ctkm;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
        this.trang_thai = trang_thai;
    }

    public ChuongTrinhKMDTO() {
    }

    
    public int getMa_ctkm() {
        return ma_ctkm;
    }

    public void setMa_ctkm(int ma_ctkm) {
        this.ma_ctkm = ma_ctkm;
    }

    public String getTen_ctkm() {
        return ten_ctkm;
    }

    public void setTen_ctkm(String ten_ctkm) {
        this.ten_ctkm = ten_ctkm;
    }

    public Date getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(Date ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public Date getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(Date ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }
    
}