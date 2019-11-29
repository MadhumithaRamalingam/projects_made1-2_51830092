<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="addaccount" method="post" modelAttribute="account" >
<form:hidden path="accountNumber"/>
Enter account Balance:<form:input path="balance"/><form:errors path="balance" class="error"/><br/>
Enter customer blocked:<form:input path="blocked"/><form:errors path="blocked" class="error"/><br/>
<form:hidden path="customer.id"/>
Enter customer name:<form:input path="customer.name"/><form:errors path="customer.name" class="error"/><br/>
Enter customer address:<form:input path="customer.address"/><form:errors path="customer.address" class="error"/><br/>
Enter customer city:<form:input path="customer.city"/><form:errors path="customer.city" class="error"/><br/>
Enter customer email:<form:input path="customer.email"/><form:errors path="customer.email" class="error"/><br/>

Enter customer country:<form:input path="customer.country"/><form:errors path="customer.country" class="error"/><br/>
Enter customer phone:<form:input path="customer.phone"/><form:errors path="customer.phone" class="error"/><br/>



<input type="submit">
</form:form>

</body>
</html>