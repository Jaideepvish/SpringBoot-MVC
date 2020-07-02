<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Mvc Application</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/scripts/customer.js"></script>
<body>
    <c:if test="${not empty message}">
    	<div>
			${message}
		</div>
    </c:if>	
	<h2>Add Customers</h2>
	<form action="/addCustomer" method="post">
		<div>
			Customer First Name : <input type="text" name="firstName"/>
		</div>
		<div>
			Customer Last Name : <input type="text" name="lastName"/>
		</div>		
		<input type="submit" value="Add Customer"/>
	</form>
	
	<h2>Get Customer Details</h2>
	<form action ="/getCustomerDetails" method ="post">
		<div>
			Enter Customer Id: <input type="text" name = "id"/>			
		</div>
		<input type="submit" value="Submit" id= "fetchCustomerDetails"/>
	</form>
	
	<div id = "CustomerDetails" style="display:block">
		<h3>Customer Details</h3>	
		<c:choose>
			<c:when test="${customer ne null}">
				<div>
					Customer First Name : ${customer.firstName}
				</div>
				<div>
					Customer Last Name : ${customer.lastName}
				</div>
			</c:when>
			<c:otherwise>
				<div>
					${noRecordFound}
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<h2>Delete Customer</h2>
	<form action ="/deleteCustomer" method ="post">
		<div>
			Enter Customer Id: <input type="text" name = "id"/>			
		</div>
		<input type="submit" value="Delete Customer"/>
	</form>
	 <c:if test="${not empty deletionResult}">
    	<div>
			${deletionResult}
		</div>
    </c:if>	
	
	
	<h2><a href ="/getAllCustomerDetails">Get All Customers</a></h2>
	<div id="CustomerList">
		<table>
			<tr>
				<th>CustomerID</th>
    			<th>First Name</th>
    			<th>Last Name</th>   				
 			 </tr>
			<c:forEach items="${customerList}" var="customer">
				<tr>
					<td>${customer.customerID}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
				</tr>
			</c:forEach>		
		</table>		
	</div>
	
</body>
</html>