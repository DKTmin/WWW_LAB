<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách Nhà Cung Cấp</title>
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
            <a href="<%=request.getContextPath()%>" class="nav-link">NHA CUNG CAP</a>
        </div>
    </nav>
</header>

<div class="row">
    <div class="container">
        <h3>List of Nhà Cung Cấp</h3>
        <hr>
        <table>
            <thead>
            <tr>
                <th>Mã</th>
                <th>Tên</th>
                <th>Địa Chỉ</th>
                <th>Số Điện Thoại</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="nhacungcap" items="${nhacungcap}">
                <tr>
                    <td>${nhacungcap.maNCC}</td>
                    <td>${nhacungcap.tenNhaCC}</td>
                    <td>${nhacungcap.diaChi}</td>
                    <td>${nhacungcap.soDienThoai}</td>
                    <td>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
