<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 21/03/2023
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
    <div class="row text-center">
        <div class="col-2">
            <nav class="navbar">
                <div class="container-fluid">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <p class="navbar-brand loc">Tất cả</p>
                        </li>
                        <%--                        <li class="nav-item" ng-repeat="x in loaiSanPham">--%>
                        <%--                            <p class="navbar-brand loc">--%>
                        <%--                                {x.name}--%>
                        <%--                            </p>--%>
                        <%--                        </li>--%>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="col-10">
            <div class="row">
                <c:forEach items="${listProducts}" var="x">
                    <div class="col-4">
                        <a href="/product/detail?id=${x.id}">
                            <div class="card" style="width: 18rem" id="khoi">
                                <img src="/images/${x.images}" class="card-img-top" width="15rem" height="180px"/>
                                <div class="card-body">
                                    <h5>${x.sanPham.ten}</h5>
                                    <p>Giá tiền : ${x.giaBan}</p>
                                    <button type="button" class="btn btn-primary">
                                        <i class="bi bi-eye text-white"></i>
                                    </button>
                                    <button type="button" class="btn btn-light">
                                        <i class="bi bi-cart"></i>
                                    </button>
                                    <button type="button" class="btn btn-danger">
                                        <i class="bi bi-chat"></i>
                                    </button>
                                </div>
                            </div
                            >
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
