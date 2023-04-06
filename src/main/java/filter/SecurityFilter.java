package filter;

import entity.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/giohang/*","/trangchu/*","/mausac/*",
            "/chucvu/*","/cuahang/*","/dongsp/*","/khach-hang/*","/mausac/*",
        "/nhanvien/*","/nsx/*","/sanpham/*","/hoadon/*","/ctsanpham/*"
        })
public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession();
        KhachHang kh = (KhachHang) session.getAttribute("khachHangLogin");
        if (kh == null) {
            HttpServletResponse httpRes = (HttpServletResponse) response;
            httpRes.sendRedirect("/login/viewkh");
        } else {
            chain.doFilter(request, response);
        }
    }
}
