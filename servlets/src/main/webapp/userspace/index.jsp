<%--
  Created by IntelliJ IDEA.
  User: wopqw
  Date: 22.10.16
  Time: 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Person" %>
<%@ page import="java.util.HashSet" %>
<html>
  <head>
    <title>Userspace</title>
  </head>
  <body>
  
  <jsp:useBean id="persons" class="java.util.HashSet" scope="request"/>

  <table>
    <tr>
      <th>id</th>
      <th>fist_name</th>
      <th>last_name</th>
      <th>email</th>
    </tr>
      <%
        for (Person p: (HashSet<Person>)persons) {%>
          <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getFirstName() %></td>
            <td><%= p.getLastName() %></td>
            <td><%= p.getEmail()%></td>
          </tr>
      <%}%>
  </table>

  </body>
</html>
