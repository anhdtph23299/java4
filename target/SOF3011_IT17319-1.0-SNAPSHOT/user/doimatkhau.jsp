<%--
  Created by IntelliJ IDEA.
  User: sktfk
  Date: 02/04/2023
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2 class="text-center mt-5 mb-4">Đổi mật khẩu</h2>
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <form method="post" action="/trangchu/submitdoimk">
                <div class="form-group mb-3">
                    <label for="oldPassword">Mật khẩu cũ:</label>
                    <input
                            type="password"
                            class="form-control"
                            id="oldPassword"
                            name="oldPassword"
                            required
                    />
                </div>
                <div class="form-group mb-3">
                    <label for="newPassword">Mật khẩu mới:</label>
                    <input
                            type="password"
                            class="form-control"
                            id="newPassword"
                            name="newPassword"
                            required
                    />
                </div>
                <div class="form-group mb-3">
                    <label for="confirmPassword">Xác nhận mật khẩu mới:</label>
                    <input
                            type="password"
                            class="form-control"
                            id="confirmPassword"
                            name="confirmPassword"
                            required
                    />
                </div>
                <div class="d-grid gap-2">
                    <button
                            type="submit"
                            class="btn btn-primary btn-block mt-4"
                    >
                        Lưu
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

