<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>

    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <a href="/trang-chu">
                <button class="btn btn-success" style="text-align: center; width: 41px; line-height: 24px; padding: 0; border-width: 4px;" title="Trang chủ">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                        <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5"/>
                    </svg>
                </button>
            </a>

            <a href="/admin/building-list">
                <button class="btn btn-info" style="text-align: center; width: 41px; line-height: 24px; padding: 0; border-width: 4px;" title="Tòa nhà">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-buildings-fill" viewBox="0 0 16 16">
                        <path d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zM2 11h1v1H2zm2 0h1v1H4zm-1 2v1H2v-1zm1 0h1v1H4zm9-10v1h-1V3zM8 5h1v1H8zm1 2v1H8V7zM8 9h1v1H8zm2 0h1v1h-1zm-1 2v1H8v-1zm1 0h1v1h-1zm3-2v1h-1V9zm-1 2h1v1h-1zm-2-4h1v1h-1zm3 0v1h-1V7zm-2-2v1h-1V5zm1 0h1v1h-1z"/>
                    </svg>
                </button>
            </a>

            <a href="/admin/customer-list">
                <button class="btn btn-warning" style="text-align: center; width: 41px; line-height: 24px; padding: 0; border-width: 4px;" title="Khách hàng">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-vcard-fill" viewBox="0 0 16 16">
                        <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm9 1.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4a.5.5 0 0 0-.5.5M9 8a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4A.5.5 0 0 0 9 8m1 2.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 0-1h-3a.5.5 0 0 0-.5.5m-1 2C9 10.567 7.21 9 5 9c-2.086 0-3.8 1.398-3.984 3.181A1 1 0 0 0 2 13h6.96q.04-.245.04-.5M7 6a2 2 0 1 0-4 0 2 2 0 0 0 4 0"/>
                    </svg>
                </button>
            </a>

            <a href="/admin/user-list">
                <button class="btn btn-danger" style="text-align: center; width: 41px; line-height: 24px; padding: 0; border-width: 4px;" title="Tài khoản">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
                        <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5.784 6A2.24 2.24 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.3 6.3 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1zM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5"/>
                    </svg>
                </button>
            </a>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
<%--    <ul class="nav nav-list">--%>
<%--    <li class="">--%>
<%--        <a href="#" class="dropdown-toggle">--%>
<%--            &lt;%&ndash;<i class="menu-icon fa fas fa-users"></i>&ndash;%&gt;--%>
<%--            &lt;%&ndash;<span class="menu-text">QL Tòa Nhà</span>&ndash;%&gt;--%>
<%--            &lt;%&ndash;<b class="arrow fa fa-angle-down"></b>&ndash;%&gt;--%>
<%--            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-fill" viewBox="0 0 16 16">--%>
<%--                <path d="M3 0a1 1 0 0 0-1 1v14a1 1 0 0 0 1 1h3v-3.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5V16h3a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H3Zm1 2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3.5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5ZM4 5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1ZM7.5 5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5Zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1ZM4.5 8h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5Zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3.5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5Z"/>--%>
<%--                <span class="menu-text"> Quản Lý Tòa Nhà</span>--%>
<%--            </svg>--%>
<%--        </a>--%>
<%--        <b class="arrow"></b>--%>
<%--        <ul class="submenu">--%>
<%--            <li class="">--%>
<%--                <a href='<c:url value='/admin/building-list'/>'>--%>
<%--                    <i class="menu-icon fa fa-caret-right"></i>--%>
<%--                    Danh sách tòa nhà--%>
<%--                </a>--%>
<%--                <b class="arrow"></b>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </li>--%>
<%--</ul>--%>
    <ul class="nav nav-list">
        <li class="">
            <a href="/trang-chu">
                <i class="menu-icon">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                        <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5"/>
                    </svg>
                </i>
                <span class="menu-text">Về trang chủ</span>
            </a>
        </li>
    </ul>

    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-buildings-fill" viewBox="0 0 16 16">
                        <path d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zM2 11h1v1H2zm2 0h1v1H4zm-1 2v1H2v-1zm1 0h1v1H4zm9-10v1h-1V3zM8 5h1v1H8zm1 2v1H8V7zM8 9h1v1H8zm2 0h1v1h-1zm-1 2v1H8v-1zm1 0h1v1h-1zm3-2v1h-1V9zm-1 2h1v1h-1zm-2-4h1v1h-1zm3 0v1h-1V7zm-2-2v1h-1V5zm1 0h1v1h-1z"/>
                    </svg>
                </i>
                <span class="menu-text">Quản Lý Tòa Nhà</span>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='/admin/building-list'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách tòa nhà
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-vcard-fill" viewBox="0 0 16 16">
                        <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm9 1.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4a.5.5 0 0 0-.5.5M9 8a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4A.5.5 0 0 0 9 8m1 2.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 0-1h-3a.5.5 0 0 0-.5.5m-1 2C9 10.567 7.21 9 5 9c-2.086 0-3.8 1.398-3.984 3.181A1 1 0 0 0 2 13h6.96q.04-.245.04-.5M7 6a2 2 0 1 0-4 0 2 2 0 0 0 4 0"/>
                    </svg>
                </i>

                <span class="menu-text">Quản Lý Kh.hàng</span>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='/admin/customer-list'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách khách hàng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

    <security:authorize access="hasRole('MANAGER')">
        <ul class="nav nav-list">
            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
                            <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5.784 6A2.24 2.24 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.3 6.3 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1zM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5"/>
                        </svg>
                    </i>
                    <span class="menu-text">Quản Lý Tài Khoản</span>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href='/admin/user-list'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            Danh sách tài khoản
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>
        </ul>
    </security:authorize>
<%--    <ul class="nav nav-list">--%>
<%--        <li class="">--%>
<%--            <a href="#" class="dropdown-toggle">--%>
<%--                <i class="menu-icon">--%>
<%--                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">--%>
<%--                        <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5.784 6A2.24 2.24 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.3 6.3 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1zM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5"/>--%>
<%--                    </svg>--%>
<%--                </i>--%>
<%--                <span class="menu-text">Quản Lý Tài Khoản</span>--%>
<%--            </a>--%>
<%--            <b class="arrow"></b>--%>
<%--            <ul class="submenu">--%>
<%--                <li class="">--%>
<%--                    <a href='/admin/user-list'>--%>
<%--                        <i class="menu-icon fa fa-caret-right"></i>--%>
<%--                        Danh sách tài khoản--%>
<%--                    </a>--%>
<%--                    <b class="arrow"></b>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </li>--%>
<%--    </ul>--%>

<%--    <ul class="nav nav-list">--%>
<%--        <li class="">--%>
<%--            <a href="#" class="dropdown-toggle">--%>
<%--                <i class="menu-icon fa fas fa-users"></i>--%>
<%--                <span class="menu-text">Quản Lý Khách Hàng</span>--%>
<%--            </a>--%>
<%--            <b class="arrow"></b>--%>
<%--            <ul class="submenu">--%>
<%--                <li class="">--%>
<%--                    <a href='/admin/customer-list'>--%>
<%--                        <i class="menu-icon fa fa-caret-right"></i>--%>
<%--                        Danh sách khách hàng--%>
<%--                    </a>--%>
<%--                    <b class="arrow"></b>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </li>--%>
<%--    </ul>--%>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <script type="text/javascript">
        try { ace.settings.check('sidebar', 'collapsed') } catch (e) { }
    </script>
</div>

