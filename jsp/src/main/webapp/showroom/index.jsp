<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Gun" %>
<%@ page import="java.util.HashSet" %>
<html>
<head>
    <title>Showroom</title>
</head>
<jsp:useBean id="guns" class="java.util.HashSet" scope="request"/>
<body onload="makeReadOnly()">
<h1>ShowRoom</h1>
<table>
    <tr>
        <th>   </th>
        <th>name</th>
        <th>caliber</th>
        <th>price</th>
    </tr>
    <% for (Gun gun: (HashSet<Gun>) guns){%>
    <tr>
        <form method="post" action="/showroom/">
            <td><input type="hidden" name="id" value="<%=gun.getId()%>" /></td>
            <td><input type="text" name="name" value="<%=gun.getName()%>" title="<%=gun.getId()%>"/></td>
            <td><input type="text" name="caliber" value="<%=gun.getCaliber()%>" title="<%=gun.getId()%>"/></td>
            <td><input type="text" name="price" value="<%=gun.getPrice()%>" title="<%=gun.getId()%>"/></td>
            <td><input type="button" value="Edit" onclick="enable(<%= gun.getId()%>)"/></td>
            <td><input type="submit" value="Save" onclick="disable(<%= gun.getId()%>)"/></td>
        </form>
    </tr>
    <%--<form method="post" action="/showroom/">--%>
        <%--<input type="hidden" name="id" value="<%=gun.getId()%>" />--%>
        <%--<input type="text" name="name" value="<%=gun.getName()%>" title="<%=gun.getId()%>"/>--%>
        <%--<input type="text" name="caliber" value="<%=gun.getCaliber()%>" title="<%=gun.getId()%>"/>--%>
        <%--<input type="text" name="price" value="<%=gun.getPrice()%>" title="<%=gun.getId()%>"/>--%>
        <%--<input type="button" value="Edit" onclick="enable(<%= gun.getId()%>)"/>--%>
        <%--<input type="submit" value="Save" onclick="disable(<%= gun.getId()%>)"/><br/>--%>
    <%--</form>--%>
    <%}%>
</table>

</body>

<script>
    function makeReadOnly() {
        var inputs = document.getElementsByTagName('input');
        for(i = 0; i<inputs.length; i++){
            if(inputs[i].name=="name"||inputs[i].name=="caliber"||inputs[i].name=="price")
                inputs[i].readOnly = true;
        }
    }

    function disable(a){
        console.log("in disable");
        var inputs = document.getElementsByTagName('input');
        for(i = 0; i<inputs.length; i++){
            if(inputs[i].title == a) {
                console.log(inputs.name);
                inputs[i].readOnly = true;
            }
        }
    }
    function enable(a) {
        var inputs = document.getElementsByTagName('input');
        for(i = 0; i<inputs.length; i++){
            if(inputs[i].title == a) {
                inputs[i].readOnly = false;
            }
        }
    }
</script>
</html>