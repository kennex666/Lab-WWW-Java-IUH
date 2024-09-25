<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart List</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
    <div class="container mx-auto mt-10">
        <table class="min-w-full bg-white shadow-md rounded-lg">
            <thead>
                <tr class="bg-gray-200 text-gray-600 uppercase text-sm leading-normal">
                    <th class="py-3 px-6 text-left">ID</th>
                    <th class="py-3 px-6 text-left">Name</th>
                    <th class="py-3 px-6 text-left">Price</th>
                    <th class="py-3 px-6 text-left">Quantity</th>
                    <th class="py-3 px-6 text-left">Total</th>
                    <th class="py-3 px-6 text-center">Action</th>
                </tr>
            </thead>
            <tbody class="text-gray-600 text-sm font-light">
            <c:forEach var="item" items="${cart}">
            	<tr class="border-b border-gray-200 hover:bg-gray-100">
                    <td class="py-3 px-6 text-left whitespace-nowrap">
                        ${item.product.id}
                    </td>
                    <td class="py-3 px-6 text-left">
                        ${item.product.name}
                    </td>
                    <td class="py-3 px-6 text-left">
                        ${item.product.price}
                    </td>
                    <td class="py-3 px-6 text-left">
                        ${item.quantity}
                    </td>
                    <td class="py-3 px-6 text-left">
                        ${item.quantity * item.product.price}
                    </td>
                    <td class="py-3 px-6 text-center">
                        <a class="bg-blue-500 text-white px-4 py-2 rounded" href="${pageContext.request.contextPath}/cart?action=remove&id=${product.id}">Remove</a>
                    </td>
                </tr>
            </c:forEach>
                
            </tbody>
        </table>
    </div>
</body>
</html>
