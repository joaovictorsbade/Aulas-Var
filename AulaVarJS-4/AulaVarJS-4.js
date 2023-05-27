    document.addEventListener("DOMContentLoaded", function() {
        const botao = document.querySelector("#btn-buscar");
        botao.addEventListener("click", (e) => {
          BuscarTodosPosts();
        });
      });

async function BuscarTodosPosts() {
    const resposta = await fetch("https://jsonplaceholder.typicode.com/posts")
    const loadingElement = document.querySelector("#loading")
    const postContainer = document.querySelector("#post-container")
    

    console.log(resposta)
    const data = await resposta.json()
    console.log(data)
    loadingElement.classList.add("hide")
    data.map((postagem) => {
        const div = document.createElement("div")
        const title = document.createElement("h2")
        const body = document.createElement("p")
        const link = document.createElement("a")

        title.innerText = postagem.title
        body.innerText = postagem.body
        link.innerText = "Ler"
        link.setAttribute("href", "/post.html?id='" + postagem.id)

        div.appendChild(title)
        div.appendChild(body)
        div.appendChild(link)
        postContainer.appendChild(div)
    })
}

