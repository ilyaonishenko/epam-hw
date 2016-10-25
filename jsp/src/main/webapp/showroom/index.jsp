<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Gun" %>
<%@ page import="java.util.HashSet" %>
<html>
<head>
    <title>Showroom</title>
</head>
<body>
<h1>ShowRoom</h1>
<jsp:useBean id="guns" class="java.util.HashSet" scope="request"/>
<table>
    <tr>
        <th>name</th>
        <th>caliber</th>
        <th>price</th>
    </tr>
    <% for (Gun gun: (HashSet<Gun>) guns){%>
    <tr>
        <td><%=gun.getName()%></td>
        <td><%=gun.getCaliber()%></td>
        <td><%=gun.getPrice()%></td>
    </tr>
    <%}%>
</table>

</body>
</html>