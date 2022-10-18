package DTO;

public class CTChuongTrinhKMDTO {
    
    private int ma_ctkm;
    private String ma_mon;
    private String ten_mon; 
    private int gia_goc;  
    private int tien_giam;
    private int gia_hien_tai; 
    private String ten_loai;
    
    public CTChuongTrinhKMDTO(String ma_mon, String ten_mon, int gia_goc, int tien_giam, int gia_hien_tai, String ten_loai) {
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
        this.gia_goc = gia_goc;
        this.tien_giam = tien_giam;
        this.gia_hien_tai = gia_hien_tai;
        this.ten_loai = ten_loai;
    }

    
    public int getMa_ctkm() {
        return ma_ctkm;
    }

    public void setMa_ctkm(int ma_ctkm) {
        this.ma_ctkm = ma_ctkm;
    }

    public String getMa_mon() {
        return ma_mon;
    }

    public void setMa_mon(String ma_mon) {
        this.ma_mon = ma_mon;
    }

    public String getTen_mon() {
        return ten_mon;
    }

    public void setTen_mon(String ten_mon) {
        this.ten_mon = ten_mon;
    }

    public int getGia_goc() {
        return gia_goc;
    }

    public void setGia_goc(int gia_goc) {
        this.gia_goc = gia_goc;
    }

    public int getTien_giam() {
        return tien_giam;
    }

    public void setTien_giam(int tien_giam) {
        this.tien_giam = tien_giam;
    }

    public int getGia_hien_tai() {
        return gia_hien_tai;
    }

    public void setGia_hien_tai(int gia_hien_tai) {
        this.gia_hien_tai = gia_hien_tai;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }

    public CTChuongTrinhKMDTO(int ma_ctkm, String ma_mon, String ten_mon, int gia_goc, int tien_giam, int gia_hien_tai, String ten_loai) {
        this.ma_ctkm = ma_ctkm;
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
        this.gia_goc = gia_goc;
        this.tien_giam = tien_giam;
        this.gia_hien_tai = gia_hien_tai;
        this.ten_loai = ten_loai;
    }

    public CTChuongTrinhKMDTO() {
    }
    
}    
    