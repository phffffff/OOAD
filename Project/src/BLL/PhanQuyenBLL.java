package BLL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import DAL.PhanQuyenDAL;
import DTO.PhanQuyenDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
 
/**
 *
 * @author Acer
 */
public class PhanQuyenBLL {
    public static List<PhanQuyenDTO> listPQ = new ArrayList<>();
    PhanQuyenDAL phanQuyenDAL = new PhanQuyenDAL();
    
    public PhanQuyenBLL() {
    }
    public void resetListPQ(){
        while(listPQ.size() > 0){
            listPQ.remove(0);
        }
    }
    public void loadListPQ(){
        listPQ = phanQuyenDAL.getData();
    }
    
    public void ThemPQ(String []arr){
        phanQuyenDAL.addData(arr);
        this.resetListPQ();
        this.loadListPQ();
    }
    public void suaPQ(String []arr){
        phanQuyenDAL.updateData(arr);
        
        this.resetListPQ();
        this.loadListPQ();
    }
    public void delPQ(int maPQ){
        phanQuyenDAL.delData(maPQ);
        this.resetListPQ();
        this.loadListPQ();
    }
    public String getQuyenByMaQuyen(int ma_quyen){
        this.resetListPQ();
        this.loadListPQ();
        
        for (PhanQuyenDTO phanQuyenDTO : listPQ) {
            if(phanQuyenDTO.getMa_quyen() == ma_quyen){
                return phanQuyenDTO.getQuyen();
            }
        }
        return null;
    }
    public int getMaQuyenByQuyen(String quyen){
        this.resetListPQ();
        this.loadListPQ();
        
        for (PhanQuyenDTO phanQuyenDTO : listPQ) {
            if(phanQuyenDTO.getQuyen().equals(quyen)){
                return phanQuyenDTO.getMa_quyen();
            }
        }
        return -1;
    }
    public void setLoaiTkToComboBox(DefaultComboBoxModel model){
        this.resetListPQ();
        this.loadListPQ();
        
        for (PhanQuyenDTO phanQuyenDTO : listPQ) {
            model.addElement(phanQuyenDTO.getQuyen());
        }
    }
}
