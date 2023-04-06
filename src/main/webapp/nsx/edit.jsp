<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" session="true" language="java" %>
<form action="/nsx/update" method="post">
    <div class="container text-center">
        <h1 class="mt-4">Sửa nhà sản xuất</h1>
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
                        value="${nsx.ma}"

                />
                <div class=" error mt-2"><p class="alert">${errorma}</p></div>

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
                        value="${nsx.ten}"
                />
                <div class=" error mt-2"><p class="alert">${errorma}</p></div>
            </div>
        </div>
        <!--  -->
        <button type="submit" class="btn btn-success">Sửa</button>
    </div>
</form>

