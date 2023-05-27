function pesquisacep(cep) {
  let cepfinal = cep
  let validacep = /^[0-9]{8}$/

  if (validade.test(cepfinal)) {

  }

  if (cepfinal != "") {
    if (validade.test(cepfinal)) {
      let script = document.createElement('script')
      script.src = 'https://viacep.com.br/ws/' + cepfinal + '/json/?callback=callback_name'
      document.body.appendChild(script)
    }
    else{
      alert('CEP Invalido')
      limparcampos()
    }

  }
  else {
    limparcampos()
  }
}

function callback_name(objetocep) {
  if (!("erro" in objetocep)) {
    document.getElementById('rua').value = (objetocep.logradouro)
    document.getElementById('bairro').value = (objetocep.bairro)
    document.getElementById('cidade').value = (objetocep.localidade)
    document.getElementById('estado').value = (objetocep.uf)
  }
}

function limparcampos() {
  document.getElementById('rua').value = ''
  document.getElementById('bairro').value = ''
  document.getElementById('cidade').value = ''
  document.getElementById('estado').value = ''
}


