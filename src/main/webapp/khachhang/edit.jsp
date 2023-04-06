<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 09/03/2023
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container mt-5">
    <form method="POST" action="/khach-hang/update" >
        <div class="row mt-3">
            <div class="col-lg-6">
                <label>Mã KH:</label>
                <input type="text" class="form-control" name="ma" value="${kh.ma}"/>
            </div>

            <div class="col-lg-6">
                <label>Họ:</label>
                <input type="text" class="form-control" name="ho" value="${kh.ho}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-lg-6">
                <label>Tên Đệm:</label>
                <input type="text" class="form-control" name="tenDem" value="${kh.tenDem}"/>
            </div>
            <div class="col-lg-6">
                <label>Tên:</label>
                <input type="text" class="form-control" name="ten" value="${kh.ten}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-lg-6">
                <label>Ngày Sinh:</label>
                <input type="text" class="form-control" name="ngaySinh" value="${kh.ngaySinh}"/>
            </div>
            <div class="col-lg-6">
                <label>SĐT:</label>
                <input type="text" class="form-control" name="sdt" value="${kh.sdt}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-lg-6">
                <label>Địa Chỉ:</label>
                <input type="text" class="form-control" name="diaChi" value="${kh.diaChi}"/>
            </div>
            <div class="col-lg-6">
                <label>Mật Khẩu:</label>
                <input type="password" class="form-control" name="matKhau" value="${kh.matKhau}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-lg-6">
                <label>Thành Phố:</label>
                <select class="form-select" aria-label="Default select example" name="thanhPho" >
                    <option value="Hà Nội" ${kh.thanhPho=="Hà Nội"?"selected":""}>Hà Nội</option>
                    <option value="Hải Phòng" ${kh.thanhPho=="Hoà Bình"?"selected":""}>Hoà Bình</option>
                    <option value="Hà Nam" ${kh.thanhPho=="Hà Nam"?"selected":""}>Hà Nam</option>
                </select>
            </div>
            <div class="col-lg-6 pb-3 mt-3 mb-3">
                <label>Quốc Gia:</label>
                <select class="form-select" aria-label="Default select example" name="quocGia">
                    <option value="Việt Nam" ${kh.quocGia=="Việt Nam"?"selected":""}>Việt Nam</option>
                    <option value="Hà Lan" ${kh.quocGia=="Hà Lan"?"selected":""}>Hà Lan</option>
                    <option value="USA" ${kh.quocGia=="USA"?"selected":""}>USA</option>
                </select>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Sửa</button>
        <%--        <button type="button" class="btn btn-primary">Sửa</button>--%>
        <%--        <button type="button" class="btn btn-primary">Xóa</button>--%>
    </form>
</div>
