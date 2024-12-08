<%--
  Created by IntelliJ IDEA.
  User: dinhduc0794
  Date: 15/10/2024
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Thêm khách hàng</title>
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
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Thông tin tòa nhà</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1 style="font-weight: bold;">
                    Thông tin khách hàng
                </h1>
            </div><!-- /.page-header -->
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form method="GET" modelAttribute="customerEdit" id="form-edit">
                        <form:hidden path="id"/>
                        <div class="form-group">
                            <label class="col-xs-3">Tên khách hàng</label>
                            <div class="col-xs-9">
                                <form:input class="form-control" path="fullname"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Số điện thoại</label>
                            <div class="col-xs-9">
                                <form:input class="form-control" path="phone"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Email</label>
                            <div class="col-xs-9">
                                <form:input class="form-control" path="email"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Tên công ty</label>
                            <div class="col-xs-9">
                                <form:input class="form-control" path="companyName"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Nhu cầu</label>
                            <div class="col-xs-9">
                                <form:input class="form-control" path="demand"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Trạng thái xử lý</label>
                            <div class="col-xs-3">
                                <form:select path="status" class="form-control">
                                    <form:options items="${statusCode}"/>
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 48px;">
                            <label class="col-xs-3"></label>
                            <div class="col-xs-9">
                                <c:if test="${not empty customerEdit.id}">
                                    <button type="button" class="btn btn-primary" id="btnAddOrUpdateCustomer">Sửa thông tin</button>
                                </c:if>
                                <c:if test="${empty customerEdit.id}">
                                    <button type="button" class="btn btn-primary" id="btnAddOrUpdateCustomer">Thêm khách hàng</button>
                                </c:if>
                                <a href="/admin/customer-list">
                                    <button type="button" class="btn btn-warning">
                                        Hủy thao tác
                                    </button>
                                </a>
                            </div>
                        </div>
                    </form:form>
                    <div class="hr hr-18 dotted hr-double"></div>
                </div><!-- /.col -->
            </div>
            <c:if test="${not empty customerEdit.id}">
                <c:forEach var="item" items="${transactionType}">
                    <div class="col-xs-12">
                        <h2 class="smaller lighter blue" >
                                ${item.value}
                            <button class="btn btn-md btn-success pull-right" title="Thêm giao dịch"
                                    onclick="addTransaction('${item.key}', ${customerEdit.id})">
                                <i class="ace-icon glyphicon glyphicon-plus smaller-80"></i>Thêm giao dịch
                            </button>
                        </h2>
                        <div class="hr hr-16 dotted hr-dotted"></div>
                    </div>
                    <c:if test="${item.key == 'CSKH'}">
                        <div class="col-xs-12" style="margin-bottom: 24px">
                            <table id="tableList-CSKH" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr class="center">
                                    <th class="center">Ngày tạo</th>
                                    <th class="center">Người tạo</th>
                                    <th class="center">Ngày sửa</th>
                                    <th class="center">Người sửa</th>
                                    <th class="center">Chi tiết giao dịch</th>
                                    <th class="center">Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="transaction" items="${CSKH}">
                                    <tr class="center">
                                        <td>${transaction.createdDate}</td>
                                        <td>${transaction.createdBy}</td>
                                        <td>${transaction.modifiedDate}</td>
                                        <td>${transaction.modifiedBy}</td>
                                        <td>${transaction.note}</td>
                                        <td class="center">
                                            <div class="hidden-sm hidden-xs center" style="font-size: 4px">
                                                <button class="btn btn-sm btn-info"
                                                        title="Chỉnh sửa giao dịch" type="button"
                                                        onclick="updateTransaction('CSKH', ${customerEdit.id}, ${transaction.id})"
                                                        style="margin: 0 1px; ">
                                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                </button>

                                                <security:authorize access="hasRole('MANAGER')">
                                                    <button class="btn btn-sm btn-danger"
                                                            title="Xóa giao dịch" type="button"
                                                            onclick="deleteTransaction('CSKH', ${customerEdit.id}, ${transaction.id})"
                                                            style="margin: 0 1px">
                                                        <i class="ace-icon glyphicon glyphicon-trash"></i>
                                                    </button>
                                                </security:authorize>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>

                    <c:if test="${item.key == 'DDX'}">
                        <div class="col-xs-12">
                            <table id="tableList-DDX" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr class="center">
                                    <th class="center">Ngày tạo</th>
                                    <th class="center">Người tạo</th>
                                    <th class="center">Ngày sửa</th>
                                    <th class="center">Người sửa</th>
                                    <th class="center">Chi tiết giao dịch</th>
                                    <th class="center">Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>
                                    <%--duyet tat ca cac toa nha duoc tra ra tu controler--%>
                                <c:forEach var="transaction" items="${DDX}">
                                    <tr>
                                        <td>${transaction.createdDate}</td>
                                        <td>${transaction.createdBy}</td>
                                        <td>${transaction.modifiedDate}</td>
                                        <td>${transaction.modifiedBy}</td>
                                        <td>${transaction.note}</td>
                                        <td class="center">
                                            <div class="hidden-sm hidden-xs center" style="font-size: 4px">
                                                <button class="btn btn-sm btn-info"
                                                        title="Chỉnh sửa giao dịch" type="button"
                                                        onclick="updateTransaction('CSKH', ${customerEdit.id}, ${transaction.id})"
                                                        style="margin: 0 1px; ">
                                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                </button>

                                                <security:authorize access="hasRole('MANAGER')">
                                                    <button class="btn btn-sm btn-danger"
                                                            title="Xóa giao dịch" type="button"
                                                            onclick="deleteTransaction('CSKH', ${customerEdit.id}, ${transaction.id})"
                                                            style="margin: 0 1px">
                                                        <i class="ace-icon glyphicon glyphicon-trash"></i>
                                                    </button>
                                                </security:authorize>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </c:forEach>
            </c:if>
        </div><!-- /.page-content -->

    </div>
</div>

<div class="modal fade" id="addOrUpdateTransactionModal">
    <div class="modal-dialog" style=" height: 100%; width: 100%; display: flex; justify-content: center; align-items: center;">
        <div class="modal-content" style="min-width: 50%">
            <div class="modal-header">
                <h4 class="modal-title bolder blue" id="exampleModalLabel">Nhập thông tin giao dịch</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"
                        style="position: absolute; top: 0; right: 0; padding: 12px;">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group" style="padding: 20px">
                    <label class="col-sm-3 control-label no-padding-right"> Chi tiết giao dịch </label>
                    <div class="col-sm-9" style="padding: 5px; border: solid #aaa 1px">
                        <input id="note" value="" style="width: 100%; border: none"/>
                    </div>

                </div>
                <input type="hidden" id="customerId" value=""/>
                <input type="hidden" id="code" value=""/>
                <input type="hidden" id="transactionId" value=""/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btnAddOrUpdateTransaction">Xác nhận</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

    <script>
        function addTransaction(code, customerId){
            $('#addOrUpdateTransactionModal').modal();  // show modal
            // reset value
            $('#note').val('');
            $('#customerId').val(customerId);
            $('#code').val(code);
        }
        function updateTransaction(code, customerId, transactionId){
            $('#addOrUpdateTransactionModal').modal();  // show modal
            loadTransaction(transactionId); // load transaction can update
            // set value
            $('#customerId').val(customerId);
            $('#code').val(code);
            $('#transactionId').val(transactionId);
        }

        // load transaction cu can update (by id)
        function loadTransaction(transactionId){
            $.ajax({
                type: "GET",
                url: "/api/transactions/" + transactionId,
                dataType: "JSON",
                success: function(response) {
                    console.log(response);
                    $('#note').val(response['data']);
                },
                error: function(response){
                    console.log("Failed")
                    console.log(response);
                }
            });
        }

        $('#btnAddOrUpdateTransaction').click(function (e){
            e.preventDefault();
            // get data from form
            var data = {};
            data['id'] = $('#transactionId').val();
            data['code'] = $('#code').val();
            data['note'] = $('#note').val().trim();
            data['customerId'] = $('#customerId').val();
            if(data['note'] != ''){ // neu note khac rong thi goi api save
                handleAddOrUpdateTransaction(data);
            }
            else{   // neu note rong thi hien thong bao dien chi tiet giao dich
                $('#note').attr('placeholder', 'Vui lòng điền chi tiết giao dịch');
            }
        });


        function handleAddOrUpdateTransaction(data){
            $.ajax({
                type: "POST",
                url: "/api/transactions",
                data: JSON.stringify(data),
                contentType: "application/json",
                dataType: "JSON",
                success: function (response) {
                    console.log("Success");
                    alert(response.message);
                    location.reload();
                },
                error: function (response) {
                    console.log("Error");
                    alert(response.message);
                }
            });
        }

        // delete transaction
        function deleteTransaction(code, customerId, transactionId){
            $.ajax({
                type: "DELETE",
                url: "/api/transactions/" + transactionId,
                dataType: "JSON",
                success: function(response) {
                    console.log("Success");
                    alert(response.message);
                    location.reload();
                },
                error: function(response) {
                    console.log("Error");
                    alert(response.message);
                }
            });
        }

        // bo sungvalidate form input in client side (da validate o server side)
        $(document).ready(function () {
            $('#btnAddOrUpdateCustomer').click(function () {
                var data = {};
                var formData = $('#form-edit').serializeArray();

                $.each(formData, function (i, v) {
                    data[v.name] = v.value.trim();
                });

                if (data['fullname'] && data['phone'] && data['email']) {
                    addOrUpdateCustomer(data);
                } else {
                    alert("Vui lòng điền đầy đủ thông tin");
                    highlightEmptyFields(data);
                }
            });

            function highlightEmptyFields(data) {
                $('span.error-message').remove(); // Xóa tất cả các thông báo lỗi cũ
                if (!data['fullname']) {
                    $('#fullname').after('<span style="color: red">Tên khách hàng không được để trống</span>');
                }
                if (!data['phone']) {
                    $('#phone').after('<span style="color: red">Số điện thoại khách hàng không được để trống</span>');
                }
                if (!data['email']) {
                    $('#email').after('<span style="color: red">Email khách hàng không được để trống</span>');
                }
            }
        });

        // save customer
        function addOrUpdateCustomer(data){
            //call api
            $.ajax({
                type: "POST",
                url: "/api/customers",
                data: JSON.stringify(data),
                contentType: "application/json",
                dataType: "JSON",
                success: function (response) {
                    console.log("Success");
                    alert(response.message);
                    location.reload();
                },
                error: function (response) {
                    console.log("Error");
                    alert(response.message);
                }
            })
        }
    </script>
</body>
</html>
