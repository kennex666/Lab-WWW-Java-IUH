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
    <style>
        .table {
            width: 80vw;
            margin: 0 auto;
            margin-top: 20px;
            border-collapse: collapse;
            
        }
        .table th, .table td {
            border: 1px solid black;
            padding: 8px;
        }
        .table th {
            text-align: center;
        }
        /* width of child */
            
        .table th:first-child {
            width: 200px;
        }

        
        .table th:nth-child(4) {
            width: 200px;
        }
        
    </style>
    
    <div>
    
    	<div class="table">
    	
	    	<a href="${pageContext.request.contextPath}?action=addGV"> Thêm giảng viên </a>
	    	
	    	<div style="width:12px; display: inline-block"></div>
	    	
	    	<a href="${pageContext.request.contextPath}?action=addDT"> Thêm đề tài </a>
    	</div>
        <table class="table">
            <tr>
                <th>Faculty ID</th>
                <th>Full name</th>
                <th>Research area</th>
                <th>Phone number</th>
            </tr>
            
            <c:forEach var="giangVien" items="${listGiangVien}">
	            <tr>
	                <td>${ giangVien.maGV }</td>
	                <td>${ giangVien.tenGV }<br><i><u>Danh sách để tài:</u></i><br>
	                	<ul>
	                		<c:forEach var="deTai" items="${giangVien.detais}">
	                			<li>${ deTai.tenDT }</li>
	                		</c:forEach>
	                	</ul>
	                </td>
	                <td>${ giangVien.linhVucNghienCuu }</td>
	                <td>${ giangVien.soDT }</td>
	            </tr>
	            
            </c:forEach>
        </table>
    </div>
</body>
</html>