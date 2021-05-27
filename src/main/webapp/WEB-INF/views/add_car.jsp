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
    <input type="hidden" name="command" value="addnewcar" /> 
    
      <label for="brand"><b>Brand</b></label>
      <input type="text" name="brand" value=""/>
      
      <label for="describe_of_brand"><b>Describe</b></label>
      <input type="text" name="describe_of_brand" value="" maxlength="1000"/>
      
      <label for="bodywork"><b>bodywork</b></label>
      <input type="text" name="bodywork" value="" />

      <label for="power"><b>power</b></label>
      <input type="text" name="power" value="" />
      
      <label for="transmission"><b>transmission</b></label>
      <input type="text" name="transmission" value="" />
      
      <label for="number_of_doors"><b>number_of_doors</b></label>
      <input type="text" name="number_of_doors" value="" />
      
      <label for="year"><b>year</b></label>
      <input type="text" name="year" value="" />
      
      <label for="photoPath"><b>photo</b></label>
      <input type="file" name="photoPath"value="" />
        
      <button type="submit">Save</button>
      
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button"  class="cancelbtn">Отменить</button>
      
    </div>
    
   
  </form>
	
	
	
	
	<!-- footer -->
<div></div><!-- очищающий блок -->
<div id="substrate-footer"></div><!-- блок подложка подвала сайта -->
</div><!-- конец блока PAGE -->

<div id="footer"><!-- подвал сайта -->
&copy; Pervak Oksana
<!-- end of footer -->


</body>
</html>