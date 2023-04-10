package controllers.admin;

import entity.NSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NSXRepository;
import utils.CheckString;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/nsx/index", "/nsx/create", "/nsx/store",
        "/nsx/edit", "/nsx/update", "/nsx/delete"})
public class NSXServlet extends HttpServlet {

    NSXRepository nsxRepo;

    @Override
    public void init() throws ServletException {
        nsxRepo = new NSXRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/nsx/delete")) {
            delete(request, response);
        } else if (url.contains("/nsx/create")) {
            create(request, response);
        } else if (url.contains("/nsx/edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/nsx/store")) {
            store(request, response);
        } else {
            update(request, response);
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", nsxRepo.getAll());
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/nsx/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/nsx/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NSX nsx = new NSX();
        try {
            BeanUtils.populate(nsx, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//
        HttpSession session = request.getSession();
        NSX d = nsxRepo.findMa(nsx.getMa());
        boolean check = false;
        if (d != null) {
            session.setAttribute("errorma", "Trùng mã");
            response.sendRedirect("/nsx/create");
            return;
        }
        if (nsx.getMa().trim().isEmpty()) {
            session.setAttribute("errorma", CheckString.checkValues(nsx.getTen(), "mã"));
            response.sendRedirect("/nsx/create");
            return;
        }
        if (nsx.getTen().trim().isEmpty()) {
            session.setAttribute("errorten", CheckString.checkValues(nsx.getTen(), "tên"));
            response.sendRedirect("/nsx/create");
            return;
        }
        nsx.setTrangThai(0);
        nsxRepo.insert(nsx);
        response.sendRedirect("/nsx/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = nsxRepo.findMa(ma);
        try {
            BeanUtils.populate(nsx, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        if (nsx.getMa().trim().isEmpty()) {
            session.setAttribute("errorma", CheckString.checkValues(nsx.getTen(), "mã"));
            response.sendRedirect("/nsx/edit");
            return;
        }
        if (nsx.getTen().trim().isEmpty()) {
            session.setAttribute("errorten", CheckString.checkValues(nsx.getTen(), "tên"));
            response.sendRedirect("/nsx/edit");
            return;
        }
        nsxRepo.update(nsx);
        response.sendRedirect("/nsx/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = nsxRepo.findMa(ma);
        request.setAttribute("nsx", nsx);
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/nsx/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = nsxRepo.findMa(ma);
        nsxRepo.delete(nsx);
        response.sendRedirect("/nsx/index");
    }
}
