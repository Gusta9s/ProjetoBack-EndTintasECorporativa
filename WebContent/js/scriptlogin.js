function logar(){
    var login = document.getElementById("login").value;
    var senha = document.getElementById("senha").value;

    if(login == "Gustavo" && senha == "BoxCola123"){
        alert("Login autorizado, seja bem-vindo " + login + "!.");
        location.href = "../index.jsp";
    }
    else{
        alert("Usuario ou senha invalidos!.")
    }
}