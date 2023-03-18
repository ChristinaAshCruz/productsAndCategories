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
    <title>New Category</title>
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
      <h1>Create a New Category</h1>
      <span><a href="/" class="btn btn-primary me-2">Go Back home</a></span>
    </div>
    <hr />
    <div class="card p-3" id="main">
      <form:form
        action="/category/new"
        method="POST"
        modelAttribute="newCategory"
      >
        <div class="form-group d-flex align-items-center mb-3">
          <form:label for="name" class="form-label col-2" path="name"
            >Name:</form:label
          >
          <form:input
            type="text"
            class="form-control col"
            name="name"
            path="name"
          />
        </div>
        <div class="d-flex justify-content-end">
          <button class="btn btn-primary col-2">Create Category</button>
        </div>
      </form:form>
    </div>
  </body>
</html>
