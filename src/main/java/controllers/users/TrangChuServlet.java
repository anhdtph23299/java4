package controllers.users;

import entity.CTSanPham;
import entity.GioHang;
import entity.GioHangChiTiet;
import entity.GioHangChiTietId;
import entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import repositories.TrangChuRepository;
import utils.RandomString;
import viewmodel.ChangePass;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet({"/trangchu/index", "/product/detail", "/trangchu/sanpham",
        "/trangchu/addcard", "/trangchu/doimatkhau", "/trangchu/submitdoimk"})
public class TrangChuServlet extends HttpServlet {

    private TrangChuRepository trangChuRepo;

    @Override
    public void init() throws ServletException {
        trangChuRepo = new TrangChuRepository();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/trangchu/index")) {
            index(request, response);
        } else if (url.contains("/product/detail")) {
            detailProduct(request, response);
        } else if (url.contains("/trangchu/sanpham")) {
            showProduct(request, response);
        } else if (url.contains("/trangchu/addcard")) {
            addCard(request, response);
        } else if (url.contains("/trangchu/doimatkhau")) {
            doiMatKhau(request, response);
        }

    }

    private void doiMatKhau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("main", "/user/doimatkhau.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/trangchu/submitdoimk")) {
            changePass(request, response);
        }
    }

    private void changePass(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHangLogin");
        ChangePass changePass = new ChangePass();
        BeanUtils.populate(changePass, request.getParameterMap());
        if (khachHang.getMatKhau().equals(changePass.getOldPassword())) {
            if (changePass.getNewPassword().equals(changePass.getConfirmPassword())) {
                khachHang.setMatKhau(changePass.getNewPassword());
                trangChuRepo.updateMatKhauKH(khachHang);
                response.sendRedirect("/trangchu/index");
            }
        }


    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProducts", trangChuRepo.getAllSanPham());
        request.setAttribute("main", "/user/sanpham.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);
    }

    private void addCard(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        CTSanPham ctSanPham = trangChuRepo.findCTSanPhamById(id);
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHangLogin");
        GioHang gioHang = trangChuRepo.findGioHangByKhachHang(khachHang.getId());
        if (gioHang == null) {
            gioHang = new GioHang();
            RandomString randomString = new RandomString();
            gioHang.setMa(randomString.nextString().substring(0,5));
            gioHang.setKhachHang(khachHang);
            gioHang.setTinhTrang(1);
            trangChuRepo.insertGioHang(gioHang);
            gioHang = trangChuRepo.findGioHangByKhachHang(khachHang.getId());
        }
        GioHangChiTiet gioHangChiTiet = trangChuRepo.findGioHangByGioHangCT(gioHang.getId(), ctSanPham.getId());
        System.out.println(gioHangChiTiet);
        if (gioHangChiTiet == null) {
            System.out.println("Vào đây");
            gioHangChiTiet = new GioHangChiTiet();
            GioHangChiTietId gioHangChiTietId = new GioHangChiTietId(gioHang.getId(), ctSanPham.getId());

            System.out.println(gioHangChiTietId.getIdGioHang());

            gioHangChiTiet.setGioHangChiTietId(gioHangChiTietId);
            gioHangChiTiet.setDonGia(ctSanPham.getGiaBan());
//            gioHangChiTiet.setCTSanPham(ctSanPham);
            gioHangChiTiet.setSoLuong(1);
            trangChuRepo.insertGioHangChiTiet(gioHangChiTiet);
        } else {
            gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
            trangChuRepo.updateGioHangChiTiet(gioHangChiTiet);
        }
        response.sendRedirect("/trangchu/index");
    }

    private void detailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        CTSanPham ctSanPham = trangChuRepo.findCTSanPhamById(id);
        request.setAttribute("spDetail", ctSanPham);
        request.setAttribute("main", "/user/detailproduct.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHangLogin");
        int soLuong = trangChuRepo.findGioHangByKhachHang(khachHang);
        List<CTSanPham> list = trangChuRepo.getAllSanPham();
        getServletContext().setAttribute("soLuong", soLuong);
        request.setAttribute("listProduct", list);
        request.setAttribute("main", "/user/trangchu.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);
    }

}
