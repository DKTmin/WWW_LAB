<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Product Page</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css"
          integrity="sha512-SbiR/eusphKoMVVXysTKG/7VseWii+Y3FdHrt0EpKgpToZeemhqHeZeLWLhJutz/2ut2Vw1uQEj2MbRF+TVBUA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 800vh;
        }

        .table_center {
            margin-left: auto;
            margin-right: auto;
            width: 80%
        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato; padding-left: 100px">
        <div class="navbar-brand">
            <a href="<%=request.getContextPath()%>" class="nav-link">DIEN THOAI</a>
        </div>
    </nav>
</header>
<div class="row">
    <div class="container">
        <h3 class="text-center">List of DienThoai</h3>
        <hr>
        <br>
        <table class="table table-striped table_center">
            <thead class="alert alert-info">
            <tr>
                <th>Ma</th>
                <th>Ten</th>
                <th>NamSanXuat</th>
                <th>CauHinh</th>
<%--                <th>NhaCungCap</th>--%>
                <th>HinhAnh</th>

            </tr>
            </thead>
            <c:forEach var="dt" items="${dienthoais}">
                <tr>
                    <td>${dt.maDT}</td>
                    <td>${dt.tenDT}</td>
                    <td>${dt.namSanXuat}</td>
                    <td>${dt.cauHinh}</td>
<%--                    <td>${dt.nhaCungCap}</td>--%>
                    <td>
                        <img src="${pageContext.request.contextPath}/images/${dt.hinhAnh}" width="120">
                    </td>
                </tr>
            </c:forEach>

        </table>
        <br>
        <h6 class="text-center">
            <a href="${pageContext.request.contextPath }/nhacungcaps">Quay về trang Nhà Cung Cấp</a></h6>
    </div>
</div>
</body>
</html>