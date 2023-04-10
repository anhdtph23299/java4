<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 21/03/2023
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sản phẩm bán chạy nhất -->
<section>
    <div class="row container">
        <div class="col-4"></div>
        <div class="col-6">
            <form class="d-flex" role="search" method="post" action="/trangchu/search">
                <input
                        class="form-control me-2"
                        type="search"
                        placeholder="Search"
                        aria-label="Search"
                        style="width: 400px"
                        name="search"
                />
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
    <div class="row">
        <center>
            <h1 style="margin: 30px; color: forestgreen">Sản phẩm bán chạy nhất</h1>
        </center>
    </div>
    <div class="row mb-4 text-center">
        <c:forEach items="${listProduct}" var="x">
            <div class="col-3">
                <a href="/product/detail?id=${x.id}">
                    <div class="card" style="width: 18rem" id="khoi">
                        <img
                                src="/images/${x.images}"
                                class="card-img-top"
                                style="height: 230px"
                                alt="..."
                        />
                        <div class="card-body">
                            <h5>${x.sanPham.ten}</h5>
                            <p>Giá tiền : ${x.giaBan}</p>
                            <button
                                    type="button"
                                    class="btn btn-primary tha"
                                    data-bs-toggle="modal"
                                    data-bs-target="#detail"
                            >
                                <i class="bi bi-eye"></i>
                            </button>

                                <a class="bi bi-cart btn btn-light" href="/trangchu/addcard?id=${x.id}"></a>
                            <button
                                    type="button"
                                    class="btn btn-danger"
                            >
                                <i class="bi bi-chat"></i>
                            </button>
                        </div>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
</section>
<%--<section>--%>
<%--    <div class="row">--%>
<%--        <center>--%>
<%--            <h1 style="margin: 30px; color: forestgreen">Sản phẩm mới nhất</h1>--%>
<%--        </center>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="row mb-4 text-center">--%>
<%--            <div class="col-3" ng-repeat="x in spBanChay">--%>
<%--                <a href="#detail/product/{{x.id}}">--%>
<%--                    <div class="card" style="width: 18rem" id="khoi">--%>
<%--                        <img--%>
<%--                                src="{{x.anh}}"--%>
<%--                                class="card-img-top"--%>
<%--                                style="height: 230px"--%>
<%--                                alt="..."--%>
<%--                        />--%>
<%--                        <div class="card-body">--%>
<%--                            <h5>{{x.tenSanPham}}</h5>--%>
<%--                            <p>Giá tiền : ${{x.giaTien}}</p>--%>
<%--                            <button--%>
<%--                                    type="button"--%>
<%--                                    class="btn btn-primary tha"--%>
<%--                                    data-bs-toggle="modal"--%>
<%--                                    data-bs-target="#detail"--%>
<%--                                    ng-click="detailProductmn($event,$index)"--%>
<%--                            >--%>
<%--                                <i class="bi bi-eye"></i>--%>
<%--                            </button>--%>
<%--                            <button type="button" class="btn btn-light">--%>
<%--                                <i class="bi bi-cart"></i>--%>
<%--                            </button>--%>
<%--                            <button type="button" class="btn btn-danger">--%>
<%--                                <i class="bi bi-chat"></i>--%>
<%--                            </button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <!-- Modal -->--%>
<%--    <div--%>
<%--            class="modal fade"--%>
<%--            id="detail"--%>
<%--            tabindex="-1"--%>
<%--            aria-labelledby="exampleModalLabel"--%>
<%--            aria-hidden="true"--%>
<%--    >--%>
<%--        <div class="modal-dialog">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h1 class="modal-title fs-5" id="exampleModalLabel">--%>
<%--                        Chi tiết sản phẩm--%>
<%--                    </h1>--%>
<%--                    <button--%>
<%--                            type="button"--%>
<%--                            class="btn-close"--%>
<%--                            data-bs-dismiss="modal"--%>
<%--                            aria-label="Close"--%>
<%--                    ></button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <p>Tên : {{spDetail.tenSanPham}}</p>--%>
<%--                    <p>Giá tiền : {{spDetail.giaTien}}</p>--%>
<%--                    <p>Số lượng : {{spDetail.soLuong}}</p>--%>
<%--                    <p>Loại : {{spDetail.loai}}</p>--%>
<%--                    <p>Mô tả : {{spDetail.moTa}}</p>--%>
<%--                    <div class="text-center">--%>
<%--                        <img--%>
<%--                                src="{{spDetail.anh}}"--%>
<%--                                class="mx-auto d-block"--%>
<%--                                style="width: 270px"--%>
<%--                                alt="Lỗi ảnh"--%>
<%--                        />--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button--%>
<%--                            type="button"--%>
<%--                            class="btn btn-secondary"--%>
<%--                            data-bs-dismiss="modal"--%>
<%--                    >--%>
<%--                        Đóng--%>
<%--                    </button>--%>
<%--                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">--%>
<%--                        Thêm vào giỏ hàng--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <!--  -->--%>
<%--    </div>--%>
<%--</section>--%>
