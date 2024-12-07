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
                                            <h2 class="fw-bold mb-2 text-uppercase">Register</h2>
                                            <p class="text-white-50 mb-5">Please fill in the form to create an account!</p>
                                            <form action="j_spring_security_check" id="formLogin" method="post">
                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="userName">Username</label>
                                                    <input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="password">Password</label>
                                                    <input type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu">
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="password">Confirm your password</label>
                                                    <input type="password" class="form-control" id="confirmPassword" name="j_password" placeholder="Nhập lại mật khẩu">
                                                </div>

                                                <button type="submit" class="btn btn-primary" >Đăng ký</button>
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
            <%--<script src="./assets/dist/js/boostrap-v5/bootstrap.js"></script>--%>
            <%--<script src="./assets/dist/js/fontawsome-v5/all.js"></script>--%>
        </div>
    </div>
</div>
</body>
</html>