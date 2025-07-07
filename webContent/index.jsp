<%@ page import="vue.*" %>
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
        out.println(new User().buildHtmlInsert());
      %>
      <input type="submit" value="Insert">
    </form>
    <a href="../index.jsp">index</a>
  </body>
</html>
