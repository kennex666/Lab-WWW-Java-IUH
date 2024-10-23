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

    <div>
			
		<c:if test="${not empty error}">
			<p style="color: red">Không tồn tại mã danh mục hoặc trùng mã tin tức. Thêm thất bại</p>
		</c:if>
        <form action="${ pageContext.request.contextPath }/tinTuc?action=addTT" method="POST" id="form">
            <table>
                <tr>
                    <td>Mã tin tức</td>
                    <td><input type="text" name="maTT" required></td>
                </tr>
                <tr>
                    <td>Tiêu đề</td>
                    <td><input type="text" name="tieuDe" required></td>
                </tr>
                <tr>
                    <td>Nội dung</td>
                    <td><textarea name="noiDungTT" required></textarea></td>
                </tr>
                <tr>
                    <td>Liên kết</td>
                    <td><input type="text" name="lienKet" required></td>
                </tr>
                <tr>
                    <td>Mã danh mục</td>
                    <td><input type="text" name="maDM" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Thêm"></td>
                </tr>
            </table>
            
        </form>
    </div>
    
    <div class="bar">
        <a href="https://dtbao.io.vn/">Dương Thái Bảo - 21037621 - DHKTPM17B</a>
    </div>

    <script>
        document.getElementById('form').addEventListener('submit', function(e){
            e.preventDefault();
            var form = this;
            var data = new FormData(form);

            //check if noicungTT has at least 10 characters
            if(data.get('noiDungTT').length >= 255){
                alert('Nội dung phải có ít hơn 255 ký tự');
                return;
            }
            // check if lienKet not start with http://
            if(data.get('lienKet').indexOf('http://') !== 0){
                alert('Liên kết phải bắt đầu bằng http://');
                return;
            }
            
            // send data to server via default action
            form.submit();
        });
    </script>

</body>
</html>