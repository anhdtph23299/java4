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
            <i class="bx bx-search"></i>
            <i class="bx bx-filter"></i>
        </div>
        <!-- <table>
          <thead>
            <tr>
              <th>User</th>
              <th>Date Order</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <img src="img/people.png" />
              </td>
              <td>01-10-2021</td>
              <td><span class="status completed">Completed</span></td>
            </tr>
            <tr>
              <td>
                <img src="img/people.png" />
              </td>
              <td>01-10-2021</td>
              <td><span class="status pending">Pending</span></td>
            </tr>
            <tr>
              <td>
                <img src="img/people.png" />
              </td>
              <td>01-10-2021</td>
              <td><span class="status process">Process</span></td>
            </tr>
            <tr>
              <td>
                <img src="img/people.png" />
              </td>
              <td>01-10-2021</td>
              <td><span class="status pending">Pending</span></td>
            </tr>
            <tr>
              <td>
                <img src="img/people.png" />
              </td>
              <td>01-10-2021</td>
              <td><span class="status completed">Completed</span></td>
            </tr>
          </tbody>
        </table> -->

        <table>
            <thead>
            <tr>
                <th>Mã đơn hàng</th>
                <th>Tên người nhận</th>
                <th>Ngày đặt</th>
                <th>Số điện thoại</th>
                <th>Địa chỉ</th>
                <th>Tình trạng</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listDonHang}" var="x">
                <tr>
                    <td>${x.maTuTang}</td>
                    <td>${x.tenNguoiNhan}</td>
                    <td>${x.ngayTao}</td>
                    <td>${x.diaChi}</td>
                    <td>${x.sdt}</td>
                    <td><span class="status ${x.tinhTrang==2?"pending":x.tinhTrang==3?
                            "process":x.tinhTrang==4?"completed":"text-primary"}">
                            ${x.tinhTrang==2?"Chờ xác nhận":x.tinhTrang==3?
                            "Đang giao":x.tinhTrang==4?"Hoàn thành":x.tinhTrang==5?"Huỷ":""}
                    </span></td>
                    <td><a  href="/hoadon/hdct?id=${x.id}">Chi tiết</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
