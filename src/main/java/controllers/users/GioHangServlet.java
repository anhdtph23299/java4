package controllers.users;

import entity.GioHang;
import entity.GioHangChiTiet;
import entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import repositories.GioHangRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@WebServlet({"/giohang/giamsl", "/giohang/tangsl", "/giohang","/giohang/detail","/giohang/delete"
        ,"/giohang/checkout","/giohang/dathang"})
public class GioHangServlet extends HttpServlet {


    GioHangRepository gioHangRepo = new GioHangRepository();
    @Override
    public void init() throws ServletException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.equals("/giohang")) {
            index(request, response);
        } else if (url.contains("/giohang/tangsl")) {
            tangSL(request, response);
        } else if (url.contains("/giohang/giamsl")) {
            giamSL(request, response);
        }else if(url.contains("/giohang/delete")){
            delete(request,response);
        }else if(url.contains("/giohang/checkout")){
            checkOut(request,response);
        }else{
            index(request, response);
        }

    }

    private void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHangLogin");
        List<GioHangChiTiet> list = gioHangRepo.getAllSanPham(khachHang.getId());
//        GioHang gioHang = gioHangRepo.getGioHangByKhachHang(khachHang.getId());
        request.setAttribute("listGioHang",list);
        request.setAttribute("tongTien",gioHangRepo.getTongTienList(khachHang.getId()));
        request.setAttribute("main","/user/checkout.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);

    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if(url.contains("/giohang/dathang")){
            datHang(request,response);
        }

    }

    private void datHang(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHangLogin");
        GioHang gh = gioHangRepo.getGioHangByKhachHang(khachHang.getId());
        BeanUtils.populate(gh,request.getParameterMap());
        gh.setTinhTrang(2);
        gh.setNgayTao(new Date(new java.util.Date().getTime()));
        gioHangRepo.updateGioHang(gh);
        response.sendRedirect("/trangchu/index");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID idSp = UUID.fromString(request.getParameter("idsp"));
        UUID idgh = UUID.fromString(request.getParameter("idgh"));
        GioHangChiTiet ghct = gioHangRepo.getGioHangByIdSpAndIdGh(idSp,idgh);
        gioHangRepo.deleteGioHang(ghct);
        response.sendRedirect("/giohang");
    }


    private void tangSL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID idSp = UUID.fromString(request.getParameter("idsp"));
        UUID idgh = UUID.fromString(request.getParameter("idgh"));
        GioHangChiTiet ghct = gioHangRepo.getGioHangByIdSpAndIdGh(idSp,idgh);
        ghct.setSoLuong(ghct.getSoLuong()+1);
        gioHangRepo.updateGioHangChiTiet(ghct);
        response.sendRedirect("/giohang");
    }

    private void giamSL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID idSp = UUID.fromString(request.getParameter("idsp"));
        UUID idgh = UUID.fromString(request.getParameter("idgh"));
        GioHangChiTiet ghct = gioHangRepo.getGioHangByIdSpAndIdGh(idSp,idgh);
        int soLuong = ghct.getSoLuong();
        if (soLuong==1){
            gioHangRepo.deleteGioHang(ghct);
        }else{
            ghct.setSoLuong(soLuong-1);
            gioHangRepo.updateGioHangChiTiet(ghct);
        }
        response.sendRedirect("/giohang");
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHangLogin");
        List<GioHangChiTiet> list = gioHangRepo.getAllSanPham(khachHang.getId());
        getServletContext().setAttribute("soLuong", list.size());
        request.setAttribute("listcard", list);
        request.setAttribute("listcard", list);
        request.setAttribute("tongTien", gioHangRepo.getTongTienList(khachHang.getId()));
        request.setAttribute("main", "/user/giohang.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);
    }


}
