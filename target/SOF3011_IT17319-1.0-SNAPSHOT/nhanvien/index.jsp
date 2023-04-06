<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container text-center">
    <h1 class="mt-4">Quản lý nhân viên</h1>
    <c:if test="${list.size()==0}">
        <p>Danh sách rỗng</p>
    </c:if>
    <table class="table table-bordered mt-4">
        <thead>
        <tr>
            <th scope="col">Mã nhân viên</th>
            <th scope="col">Họ </th>
            <th scope="col">Tên đệm</th>
            <th scope="col">Tên</th>
            <th scope="col">Giới tính</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="x">
            <tr>
                <th scope="row">${x.ma}</th>
                <td>${x.ho}</td>
                <td>${x.tenDem}</td>
                <td>${x.ten}</td>
                <td>${x.gioiTinh}</td>
                <td>${x.ngaySinh}</td>
                <td>${x.diaChi}</td>
                <td>${x.sdt}</td>
                <td>${x.matKhau}</td>
                <td>${x.trangThai==0?"Đang làm":"Nghỉ làm"}</td>
                <td>
                    <a href="/nhanvien/edit?ma=${x.ma}" class="btn btn-outline-primary">Sửa</a>
                    <a href="/nhanvien/delete?ma=${x.ma}" class="btn btn-outline-primary">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!--  -->
    <a href="/nhanvien/create" class="btn btn-primary mt-5">Thêm mới</a>

    <!--  -->
</div>

