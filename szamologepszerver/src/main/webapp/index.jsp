<html>
<head>
    <title>Calculator</title>
</head>
<body>
<%
//ha a servlettol jott, akkor van, ha elso keres, akkor nincs
szamologepszerver.ResultDto result = (request.getAttribute("result") != null) ? (szamologepszerver.ResultDto) request.getAttribute("result") : new szamologepszerver.ResultDto();
			
String resultText = (result == null) ? " " : "result " + result.getResult().toString();
%>

ver: 0.5
<form method="post" action="/<%=request.getContextPath()%>/szamologep.do">
    <input type="text" name="a" value="<%= result.getA() %>"/><br>
    <input type="text" name="b" value="<%= result.getB() %>"/><br>
    <select name="operator">
        <option value="+" <%="+".equals(result.getOperator())? "selected" : ""%> > +
        <option value="-" <%="-".equals(result.getOperator())? "selected" : ""%> > -
        <option value="*" <%="*".equals(result.getOperator())? "selected" : ""%> > *
        <option value="/" <%="/".equals(result.getOperator())? "selected" : ""%> > /
    </select><br>

<%= resultText %>
    <input type="submit" /><br>
</form>

</body>
</html>