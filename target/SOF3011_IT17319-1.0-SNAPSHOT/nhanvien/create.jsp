<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/nhanvien/store" method="post">
    <div class="container">
        <h1 class="mt-4 text-center mb-4">Thêm nhân viên</h1>
        <div class="row mb-4">
            <div class="col-lg-6">
                <label>Mã:</label>
                <input type="text" class="form-control" name="ma"/>
            </div>
            <div class="col-lg-6">
                <label>Họ:</label>
                <input type="text" class="form-control" name="ho"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-lg-6">
                <label>Tên Đệm:</label>
                <input type="text" class="form-control" name="tenDem"/>
            </div>
            <div class="col-lg-6">
                <label>Tên:</label>
                <input type="text" class="form-control" name="ten"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-lg-6">
                <label>Giới tính:</label>
                <div class="row">
                    <div class="col-3">
                        <div class="form-check">
                            <input
                                    class="form-check-input"
                                    type="radio"
                                    name="gioiTinh"
                                    checked
                            />
                            <label class="form-check-label">
                                Nam
                            </label>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-check">
                            <input
                                    class="form-check-input"
                                    type="radio"
                                    name="gioiTinh"
                            />
                            <label class="form-check-label">
                                Nữ
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <label>Ngày sinh:</label>
                <input type="text" class="form-control" name="ngaySinh"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-lg-6">
                <label>Địa Chỉ:</label>
                <input type="text" class="form-control" name="diaChi"/>
            </div>
            <div class="col-lg-6">
                <label>Số điện thoại:</label>
                <input type="text" class="form-control" name="sdt"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-lg-6">
                <label>Mật khẩu:</label>
                <input type="password" class="form-control" name="matKhau"/>
            </div>
            <div class="col-lg-6 pb-3">
                <label>Trạng thái:</label>
                <div class="row">
                    <div class="col-3">
                        <div class="form-check">
                            <input
                                    class="form-check-input"
                                    type="radio"
                                    name="trangThai"
                                    value="0"
                                    checked
                            />
                            <label class="form-check-label">
                                Đang làm
                            </label>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-check">
                            <input
                                    class="form-check-input"
                                    type="radio"
                                    name="trangThai"
                                    value="1"
                            />
                            <label class="form-check-label">
                                Nghỉ làm
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--        --%>
        <div class="row mb-3">
            <div class="col-lg-6">
                <label>Cửa hàng:</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maCuaHang"
                >
                    <c:forEach items="${listCuaHang}" var="x">
                        <option value="${x.ma}">${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-lg-6">
                <label>Chức vụ:</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maChucVu"
                >
                    <c:forEach items="${listChucVu}" var="x">
                        <option value="${x.ma}">${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-4"></div>
            <div class="col-2">
                <a href="/nhanvien/index" class="btn btn-primary">Quay lại</a>
            </div>
            <div class="col-2">
                <button type="submit" class="btn btn-success">Thêm</button>
            </div>
        </div>
        <!--  -->
    </div>
</form>

