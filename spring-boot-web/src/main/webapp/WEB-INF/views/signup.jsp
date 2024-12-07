<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký</title>
</head>
<body>
<div class="container">
    <div class="sign-up-form">
        <div class="main-div">
            <c:if test="${param.registrationError != null}">
                <div class="alert alert-danger">
                    Registration failed. Please check your information.
                </div>
            </c:if>
            <div class="container-fluid">
                <section class="gradient-custom">
                    <div class="page-wrapper">
                        <div class="row d-flex justify-content-center align-items-center">
                            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                                <div class="card text-white" style="border-radius: 1rem; background-color: #35bf76;">
                                    <div class="card-body p-5">
                                        <div class="mb-md-5 mt-md-4 pb-5 text-center">
                                            <h2 class="fw-bold mb-2 text-uppercase">Sign Up</h2>
                                            <p class="text-white-50 mb-5">Please fill in the details to create an account.</p>
                                            <form action="register" id="formSignUp" method="post">
                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="fullName">Full Name</label>
                                                    <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Full Name" required>
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="email">Email</label>
                                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="phone">Phone Number</label>
                                                    <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone Number" required>
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="password">Password</label>
                                                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <label class="form-label" for="confirmPassword">Confirm Password</label>
                                                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required>
                                                </div>

                                                <button type="submit" class="btn btn-primary">Sign Up</button>
                                            </form>
                                        </div>
                                        <div class="text-center">
                                            <p class="mb-0 tex-center account">Already have an account? <a href="/login" class="text-white-50 fw-bold">Login</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>
