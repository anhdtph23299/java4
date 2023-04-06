<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 21/03/2023
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="head-title">
    <div class="left">
        <h1>Dashboard</h1>
        <ul class="breadcrumb">
            <li>
                <a href="#">Dashboard</a>
            </li>
            <li><i class="bx bx-chevron-right"></i></li>
            <li>
                <a class="active" href="#">Home</a>
            </li>
        </ul>
    </div>
    <a href="#" class="btn-download">
        <i class="bx bxs-cloud-download"></i>
        <span class="text">Download PDF</span>
    </a>
</div>
<!-- <section style="padding-top: 40px; padding-bottom: 0px">
<h1>Hi</h1>
</section> -->

<ul class="box-info">
    <li>
        <i class="bx bxs-calendar-check"></i>
        <span class="text">
              <h3>1020</h3>
              <p>New Order</p>
            </span>
    </li>
    <li>
        <i class="bx bxs-group"></i>
        <span class="text">
              <h3>2834</h3>
              <p>Visitors</p>
            </span>
    </li>
    <li>
        <i class="bx bxs-dollar-circle"></i>
        <span class="text">
              <h3>$2543</h3>
              <p>Total Sales</p>
            </span>
    </li>
</ul>

<div class="table-data">
    <div class="order">
        <div class="head">
            <h3>Hoá Đơn</h3>
            <c:if test="${hoaDon.tinhTrang==5}">
                <a class="btn btn-danger" href="/hoadon/huydon?idhd=${hoaDon.id}">Huỷ đơn</a>
            </c:if>
            <c:if test="${hoaDon.tinhTrang==2}">
                <a class="btn btn-success" href="/hoadon/nhandon?idhd=${hoaDon.id}">Nhận đơn</a>
            </c:if>
            <c:if test="${hoaDon.tinhTrang==3}">
                <a class="btn btn-success" href="/hoadon/hoanthanh?idhd=${hoaDon.id}">Hoàn thành</a>
            </c:if>
            <i class="bx bx-search"></i>
            <i class="bx bx-filter"></i>
        </div>
        <table>
            <thead>
            <tr>
                <th></th>
                <th>Tên mặt hàng</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listGioHangChiTiet}" var="x">
                <tr>
                    <td>
                        <img src="/images/${x.CTSanPham.images}" height="50px" width="80px"/>
                    </td>
                    <td>${x.CTSanPham.sanPham.ten}</td>
                    <td>${x.soLuong}</td>
                    <td>${x.CTSanPham.giaBan}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
