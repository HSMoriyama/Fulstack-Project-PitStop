const form = document.querySelector("form");
const nome = document.querySelector("#nome");
const cpf = document.querySelector("#cpf");
const rg = document.querySelector("#rg");
const telefone = document.querySelector("#telefone");
const email = document.querySelector("#exampleInputEmail1");
const endereco = document.querySelector("#exampleFormControlTextarea1");

//FUNÇÃO cadastrar()
function cadastrar(){
    
    //FETCH ACESSA A API ATRAVÉS DO ENDEREÇO
    //UPLOAD DE UM JSON PARA A API
    fetch("http://localhost:8080/cliente",
        {
            //HEADER DESCREVE TIPO DE DADO(JSON)
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },

            //DEFINE O MÉTODO DE COMUNICAÇÃO
            method: "POST",

            //CONVERTE O OBJ EM JSON
            body: JSON.stringify({
                //OBJ JSON
                nome: nome.value,
                cpf: cpf.value,
                rg: rg.value,
                telefone: telefone.value,
                email: email.value,
                endereco: endereco.value
            })
        })
        //O QUE FAZER COM A RESPOSTA
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })

}

function limpaDados(){
    const status = document.querySelector("#status");
    status.value = "STATUS: Dados cadastrados com sucesso!";
    nome.value = " ";
    cpf.value = " ";
    rg.value = " ";
    telefone.value = " ";
    email.value = " ";
    endereco.value = " ";
}


form.addEventListener('submit', function(event){
    event.preventDefault();
    cadastrar();
    limpaDados();
});