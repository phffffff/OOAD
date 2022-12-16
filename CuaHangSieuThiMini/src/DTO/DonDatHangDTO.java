package DTO;

import java.util.Date;
public class DonDatHangDTO {
    private String ma_don_dat;
    private String ma_ncc;
    private Date ngay_dat;
    private int tong_tien_dat; 
    
    public DonDatHangDTO(String ma_don_dat, String ma_ncc, Date ngay_dat, int tong_tien_dat) {
        this.ma_don_dat = ma_don_dat;
        this.ma_ncc = ma_ncc;
        this.ngay_dat = ngay_dat;
        this.tong_tien_dat = tong_tien_dat;
    }
   
    public String getMa_don_dat() {
        return ma_don_dat;
    }

    public void setMa_don_dat(String ma_don_dat) {
        this.ma_don_dat = ma_don_dat;
    }

    public String getMa_ncc() {
        return ma_ncc;
    }

    public void setMa_ncc(String ma_ncc) {
        this.ma_ncc = ma_ncc;
    }

    public Date getNgay_dat() {
        return ngay_dat;
    }

    public void setNgay_dat(Date ngay_dat) {
        this.ngay_dat = ngay_dat;
    }

    public int getTong_tien_dat() {
        return tong_tien_dat;
    }

    public void setTong_tien_dat(int tong_tien_dat) {
        this.tong_tien_dat = tong_tien_dat;
    }

    
    public DonDatHangDTO() {
    }

}
