<%-- 
    Document   : erro
    Created on : 22 de mai. de 2026, 23:12:28
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Erro no Sistema</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="alert alert-danger shadow text-center">
            <h3 class="alert-heading">🚨 Ops! Ocorreu um erro</h3>
            <p>Não foi possível concluir a operação no banco de dados.</p>
            <hr>
            <p class="mb-4"><strong>Detalhe Técnico:</strong> <%= request.getAttribute("message") %></p>
            
            <a href="index.html" class="btn btn-outline-danger">Voltar ao Início</a>
        </div>
    </div>
</body>
</html>