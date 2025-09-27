<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách Dien Thoai</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }

        header nav div {
            background-color: #007bff;
            padding: 10px;
        }

        .nav-link {
            color: white;
            text-decoration: none;
            font-weight: bold;
            font-size: 18px;
        }

        .container {
            background-color: white;
            padding: 20px;
            border-radius: 6px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h3 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

    </style>
</head>
<body>
<header>
    <nav>
        <div>
            <a href="<%=request.getContextPath()%>" class="nav-link">DIEN THOAI</a>
        </div>
    </nav>
</header>

<div class="row">
    <div class="container">
        <h3>List of DienThoai</h3>
        <hr>
        <table>
            <thead>
            <tr>
                <th>Mã</th>
                <th>Tên</th>
                <th>Nam san xuat</th>
                <th>Cau Hinh</th>
                <th>Hinh Anh</th>
                <th>Nha Cung Cap</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="dt" items="${dienthoai}">
                <tr>
                    <td>${dt.maDT}</td>
                    <td>${dt.tenDT}</td>
                    <td>${dt.namSanXuat}</td>
                    <td>${dt.cauHinh}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/images/${dt.hinhAnh}">
                    </td>
                    <td>${dt.nhaCungCap.maNCC}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
