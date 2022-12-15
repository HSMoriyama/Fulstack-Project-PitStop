const form = document.querySelector('.busca');
const paramBusca = document.querySelector('#paramBusca');

//FUNÇÃO cadastrar()
function buscar(){

    //FETCH ACESSA A API ATRAVÉS DO ENDEREÇO
    //UPLOAD DE UM JSON PARA A API
    fetch(`http://localhost:8080/servico/bynome/${paramBusca.value}`)
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })

}

form.addEventListener('submit', function(event){
    event.preventDefault();
    buscar();
});


/*
function excluirUsuario(posicao) {
    const url = `http://localhost:8081/usuario/${posicao}`;
    console.log(posicao)

    fetch(url,
{
    headers: {
        "Accept": "application/json",
        "Content-Type": "application/json"
    },
    method: "DELETE"
    
}) */