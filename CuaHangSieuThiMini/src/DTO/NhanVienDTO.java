/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
/**
 *  
 * @author Acer
 */
import java.util.Date;

public class NhanVienDTO {
    private String ma_nhan_vien;
    private String ten_nhan_vien;
    private Date ngay_sinh;
    private String sdt;
    private String mail;
    private int tai_khoan;

    public String getMa_nhan_vien() {
        return ma_nhan_vien;
    }

    public void setMa_nhan_vien(String ma_nhan_vien) {
        this.ma_nhan_vien = ma_nhan_vien;
    }

    public String getTen_nhan_vien() {
        return ten_nhan_vien;
    }

    public void setTen_nhan_vien(String ten_nhan_vien) {
        this.ten_nhan_vien = ten_nhan_vien;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTai_khoan() {
        return tai_khoan;
    }

    public void setTai_khoan(int tai_khoan) {
        this.tai_khoan = tai_khoan;
    }
    public NhanVienDTO(){
    }
    public NhanVienDTO(String ma_nhan_vien, String ten_nhan_vien, Date ngay_sinh,String sdt, String mail, int tai_khoan) {
        this.ma_nhan_vien = ma_nhan_vien;
        this.ten_nhan_vien = ten_nhan_vien;
        this.ngay_sinh = ngay_sinh;
        this.sdt = sdt;
        this.mail= mail;
        this.tai_khoan = tai_khoan;
        
    }
}
