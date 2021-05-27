<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.util.ArrayList,java.util.List,by.htp.jwd.bean.Car"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="css/header.jsp" />
<html>
<style>
/* Поля ввода полной ширины */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.container {
	padding: 16px;
}

button {
	background-color: #8AB8CC;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100px;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f99790;
}
</style>

<body>
	<!-- menu -->
	<ul id="menu">
		<li><a href="#">HOMEPAGE</a></li>
		<li><a href="#">SERVICES</a></li>
		<li><a href="#">OUR CARS</a></li>
		<li><a href="#">PAYMENT TERMS</a></li>
		<li><a href="#">CONTACT US</a></li>
		<li><a href='<c:url value="/Controller?command=addnewcarview" />'>UPLOAD</a></li>
		<li><a href='<c:url value="/Controller?command=logination" />'>LOG
				IN</a></li>
		<li><a
			href="Controller?command=Localization&lang=en&page=gotoaddnewspage"><img
				src="images/eng.png" /></a></li>
		<li><a
			href="Controller?command=Localization&lang=en&page=gotoaddnewspage"><img
				src="images/ru.png" /></a></li>
	</ul>
	<!-- end of menu -->

	<c:forEach var="n" items="${requestScope.cars}">

		<table>
			<tr>
				<td><br /></td>
				<td><br /></td>
				<td><br /></td>
				<td><img src="${n.photoPath}" width="130" height="130" /></td>
				<td><br /></td>
				<td><br /></td>
				<td><br /></td>
				<td><c:out value="${n.brand}" /><br /> <c:out
						value="${n.describe_of_brand}" /> <br />
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="addnewcar" />
						<button type="submit">Read</button>
					</form> <br /></td>
				<td><br /></td>
				<td><br /></td>
				<td><br /></td>
			</tr>

		</table>

	</c:forEach>


	<!-- footer -->
	<div></div>
	<!-- очищающий блок -->
	<div id="substrate-footer"></div>
	<!-- блок подложка подвала сайта -->
	</div>
	<!-- конец блока PAGE -->

	<div id="footer">
		<!-- подвал сайта -->
		&copy; Pervak Oksana
	</div>
	<!-- end of footer -->
</body>
</html>