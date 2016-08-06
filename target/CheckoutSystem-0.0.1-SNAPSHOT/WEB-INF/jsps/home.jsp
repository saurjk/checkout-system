<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout System</title>
</head>
<body>
	Body
	<div class="container">
		<div class="checkout">
			<form id="orderForm" method="post"
				action="${pageContext.request.contextPath}/doorder">
				<div class="input_fields_wrap">
					<div>
						<input type="text" name="orderItem[]" class="order_item">
					</div>
				</div>
				<button class="add_more_item_button">Add More Item</button>
				<button class="submit_form">Order</button>
			</form>
		</div>
		<div class="priceStructure">
			<table>
				<tr>
					<th>Item</th>
					<th>Unit Price</th>
					<th>Special Price</th>
				</tr>
				<c:forEach var="rule" items="${rules}">
					<tr>
						<td><c:out value="${rule.key}" /></td>
						<td><c:out value="${rule.value.unitPrice}" /></td>
						<td><c:if test="${rule.value.specialPriceNumber > 0}">
								<c:out
									value="${rule.value.specialPriceNumber} for ${rule.value.specialPrice}" />
							</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery-3.1.0.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/main.js"></script>
</body>
</html>