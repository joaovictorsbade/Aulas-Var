function pesquisacep(cep) {
    let cepfinal = cep

    if (cepfinal != "") {
       document.getElementById('rua').value = 'Rua Teste'
       document.getElementById('bairro').value = 'Jardin America'
       document.getElementById('cidade').value = 'Jandira'
       document.getElementById('estado').value = 'SP'
    }
    else{
      limparcampos()
    }
}

function limparcampos9(){
    document.getElementById('rua').value = ''
    document.getElementById('bairro').value = ''
    document.getElementById('cidade').value = ''
    document.getElementById('estado').value = ''
}