<%@ page import="vue.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <form action="" method="get">
      <h1>nom de la classe : </h1>
      <%
        out.println(request.getParameter("class"));
      %>
    <a href="../index.jsp">index</a><br>
  </body>
</html>
