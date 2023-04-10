<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/ctsanpham/store" method="post" enctype="multipart/form-data">
    <div class="container">
        <h1 class="mt-4 text-center mb-4">Thêm chi tiết sản phẩm</h1>
        <div class="row mb-4">
            <%--            <div class="col-6">--%>
            <%--                <label>ID</label>--%>
            <%--                <input type="text" class="form-control" name="id" disabled/>--%>
            <%--                <c:if test="${trungMa==false}">--%>
            <%--                    <div class="col error"><p>Trùng mã</p></div>--%>
            <%--                </c:if>--%>
            <%--&lt;%&ndash;                <div class="col error"><p>Trùng mã</p></div>&ndash;%&gt;--%>
            <%--            </div>--%>

            <div class="col-6">
                <label>Sản phẩm</label>
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="SanPham"
                >
                    <c:forEach items="${listSanPham}" var="x">
                        <option value="${x}">${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <div class="mb-3">
                    <label for="formFile" class="form-label">Ảnh</label>
                    <input class="form-control" type="file" id="formFile" name="hinhAnh"
                           accept="image/*" enctype="multipart/form-data">
                </div>
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
                        <option value="${x.ma}">${x.ten}</option>
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
                        <option value="${x.ma}">${x.ten}</option>
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
                        <option value="${x.ma}">${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Năm bán hàng:</label>
                <input type="text" class="form-control" name="namBH"/>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Số lượng :</label>
                <input type="number" class="form-control" name="soLuongTon"/>
            </div>
            <div class="col-6">
                <label>Giá nhập :</label>
                <input type="text" class="form-control" name="giaNhap"/>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Giá bán :</label>
                <input type="text" class="form-control" name="giaBan"/>
            </div>
            <div class="col-6">
                <label>Mô tả :</label>
                <input type="text" class="form-control" name="moTa"/>
            </div>
        </div>
        <!--  -->
        <div class="row">
            <div class="col-4"></div>
            <div class="col-2">
                <a href="/ctsanpham/index" class="btn btn-primary">Quay lại</a>
            </div>
            <div class="col-2">
                <button type="submit" class="btn btn-success">Thêm</button>
            </div>
        </div>
    </div>
</form>