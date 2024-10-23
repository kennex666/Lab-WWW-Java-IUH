<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
	<div class="col-span-4 grid grid-cols-4 gap-4">
	<c:forEach var="product" items="${products}">
		<div class="bg-white p-4 flex flex-col justify-between">
				
				<div class="flex justify-center items-center">
					<img src="${pageContext.request.contextPath}/resources/images/${product.imgPath}" alt="${product.name}" class="h-52 object-contain">
				</div>
				<div>
					<p class="font-bold mt-8">${product.name}</p>
	                <p>Price: ${product.price}</p>
	                <p>Quantity: ${product.quantity}</p>
				</div>
				<c:if test="${empty backToProductList}">
	                <div class="flex justify-between">
		                <a href="${pageContext.request.contextPath}/products?action=details&id=${product.id}" class="px-1 text-blue-600 py-1">Product details</a>
		                <a href="${pageContext.request.contextPath}/cart?action=add&id=${product.id}" class="bg-blue-500 text-white px-4 py-1">Add to cart</a>
	                </div>
	             </c:if>
				<c:if test="${not empty backToProductList}">
					<div>
						<a href="${pageContext.request.contextPath}/products" class="text-blue-600 underline mt-3">Back to product list</a>
					</div>
				</c:if>
            </div>
		
	</c:forEach>
</div>