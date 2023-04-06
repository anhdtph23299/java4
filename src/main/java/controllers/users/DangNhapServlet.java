package controllers.users;

import entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DangNhapRepository;
import viewmodel.Login;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/login/viewnv", "/login/submitnv","/login/viewkh", "/login/submitkh","/login/dangxuat"})
public class DangNhapServlet extends HttpServlet {

    DangNhapRepository dangNhapRepo ;
    Boolean error = false;
    Boolean errorkh = false;

    @Override
    public void init() throws ServletException {
        dangNhapRepo = new DangNhapRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/login/viewnv")) {
            index(request, response);
        } else if(url.contains("/login/dangxuat")){
            dangXuat(request, response);
        }else{
            loginkh(request, response);
        }

    }

    private void dangXuat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("khachHangLogin");
        response.sendRedirect("/");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/login/submitnv")) {
            try {
                submitnv(request, response);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            submidkh(request, response);
        }

    }
    private void loginkh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void submidkh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login login = new Login();
        try {
            BeanUtils.populate(login, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        KhachHang khachHang = dangNhapRepo.getKhachHang(login);
        if (khachHang!=null) {
            session.setAttribute("khachHangLogin",khachHang);
            response.sendRedirect("/trangchu/index");
        } else {
            session.setAttribute("check","Tài khoản hoặc mật khẩu sai");
            response.sendRedirect("/login/viewkh");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (error){
            request.setAttribute("check", "Tài khoản hoặc mật khẩu sai");
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void submitnv(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        Login login = new Login();
            BeanUtils.populate(login, request.getParameterMap());

//        if (nhanVienRepo.checkUser(login)) {
//            error = false;
//            response.sendRedirect("/chucvu/index");
//        } else {
//            error = true;
//            response.sendRedirect("/login/viewnv");
//        }
    }


}
