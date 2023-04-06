<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/cuahang/store" method="post">
    <div class="container">
        <h1 class="mt-4 text-center mb-4">Thêm cửa hàng</h1>
        <div class="row mb-4">
            <div class="col-6">
                <label>Mã cửa hàng:</label>
                <input type="text" class="form-control" name="ma" />
                <div class=" error mt-2"><p>${trungMa}</p></div>
                <div class=" error mt-2"><p>${errorma}</p></div>
            </div>
            <div class="col-6">
                <label>Tên cửa hàng:</label>
                <input type="text" class="form-control" name="ten" />
                <div class=" error mt-2"><p>${errorten}</p></div>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Địa chỉ:</label>
                <input type="text" class="form-control" name="diaChi" />
                <div class=" error mt-2"><p>${errordiachi}</p></div>
            </div>
            <div class="col-6">
                <label>Thành phố:</label>
                <select class="form-select" aria-label="Default select example" name="thanhPho">
                    <option value="Hà Nội">Hà Nội</option>
                    <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                    <option value="Tokyo">Tokyo</option>
                </select>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label>Quốc gia:</label>
                <select class="form-select" aria-label="Default select example" name="quocGia">
                    <option value="Việt Nam">Việt Nam</option>
                    <option value="Lào">Lào</option>
                    <option value="Nhật Bản">Nhật Bản</option>
                </select>
            </div>
        </div>
        <!--  -->
        <div class="row">
            <div class="col-4"></div>
            <div class="col-2">
                <a href="/cuahang/index" class="btn btn-primary">Quay lại</a>
            </div>
            <div class="col-2">
                <button type="submit" class="btn btn-success">Thêm</button>
            </div>
        </div>
    </div>
</form>
