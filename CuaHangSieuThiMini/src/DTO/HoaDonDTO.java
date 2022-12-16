/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;
 
/**
 *
 * @author mizuk
 */
public class HoaDonDTO {
    private String ma_hoa_don;
    private Date ngay_xuat;
    private String ma_nhan_vien;
    private String ma_thanh_vien;
    private int tong_tien;
    private int tien_giam;
    private int tien_con_lai;
    private String ma_phieu_giam_gia;
    private int diem;
    
    public HoaDonDTO(String ma_hoa_don, Date ngay_xuat, String ma_nhan_vien, String ma_thanh_vien, int tong_tien, int tien_giam, int tien_con_lai, String ma_phieu_giam_gia, int diem) {
        this.ma_hoa_don = ma_hoa_don;
        this.ngay_xuat = ngay_xuat;
        this.ma_nhan_vien = ma_nhan_vien;
        this.ma_thanh_vien = ma_thanh_vien;
        this.tong_tien = tong_tien;
        this.tien_giam = tien_giam;
        this.tien_con_lai = tien_con_lai;
        this.ma_phieu_giam_gia = ma_phieu_giam_gia;
        this.diem = diem;
    }

    
    public String getMa_hoa_don() {
        return ma_hoa_don;
    }

    public void setMa_hoa_don(String ma_hoa_don) {
        this.ma_hoa_don = ma_hoa_don;
    }

    public Date getNgay_xuat() {
        return ngay_xuat;
    }

    public void setNgay_xuat(Date ngay_xuat) {
        this.ngay_xuat = ngay_xuat;
    }

    public String getMa_nhan_vien() {
        return ma_nhan_vien;
    }

    public void setMa_nhan_vien(String ma_nhan_vien) {
        this.ma_nhan_vien = ma_nhan_vien;
    }

    public String getMa_thanh_vien() {
        return ma_thanh_vien;
    }

    public void setMa_thanh_vien(String ma_thanh_vien) {
        this.ma_thanh_vien = ma_thanh_vien;
    }

    public int getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(int tong_tien) {
        this.tong_tien = tong_tien;
    }

    public int getTien_giam() {
        return tien_giam;
    }

    public void setTien_giam(int tien_giam) {
        this.tien_giam = tien_giam;
    }

    public int getTien_con_lai() {
        return tien_con_lai;
    }

    public void setTien_con_lai(int tien_con_lai) {
        this.tien_con_lai = tien_con_lai;
    }

    public String getMa_phieu_giam_gia() {
        return ma_phieu_giam_gia;
    }

    public void setMa_phieu_giam_gia(String ma_phieu_giam_gia) {
        this.ma_phieu_giam_gia = ma_phieu_giam_gia;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
    

    
    public  HoaDonDTO(){
    }
}
