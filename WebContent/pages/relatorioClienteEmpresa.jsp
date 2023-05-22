<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:url value="/listaCliente" var="listaempresapf"/>
	<c:url var="listaempresapj" value="/listaEmpresa" />
	<c:url var="deleteUrl" value="/deletaCliente" />
	<c:url var="deleteUrls" value="/deletaEmpresa" />
	<c:url var="alteraUrl" value="/alteraCliente" />
	<c:url var="alteraUrls" value="/alteraEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tintas e Corporativa Relatório</title>
<style>
@charset "UTF-8";

.menu-anchor {
      font-family: Arial, sans-serif;
      color: black;
      margin-left: 20px;
      text-decoration: none; 
    }
    
    #menu-superior h2 {
  		font-family: Arial, sans-serif;
  		color: black;
 		font-size: 40px;
     	text-decoration: none; 
	}
	
	#menu-superior {
      background-color: white;
      font-size: 16px; 
      border: none;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
}

.box {
    background-color: #fff;
    width: 90%;
    max-width: 900px;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    margin: 20px auto;
}

.box h1 {
    font-size: 24px;
    font-weight: bold;
    margin-bottom: 20px;
}

.table-container {
    overflow: auto;
}

.table-container table {
    width: 100%;
    border-collapse: collapse;
}

.table-container th,
.table-container td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

.table-container th {
    background-color: #f2f2f2;
}

.table-container tr:hover {
    background-color: #f9f9f9;
}

.black-link {
        color: black;
        text-decoration: none;
        font-size: 15px;
    }
    
.bananaForm input[type="submit"] {
    font-size: 15px;
    font-family: Arial, sans-serif;
    background-color: white;
    border: 2px 2px 4px black;
    border-radius: 10px;
    outline: none;
    padding: 5px 10px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.bananaForm input[type="submit"]:hover {
    background-color: #f2f2f2;
}


</style>
</head>
<body>

	<nav id="menu-superior">
		<h2>Consulta de Clientes e Empresas</h2>
		<div>
			<a href="../index.jsp" class="menu-anchor">Home</a> 
			<a href="formularioPessoaFisica.jsp" class="menu-anchor">Pessoa Fisica</a> 
				<a href="formularioPessoaJuridica.jsp" class="menu-anchor">Pessoa Jurídica</a>
		</div>
	</nav>

	<main class="box">
    <h1>Consulta de Clientes</h1>
    <form action="${listaempresapf}" method="post" class="bananaForm">
        <div>
            <label><strong>Para consultar o seu cadastro, clique no botão:</strong></label>
        </div>
        <br>
        <div>
            <input id="bananaButton" type="submit" name="consultarClientes" value="Consultar Cliente">
        </div>
    </form>
</main>

<main class="box">
    <div class="table-container">
        <table class="bananaTable">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Saldo</th>
                <th>CPF</th>
                <th>Ações (Excluir/Editar)</th>
            </tr>
            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.codigo}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.saldo}</td>
                    <td>${cliente.cpf}</td>
                    <td class="button-container">
                        <a class="black-link" href="${deleteUrl}?codigo=${cliente.codigo}">Excluir</a>
                        <a class="black-link" href="${alteraUrl}?codigo=${cliente.codigo}">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>


	<main class="box">
	<h1>Consulta de Empresas</h1>
    <form action="${listaempresapj}" method="post" class="bananaForm">
        <div>
            <label><strong>Para consultar o seu cadastro, clique no botão:</strong></label>
        </div>
        <br>
        <div>
             <input id="bananaButton" type="submit" name="salvar" value="Consultar Empresa">
        </div>
    </form>
</main>

<main class="box">
    <div class="table-container">
        <table class="bananaTable">
            <tr>
                <th>Código</th>
                <th>Razão Social</th>
                <th>Saldo</th>
                <th>CNPJ</th>
                <th>Ações (Excluir/Editar)</th>
            </tr>
            <c:forEach var="empresa" items="${empresas}">
                <tr>
                    <td>${empresa.codigo}</td>
                    <td>${empresa.razaoSocial}</td>
                    <td>${empresa.saldo}</td>
                    <td>${empresa.cnpj}</td>
                    <td class="button-container">
                        <a class="black-link" href="${deleteUrls}?codigo=${empresa.codigo}">Excluir</a>
                        <a class="black-link" href="${alteraUrls}?codigo=${empresa.codigo}">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>

</body>
</html>