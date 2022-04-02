<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="products?action=Products">List All Products</a>
    </h2>
    <c:if test='${requestScope["message"]}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</center>
<div align="center">
    <caption>
        <h2>
            Edit Product
        </h2>
    </caption>
    <form method="post">
        <table class="table table-hover " border="1" cellpadding="5">
            <c:if test="${product != null}">
                <input type="text" disabled size="45" name="id" value="<c:out value='${Product.id}' />"/>
            </c:if>
            <tr class="table-dark">
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price :</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${product.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity :</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${product.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Color :</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${product.color}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Category :</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${product.category}' />"
                    />
                </td>
            </tr>

            <tr class="table-dark">
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>