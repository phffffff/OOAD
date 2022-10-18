/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
 
import DAL.CTChuongTrinhKMDAL;
import DTO.CTChuongTrinhKMDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class CTChuongTrinhKMBLL {
    public static List<CTChuongTrinhKMDTO> listCTCTKM = new ArrayList<>();
    
    CTChuongTrinhKMDAL cTChuongTrinhKMDAL = new CTChuongTrinhKMDAL();
    MonAnBLL monAnBLL = new MonAnBLL();
    
    public CTChuongTrinhKMBLL() {
    }
    public void resetListCTCTKM(){
        while(listCTCTKM.size() > 0){
            listCTCTKM.remove(0);
        }
    }
    public void loadListCTCTKM(int ma_ctkm){
        listCTCTKM = cTChuongTrinhKMDAL.getDataByID(ma_ctkm);
    }
    //set list lên table list
    public  void setListCTCTKM(DefaultTableModel model,int ma_ctkm){
        this.resetListCTCTKM();
        this.loadListCTCTKM(ma_ctkm);
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        
        for (CTChuongTrinhKMDTO cTChuongTrinhKMDTO : listCTCTKM) {
            model.addRow(new Object[]{
                cTChuongTrinhKMDTO.getMa_mon(),
                cTChuongTrinhKMDTO.getTen_mon(),
                cTChuongTrinhKMDTO.getGia_goc(),
                cTChuongTrinhKMDTO.getTien_giam(),
                (int)(cTChuongTrinhKMDTO.getGia_goc()-cTChuongTrinhKMDTO.getTien_giam()),
                cTChuongTrinhKMDTO.getTen_loai()
            });
        }
        model.fireTableDataChanged();
    }
    public void apdungCTKM(int ma_ctkm){
        this.resetListCTCTKM();
        this.loadListCTCTKM(ma_ctkm);
//        System.out.println(listCTCTKM.get(0).getMa_mon());
//        System.out.println(listCTCTKM.get(0).getTien_giam());
//        monAnBLL.suaGiaMonTheoKM(listCTCTKM.get(0).getMa_mon(),listCTCTKM.get(0).getTien_giam());
        for(int i = 0 ; i < listCTCTKM.size() ; i++){
            monAnBLL.suaGiaMonTheoKM(listCTCTKM.get(i).getMa_mon(),listCTCTKM.get(i).getTien_giam());
        }
    }
    public void ngungApDung(int ma_ctkm){
        this.resetListCTCTKM();
        this.loadListCTCTKM(ma_ctkm);

        for(int i = 0 ; i < listCTCTKM.size() ; i++){
            monAnBLL.suaGiaMonTheoKM(listCTCTKM.get(i).getMa_mon(),0);
        }
    }
    public void ThemCTCTKM(String []str){
        cTChuongTrinhKMDAL.addData(str);
        this.resetListCTCTKM();
        this.loadListCTCTKM(Integer.parseInt(str[0]));
    }
    public void suaCTCTKM(String []str){
        cTChuongTrinhKMDAL.updateData(str);
        
        this.resetListCTCTKM();
        this.loadListCTCTKM(Integer.parseInt(str[0]));
    }
    public void delCTCTKM(int ma_ctkm,String ma_mon){
        cTChuongTrinhKMDAL.delData(ma_ctkm,ma_mon);
        this.resetListCTCTKM();
        this.loadListCTCTKM(ma_ctkm);
    }
    public CTChuongTrinhKMDTO getCtctkmByMaMon(String ma_mon,int ma_ctkm) {
        this.resetListCTCTKM();
        this.loadListCTCTKM(ma_ctkm);
        
        for (CTChuongTrinhKMDTO cTChuongTrinhKMDTO : listCTCTKM) {
            if(cTChuongTrinhKMDTO.getMa_mon().equals(ma_mon)){
                return cTChuongTrinhKMDTO;
            }
        }
        return null;
    }

}

