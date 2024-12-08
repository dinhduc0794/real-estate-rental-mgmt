<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký</title>
</head>
<body>
<div class="container">
    <!-- <h1 class="form-heading">login Form</h1> -->
    <div class="register-form-form">
        <div class="main-div">
            <c:if test="${param.registerFail != null}">
                <div class="alert alert-danger">
                    Register fail! Please try again!
                </div>
            </c:if>
            <div class="container-fluid" >
                <section class="gradient-custom">
                    <div class="page-wrapper">
                        <div class="row d-flex justify-content-center align-items-center">
                            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                                <div class="card text-white" style="border-radius: 1rem; background-color: #35bf76;">
                                    <div class="card-body p-5">
                                        <div class="mb-md-5 mt-md-4 pb-5 text-center">
                                            <h2 class="fw-bold mb-2 text-uppercase">Sign up</h2>
                                            <p class="text-white-50 mb-5">Please fill in the form to create an account!</p>
                                            <form action="j_spring_security_check" id="formRegister" method="post">
                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="fullName">Fullname</label>
                                                    <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Họ và tên">

                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="userName">Username</label>
                                                    <input type="text" class="form-control" id="userName" name="userName" placeholder="Tên đăng nhập">
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="password">Password</label>
                                                    <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu">
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="password">Confirm your password</label>
                                                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Nhập lại mật khẩu">
                                                </div>

                                                <input type="hidden" name="roleCode" value="USER" />

                                                <div class="form-check d-flex flex-column align-items-center justify-content-center mb-2" style="margin-left: -24px">
                                                    <div class="form-check d-flex justify-content-center mb-5">
                                                        <div>
                                                            <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg" />
                                                        </div>
                                                        <div>
                                                            <label class="form-check-label">
                                                                    I agree to all statements in
                                                                    <br>
                                                                    <a href="#!" class="blue" style="text-decoration: underline;">Terms of Service</a>
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <button type="submit" class="btn btn-primary" id="register">Đăng ký</button>
                                            </form>
                                        </div>
                                        <div class="text-center">
                                            <p class="mb-0 tex-center account">Already have an account? <a class="nav-link" href="<c:url value='/login'/>">Login</a></p>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
<%--            <script src="./assets/dist/js/boostrap-v5/bootstrap.js"></script>--%>
<%--            <script src="./assets/dist/js/fontawsome-v5/all.js"></script>--%>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
            <script>
                $('#register').click(function (e) {
                    e.preventDefault();

                    // Kiểm tra điều khoản sử dụng
                    if (!$('#form2Example3cg').is(':checked')) {
                        alert("Đọc và đồng ý với điều khoản sử dụng trước khi tạo tài khoản!");
                        return;
                    }

                    // Thu thập dữ liệu từ form
                    var data = {};
                    var formData = $('#formRegister').serializeArray();
                    var confirmPassword = $('#confirmPassword').val();

                    $.each(formData, function (i, v) {
                        data[v.name] = v.value.trim();
                    });

                    // Kiểm tra dữ liệu đầu vào
                    $('span.error-message').remove(); // Xóa các lỗi cũ
                    if (data['fullName'] && data['userName'] && data['password'] && confirmPassword !== '' && data['password'] === confirmPassword) {
                        registerNewUser(data);
                    } else {
                        alert("Vui lòng điền đầy đủ thông tin");
                        highlightEmptyFields(data, confirmPassword);
                    }
                });

                // Hiển thị các lỗi còn thiếu
                function highlightEmptyFields(data, confirmPassword) {
                    $('span.error-message').remove(); // Xóa tất cả các thông báo lỗi cũ
                    if (!data['fullName']) {
                        $('#fullName').after('<span class="error-message" style="color: red">Tên không được để trống</span>');
                    }
                    if (!data['userName']) {
                        $('#userName').after('<span class="error-message" style="color: red">Tên tài khoản không được để trống</span>');
                    }
                    if (!data['password']) {
                        $('#password').after('<span class="error-message" style="color: red">Mật khẩu không được để trống</span>');
                    }
                    if (confirmPassword === '') {
                        $('#confirmPassword').after('<span class="error-message" style="color: red">Vui lòng xác nhận mật khẩu</span>');
                    }
                    else if (data['password'] !== confirmPassword) {
                        $('#confirmPassword').after('<span class="error-message" style="color: red">Mật khẩu không khớp</span>');
                    }
                }

                // Gửi dữ liệu đến server
                function registerNewUser(data) {
                    $.ajax({
                        url: "/api/users/register",
                        type: "POST",
                        data: JSON.stringify(data),
                        contentType: "application/json",
                        success: function (response) {
                            alert(response.message);
                            if (response.message === "Đăng ký tài khoản thành công")
                                window.location.href = "/login";
                        },
                        error: function (response) {
                            alert(response.message || "Có lỗi xảy ra khi đăng ký");
                        }
                    });
                }
            </script>

        </div>
    </div>
</div>
</body>
</html>