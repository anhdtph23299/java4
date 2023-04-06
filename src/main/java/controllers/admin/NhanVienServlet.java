package controllers.admin;

import entity.ChucVu;
import entity.CuaHang;
import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NhanVienRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/nhanvien/index", "/nhanvien/create", "/nhanvien/store",
        "/nhanvien/edit", "/nhanvien/update", "/nhanvien/delete"})
public class NhanVienServlet extends HttpServlet {
    NhanVienRepository nhanVienRepo;

    @Override
    public void init() throws ServletException {
//        converter.setPattern("yyyy-MM-dd");
        nhanVienRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/nhanvien/delete")) {
            delete(request, response);
        } else if (url.contains("/nhanvien/create")) {
            create(request, response);
        } else if (url.contains("/nhanvien/edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/nhanvien/store")) {
            store(request, response);
        } else {
            update(request, response);
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", nhanVienRepo.getAll());
        request.setAttribute("navbar", "/layout/nhanvien.jsp");
        request.setAttribute("view", "/nhanvien/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("listChucVu",nhanVienRepo.getAllChucVu());
        request.setAttribute("listCuaHang",nhanVienRepo.getAllCuaHang());
        request.setAttribute("navbar", "/layout/nhanvien.jsp");
        request.setAttribute("view", "/nhanvien/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NhanVien nhanVien = new NhanVien();
        try {
            BeanUtils.populate(nhanVien, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String maCuaHang = request.getParameter("maCuaHang");
        String maChucVu = request.getParameter("maChucVu");
        CuaHang cuaHang = nhanVienRepo.findCuaHangByMa(maCuaHang);
        ChucVu chucVu = nhanVienRepo.findChucVuByMa(maChucVu);
        nhanVien.setChucVu(chucVu);
        nhanVien.setCuaHang(cuaHang);
        nhanVienRepo.insert(nhanVien);
        response.sendRedirect("/nhanvien/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nhanVien = nhanVienRepo.findMa(ma);
        try {
            BeanUtils.populate(nhanVien, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String maCuaHang = request.getParameter("maCuaHang");
        String maChucVu = request.getParameter("maChucVu");
        CuaHang cuaHang = nhanVienRepo.findCuaHangByMa(maCuaHang);
        ChucVu chucVu = nhanVienRepo.findChucVuByMa(maChucVu);
        nhanVien.setChucVu(chucVu);
        nhanVien.setCuaHang(cuaHang);
        nhanVienRepo.update(nhanVien);
        response.sendRedirect("/nhanvien/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = nhanVienRepo.findMa(ma);
        request.setAttribute("listChucVu",nhanVienRepo.getAllChucVu());
        request.setAttribute("listCuaHang",nhanVienRepo.getAllCuaHang());
        request.setAttribute("nv", nv);
        request.setAttribute("navbar", "/layout/nhanvien.jsp");
        request.setAttribute("view", "/nhanvien/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = nhanVienRepo.findMa(ma);
        nhanVienRepo.delete(nv);
        try {
            response.sendRedirect("/nhanvien/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
