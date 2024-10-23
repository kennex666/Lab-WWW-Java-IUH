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
<style>
    img {
        width: 100%;
        height: auto;
        border: 1px solid black;
    }
    .bar{
        width: 100%;
        height: 30px;
        border: 1px solid black;
        text-align: center;
        line-height: 30px;
        border-collapse: collapse;
    }

    .table{
        width: 100%;
        border: 1px solid black;
        border-collapse: collapse;
    }

    .table th, .table td{
        border: 1px solid black;
        text-align: left;
        padding: 5px;
    }

    .table th{
        background-color: #f2f2f2;
    }

    .table a{
        text-decoration: none;
        color: blue;
    }

    .table th, .table td{
        width: 33.33%;
    }
</style>
<body>
    <div class="">
        <img src="resources/banner.png"/>
    </div>

    <div class="bar">
        <a href="${ pageContext.request.contextPath }">Danh sách tin tức</a> <span> | </span>
        <a href="${ pageContext.request.contextPath }/?action=addTT">Thêm tin tức mới</a> <span> | </span>
        <a href="${ pageContext.request.contextPath }/?action=editMode">Chức năng quản lý</a>
    </div>

	<c:forEach var="danhMuc" items="${listDanhMuc}">
		<div style="margin-bottom: 12px;">
	        <p>Danh mục ${ danhMuc.tenDanhMuc }</p>
	        <table class="table">
	            <tr>
	            	<th>ID</th>
	                <th>Tiêu đề</th>
	                <th>Nội dung</th>
	                <th>Liên kết</th>
	                <c:if test="${ not empty isEditMode }">
	                <th>Remove</th>
	                </c:if>
	            </tr>
	           
	           <c:forEach var="tinTuc" items="${danhMuc.tinTucs}">
	            <tr>
	            	<td>${tinTuc.maTT}</td>
	                <td>${tinTuc.tieuDe}</td>
	                <td>${tinTuc.noiDungTT}</td>
	                <td><a href="${tinTuc.lienKet}">${tinTuc.lienKet}</a></td>
	                
	                <c:if test="${ not empty isEditMode }">
	                	<td><button onclick="confirmDelete('${tinTuc.maTT}')" >Xoá</button></td>
	                </c:if>
	            </tr>
	           </c:forEach>
	
	        </table>
	    </div>
		
	</c:forEach>
    
    
    <div class="bar">
        <a href="https://dtbao.io.vn/">Dương Thái Bảo - 21037621 - DHKTPM17B</a>
    </div>


<script>
function confirmDelete(id) {
  if (confirm('Are you sure you want to delete this?')) {
	  window.location.href = "${pageContext.request.contextPath}?action=remove&maTT=" + id
  } else {
    // User clicked Cancel
    console.log('Action canceled');
    // Return false or handle cancellation here
  }
}
</script>

</body>
</html>