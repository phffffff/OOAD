/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Help;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mizuk
 */
public class Validater {
    public static boolean isEmpty(String text, StringBuilder sb, String title){
        sb.append("");
        boolean flag = false;
        if(text.trim().equals("")){
            sb.append("Không được bỏ trống "+title+"\n");
            flag = true;
        }
        return flag;
    }
    public static boolean checkNumber(String text, StringBuilder sb, String title){
        if(isEmpty(text,sb,title)){
            return true;
        }
        try{
            int number = Integer.valueOf(text);
            if(number < 0){
                sb.append(title+" không được âm"+"\n");
                return true;
            }
        }catch(Exception e){
            sb.append("Sai định dạng dữ liệu, vui lòng nhập lại "+title+"\n");
            return true;
        }
        return false;
    }
}
