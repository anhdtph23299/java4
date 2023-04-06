package controllers.admin;

import entity.GioHang;
import entity.GioHangChiTiet;
import entity.HoaDon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.HoaDonRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet({"/hoadon/index","/hoadon/hdct","/hoadon/nhandon","/hoadon/hoanthanh"
        ,"/hoadon/huydon"})
public class HoaDonServlet extends HttpServlet {

    HoaDonRepository hoaDonRepo ;

    @Override
    public void init() throws ServletException {
        hoaDonRepo = new HoaDonRepository();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/hoadon/index")) {
            index(request, response);
        } else if(url.contains("/hoadon/hdct")){
            hoaDonChiTiet(request, response);
        }else if(url.contains("/hoadon/nhandon")){
            nhanDon(request, response);
        }else if(url.contains("/hoadon/huydon")){
            huyDon(request, response);
        }else if(url.contains("/hoadon/hoanthanh")){
            hoanThanh(request, response);
        }

    }

    private void nhanDon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID idHd = UUID.fromString(request.getParameter("idhd"));
        GioHang gioHang = hoaDonRepo.getGioHangById(idHd);
        hoaDonRepo.chuyenTrangThaiGioHang(gioHang,3);
        response.sendRedirect("/hoadon/index");
    }
    private void huyDon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID idHd = UUID.fromString(request.getParameter("idhd"));
        GioHang gioHang = hoaDonRepo.getGioHangById(idHd);
        hoaDonRepo.chuyenTrangThaiGioHang(gioHang,5);
        response.sendRedirect("/hoadon/index");
    }
    private void hoanThanh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID idHd = UUID.fromString(request.getParameter("idhd"));
        GioHang gioHang = hoaDonRepo.getGioHangById(idHd);
        hoaDonRepo.chuyenTrangThaiGioHang(gioHang,4);
        response.sendRedirect("/hoadon/index");
    }

    private void hoaDonChiTiet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID idhd = UUID.fromString(request.getParameter("id"));
        List<GioHangChiTiet> gioHangChiTiets = hoaDonRepo.getGioHangChiTietByID(idhd);
        GioHang gioHang = hoaDonRepo.getGioHangById(idhd);
        request.setAttribute("listGioHangChiTiet",gioHangChiTiets);
        request.setAttribute("hoaDon",gioHang);
        request.setAttribute("view","null.jsp");
        request.setAttribute("navbar","/layout/hoadonct.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GioHang> list =  hoaDonRepo.getHoaDon();
        request.setAttribute("listDonHang",list);
        request.setAttribute("view","null.jsp");
        request.setAttribute("navbar","/layout/hoadon.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }



}
