package utils;

import jakarta.servlet.http.HttpSession;

public class CheckString {
    public static String checkValues(String value,String ten){
        if (value.isEmpty()){
            return "Phải nhập "+ten;
        }
        return "";
    }
    public static boolean setTrangThai(HttpSession session,String value,String truong,String ten){
            if (value.trim().isEmpty()){
                session.setAttribute("error"+truong,"Bạn chưa nhập "+ten);
                return true;
            }
            session.setAttribute("error"+truong,"");
        return false;
    }
}
