/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
/**
 *  
 * @author mizuk
 */
public class LoaiMonDTO {
    private String ma_loai;
    private String ten_loai;
    
    public String getMa_loai() {
        return ma_loai;
    }

    public void setMa_loai(String ma_loai) {
        this.ma_loai = ma_loai;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }

    public LoaiMonDTO() {
    }

    public LoaiMonDTO(String ma_loai, String ten_loai) {
        this.ma_loai = ma_loai;
        this.ten_loai = ten_loai;
    }
    
}
