/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
/**
 * 
 * @author mizuk
 */ 
public class PhanQuyenDTO {
    private int ma_quyen;
    private String quyen;
    
    public PhanQuyenDTO() {
    }

    public PhanQuyenDTO(int ma_quyen, String quyen) {
        this.ma_quyen = ma_quyen;
        this.quyen = quyen;
    }

    public int getMa_quyen() {
        return ma_quyen;
    }

    public void setMa_quyen(int ma_quyen) {
        this.ma_quyen = ma_quyen;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
    
}
