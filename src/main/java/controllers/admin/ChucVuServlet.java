package controllers.admin;

import entity.ChucVu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import utils.CheckString;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/chucvu/index", "/chucvu/create", "/chucvu/store",
        "/chucvu/edit", "/chucvu/update", "/chucvu/delete"})
public class ChucVuServlet extends HttpServlet {

    ChucVuRepository chucVuRepo;
    String error ;
    String errorTen;
    String errorMa;

    @Override
    public void init() throws ServletException {
        chucVuRepo = new ChucVuRepository();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/chucvu/delete")) {
            delete(request, response);
        } else if (url.contains("/chucvu/create")) {
            create(request, response);
        } else if (url.contains("/chucvu/edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/chucvu/store")) {
            store(request, response);
        } else {
            update(request, response);
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("list", chucVuRepo.getAll());
        request.setAttribute("navbar","/layout/nhanvien.jsp");
        request.setAttribute("view","/chucvu/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.setAttribute("trungMa",error);
        session.setAttribute("checkten", errorTen);
        session.setAttribute("checkma", errorMa);
        request.setAttribute("navbar","/layout/nhanvien.jsp");
        request.setAttribute("view","/chucvu/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ChucVu chucVu = new ChucVu();
        try {
            BeanUtils.populate(chucVu, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(chucVu.getTen(),"tên");
        errorMa = CheckString.checkValues(chucVu.getMa(),"mã");
        ChucVu cv = chucVuRepo.findMa(chucVu.getMa());
        if (cv!=null){
            error="Trùng mã";
            response.sendRedirect("/chucvu/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/chucvu/create");
            return;
        }

        chucVu.setTrangThai(0);
        chucVuRepo.insert(chucVu);
        response.sendRedirect("/chucvu/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu chucVu = chucVuRepo.findMa(ma);
        try {
            BeanUtils.populate(chucVu, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/chucvu/edit");
            return;
        }
        errorTen = CheckString.checkValues(chucVu.getTen(),"tên");
        errorMa = CheckString.checkValues(chucVu.getMa(),"mã");
        chucVuRepo.update(chucVu);
        response.sendRedirect("/chucvu/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu chucVu = chucVuRepo.findMa(ma);
        HttpSession session = request.getSession();
        session.setAttribute("checkten", errorTen);
        session.setAttribute("checkma", errorMa);
        request.setAttribute("cv", chucVu);
        request.setAttribute("navbar","/layout/nhanvien.jsp");
        request.setAttribute("view","/chucvu/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu chucVu = chucVuRepo.findMa(ma);
        chucVuRepo.delete(chucVu);
        response.sendRedirect("/chucvu/index");
    }

}
