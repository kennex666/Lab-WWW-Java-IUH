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
    <form action="${ pageContext.request.contextPath }/listGV?action=addGV" method="POST">
        <label for="facultyID">Faculty ID:</label>
        <input type="text" name="facultyID" id="facultyID" required>
        <br>
        <label for="fullName">Full name:</label>
        <input type="text" name="fullName" id="fullName" required>
        <br>
        <label for="researchArea">Research area:</label>
        <input type="text" name="researchArea" id="researchArea">
        <br>
        <label for="phoneNumber">Phone number:</label>
        <input type="text" name="phoneNumber" id="phoneNumber">
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>