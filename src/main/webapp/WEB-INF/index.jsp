<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Home Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div
      class="d-flex justify-content-between align-items-baseline mb-3"
      id="header"
    >
      <div class="flex-grow-1">
        <h1>Home Page</h1>
      </div>
      <div>
        <span
          ><a href="/product/new" class="btn btn-primary me-2"
            >New Product</a
          ></span
        >
        <span
          ><a href="/category/new" class="btn btn-primary"
            >New Category</a
          ></span
        >
      </div>
    </div>
    <hr />

    <div class="card p-3" id="main">
      <table class="table table-bordered" id="directory">
        <thead>
          <tr class="text-center" id="header-row">
            <th scope="col">Products</th>
            <th scope="col">Categories</th>
          </tr>
        </thead>
        <tr>
          <td>
            <ul>
              <c:forEach var="product" items="${allProducts}">
                <li>
                  <a href="/product/${product.id}/view">
                    <c:out value="${product.name}"></c:out>
                  </a>
                </li>
              </c:forEach>
            </ul>
          </td>
          <td>
            <ul>
              <c:forEach var="category" items="${allCategories}">
                <li>
                  <a href="/category/${category.id}/view">
                    <c:out value="${category.name}"></c:out>
                  </a>
                </li>
              </c:forEach>
            </ul>
          </td>
        </tr>
      </table>
    </div>
  </body>
</html>
