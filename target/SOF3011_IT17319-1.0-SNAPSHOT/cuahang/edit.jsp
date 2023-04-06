<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/cuahang/update" method="post">
    <div class="container">
        <h1 class="mt-4 text-center mb-4">Sửa cửa hàng</h1>
        <div class="row mb-4">
            <div class="col-6">
                <label>Mã cửa hàng:</label>
                <input type="text" class="form-control" name="ma" value="${ch.ma}" />
            </div>
            <div class="col-6">
                <label>Tên cửa hàng:</label>
                <input type="text" class="form-control" name="ten" value="${ch.ten}" />
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Địa chỉ:</label>
                <input type="text" class="form-control" name="diaChi" value="${ch.diaChi}" />
            </div>
            <div class="col-6">
                <label>Thành phố:</label>
                <select class="form-select" aria-label="Default select example" name="thanhPho">
                    <option value="Hà Nội" ${ch.thanhPho == "Hà Nội"?"selected":""}>Hà Nội</option>
                    <option value="Hồ Chí Minh" ${ch.thanhPho == "Hồ Chí Minh"?"selected":""}>Hồ Chí Minh</option>
                    <option value="Hồ Chí Minh" ${ch.thanhPho == "Tokyo"?"selected":""}>Tokyo</option>
                </select>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Quốc gia:</label>
                <select class="form-select" aria-label="Default select example" name="quocGia">
                    <option value="Việt Nam" ${ch.thanhPho == "Việt Nam"?"selected":""}>Việt Nam</option>
                    <option value="Lào" ${ch.quocGia == "Lào"?"selected":""}>Lào</option>
                    <option value="Lào" ${ch.quocGia == "Nhật Bản"?"selected":""}>Nhật Bản</option>
                </select>
            </div>
        </div>
        <!--  -->
        <button type="submit" class="btn btn-success">Sửa</button>
    </div>
</form>

