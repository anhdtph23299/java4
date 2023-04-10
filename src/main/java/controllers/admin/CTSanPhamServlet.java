package controllers.admin;

import entity.CTSanPham;
import entity.DongSP;
import entity.MauSac;
import entity.NSX;
import entity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CTSanPhamRepository;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet({"/ctsanpham/index", "/ctsanpham/create", "/ctsanpham/store",
        "/ctsanpham/edit", "/ctsanpham/update", "/ctsanpham/delete"})
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 10,//10MB
        fileSizeThreshold = 1024 * 1024 * 1,//1MB
        maxRequestSize = 1024 * 1024 * 10//10MB
)
public class CTSanPhamServlet extends HttpServlet {
    public CTSanPhamRepository ctSanPhamRepo;


    @Override
    public void init() throws ServletException {
        ctSanPhamRepo = new CTSanPhamRepository();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/ctsanpham/delete")) {
            delete(request, response);
        } else if (url.contains("/ctsanpham/create")) {
            create(request, response);
        } else if (url.contains("/ctsanpham/edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/ctsanpham/store")) {
            try {
                store(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            update(request, response);
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", ctSanPhamRepo.getAll());
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/ctsanpham/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("listNSX", ctSanPhamRepo.getAllNSX());
        request.setAttribute("listSanPham", ctSanPhamRepo.getAllSanPham());
        request.setAttribute("listDongSP", ctSanPhamRepo.getAllDongSP());
        request.setAttribute("listMauSac", ctSanPhamRepo.getAllMauSac());
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/ctsanpham/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CTSanPham ctSanPham = new CTSanPham();
        try {
            BeanUtils.populate(ctSanPham, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        String filename = null;
        try {
            String uploadPath = request.getServletContext().getRealPath("/") + "images";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                System.out.println( uploadDir.mkdir());;
            }
            Part part = request.getPart("hinhAnh");
            filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            part.write(uploadPath + "/" + filename);

        } catch (Exception e) {
            e.printStackTrace();
        }

//        String maSanPham = request.getParameter("maSanPham");
        SanPham sanPham = new SanPham();
        try {
            BeanUtils.setProperty(sanPham, "ten", request.getParameter("SanPham"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(sanPham);
//
//        String maNSX = request.getParameter("maNSX");
//        String maDongSP = request.getParameter("maDongSP");
//        String maMauSac = request.getParameter("maMauSac");
////        SanPham sanPham = ctSanPhamRepo.findMaSanPham(maSanPham);
//        NSX nsx = ctSanPhamRepo.findMaNSX(maNSX);
//        DongSP dongSP = ctSanPhamRepo.findMaDongSP(maDongSP);
//        MauSac mauSac = ctSanPhamRepo.findMaMauSac(maMauSac);
//        ctSanPham.setSanPham(sanPham);
//        ctSanPham.setDongSP(dongSP);
//        ctSanPham.setMauSac(mauSac);
//        ctSanPham.setNsx(nsx);
//        ctSanPham.setImages(filename);
//        ctSanPhamRepo.insert(ctSanPham);
        response.sendRedirect("/ctsanpham/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("msp"));
        CTSanPham ctSanPham = ctSanPhamRepo.findID(id);
        try {
            BeanUtils.populate(ctSanPham, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // Lấy ảnh rồi gán vào forder images tạo ra
        String filename = null;
        try {
            String uploadPath = request.getServletContext().getRealPath("/") + "images";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                System.out.println( uploadDir.mkdir());;
            }
            Part part = request.getPart("hinhAnh");
            filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            part.write(uploadPath + "/" + filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
        ctSanPham.setImages(filename);
        String maSanPham = request.getParameter("maSanPham");
        String maNSX = request.getParameter("maNSX");
        String maDongSP = request.getParameter("maDongSP");
        String maMauSac = request.getParameter("maMauSac");
        SanPham sanPham = ctSanPhamRepo.findMaSanPham(maSanPham);
        NSX nsx = ctSanPhamRepo.findMaNSX(maNSX);
        DongSP dongSP = ctSanPhamRepo.findMaDongSP(maDongSP);
        MauSac mauSac = ctSanPhamRepo.findMaMauSac(maMauSac);
        ctSanPham.setSanPham(sanPham);
        ctSanPham.setDongSP(dongSP);
        ctSanPham.setMauSac(mauSac);
        ctSanPham.setNsx(nsx);
        ctSanPham.setImages(filename);
        ctSanPhamRepo.update(ctSanPham);
        response.sendRedirect("/ctsanpham/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        UUID id = UUID.fromString(idStr);
        CTSanPham ctsanpham = ctSanPhamRepo.findID(id);
        request.setAttribute("ctsp", ctsanpham);
        request.setAttribute("listNSX", ctSanPhamRepo.getAllNSX());
        request.setAttribute("listSanPham", ctSanPhamRepo.getAllSanPham());
        request.setAttribute("listDongSP", ctSanPhamRepo.getAllDongSP());
        request.setAttribute("listMauSac", ctSanPhamRepo.getAllMauSac());
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/ctsanpham/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        CTSanPham ctsanpham = ctSanPhamRepo.findID(id);
        ctSanPhamRepo.delete(ctsanpham);
        response.sendRedirect("/ctsanpham/index");
    }
}
