/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
/** 
 *
 * @author niek 
 */
public class CTNhaCungCapLoaiMonDTO {
    private String ma_ncc;
    private String ma_loai;

    public CTNhaCungCapLoaiMonDTO(String ma_ncc, String ma_loai) {
        this.ma_ncc = ma_ncc;
        this.ma_loai = ma_loai;
    }

    public CTNhaCungCapLoaiMonDTO() {
    }

    public String getMa_ncc() {
        return ma_ncc;
    }

    public void setMa_ncc(String ma_ncc) {
        this.ma_ncc = ma_ncc;
    }

    public String getMa_loai() {
        return ma_loai;
    }

    public void setMa_loai(String ma_loai) {
        this.ma_loai = ma_loai;
    }
}
