<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" session="true" language="java" %>

<form  action="/dongsp/update" method="post">
    <div class="container text-center">
        <h1 class="mt-4">Sửa dòng sản phẩm</h1>
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
                        value="${dongsp.ma}"

                />
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
                        value="${dongsp.ten}"
                />
            </div>
        </div>
        <!--  -->
        <button type="submit" class="btn btn-success">Sửa</button>
    </div>
</form>

