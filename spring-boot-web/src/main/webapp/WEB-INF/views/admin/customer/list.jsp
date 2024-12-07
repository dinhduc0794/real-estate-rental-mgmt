<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
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
    <title>Danh sách khách hàng</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="<c:url value="/admin/home"/>" style="text-decoration: none">
                        Trang chủ
                    </a>
                </li>
                <li class="active">
                    Danh sách khách hàng
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="page-header">
                <h1 style="font-weight: bold;">
                    Danh sách khách hàng
                </h1>
            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">
                    <div class="widget-box">
                        <div class="widget-header">
                            <h4 class="widget-title">Tìm kiếm khách hàng</h4>

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
                                <%--the form cua spring framework--%>
                                <form:form id="listForm" modelAttribute="modelSearch" action="/admin/customer-list" method="GET">
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <label>Tên khách hàng </label><br>
                                                <form:input class="form-control" type="text" path="fullname" placeholder="Nhập tên..."/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <label>Di động</label><br>
                                                <form:input class="form-control" type="text" path="phone" placeholder="Nhập số điện thoại..."/>
                                            </div>

                                            <div class="col-xs-6">
                                                <label>Email</label><br>
                                                <form:input class="form-control" type="text" path="email" placeholder="Nhập địa chỉ email..."/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <security:authorize access="hasRole('MANAGER')">
                                                <div class="col-xs-6">
                                                    <div>
                                                        <label>Tình trạng</label>
                                                        <form:select path="status" class="form-control">
                                                            <form:option value="" label="---Chọn tình trạng---"/>
                                                            <form:options items="${statusCode}"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </security:authorize>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <security:authorize access="hasRole('MANAGER')">
                                                <div class="col-xs-6">
                                                    <div>
                                                        <label>Nhân viên quản lí</label>
                                                        <form:select path="staffId" class="form-control">
                                                            <form:option value="" label="---Chọn nhân viên---"/>
                                                            <form:options items="${staffList}"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </security:authorize>

                                            <security:authorize access="hasRole('MANAGER')">
                                                <div class="col-xs-6">
                                                    <div>
                                                        <label>Nhân viên thêm khách hàng</label>
                                                        <form:select path="createdBy" class="form-control">
                                                            <form:option value="" label="---Chọn nhân viên---"/>
                                                            <form:options items="${staffsUsername}"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </security:authorize>
                                        </div>
                                    </div>



                                    <div class="form-group" style="margin-top: 32px">
                                        <div class="col-xs-12 center">
                                            <button class="btn btn-primary" id="btnSearchCustomer" type="button">
                                                <i class="ace-icon glyphicon glyphicon-search"></i>
                                                Tìm kiếm
                                            </button>
                                            <button type="button" class="btn btn-danger" id="clearForm" style="padding: 8px">
                                                <i class="ace-icon glyphicon glyphicon-trash"></i>
                                                Hoàn tác
                                            </button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>

                    <div class="hr hr-25 dotted hr-double" style="margin: 24px 0"></div>

                    <div class="pull-right" style="margin-bottom: -24px">
                        <a href="/admin/customer-edit">
                            <button class="btn btn-app btn-primary btn-sm" title="Thêm khách hàng">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill-add" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0m-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                                    <path d="M2 13c0 1 1 1 1 1h5.256A4.5 4.5 0 0 1 8 12.5a4.5 4.5 0 0 1 1.544-3.393Q8.844 9.002 8 9c-5 0-6 3-6 4"/>
                                </svg>
                            </button>
                        </a>
                        <security:authorize access="hasRole('MANAGER')">
                            <button class="btn btn-app btn-danger btn-sm" title="Xóa khách hàng" id="btnDeleteBuildings">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill-dash" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1m0-7a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                                    <path d="M2 13c0 1 1 1 1 1h5.256A4.5 4.5 0 0 1 8 12.5a4.5 4.5 0 0 1 1.544-3.393Q8.844 9.002 8 9c-5 0-6 3-6 4"/>
                                </svg>
                            </button>
                        </security:authorize>
                    </div>
                </div>
            </div>

            <div class="table-responsive">
                <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                               requestURI="${formUrl}" partialList="true" sort="external"
                               size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                               id="tableList" pagesize="${model.maxPageItems}"
                               export="false"
                               class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                               style="margin: 3em 0 1.5em;">
                    <security:authorize access="hasRole('MANAGER')">
                        <display:column title="<fieldset class='form-group' style='display: block; margin: 0' >
                                                       <input type='checkbox' id='checkAll' class='check-box-element'>
                                                   </fieldset>"
                                        class="center select-cell"
                                        headerClass="center select-cell">
                            <fieldset class="no-select">
                                <input type="checkbox" name="checkList" value="${tableList.id}"
                                       id="checkbox_${tableList.id}" class="check-box-element"/>
                            </fieldset>
                        </display:column>
                    </security:authorize>


                    <display:column property="fullname" title="Tên khách hàng" headerClass="center"/>
                    <display:column property="phone" title="Di động" headerClass="center"/>
                    <display:column property="email" title="Email" headerClass="center"/>
                    <display:column property="demand" title="Nhu cầu" headerClass="center"/>
                    <display:column property="createdBy" title="Người thêm" headerClass="center"/>
                    <display:column property="createdDate" title="Ngày thêm" headerClass="center"/>
                    <display:column property="status" title="Tình trạng" headerClass="center"/>
                    <display:column title="Thao tác" headerClass="center" style="width: 8%;">
                        <div class="hidden-sm hidden-xs center" style="font-size: 4px">
                            <security:authorize access="hasRole('MANAGER')">
                                <button class="btn btn-xs btn-success" title="Giao khách hàng này" type="button" style="margin: 0 1px"
                                        onclick="assignCustomer(${tableList.id})" name="customerId">
                                    <i class="ace-icon fa fa-key bigger-120"></i>
                                </button>
                            </security:authorize>

                            <a href="/admin/customer-edit-${tableList.id}">
                                <button class="btn btn-xs btn-info" title="Sửa khách hàng này" type="button" style="margin: 0 1px">
                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                </button>
                            </a>

                            <security:authorize access="hasRole('MANAGER')">
                                <button class="btn btn-xs btn-danger" title="Xóa khách hàng này" onclick="deleteCustomer(${tableList.id})" type="button" style="margin: 0 1px">
                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                </button>
                            </security:authorize>
                        </div>
                    </display:column>
                </display:table>
            </div>
        </div>
    </div><!-- /.page-content -->
</div>

<div class="modal fade" id="assignCustomerModel">
    <div class="modal-dialog" style=" height: 100%; width: 100%; display: flex; justify-content: center; align-items: center;">
        <div class="modal-content" style="min-width: 50%">
            <div class="modal-header">
                <h4 class="modal-title bolder blue" id="exampleModalLabel">Danh sách nhân viên</h4>
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
                    </tbody>
                </table>
                <input type="hidden" id="customerId" value="">
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btnAssignCustomer">Giao khách hàng</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

<script>
    // Xoa toan bo noi dung form
    document.getElementById('clearForm').addEventListener('click', function () {
        // Lấy tất cả các input và select trong form
        const inputs = document.querySelectorAll('#listForm input, #listForm select');

        // Xóa giá trị của các input và select
        inputs.forEach(input => {
            if (input.type === 'text' || input.type === 'number') {
                input.value = '';
            } else if (input.tagName === 'SELECT') {
                input.selectedIndex = 0;
            }
        });
    });


    // Check all checkboxes in table
    document.addEventListener("DOMContentLoaded", function() {
        const mainCheckbox = document.querySelector("#tableList thead input[type='checkbox']");
        const bodyCheckboxes = document.querySelectorAll("#tableList tbody input[type='checkbox']");

        mainCheckbox.addEventListener("change", function() {
            bodyCheckboxes.forEach(checkbox => {
                checkbox.checked = mainCheckbox.checked;
            });
        });
    });

    function assignCustomer(customerId){
        console.log(customerId);
        $("#assignCustomerModel").modal();
        $('#customerId').val(customerId);
        loadStaffs(customerId);
    }

    function loadStaffs(customerId) {
        $.ajax({
            url: "/api/customers/" + customerId + "/staffs",  //bỏ http://localhost:8081 vì port do TOMCAT quyết định -> tránh lỗi CORS
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
                    row += '<td class="center">' + item.userName + '</td>'
                    row += '</tr>'
                })
                $('#staffList tbody').html(row);
                // alert(response.message);
            },
            error: function (response) {
                console.log("Error");
                alert(response.message);
            }
        });
    }

    $('#btnAssignCustomer').click(function (e){
        e.preventDefault();
        var data = {};
        data["id"] = $('#customerId').val();
        var staffIds = $("#staffList").find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        data['staffIds'] = staffIds;
        if(data != ''){
            updateAssignmentCustomer(data);
        }
    })
    function updateAssignmentCustomer(data){
        $.ajax({
            type: "POST",
            url: "/api/customers/assignment",
            type: "PUT",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "JSON",
            success: function (response) {
                console.log("Success");
                alert(response.message);
            },
            error: function (response) {
                console.log("Error");
                alert(response.message);
            }
        });
    }


    $('#btnSearchCustomer').click(function (e){
        e.preventDefault();
        $('#listForm').submit();
    })

    function deleteCustomer(id){
        var customerId = [id];
        $('#deleteConfirmModal').modal('show');
        $('#deleteBtn').click(function() {
            deleteCustomers(customerId);
        });
    }
    $('#deleteCustomersBtn').click(function (e){
        e.preventDefault();
        var customerIds = $('#tableList').find('tbody input[type = checkbox]:checked').map(function (){
            return $(this).val();
        }).get();
        $('#deleteConfirmModal').modal('show');
        $('#deleteBtn').click(function() {
            deleteCustomers(customerIds);
        });
    })
    function deleteCustomers(data){
        $.ajax({
            type: "POST",
            url: "${customerAPI}/" + data,
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "JSON",
            success: function (respond) {
                window.location.href = "<c:url value='/admin/customer-list'/>";
            },
            error: function (respond){
                customAlert("Xóa khách hàng thất bại", function() {
                    window.location.href = "<c:url value='/admin/customer-list'/>";
                });
            }
        });
    }
</script>
</body>
</html>