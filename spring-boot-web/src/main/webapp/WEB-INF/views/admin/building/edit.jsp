<%--
  Created by IntelliJ IDEA.
  User: dinhduc0794
  Date: 15/10/2024
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Thông tin tòa nhà</title>
</head>
<body>
<div class="main-content">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="active">Thông tin tòa nhà</li>
                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">


                <div class="page-header">
                    <h1 style="font-weight: bold;">
                        Thông tin tòa nhà
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <form:form method="GET" modelAttribute="buildingEdit" id="form-edit">
<%--                            <input type="hidden" name="id" value="${buildingEdit.id}">--%>
                            <form:hidden path="id"/>
                            <div class="form-group">
                                <label class="col-xs-3">Tên tòa nhà</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="name"/>
<%--                                    <input type="text" name="name" id="name" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Quận</label>
                                <div class="col-xs-3">
                                    <form:select path="district" class="form-control">
                                        <form:option value="" label="---Chọn quận---"/>
                                        <form:options items="${district}"/>
                                    </form:select>
<%--                                    <select name="districtId" id="districtId" class="form-control">--%>
<%--                                        <option value="">---Chọn Quận---</option>--%>
<%--                                        <option value="Q1">Quận 1</option>--%>
<%--                                        <option value="Q2">Quận 2</option>--%>
<%--                                        <option value="Q3">Quận 3</option>--%>
<%--                                        <option value="GV">Quận Gò Vấp</option>--%>
<%--                                    </select>--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Phường</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="ward"/>
<%--                                    <input type="text" name="ward" id="ward" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Đường</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="street"/>
<%--                                    <input type="text" name="street" id="street" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Kết cấu</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="structure"/>
<%--                                    <input type="text" name="structure" id="structure" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Số tầng hầm</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="numberOfBasement"/>
<%--                                    <input type="number" name="numberOfBasement" id="numberOfBasement"--%>
<%--                                           class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Diện tích sàn</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="floorArea"/>
<%--                                    <input type="number" name="floorArea" id="floorArea" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Hướng</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="direction"/>
<%--                                    <input type="text" name="direction" id="direction" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Hạng</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="level"/>
<%--                                    <input type="number" name="level" id="level" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Diện tích thuê</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="rentArea"/>
<%--                                    <input type="number" name="rentArea" id="rentArea" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Giá thuê</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="rentPrice"/>
<%--                                    <input type="number" name="rentPrice" id="rentPrice" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Mô tả giá</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="rentPriceDescription"/>
<%--                                    <input type="text" name="description" id="description" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Phí dịch vụ</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="serviceFee"/>
<%--                                    <input type="number" name="serviceFee" id="serviceFee" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Phí ô tô</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="carFee"/>
<%--                                    <input type="number" name="carFee" id="carFee" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Phí mô tô</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="motoFee"/>
<%--                                    <input type="number" name="motorFee" id="motorFee" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Phí ngoài giờ</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="overtimeFee"/>
<%--                                    <input type="number" name="overtimeFee" id="overtimeFee" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Tiền điện</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="electricityFee"/>
<%--                                    <input type="number" name="electricityBill" id="electricityBill"--%>
<%--                                           class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Đặt cọc</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="deposit"/>
<%--                                    <input type="number" name="deposit" id="deposit" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Thanh toán</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="payment"/>
<%--                                    <input type="number" name="payment" id="payment" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Thời hạn thuê</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="rentTime"/>
<%--                                    <input type="text" name="duration" id="duration" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Thời gian trang trí</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="decorationTime"/>
<%--                                    <input type="text" name="decorationTime" id="decorationTime"--%>
<%--                                           class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Tên quản lí</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="managerName"/>
<%--                                    <input type="text" name="managerName" id="managerName" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Số điện thoại quản lí</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="managerPhone"/>
<%--                                    <input type="text" name="managerPhoneNumber" id="managerPhoneNumber"--%>
<%--                                           class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Phí môi giới</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="brokerageFee"/>
<%--                                    <input type="number" name="brokerageFee" id="brokerageFee" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Loại tòa nhà</label>
                                <div class="col-xs-9">
                                    <div style="margin-left: -12px">
                                        <form:checkboxes path="typeCodes" items="${rentType}" style="margin: 0 4px 0 14px"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-3">Ghi chú</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="note"/>
<%--                                    <input type="text" name="note" id="note" class="form-control">--%>
                                </div>
                            </div>

                            <div class="form-group" style="margin-top: 48px;">
                                <label class="col-xs-3"></label>
                                <div class="col-xs-9">
                                    <c:if test="${not empty buildingEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Sửa thông tin</button>
                                    </c:if>
                                    <c:if test="${empty buildingEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Thêm tòa nhà</button>
                                    </c:if>
                                    <a href="/admin/building-list">
                                        <button type="button" class="btn btn-warning">
                                            Hủy thao tác
                                        </button>
                                    </a>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
</div><!-- /.main-container -->

<script>
    $("#btnAddOrUpdateBuilding").click(function () {
        var formDataArr = $("#form-edit").serializeArray();
        var json = {};
        var typeCodes = [];
        $.each(formDataArr, function(i, v) {
            if (v.name == 'typeCode'){
                typeCodes.push(v.value);
            }
            else
                json["" + v.name + ""] = v.value;	// convert v.name toString
        });
        json['typeCode'] = typeCodes;
        if (typeCodes.length ==0) {
            alert("Type Code is a not-null field!");
        }
        else btnAddOrUpdateBuilding(json);
    });

    function btnAddOrUpdateBuilding(json) {
        $.ajax({
            url: "/api/buildings",  //bỏ http://localhost:8081 vì port do TOMCAT quyết định -> tránh lỗi CORS
            type: "POST",
            data: JSON.stringify(json),   //convert object json thanh kieu du lieu JSON //data: kieu du lieu client gui xuong cho server
            contentType: "application/json",    //contentType: kieu content client gui xuong cho server
            // dataType: client yeu cau server tra json (mong muon)
            success: function (responnse) {
                console.log("Success");
                alert(responnse.message);
            },
            error: function (responnse) {
                console.log("Error");
                alert(responnse.message);
            }
        });
    }
</script>
</body>
</html>
