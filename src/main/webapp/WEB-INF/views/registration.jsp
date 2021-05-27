<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="css/header.jsp" />

<!DOCTYPE html>
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
  width: 100%;
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
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- menu -->
	<ul id="menu">
		<li><a href="#">HOMEPAGE</a></li>
		<li><a href="#">SERVICES</a></li>
		<li><a href="#">OUR CARS</a></li>
		<li><a href="#">PAYMENT TERMS</a></li>
		<li><a href="#">CONTACT US</a></li>
	
		<li><a href='<c:url value="/Controller?command=logination" />'>LOG IN</a></li>
		<li><a href="Controller?command=Localization&lang=en&page=gotoaddnewspage"  ><img src="images/eng.png"/></a> </li>
		<li><a href="Controller?command=Localization&lang=en&page=gotoaddnewspage"  ><img src="images/ru.png"/></a> </li>
	</ul>
	<!-- end of menu -->

<form  action="Controller" method="post">
    
    <div class="container">
    <input type="hidden" name="command" value="saveuser" /> 
    
      <label for="login"><b>Логин</b></label>
      <input placeholder="Введите логин" type="text" name="login" value=""/>
      
      <label for="name"><b>Имя пользователя</b></label>
      <input  placeholder="Введите имя пользователя" type="text" name="name" value="" />
      
       <label for="surname"><b>Фамилия пользователя</b></label>
      <input  placeholder="Введите фамилию пользователя" type="text" name="surname"value="" />

      <label for="password"><b>Пароль</b></label>
      <input  placeholder=" Введите пароль" type="password" name="password"value="" />
        
      <button type="submit">Save</button>
      
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Отменить</button>
      
    </div>
    
   
  </form>
  
  
<!-- footer -->
<div></div><!-- очищающий блок -->
<div id="substrate-footer"></div><!-- блок подложка подвала сайта -->
</div><!-- конец блока PAGE -->

<div id="footer"><!-- подвал сайта -->
&copy; Pervak Oksana
</div>
</body>
</html>