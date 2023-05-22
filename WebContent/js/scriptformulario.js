function exibirFormulario() {
		var tipoPessoa = document.getElementById("tipo-pessoa").value;
		var formularioPessoaFisica = document
				.getElementById("formulario-pessoa-fisica");
		var formularioPessoaJuridica = document
				.getElementById("formulario-pessoa-juridica");

		if (tipoPessoa === "fisica") {
			formularioPessoaFisica.style.display = "block";
			formularioPessoaJuridica.style.display = "none";
		} else if (tipoPessoa === "juridica") {
			formularioPessoaFisica.style.display = "none";
			formularioPessoaJuridica.style.display = "block";
		}
	}