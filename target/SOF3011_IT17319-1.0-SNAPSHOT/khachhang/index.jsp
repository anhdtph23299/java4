<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 10/03/2023
  Time: 4:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Họ</th>
            <th scope="col">Tên đệm</th>
            <th scope="col">tên</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Thành phố</th>
            <th scope="col">Quốc gia</th>
            <th scope="col">Mật khẩu</th>
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
                <td>${x.ngaySinh}</td>
                <td>${x.sdt}</td>
                <td>${x.diaChi}</td>
                <td>${x.thanhPho}</td>
                <td>${x.quocGia}</td>
                <td>${x.matKhau}</td>
                <td>
                    <a href="/khach-hang/edit?ma=${x.ma}"
                       class="btn btn-outline-primary">Sửa</a>
                    <a href="/khach-hang/delete?ma=${x.ma}"
                       class="btn btn-outline-primary">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <button type="button" class="btn btn-outline-primary">
            <a href="/khach-hang/create">Thêm</a>
        </button>
        <%--        <c:if test="${ds.size()!=0}"><p>Không có dữ liệu 1</p></c:if>--%>
    </table>
</div>