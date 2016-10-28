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
        <form name="gunForm" method="post" action="/showroom/">
            <td><input type="text" name="<%= gun.getId()%>" value="<%=gun.getName()%>" disabled/></td>
            <td><input type="text" name="<%= gun.getId()%>" value="<%=gun.getCaliber()%>" disabled/></td>
            <td><input type="text" name="<%= gun.getId()%>" value="<%=gun.getPrice()%>" disabled/></td>
            <td><input id="editButton" type="button" value="Edit" onclick="enable(<%= gun.getId()%>)"/></td>
            <td><input id='saveButton' type="submit" value="Save" onclick="disable(<%= gun.getId()%>)"/></td>
        </form>
    </tr>
    <%}%>
</table>
</body>

<script>
    function disable(a){
        var inputs = document.getElementsByTagName('input');
        for(i = 0; i<inputs.length; i++){
            if(inputs[i].name == a) {
                inputs[i].disabled = true;
            }
        }
    }
    function enable(a) {
        var inputs = document.getElementsByTagName('input');
        for(i = 0; i<inputs.length; i++){
            if(inputs[i].name==a) {
                inputs[i].disabled = false;
            }
        }
    }
</script>
</html>