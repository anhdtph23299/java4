<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/ctsanpham/update" method="post" enctype="multipart/form-data">
    <div class="container">
        <h1 class="mt-4 text-center mb-4">Sửa chi tiết sản phẩm</h1>
        <div class="row mb-4">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" class="form-control" name="msp" value="${ctsp.id}"/>
            </div>
            <div class="col-6">
                <label>Sản phẩm</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maSanPham"
                >
                    <c:forEach items="${listSanPham}" var="x">
                        <option value="${x.ma}" ${ctsp.sanPham.id==x.id?"selected":""}>${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Dòng sản phẩm</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maDongSP"
                >
                    <c:forEach items="${listDongSP}" var="x">
                        <option value="${x.ma}" ${ctsp.dongSP.id==x.id?"selected":""}>${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Màu sắc</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maMauSac"
                >
                    <c:forEach items="${listMauSac}" var="x">
                        <option value="${x.ma}" ${ctsp.mauSac.id==x.id?"selected":""}>${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Nhà sản xuất</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maNSX"
                >
                    <c:forEach items="${listNSX}" var="x">
                        <option value="${x.ma}" ${ctsp.nsx.id==x.id?"selected":""}>${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Năm bán hàng:</label>
                <input type="text" class="form-control" name="namBH" value="${ctsp.namBH}"/>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Số lượng :</label>
                <input type="number" class="form-control" name="soLuongTon" value="${ctsp.soLuongTon}"/>
            </div>
            <div class="col-6">
                <label>Giá nhập :</label>
                <input type="text" class="form-control" name="giaNhap" value="${ctsp.giaNhap}"/>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Giá bán :</label>
                <input type="text" class="form-control" name="giaBan" value="${ctsp.giaBan}"/>
            </div>
            <div class="col-6">
                <label>Mô tả :</label>
                <input type="text" class="form-control" name="moTa" value="${ctsp.moTa}"/>
            </div>
            <div class="col-6">
                <div class="mb-3">
                    <label for="formFile" class="form-label">Ảnh</label>
                    <input class="form-control" type="file" id="formFile" name="hinhAnh"
                           accept="image/*" enctype="multipart/form-data">
                </div>
            </div>
        </div>
        <!--  -->
        <div class="row">
            <div class="col-4"></div>
            <div class="col-2">
                <button type="submit" class="btn btn-success">Sửa</button>
            </div>
        </div>
    </div>
</form>

