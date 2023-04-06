<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" session="true" language="java" %>

<form action="/sanpham/store" method="post">
    <div class="container text-center">
        <h1 class="mt-4">Thêm sản phẩm</h1>
        <div class="row mt-5 mb-4">
            <div class="col-2"></div>
            <div class="col-2">
                <span>Mã : </span>
            </div>
            <div class="col-4">
                <input
                        type="text"
                        class="form-control"
                        aria-describedby="basic-addon1"
                        name="ma"
                />
                <div class="error mt-2"><p class="alert">${errorma}</p></div>
            </div>
        </div>
        <!--  -->
        <div class="row mt-5 mb-4">
            <div class="col-2"></div>
            <div class="col-2">
                <span>Tên : </span>
            </div>
            <div class="col-4">
                <input
                        type="text"
                        class="form-control"
                        aria-describedby="basic-addon1"
                        name="ten"
                />
                <div class="error mt-2"><p class="alert">${errorten}</p></div>
            </div>
        </div>
        <!--  -->
        <div class="row">
            <div class="col-4"></div>
            <div class="col-2">
                <a href="/sanpham/index" class="btn btn-primary">Quay lại</a>
            </div>
            <div class="col-2">
                <button type="submit" class="btn btn-success">Thêm</button>
            </div>
        </div>
    </div>
</form>
