<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/atualizaEmpresa" var="listaempresapj"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tintas e Corporativa - Editar Empresa</title>
    <style>
        .menu-anchor {
            font-family: Arial, sans-serif;
            color: black;
            margin-left: 20px;
            text-decoration: none;
        }
        
        #menu-superior img {
            width: 100px;
            height: 100px;
        }
        
        #menu-superior {
            background-color: white;
            font-size: 16px;
            border: none;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        
        body {
            font-family: Arial, sans-serif;
        }
        
        h1 {
            font-size: 30px;
            font-family: Arial, sans-serif;
            font-weight: bold;
            margin-bottom: 20px;
        }
        
        label {
            font-size: 20px;
            font-family: Arial, sans-serif;
        }
        
        input[type="text"],
        input[type="submit"] {
            font-size: 16px;
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
        form {
            max-width: 400px;
            margin: 0 auto;
            border: 1px solid #ccc;
            padding: 20px;
            box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.1);
        }
        
        .form-row {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<nav id="menu-superior">
    <img src="img/is1.png" alt="Logo do Menu">
    <div>
        <a href="index.jsp" class="menu-anchor">Home</a>
        <a href="pages/relatorioClienteEmpresa.jsp" class="menu-anchor">Relatórios</a>
    </div>
</nav>

<div class="form-container">
    <form action="${listaempresapj}" method="post">
        <h1>Editar Empresa</h1>
        <div class="form-row">
            <input type="hidden" name="codigo" value="${empresa.codigo}">
        </div>
        
        <div class="form-row">
            <label for="razaoSocial">Razão Social:</label>
            <input type="text" name="razaoSocial" value="${empresa.razaoSocial}">
        </div>
        
        <div class="form-row">
            <label for="saldo">Saldo:</label>
            <input type="text" name="saldo" value="${empresa.saldo}">
        </div>
        
        <div class="form-row">
            <label for="cnpj">CNPJ:</label>
            <input type="text" name="cnpj" value="${empresa.cnpj}">
        </div>
        
        <div class="form-row">
            <input type="submit" value="Atualizar">
        </div>
    </form>
</div>
</body>
</html>