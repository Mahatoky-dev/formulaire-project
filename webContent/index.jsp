<%@ page import="vue.*" %>
<%@ page import="vue.test.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <form action="FormServlet" method="get">
      <%
        out.println(new PersonneLocalise().buildHtmlInsert());
      %>
      <input type="submit" value="Insert">
    </form>
    <a href="jsp/liste.jsp">Voir la liste</a>
  </body>
</html>
