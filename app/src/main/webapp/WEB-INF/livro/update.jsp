<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Editar Livro</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Editar Livro</h1>
            <form action="/livro/update" method="post">
                <input type="hidden" name="id" value="${livro.id}" />
                <div class="form-group">
                    <label>Título:</label>
                    <input type="text" name="titulo" value="${livro.titulo}" class="form-control" />
                </div>
                <div class="form-group">
                    <label>ISBN:</label>
                    <input type="text" name="isbn" value="${livro.isbn}" class="form-control" />
                </div>
                <div class="form-group">
                    <label>Gênero</label>
                    <select name="genero" class="form-select">
                        <c:forEach var="g" items="${generos}">
                            <option ${livro.genero.id == g.id ? "selected" : ""} value="${g.id}">${g.nome}</option>
                        </c:forEach>
                    </select>
                </div>

                <br />
                <a href="/livro/list" class="btn btn-primary" >Voltar</a>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>