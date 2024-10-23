<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>21037621 - Dương Thái Bảo</title>
</head>
<body>
	<c:if test="${ not empty success }">
    	<p style="color: green;"> Thêm thành công! </p>
	</c:if>
	
	<c:if test="${ not empty error }">
    	<p style="color: red;"> Thêm thất bại, lỗi CSDL! </p>
	</c:if>
    <form action="${ pageContext.request.contextPath }/listGV?action=addDT" method="POST">
        <label for="MaDT">Mã đề tài:</label>
        <input type="text" name="MaDT" id="MaDT" required>
        <br>
        <label for="TenDT">Tên đề tài:</label>
        <input type="text" name="TenDT" id="TenDT" required>
        <br>
        <label for="NamDangKy">Năm đăng ký:</label>
        <input type="text" name="NamDangKy" id="NamDangKy">
        <br>
        <label for="MoTa">Mô tả:</label>
        <input type="text" name="MoTa" id="MoTa">
        <br>
        <label for="MaGV">Mã giảng viên:</label>
        <input type="text" name="MaGV" id="MaGV">
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>