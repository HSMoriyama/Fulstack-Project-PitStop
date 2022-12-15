const form = document.querySelector("form");
const userNome = document.querySelector("#nomeUser");
const userSenha = document.querySelector("#exampleInputPassword1");
const userStatus = document.querySelector("#status");

//FUNÇÃO cadastrar()
function cadastrar(){
    
    //FETCH ACESSA A API ATRAVÉS DO ENDEREÇO
    //UPLOAD DE UM JSON PARA A API
    fetch("http://localhost:8080/user",
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
                nome: userNome.value,
                senha: userSenha.value
            })
        })
        //O QUE FAZER COM A RESPOSTA
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })

}


form.addEventListener('submit', function(event){
    event.preventDefault();
    cadastrar();
    userStatus.value = "Usuário " + userNome.value + " foi cadastrado com sucesso!";
    window.alert("Usuário " + userNome.value + " foi cadastrado com sucesso!");

});