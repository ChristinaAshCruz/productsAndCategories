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
    <title>Project Name here</title>
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
      <h1><c:out value="${product.name}"></c:out></h1>
      <span><a href="/" class="btn btn-primary me-2">Go Back home</a></span>
    </div>
    <hr />
    <div class="d-flex">
      <div class="card p-3 me-3 col">
        <h3>Categories:</h3>
        <hr />
        <ul>
          <c:forEach var="category" items="${product.categories}">
            <li><c:out value="${category.name}"></c:out></li>
          </c:forEach>
        </ul>
      </div>
      <div class="card p-3 col">
        <h3>Add to Category:</h3>
        <hr />
        <form
          action="/product/${product.id}/add-categories"
          method="POST"
          modelAttribute="unaddedCategory"
        >
          <input type="hidden" name="_method" value="PUT" />
          <select name="categories" id="categories" class="form-select mb-3">
            <option>Select category...</option>
            <c:forEach var="category" items="${allCategories}">
              <c:if test="${!category.products.contains(product)}">
                <option value="${category.id}">
                  <c:out value="${category.name}"></c:out>
                </option>
              </c:if>
            </c:forEach>
          </select>
          <button class="btn btn-primary">Add</button>
        </form>
      </div>
    </div>
  </body>
</html>
