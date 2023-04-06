<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 12/03/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container text-center">
    <h1 class="mt-4">Quản lý nhà sản xuất</h1>
    <c:if test="${list.size()==0}">
        <p>Danh sách rỗng</p>
    </c:if>
    <table class="table table-bordered mt-4">
        <thead>
        <tr>
            <th scope="col">Mã nhà sản xuất</th>
            <th scope="col">Tên nhà sản xuất</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="x">
            <tr>
                <th scope="row">${x.ma}</th>
                <td>${x.ten}</td>
                <td>
                    <a href="/nsx/edit?ma=${x.ma}" class="btn btn-outline-primary">Sửa</a>
                    <a href="/nsx/delete?ma=${x.ma}"
                       class="btn btn-outline-primary">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!--  -->
    <a href="/nsx/create" class="btn btn-primary mt-5">Thêm mới</a>

    <!--  -->
</div>

