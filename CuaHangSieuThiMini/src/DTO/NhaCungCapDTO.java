/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
/**
 * 
 * @author thanh 
 */
public class NhaCungCapDTO {
    private String ma_ncc;
    private String ten_ncc;
    private String dia_chi;

    public String getMa_ncc() {
        return ma_ncc;
    }

    public void setMa_ncc(String ma_ncc) {
        this.ma_ncc = ma_ncc;
    }

    public String getTen_ncc() {
        return ten_ncc;
    }

    public void setTen_ncc(String ten_ncc) {
        this.ten_ncc = ten_ncc;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
    
    public NhaCungCapDTO(){
    }
    public NhaCungCapDTO(String ma_ncc, String ten_ncc, String dia_chi) {
        this.ma_ncc = ma_ncc;
        this.ten_ncc = ten_ncc;
        this.dia_chi = dia_chi;
    }
}
