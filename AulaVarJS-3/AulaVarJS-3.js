function incluirRegistro() {
  let nomeUsuario = document.getElementById('nome').value
  if (nomeUsuario != "") {
    let tabela = document.getElementById('usuarios')
    let numeroLinhas = tabela.ariaRowCount
    let linha = tabela.insertRow(numeroLinhas)
    let campo1 = linha.insertCell(0)
    let campo2 = linha.insertCell(1)
    campo1.innerHTML = document.getElementById('nome').value
    campo2.innerHTML = "<button onclick='removerLinha(this)'>Remover Linha</button>"
    document.getElementById('nome').value = ""
  }
  else {
    alert('Nome Inválido')
  }
}

function removerLinha(linha) {
  console.log(linha.parentNode.parentNode)
  let i = linha.parentNode.parentNode.rowIndex
  document.getElementById('usuarios').deleteRow(i)
}