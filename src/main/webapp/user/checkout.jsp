<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 03/04/2023
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="/giohang/dathang">
    <div class="container">
        <section>
            <div class="row inforadress">
                <!-- icon -->

                <div class="col-1">
                    <svg
                            height="16"
                            viewBox="0 0 12 16"
                            width="12"
                            class="shopee-svg-icon icon-location-marker"
                    >
                        <path
                                d="M6 3.2c1.506 0 2.727 1.195 2.727 2.667 0 1.473-1.22 2.666-2.727 2.666S3.273 7.34 3.273 5.867C3.273 4.395 4.493 3.2 6 3.2zM0 6c0-3.315 2.686-6 6-6s6 2.685 6 6c0 2.498-1.964 5.742-6 9.933C1.613 11.743 0 8.498 0 6z"
                                fill-rule="evenodd"
                        ></path>
                    </svg>
                </div>
                <div class="col-2">
                    <p>Thông tin nhận hàng</p>
                </div>
                <!--  -->
            </div>
            <!-- Infor -->

            <div class="row mb-5">
                <div class="col-2">
                    <h5>Người nhận hàng :</h5>
                </div>
                <div class="col-4"><input class="form-control" name="tenNguoiNhan" /></div>
            </div>
            <!--  -->
            <div class="row mb-5">
                <div class="col-2">
                    <h5>Địa chỉ :</h5>
                </div>
                <div class="col-4"><input class="form-control" name="diaChi"/></div>
            </div>

            <div class="row mb-5">
                <div class="col-2">
                    <h5>Số điện thoại:</h5>
                </div>
                <div class="col-4"><input class="form-control" name="sdt"/></div>
            </div>
        </section>
        <hr class="bg-danger border-3 border-top border-danger mb-4" />
        <section>
            <div class="row">
                <div class="col-6">
                    <h4>Sản phẩm</h4>
                </div>
                <div class="col-3">Đơn giá</div>
                <div class="col-3">Số lượng</div>
                <hr class="bg-success border-2 border-top border-success" />

                <%--            --%>
                <c:forEach items="${listGioHang}" var="x">
                    <div class="col-2">
                        <img src="/images/${x.CTSanPham.images}" height="60px" width="80px">
                    </div>
                    <div class="col-4">
                        <h4>${x.CTSanPham.sanPham.ten}</h4>
                    </div>
                    <div class="col-3">${x.CTSanPham.giaBan}</div>
                    <div class="col-3">${x.soLuong}</div>
                    <div class="col-2"></div>
                    <div class="row bg-light mt-4">
                        <div class="col-4">
                            <!--  -->
                            <div class="row mt-3">
                                <div class="col-4">
                                    <p style="font-size: 17px; color: #8b0000">Lời nhắn</p>
                                </div>
                                <div class="col-8 mb-4">
                                    <input class="form-control" placeholder="Lưu ý cho người bán" name="LuuY"/>
                                </div>
                            </div>
                            <!--  -->
                        </div>
                        <div class="col-3"></div>
                        <div class="col-5 mt-4">
                            <div class="row">
                                <div class="col-6"><h6>Tổng tiền (${x.soLuong} Sản phẩm) :</h6></div>
                                <div class="col-6">
                                    <p style="color: coral; font-size: 18px">${x.CTSanPham.giaBan * x.soLuong} Đ</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr class="bg-danger border-1 border-top border-danger mt-3" />
                </c:forEach>
            </div>

        </section>
        <hr class="bg-danger border-1 border-top border-primary" />

        <section>
            <div class="row mb-4">
                <div class="col-7"></div>
                <div class="col-2"><h6>Tổng số tiền :</h6></div>
                <div class="col-3">
                    <p style="color: coral; font-size: 18px">${tongTien}</p>
                </div>
            </div>
            <div class="row ">
                <div class="col-8"></div>
                <div class="col-2">
                    <button type="submit" class="btn btn-outline-warning w-100" style="height: 50px;">Đặt hàng</button>
                </div>
            </div>
        </section>
    </div>
</form>
