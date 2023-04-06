<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- Boxicons -->
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
    <!-- My CSS -->

    <link rel="stylesheet" href="/css/bootstrap.css"/>
    <link rel="stylesheet" href="/css/kh.css"/>


    <title>AdminHub</title>
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-7"></div>
            <div class="col-1"></div>
            <div class="col-2 c">
                <div class="dropdown">
                    <button
                            class="btn btn-secondary dropdown-toggle"
                            type="button"
                            id="dropdownMenuButton1"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                    >
                        Tài khoản
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="/login/dangxuat">Đăng xuất</a></li>
                        <li><a class="dropdown-item" href="#dangky">Đăng ký</a></li>
                        <li><a class="dropdown-item" href="/trangchu/doimatkhau">Đổi mật khẩu</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-2 c">
                <button type="button" class="btn btn-dark">
                    <a href="/giohang" style="color:white"
                    >Giỏ hàng
                        <span class="badge text-bg-secondary">${soLuong}</span></a
                    >
                </button>
            </div>
        </div>
        <nav class="navbar bg-body-tertiary">
            <div class="container-fluid">
                <img
                        src="https://dcassetcdn.com/design_img/6165/17990/17990_139608_6165_image.jpg"
                        style="width: 200px; height: 100px"
                />
                <a class="navbar-brand" href="/trangchu/index">Trang chủ</a>
                <a class="navbar-brand" href="/trangchu/sanpham">Sản phẩm</a>
                <a class="navbar-brand" href="/trangchu/gioithieu">Giới thiệu cửa hàng</a>
                <a class="navbar-brand" href="/trangchu/sukien">Sự kiện</a>
            </div>
        </nav>
    </div>
</header>

<main class="container">
    <jsp:include page="${main}"></jsp:include>
</main>

<footer>
    <footer class="footer">
        <div class="footer-middle container">
            <div class="row">
                <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="footer-logo">
                        <a class="logo" href="/quavatonline.com">
                            <img
                                    alt="Quà Vặt Online"
                                    src="https://dcassetcdn.com/design_img/6165/17990/17990_139608_6165_image.jpg"
                                    style="height: 100px; width: 250px"
                            />
                        </a>
                    </div>
                    <p>
                        Chúng tôi cam kết sẽ dành trọn tâm huyết để mang đến cho quý khách
                        những món ăn ngon, an toàn và giá thành hợp lý.
                    </p>
                    <div class="payment-accept">
                        <div>
                            <img
                                    src="//bizweb.dktcdn.net/thumb/compact/100/135/586/themes/175747/assets/payment-1-min.png?1608792171440"
                                    alt="payment"
                            />
                            <img
                                    src="//bizweb.dktcdn.net/thumb/compact/100/135/586/themes/175747/assets/payment-2-min.png?1608792171440"
                                    alt="payment"
                            />
                            <img
                                    src="//bizweb.dktcdn.net/thumb/compact/100/135/586/themes/175747/assets/payment-3-min.png?1608792171440"
                                    alt="payment"
                            />
                            <img
                                    src="//bizweb.dktcdn.net/thumb/compact/100/135/586/themes/175747/assets/payment-4-min.png?1608792171440"
                                    alt="payment"
                            />
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12">
                    <h3>Liên hệ</h3>
                    <div class="contacts-info">
                        <address>
                            <i class="add-icon"></i>Yên trị - Yên Thuỷ - Hoà Bình
                        </address>
                        <div class="phone-footer">
                            <i class="phone-icon"></i>Hotline: 0325808823
                        </div>
                        <div class="phone-footer">
                            <i class="phone-icon"></i>Hotline: 0389478937
                        </div>
                        <div class="email-footer">
                            <i class="email-icon"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12">
                    <h3>Facebook</h3>
                    <a href="fb.com/kit.vn" style="color: aliceblue">Tuấn Anh</a>
                </div>
            </div>
        </div>
    </footer>

</footer>

<%--<script src="/js/script.js"></script>--%>
<script src="/js/bootstrap.bundle.js"></script>
</body>
</html>
