package controllers.admin;

import entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/khach-hang/index", "/khach-hang/create", "/khach-hang/store",
        "/khach-hang/edit", "/khach-hang/update", "/khach-hang/delete"})
public class KhachHangServlet extends HttpServlet {

    private KhachHangRepository khRepo ;
    @Override
    public void init() {
        khRepo = new KhachHangRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String url = request.getRequestURI();
        if (url.contains("/khach-hang/create")) {
            create(request, response);
        } else if (url.contains("/khach-hang/index")) {
            index(request, response);
        }else if (url.contains("/khach-hang/delete")) {
            delete(request, response);
        } else if(url.contains("/khach-hang/edit")){
            edit(request,response);
        }
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("/khach-hang/store")){
            store(request, response);
        }else{
            update(request, response);
        }
    }
    private void edit(HttpServletRequest request, HttpServletResponse response) {
        String ma = request.getParameter("ma");
        KhachHang kh = khRepo.findMa(ma);
        request.setAttribute("kh",kh);
        try {
            request.setAttribute("navbar", "null.jsp");
            request.setAttribute("view", "/khachhang/edit.jsp");
            request.getRequestDispatcher("/layout.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        KhachHang kh = khRepo.findMa(ma);
        khRepo.delete(kh);
        response.sendRedirect("/khach-hang/index");
    }



    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("navbar", "null.jsp");
        request.setAttribute("view", "/khachhang/add.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        KhachHang kh = new KhachHang();
        try {
            BeanUtils.populate(kh,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        khRepo.insert(kh);
        response.sendRedirect("/khach-hang/index");
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("list", khRepo.getAll());
        request.setAttribute("navbar", "null.jsp");
        request.setAttribute("view", "/khachhang/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String ma = request.getParameter("ma");
        KhachHang kh = khRepo.findMa(ma);
        try {
            BeanUtils.populate(kh,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        khRepo.update(kh);
        response.sendRedirect("/khach-hang/index");
    }
}
