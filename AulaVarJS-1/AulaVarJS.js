function alterarTexto(){
    if (confirm('Deseja Atualizar o Horario?')){
        document.getElementById('horario').innerHTML = Date()
    }
    else{
        alert('O horario não foi atualizado')
    }
}

function alertaPadrao(textoExibicao){
    alert(textoExibicao)
    textoExibicao = textoExibicao + " + " + "Alterei o valor"
    document.getElementById('h1teste').innerHTML = textoExibicao;
}


function Cauculadora(operacaoq){
    var valor1 = parseInt(document.getElementById('num1').value)
    var valor2 = parseInt(document.getElementById('num2').value)

    if (operacaoq == "Somar"){
    var resultado = valor1 + valor2
    alert(resultado)
    }
    else if (operacaoq == "Subtrair"){
        var resultado =  valor1 - valor2
        alert(resultado)
    }
    else if (operacaoq == "Multiplicar"){
        var resultado =  valor1 * valor2
        alert(resultado)
    }
    else if (operacaoq == "Dividir"){
        var resultado =  valor1 / valor2
        alert(resultado)
    }
}