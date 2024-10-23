<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.HashMap"%>

<div class="col-span-3">
	<div class="w-full mx-auto">
		<h2 class="text-xl font-semibold text-center mb-4">YOUR SHOPPING
			CART</h2>
		<c:if test="${not empty payStatus}">
			<p class="${not empty success ? 'text-green-600' : 'text-red-600'}">${payStatus}</p>
		</c:if>
		
		<table class="min-w-full bg-white border border-gray-300">
			<thead>
				<tr class="text-gray-600 uppercase text-sm leading-normal bg-white">
					<th class="py-2 px-3 border">Product ID</th>
					<th class="py-2 px-3 border">Product name</th>
					<th class="py-2 px-3 border">Price</th>
					<th class="py-2 px-3 border">Qty</th>
					<th class="py-2 px-3 border">Total</th>
					<th class="py-2 px-3 border">Remove</th>
				</tr>
			</thead>
			<tbody class="text-gray-600 text-sm">
				<c:if test="${empty cart.items}">
					<tr class="border-b">	
						<td class="py-2 px-3"><b>Giỏ hàng rỗng!</b></td>
					</tr>
				</c:if>
				<c:forEach var="item" items="${cart.items}">
					<tr class="border-b">
						<td class="py-2 px-3 border flex justify-center">${item.key}</td>
						<td class="py-2 px-3 border">${item.value.product.name}</td>
						<td class="py-2 px-3 border">${item.value.product.price}</td>
						<td class="py-2 px-3 border flex justify-center">${item.value.quantity}</td>
						<td class="py-2 px-3 border">${item.value.quantity * item.value.product.price}</td>
						<td class="py-2 px-3 border flex justify-center"><a href="${pageContext.request.contextPath}/cart?action=remove&id=${item.value.product.id}"
							class="text-blue-600 hover:underline">Remove</a></td>
					</tr>
				</c:forEach>
				<c:if test="${cart.total > 0}">
					<tr class="bg-white font-semibold">
		                <td colspan="4" class="text-right py-2 px-3 border">Total price</td>
		                <td class="py-2 px-3 border">${cart.total}</td>
		                <td class="py-2 px-3 border">(VND)</td>
		            </tr>
				</c:if>
			</tbody>
		</table>

		<div class="flex gap-8 mt-4">
			<a href="${pageContext.request.contextPath}/cart?action=next"
				class="bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600">
				Checkout</a>
			<a href="${pageContext.request.contextPath}"
				class="bg-gray-500 text-white py-2 px-4 rounded hover:bg-gray-600">
				Continue shopping</a>
		</div>
	</div>
</div>