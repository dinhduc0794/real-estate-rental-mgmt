<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dinhduc0794
  Date: 15/10/2024
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Danh sách tòa nhà</title>
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
                    <li class="active">Danh sách tòa nhà</li>
                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1 style="font-weight: bold;">
                        Danh sách tòa nhà
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">Tìm kiếm tòa nhà</h4>

                                <span class="widget-toolbar">
										<a href="#" data-action="reload" class="white">
											<i class="ace-icon fa fa-refresh"></i>
										</a>

										<a href="#" data-action="collapse" class="white">
											<i class="ace-icon fa fa-chevron-up"></i>
										</a>
									</span>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    <form:form id="listForm" action="/admin/building-list" modelAttribute="modelSearch" method="GET">
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-xs-6">
                                                    <div>
                                                        <label>Tên tòa nhà</label>
<%--                                                        <input type="text" name="name" class="form-control" value="${modelSearch.name}">--%>
                                                        <form:input class="form-control" path="name" placeholder="Nhập tên..."/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-6">
                                                    <div>
                                                        <label>Diện tích sàn</label>
<%--                                                        <input type="number" name="floorArea" class="form-control" value="${modelSearch.floorArea}">--%>
                                                        <form:input class="form-control" path="floorArea" placeholder="Nhập diện tích sàn..."/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-xs-2">
                                                    <div>
                                                        <label>Quận</label>
                                                        <form:select path="district" class="form-control">
                                                            <form:option value="" label="---Chọn quận---"/>
                                                            <form:options items="${district}"/>
                                                        </form:select>
<%--                                                        <select name="district" class="form-control">--%>
<%--                                                            <option value="">---Chọn quận---</option>--%>
<%--                                                            <option value="Q1">Quận 1</option>--%>
<%--                                                            <option value="Q2">Quận 2</option>--%>
<%--                                                            <option value="Q3">Quận 3</option>--%>
<%--                                                            <option value="TĐ">Quận Thủ Đức</option>--%>
<%--                                                        </select>--%>
                                                    </div>
                                                </div>
                                                <div class="col-xs-5">
                                                    <div>
                                                        <label>Phường</label>
<%--                                                        <input type="text" name="ward" class="form-control" value="${modelSearch.ward}">--%>
                                                        <form:input class="form-control" path="ward" placeholder="Nhập phường..."/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-5">
                                                    <div>
                                                        <label>Đường</label>
<%--                                                        <input type="text" name="street" class="form-control" value="${modelSearch.street}">--%>
                                                        <form:input class="form-control" path="street" placeholder="Nhập đường..."/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label>Số tầng hầm</label>
<%--                                                        <input type="number" name="numberOfBasement" class="form-control" value="${modelSearch.numberOfBasement}">--%>
                                                        <form:input class="form-control" path="numberOfBasement" placeholder="Nhập số tầng hầm..."/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label>Hướng</label>
<%--                                                        <input type="text" name="direction" class="form-control" value="${modelSearch.direction}">--%>
                                                        <form:input class="form-control" path="direction" placeholder="Nhập hướng..."/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label>Hạng</label>
<%--                                                        <input type="number" name="level" class="form-control" value="${modelSearch.level}">--%>
                                                        <form:input class="form-control" path="level" placeholder="Nhập hạng..."/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-xs-3">
                                                    <div>
                                                        <label>Diện tích từ</label>
<%--                                                        <input type="number" name="rentAreaFrom" class="form-control" value="${modelSearch.rentAreaFrom}">--%>
                                                        <form:input class="form-control" path="rentAreaFrom" placeholder="Nhập diện tích thuê tối thiểu..."/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div>
                                                        <label>Diện tích đến</label>
<%--                                                        <input type="number" name="rentAreaTo" class="form-control" value="${modelSearch.rentAreaTo}">--%>
                                                        <form:input class="form-control" path="rentAreaTo" placeholder="Nhập diện tích thuê tối đa..."/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div>
                                                        <label>Giá thuê từ</label>
<%--                                                        <input type="number" name="rentPriceFrom" class="form-control" value="${modelSearch.rentPriceFrom}">--%>
                                                        <form:input class="form-control" path="rentPriceFrom" placeholder="Nhập giá thuê tối thiểu..."/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div>
                                                        <label>Giá thuê đến</label>
<%--                                                        <input type="number" name="rentPriceTo" class="form-control" value="${modelSearch.rentPriceTo}">--%>
                                                        <form:input class="form-control" path="rentPriceTo" placeholder="Nhập giá thuê tối đa..."/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label>Tên quản lí</label>
<%--                                                        <input type="text" name="managerName" class="form-control" value="${modelSearch.managerName}">--%>
                                                        <form:input class="form-control" path="managerName" placeholder="Nhập tên quản lí..."/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label>Số điện thoại quản lí</label>
<%--                                                        <input type="text" name="managerPhone" class="form-control" value="${modelSearch.managerPhone}">--%>
                                                        <form:input class="form-control" path="managerPhone" placeholder="Nhập số điện thoại quản lí..."/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label>Nhân viên phụ trách</label>
                                                        <form:select path="staffId" class="form-control">
                                                            <form:option value="" label="---Chọn nhân viên---"/>
                                                            <form:options items="${staffList}"/>
                                                        </form:select>
<%--                                                        <select name="staffId" class="form-control">--%>
<%--                                                            <option value="">---Chọn nhân viên---</option>--%>
<%--                                                            <option value="">Nguyễn Văn A</option>--%>
<%--                                                            <option value="">Trần Minh B</option>--%>
<%--                                                            <option value="">Nguyễn Thị C</option>--%>
<%--                                                            <option value="">Đỗ Văn D</option>--%>
<%--                                                        </select>--%>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-xs-6">
                                                    <label>Loại tòa nhà</label><br>
                                                    <div style="margin-left: -12px">
                                                        <form:checkboxes path="typeCode" items="${rentType}" style="margin: 0 4px 0 14px"/>
                                                    </div>
<%--                                                    <div class="building-type">--%>
<%--                                                        <input type="checkbox" name="typeCode" value="tang-tret">--%>
<%--                                                        <label>Tầng trệt</label>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="building-type">--%>
<%--                                                        <input type="checkbox" name="typeCode" value="nguyen-can">--%>
<%--                                                        <label>Nguyên căn</label>--%>
<%--                                                    </div>--%>
<%--                                                    <div class="building-type">--%>
<%--                                                        <input type="checkbox" name="typeCode" value="noi-that">--%>
<%--                                                        <label>Nội thất</label>--%>
<%--                                                    </div>--%>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12 center">
                                                <button class="btn btn-primary" id="btnSearchBuilding" type="button">
                                                    <i class="ace-icon glyphicon glyphicon-search"></i>
                                                    Tìm kiếm
                                                </button>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>

                        <div class="hr hr-25 dotted hr-double" style="margin: 24px 0"></div>

                        <div class="pull-right" style="margin-bottom: 12px">
                            <a href="/admin/building-edit">
                                <button class="btn btn-app btn-primary btn-sm" title="Thêm tòa nhà">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-building-fill-add" viewBox="0 0 16 16">
                                        <path
                                                d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0" />
                                        <path
                                                d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.5 4.5 0 0 0 12.5 8a4.5 4.5 0 0 0-3.59 1.787A.5.5 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.5 4.5 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z" />
                                    </svg>
                                </button>
                            </a>
                            <button class="btn btn-app btn-danger btn-sm" title="Xóa tòa nhà"
                                    id="btnDeleteBuildings">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-building-fill-x" viewBox="0 0 16 16">
                                    <path
                                            d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.5 4.5 0 0 0 12.5 8a4.5 4.5 0 0 0-3.59 1.787A.5.5 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.5 4.5 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z" />
                                    <path
                                            d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m-.646-4.854.646.647.646-.647a.5.5 0 0 1 .708.708l-.647.646.647.646a.5.5 0 0 1-.708.708l-.646-.647-.646.647a.5.5 0 0 1-.708-.708l.647-.646-.647-.646a.5.5 0 0 1 .708-.708" />
                                </svg>
                            </button>
                        </div>
                    </div>
                </div>



                <table id="buildingList" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th class="center">Tên tòa nhà</th>
                            <th class="center">Địa chỉ</th>
                            <th class="center">Số tầng hầm</th>

                            <th class="center">Tên quản lí</th>
                            <th class="center">SĐT Quản lí</th>

                            <th class="center">Diện tích sàn</th>
                            <th class="center">Diện tích trống</th>
                            <th class="center">Diện tích thuê</th>
                            <th class="center">Giá thuê</th>
                            <th class="center">Phí dịch vụ</th>
                            <th class="center">Phí môi giới</th>
                            <th class="center" style="min-width: 130px">Thao tác</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="item" items="${buildingList}">
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" value=${item.id}>
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>${item.name}</td>
                                <td>${item.address}</td>
                                <td>${item.numberOfBasement}</td>
                                <td>${item.managerName}</td>
                                <td>${item.managerPhone}</td>
                                <td>${item.floorArea}</td>
                                <td>${item.emptyArea}</td>
                                <td>${item.rentArea}</td>
                                <td>${item.rentPrice}</td>
                                <td>${item.serviceFee}</td>
                                <td>${item.brokerageFee}</td>
                                    <td class="center" style="font-size: 4px">
                                        <div class="hidden-sm hidden-xs ">
                                            <button class="btn btn-xs btn-success" title="Giao tòa nhà này" type="button" style="margin: 0 1px"
                                                    onclick="assignBuilding(${item.id})">
                                                <i class="ace-icon fa fa-key bigger-120"></i>
                                            </button>

                                            <a href="/admin/building-edit-${item.id}">
                                                <button class="btn btn-xs btn-info" title="Sửa tòa nhà này" type="button" style="margin: 0 1px">
                                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                </button>
                                            </a>

                                            <button class="btn btn-xs btn-danger" title="Xóa tòa nhà này" onclick="deleteOneBuilding(${item.id})" type="button" style="margin: 0 1px">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>
                                        </div>
                                    </td>
                            </tr>
                            <c:if test="${item == null}">
                                <tr>
                                    <td colspan="13" style="color:red;">Item is null</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
</div><!-- /.main-container -->

<div class="modal fade" id="assignBuildingModel">
    <div class="modal-dialog" style=" height: 100%; width: 100%; display: flex; justify-content: center; align-items: center;">
        <div class="modal-content" style="min-width: 50%">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Danh sách nhân viên</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"
                        style="position: absolute; top: 0; right: 0; padding: 12px;">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table id="staffList" class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="center">Chọn</th>
                        <th class="center">Tên nhân viên</th>
                    </tr>
                    </thead>

                    <tbody>
<%--                    <tr class="center">--%>
<%--                        <td class="center">--%>
<%--&lt;%&ndash;                            <label class="pos-rel">&ndash;%&gt;--%>
<%--                                <input type="checkbox" value="1">--%>
<%--&lt;%&ndash;                            </label>&ndash;%&gt;--%>
<%--                        </td>--%>
<%--                        <td class="center">Nguyễn Văn A</td>--%>
<%--                    </tr>--%>
<%--                    <tr class="center">--%>
<%--                        <td class="center">--%>
<%--&lt;%&ndash;                            <label class="pos-rel">&ndash;%&gt;--%>
<%--                                <input type="checkbox" value="2">--%>
<%--&lt;%&ndash;                            </label>&ndash;%&gt;--%>
<%--                        </td>--%>
<%--                        <td class="center">Nguyễn Minh B</td>--%>
<%--                    </tr>--%>
                    </tbody>
                </table>
                <input type="hidden" id="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btnAssignBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

<script>
    function assignBuilding(buildingId) {
        console.log(buildingId);
        $("#assignBuildingModel").modal();
        $('#buildingId').val(buildingId);
        loadStaffs(buildingId);
    }

    function loadStaffs(buildingId) {
        $.ajax({
            url: "/api/buildings/" + buildingId,  //bỏ http://localhost:8081 vì port do TOMCAT quyết định -> tránh lỗi CORS
            type: "GET",
            // data: JSON.stringify(json),   //convert object json thanh kieu du lieu JSON //data: kieu du lieu client gui xuong cho server
            contentType: "application/json",    //contentType: kieu content client gui xuong cho server
            dataType: "json",      //client yeu cau server tra json (mong muon)
            success: function (response) {
                var row = '';
                $.each(response.data, function (index, item) {
                    row += '<tr class="center">'
                    row += '<td class="center"> <input type="checkbox" value=' + item.staffId
                            + ' id=checkbox_' + item.staffId
                            + ' ' + item.checked
                            + "> </td>"
                    row += '<td>' + item.userName + '</td>'
                    row += '</tr>'
                })
                $('#staffList tbody').html(row);
                alert(response.message);
            },
            error: function (responnse) {
                console.log("Error");
                alert(responnse.message);
            }
        });
    }

    $('#btnAssignBuilding').click(function (e){
        e.preventDefault();
        var json = {};
        json['id'] = $('#buildingId').val();
        var staffIds = $("#staffList").find("tbody input[type=checkbox]:checked").map(function () {
            return $(this).val();
        }).get();
        json['staffIds'] = staffIds;
        if (json != '') {
            updateAssignmentBuilding(json);
        }
    });

    function updateAssignmentBuilding() {
        $.ajax({
            url: "/api/buildings/staffs",  //bỏ http://localhost:8081 vì port do TOMCAT quyết định -> tránh lỗi CORS
            type: "PUT",
            data: JSON.stringify(json),   //convert object json thanh kieu du lieu JSON //data: kieu du lieu client gui xuong cho server
            contentType: "application/json",    //contentType: kieu content client gui xuong cho server
            dataType: "text",      //client yeu cau server tra json (mong muon)
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

    $("#btnDeleteBuildings").click(function (e) {
        e.preventDefault();
        // tu buildingList tim ben trong cac the input type checkbox dc check (checked)
        var buildingIds = $("#buildingList").find("tbody input[type=checkbox]:checked").map(function () {
            return $(this).val();
        }).get();
        console.log("OK");
        if (buildingIds.length == 0) {
            alert("Chưa chọn tòa nhà để xóa");
        }
        else {
            btnDeleteBuilding(buildingIds);
        }
    });

    function deleteOneBuilding(buildingId) {
        btnDeleteBuilding(buildingId);
    }

    function btnDeleteBuilding(ids) {
        $.ajax({
            url: "/api/buildings/" + ids,  //bỏ http://localhost:8081 vì port do TOMCAT quyết định -> tránh lỗi CORS
            type: "DELETE",
            // data: JSON.stringify(json),   //convert object json thanh kieu du lieu JSON //data: kieu du lieu client gui xuong cho server
            // contentType: "application/json",    //contentType: kieu content client gui xuong cho server
            dataType: "text",      //client yeu cau server tra json (mong muon)
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

    $('#btnSearchBuilding').click(function (e) {
       e.preventDefault();
       $('#listForm').submit();
    });
</script>
</body>
</html>
