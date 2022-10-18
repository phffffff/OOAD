/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.util.Date;
 
/**
 *
 * @author Acer
 */
public class ThanhVienDTO {
    private String ma_thanh_vien;
    private String mat_khau;
    private String ten_thanh_vien;
    private Date ngay_sinh;
    private String sdt;
    private String mail;
    private int point;
    
    public ThanhVienDTO() {
    }

    public ThanhVienDTO(String ma_thanh_vien, String mat_khau, String ten_thanh_vien, Date ngay_sinh, String sdt, String mail, int point) {
        this.ma_thanh_vien = ma_thanh_vien;
        this.mat_khau = mat_khau;
        this.ten_thanh_vien = ten_thanh_vien;
        this.ngay_sinh = ngay_sinh;
        this.sdt = sdt;
        this.mail = mail;
        this.point = point;
    }

    public String getMa_thanh_vien() {
        return ma_thanh_vien;
    }

    public void setMa_thanh_vien(String ma_thanh_vien) {
        this.ma_thanh_vien = ma_thanh_vien;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public String getTen_thanh_vien() {
        return ten_thanh_vien;
    }

    public void setTen_thanh_vien(String ten_thanh_vien) {
        this.ten_thanh_vien = ten_thanh_vien;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
    