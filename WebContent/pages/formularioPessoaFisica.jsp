<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/cadastraCliente" var="linkservletcpf" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/pf.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="ISO-8859-1">
<title>Formulario Cliente TC</title>
</head>
<body>

	<nav id="menu-superior">
		<img src="../img/is1.png" alt="Logo do Menu">
		<div>
			<a href="../index.jsp" class="menu-anchor">Home</a> <a
				href="formularioPessoaJuridica.jsp" class="menu-anchor">Pessoa Jurídica</a>
		</div>
	</nav>

	<div class="card-wrapper">
		<div class="container">
			<form action="${linkservletcpf}" method="post" class="card"
				id="formularioCliente">
				<h1>Deseja realizar o seu cadastro conosco? Basta somente inserir seus dados nos campos abaixo.</h1>
				<br>
				<div>
					<label for="nome">Nome</label> <input type="text" id="nome"
						name="nome">
				</div>

				<div>
					<label for="saldo">Saldo</label> <input type="text" id="saldo"
						name="saldo">
				</div>

				<div>
					<label for="cpf">CPF</label> <input type="text" id="cpf" name="cpf">
				</div>
				<div>
					<input type="submit" value="Enviar">
				</div>
			</form>
		</div>
	</div>
</body>
</html>