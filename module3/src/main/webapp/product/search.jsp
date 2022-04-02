<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/18/2022
  Time: 2:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Home</title>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">
  <link href="css/stylehome.css" rel="stylesheet">
  <link href="css/cssviewlistproduct.css" rel="stylesheet">
</head>
<body style="background-image: url(/img/background.jpg);">


<header id="header" class="fixed-top ">
  <jsp:include page="generalform/generalform.jsp"></jsp:include>
  <div>
    <table style="width: 100%; background-color: #ede9e9;">
      <thead style="background-color: #a6a877">
      <tr>
        <th>Id</th>
        <th>Img</th>
        <th>Product</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>datePost</th>
        <th>Status</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="p" items="${listProduct}">
        <tr>
          <td>${p.id}</td>
          <td><img src="${p.img}" style="max-width:100px"></td>
          <td><a href="detail?pid=${p.id}">${p.name}</a></td>
          <td>${p.price}</td>
          <td>${p.quantity}</td>
          <td>${p.datePost}</td>
          <td>${p.status}</td>
          <td>
            <form action="edit?id=${p.id}" method="post">
              <input value="Edit" type="submit" />

            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>

  <!--Table-->
  <!--Table-->

</header><!-- End Header -->
</body>
</html>
