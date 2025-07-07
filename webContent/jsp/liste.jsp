<%@ page import="vue.*" %>
<%@ page import="dao.*" %>
<%@ page import="java.util.ArrayList" %>
<%
//prendre la liste des objects dans file
FileObjectReader fileReader = new FileObjectReader("listeObject");
ArrayList<Object> listeObject = fileReader.getAllObjectFormFile();
List list = new List(fileReader.getAllObjectFormFile());
%>
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
        out.println(list.buildTable());
      %>
    <a href="../index.jsp">formulaire</a><br>
  </body>
</html>
