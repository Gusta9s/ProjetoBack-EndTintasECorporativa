<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Confirmação</title>
<style>
/* Estilos CSS para o layout moderno */

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
	background-color: #f1f1f1;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.card {
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	padding: 20px;
	text-align: center;
	max-width: 400px;
	width: 100%;
}

h1 {
	color: #333;
	font-size: 24px;
	margin-bottom: 20px;
}

p {
	color: #555;
	font-size: 18px;
	margin-bottom: 30px;
}

h2 {
	color: #555;
	font-size: 18px;
	margin-bottom: 30px;
}

.button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<nav id="menu-superior">
		<img src="img/is1.png" alt="Logo do Menu">
		<div>
			<a
				href="pages/relatorioClienteEmpresa.jsp" class="menu-anchor">Relatórios</a>
			<a href="index.jsp" class="menu-anchor">Home</a>
		</div>
	</nav>
	<div class="container">
		<div class="card">
			<h1>Confirmação</h1>
			<p>${mensagem}</p>
			<h2>Para verificar o seu cadastro em nosso sistema, no menu clique em Relatórios!.</h2>
		</div>
	</div>
</body>
</html>