<%@page import="entities.Cart"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int shopingCartTotal = 0;
	Cart temp = (Cart) request.getSession().getAttribute("cart");
	if (temp != null) {
		shopingCartTotal = temp.getTotalItems();
	
	}
	
	request.setAttribute("shopingCartTotal", shopingCartTotal);
%>
<html>
<head>
<title>IUH Bookstore</title>
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
body {
	font-family: Arial, sans-serif;
}
</style>
</head>
<body class="bg-gray-200">
	<div
		class="bg-gray-800 px-32 py-4 flex justify-between items-center text-white">
		<a href="${ pageContext.request.contextPath }" class="text-xl">IUH
			BOOKSTORE</a>
		<div class="flex gap-12 px-6">
			<a href="${ pageContext.request.contextPath }"
				class="hover:text-gray-200">Trang chủ</a> <a
				href="${ pageContext.request.contextPath }"
				class="hover:text-gray-200">Products</a> <a
				href="${ pageContext.request.contextPath }/cart"
				class="hover:text-gray-200">Cart</a> <a
				href="https://1boxstudios.com/" class="hover:text-gray-200">Liên
				hệ</a> <a href="https://dtbao.io.vn/" class="hover:text-gray-200">Author</a>
		</div>
	</div>
	<div class="p-4 grid grid-cols-5 gap-5">
		<div class="bg-white p-4">
			<h2 class="font-bold mb-2">Thông tin người thực hiện</h2>
			<p>
				Dương Thái Bảo - 21037621.<br>
				<a href="https://dtbao.io.vn/" class="text-blue-600">Xem trang
					cá nhân »</a>
			</p>
			<h2 class="font-bold mt-4 mb-2">Tìm kiếm</h2>

			<form action="${ pageContext.request.contextPath }/products"
				method="get">
				<input name="action" hidden value="search"> <input name="q"
					type="text" class="border p-1 w-full" value="${searchQuery}">
				<button class="bg-blue-500 text-white px-4 py-1 w-full mt-3"
					type="submit">Tìm kiếm</button>
			</form>

			<p class="mt-8">
				<a href="${pageContext.request.contextPath}/cart"
					class="text-blue-600">Shopping cart (${shopingCartTotal})</a>
			</p>
		</div>