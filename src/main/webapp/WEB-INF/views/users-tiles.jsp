<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Tabela</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
            <div class="col-md-offset-3 col-xs-12">
    <h1>Użytkownicy aplikacji</h1>
    </div>
        <div class="row">
                <c:forEach var="user" items="${usersList}">
            <div class="col-md-3 col-xs-12">
        <br>
                    <c:choose>
                        <c:when test="${user.avatarUrl != null && user.avatarUrl !=''}">
                            <img height="100" src="${user.avatarUrl}">
                         </c:when>
                            <c:otherwise>
                                 <img height="100" src="http://s3.amazonaws.com/37assets/svn/765-default-avatar.png">
                             </c:otherwise>
                    </c:choose>
                     <p>${user.email}</p>
            </div>
                </c:forEach>
        </div>
    <div class="row">
    <br>
        <div class="col-md-offset-4">
            <a class="btn btn-primary" href="/users/create">Dodaj usera</a>
            <a class="btn btn-primary" href="/">Wroc do menu</a>
        </div>
    </div>
</div>

</body>
</html>