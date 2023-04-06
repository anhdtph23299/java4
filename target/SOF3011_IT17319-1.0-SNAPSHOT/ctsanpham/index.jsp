<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container text-center">
    <h1 class="mt-4">Quản lý chi tiết sản phẩm</h1>
    <c:if test="${list.size()==0}">
        <p>Danh sách rỗng</p>
    </c:if>
    <table class="table table-bordered mt-4">
        <thead>
        <tr>
            <th scope="row">Ảnh</th>
            <th scope="col">Tên</th>
            <th scope="col">Dòng SP</th>
            <th scope="col">Màu sắc</th>
            <th scope="col">NSX</th>
            <th scope="col">Năm bảo hành</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Giá nhập</th>
            <th scope="col">Giá bán</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="ctsp">
            <tr>
                <th scope="col"><img src="/images/${ctsp.images}" width="80" height="70"></img></th>
                <th scope="col">${ctsp.sanPham.ten}</th>
                <th scope="col">${ctsp.dongSP.ten}</th>
                <th scope="col">${ctsp.mauSac.ten}</th>
                <th scope="col">${ctsp.nsx.ten}</th>
                <th scope="col">${ctsp.namBH}</th>
                <th scope="col">${ctsp.soLuongTon}</th>
                <th scope="col">${ctsp.giaNhap}</th>
                <th scope="col">${ctsp.giaBan}</th>
                <td>
                    <a
                            href="/ctsanpham/edit?id=${ctsp.id}"
                            class="btn btn-outline-primary"
                    >Sửa</a
                    >
                    <a
                            href="/ctsanpham/delete?id=${ctsp.id}"
                            class="btn btn-outline-primary"
                    >Xoá</a
                    >
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!--  -->
    <a href="/ctsanpham/create" class="btn btn-primary mt-5">Thêm mới</a>

    <!--  -->
</div>


