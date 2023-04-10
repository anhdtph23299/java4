<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- Boxicons -->
    <link
            href="/boxicons-2.1.4/css/boxicons.css"
            rel="stylesheet"
    />
    <!-- My CSS -->
    <link rel="stylesheet" href="/css/bootstrap.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <style>

        .error p{
            color: red;
        }
    </style>
    <title>AdminHub</title>
</head>
<body>
<!-- SIDEBAR -->
<section id="sidebar">
    <a href="/trangchu/index" class="brand">
        <i class="bx bxs-smile"></i>
        <span class="text">AdminHub</span>
    </a>
    <ul class="side-menu top">
        <li>
            <a href="/hoadon/index">
                <i class="bx bxs-dashboard"></i>
                <span class="text">Thống Kê</span>
            </a>
        </li>
        <li id="menu2">
            <a href="/nhanvien/index">
                <i class="bx bxs-shopping-bag-alt"></i>
                <span class="text">Quản Lý Cửa Hàng</span>
            </a>
        </li>
        <li id="menu3">
            <a href="/ctsanpham/index">
                <i class="bx bxs-message-dots"></i>
                <span class="text">Quản Lý Sản Phẩm</span>
            </a>
        </li>
        <li id="menu4">
            <a href="/khach-hang/index">
                <i class="bx bxs-group"></i>
                <span class="text">Quản Lý Khách Hàng</span>
            </a>
        </li>
    </ul>
    <ul class="side-menu">
        <li>
            <a href="#">
                <i class="bx bxs-cog"></i>
                <span class="text">Settings</span>
            </a>
        </li>
        <li>
            <a href="#" class="logout">
                <i class="bx bxs-log-out-circle"></i>
                <span class="text">Logout</span>
            </a>
        </li>
    </ul>
</section>
<!-- SIDEBAR -->

<!-- CONTENT -->
<section id="content">
    <!-- NAVBAR -->
    <nav>
        <i class="bx bx-menu"></i>
        <a href="#" class="nav-link">Categories</a>
        <form action="#">
            <div class="form-input">
                <input type="search" placeholder="Search..."/>
                <button type="submit" class="search-btn">
                    <i class="bx bx-search"></i>
                </button>
            </div>
        </form>
        <input type="checkbox" id="switch-mode" hidden/>
        <label for="switch-mode" class="switch-mode"></label>
        <!-- <a href="#" class="notification">
				<i class='bx bxs-bell' ></i>
				<span class="num">8</span>
			</a>
			<a href="#" class="profile">
				<img src="img/people.png">
			</a> -->
    </nav>
    <!-- NAVBAR -->

    <!-- MAIN -->
    <main>
        <jsp:include page="${navbar}"></jsp:include>
        <jsp:include page="${view}"></jsp:include>
    </main>

    <!-- MAIN -->
</section>
<!-- CONTENT -->

<%--<script src="/js/script.js"></script>--%>
<script src="/js/bootstrap.bundle.js"></script>
</body>
</html>
