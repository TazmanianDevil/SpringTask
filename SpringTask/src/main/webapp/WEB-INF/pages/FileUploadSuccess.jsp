<%@ page import="com.task.common.model.Customers" %>
<%@ page import="com.task.common.model.Customer" %>
<%@ page import="com.task.common.model.Order" %>
<%--
  Created by IntelliJ IDEA.
  User: Musin
  Date: 26.02.2015
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
<h2>Result page</h2>

<p>Customer's list</p>
<table cellspacing="2" cellpadding="3" border="1" width="100%">
    <tr>
        <th>Customer</th>
        <th>Order's count</th>
        <th>Orders average</th>
    </tr>
<% Customers c = (Customers)request.getSession().getAttribute("customers");
    if (c!= null) {
        for (Customer customer: c.getCustomers()) {%>
    <tr>
        <td><%=customer.getName()%></td>
        <td><%=customer.getOrdersCount()%></td>
        <td>
            <table  cellspacing="2" cellpadding="3" border="1" width="100%">
                <tr>
                    <th>Order's id</th>
                    <th>Order's avg amount</th>
                        <%for (Order o: customer.getOrders()) {%>
                <tr>
                    <td><%=o.getId()%></td>
                    <td><%=o.getAverageAmount()%></td>
                </tr>
                <%}%>
                </tr>
            </table>
        </td>
    </tr>
        <%}
    }%>
</table>
<strong>Total order's price is <%=c.getTotalAmount()%></strong></br>
<strong>Customer with max order's amount is <%=c.getMaxOrderCustomer()%></strong></br>
<strong>Max order's amount is is <%=c.getMaxOrderAmount()%></strong></br>
<strong>Min order's amount is is <%=c.getMinOrderAmount()%></strong></br>
<strong>Total order's count is is <%=c.getTotalOrdersCount()%></strong></br>
</body>
</html>