package controllers.admin;

import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SanPhamRepository;
import utils.CheckString;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/sanpham/index","/sanpham/create","/sanpham/store",
        "/sanpham/edit","/sanpham/update","/sanpham/delete"})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository sanPhamRepo;
    @Override
    public void init() throws ServletException {
        sanPhamRepo = new SanPhamRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/sanpham/delete")) {
            delete(request,response);
        }else if (url.contains("/sanpham/create")) {
            create(request,response);
        }else if(url.contains("/sanpham/edit")){
            edit(request,response);
        }else{
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/sanpham/store")){
            store(request, response);
        }else{
            update(request, response);
        }

    }
    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list",sanPhamRepo.getAll());
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/sanpham/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }
    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
//        request.setAttribute("errorma",errorMa);
//        request.setAttribute("errorten",errorTen);
//        request.setAttribute("trungma",trungMa);
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/sanpham/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }
    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        SanPham d = sanPhamRepo.findMa(sp.getMa());
        if (d!=null){
            session.setAttribute("errorma","Trùng mã");
            response.sendRedirect("/sanpham/create");
        }else{
            boolean checkMa = CheckString.setTrangThai(session,sp.getMa(),"ma","Mã");
            boolean checkTen = CheckString.setTrangThai(session,sp.getTen(),"ten","Tên");
            if (checkMa||checkTen){
                response.sendRedirect("/sanpham/create");
            }else{
                sp.setTrangThai(0);
                sanPhamRepo.insert(sp);
                response.sendRedirect("/sanpham/index");
            }
        }

//        errorMa = CheckString.checkValues(sp.getMa(),"mã");
//        errorTen = CheckString.checkValues(sp.getTen(),"tên");
//        if (!errorMa.isEmpty()||!errorTen.isEmpty()){
//            check = true;
//        }
//        if (check){
//            response.sendRedirect("/sanpham/create");
//            return;
//        }

    }
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = sanPhamRepo.findMa(ma);
        try {
            BeanUtils.populate(sp,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        boolean checkMa = CheckString.setTrangThai(session,sp.getMa(),"ma","Mã");
        boolean checkTen = CheckString.setTrangThai(session,sp.getTen(),"ten","Tên");
        if (checkMa||checkTen){
            response.sendRedirect("/sanpham/edit");
        }else{
            sanPhamRepo.update(sp);
            response.sendRedirect("/sanpham/index");
        }
//
    }
    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sanPham = sanPhamRepo.findMa(ma);

        request.setAttribute("sp",sanPham);
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/sanpham/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sanPham = sanPhamRepo.findMa(ma);
        sanPhamRepo.delete(sanPham);
        response.sendRedirect("/sanpham/index");
    }
}
