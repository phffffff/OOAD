/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXCEL;

import BLL.HoaDonBLL;
import BLL.DonDatHangBLL;
import BLL.NhaCungCapBLL;
import DTO.HoaDonDTO;
import DTO.DonDatHangDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author niek
 */
public class XuatExcel {
//    FileOutputStream outFile = null;
    public void xuatHD() throws IOException{
        FileOutputStream out = null;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Hóa đơn");
            XSSFRow row = null;
            Cell cell = null;
            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Danh sách hóa đơn");
            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Mã hóa đơn");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Ngày xuất");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã nhân viên");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Mã thành viên");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tổng tiền");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Tiền giảm");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tiền còn lại");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Mã phiếu giảm giá");
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Điểm");
            
//            new HoaDonBLL().resetListHD();
//            new HoaDonBLL().loadListHD();
            List<HoaDonDTO> listExcelHD = new HoaDonBLL().getListExcel();
            for (int i = 0; i < listExcelHD.size(); i++) {
                HoaDonDTO hddto = listExcelHD.get(i);
                row = spreadsheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue(hddto.getMa_hoa_don());
                row.createCell(1).setCellValue(hddto.getNgay_xuat());
                row.createCell(2).setCellValue(hddto.getMa_nhan_vien());
                row.createCell(3).setCellValue(hddto.getMa_thanh_vien());
                row.createCell(4).setCellValue(hddto.getTong_tien());
                row.createCell(5).setCellValue(hddto.getTien_giam());
                row.createCell(6).setCellValue(hddto.getTien_con_lai());
                row.createCell(7).setCellValue(hddto.getMa_phieu_giam_gia());
                row.createCell(8).setCellValue(hddto.getDiem());
            }
            File file = new File("./hd.xlsx");
            out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException ex) {
            
        }
    }
    public void xuatDN() throws IOException{
        FileOutputStream out = null;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Đơn nhập");
            XSSFRow row = null;
            Cell cell = null;
            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Danh sách đơn nhập");
            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Mã đơn nhập");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã nhà cung cấp");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên nhà cung cấp");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ngày đặt");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tổng tiền");
            
//            new DonDatHangBLL().resetListDDH();
//            new DonDatHangBLL().loadListDDH();
            
//            List<DonDatHangDTO> listDDH = new DonDatHangBLL().getList();
            List<DonDatHangDTO> listDDH = new DonDatHangBLL().getListExcel();
            for (int i = 0; i < listDDH.size(); i++) {
                DonDatHangDTO donDatHangDTO = listDDH.get(i);
                row = spreadsheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue(donDatHangDTO.getMa_don_dat());
                row.createCell(1).setCellValue(donDatHangDTO.getMa_ncc());
                row.createCell(2).setCellValue(new NhaCungCapBLL().getTenNccByMaNcc(donDatHangDTO.getMa_ncc()));
                row.createCell(3).setCellValue(donDatHangDTO.getNgay_dat());
                row.createCell(4).setCellValue(donDatHangDTO.getTong_tien_dat());
            }
            File file = new File("./dn.xlsx");
            out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException ex) {
            
        }
    }
}
