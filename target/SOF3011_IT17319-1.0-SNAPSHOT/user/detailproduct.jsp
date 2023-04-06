<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 21/03/2023
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container my-5">
    <div class="row">
        <div class="col-md-5">
            <div class="main-img dt">
                <img class="img-fluid" src="/images/${spDetail.images}" />
            </div>
        </div>
        <div class="col-md-7">
            <div class="main-description px-2">
                <h3>Dòng sản phẩm : ${spDetail.dongSP.ten}</h3>
                <div class="product-title text-bold my-3">${spDetail.sanPham.ten}</div>
                <div class="row mb-3">
                    <div class="col-3"><p>Giá tiền :</p></div>
                    <div class="col-6">
                        <strong>${spDetail.giaBan}</strong>
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col-3"><p>Số lượng hiện tại :</p></div>
                    <div class="col-6">
                        <h5>${spDetail.soLuongTon}</h5>
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col-3">
                        <span id="basic-addon1">Số lượng</span>
                    </div>

                    <div class="col-5">
                        <input
                                type="number"
                                class="form-control"
                                aria-describedby="basic-addon1"
                                ng-model="soLuong"
                                value="1"
                                min="1"
                                max="${spDetail.soLuongTon}"
                        />
                    </div>
                </div>
                <div class="row mb-5">
                    <div class="col-2"></div>
                    <div class="col-3">
                        <button type="button" class="btn btn-dark">Mua ngay</button>
                    </div>
                    <div class="col-5">
                        <button type="button" class="btn btn-dark">
                            Thêm vào giỏ hàng
                        </button>
                    </div>
                </div>

                <div class="row mb-3">
                    <p>Mô tả :</p>
                    <p>${spDetail.moTa}</p>
                </div>
            </div>
        </div>
    </div>

</div>