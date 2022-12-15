const form = document.querySelector("form");
const userNome = document.querySelector("#nomeUser");
const userSenha = document.querySelector("#exampleInputPassword1");
const userStatus = document.querySelector("#status");

//FUNÇÃO cadastrar()
function logar(){
    
    //FETCH ACESSA A API ATRAVÉS DO ENDEREÇO
    //UPLOAD DE UM JSON PARA A API
    fetch("http://localhost:8080/user/login",
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
        .then(function (res) { 
            console.log(res) 
            if(res.status == 200){
                window.location = '../oficina/area-oficina.html';
            }else if(res.status == 403){
                window.alert('Acesso negado! Verifique sua senha!');
            }else{
                window.alert('Usuário não permitido!');
            }
        })
        .catch(function (res) { console.log(res) })

}

form.addEventListener('submit', function(event){
    event.preventDefault();
    logar();
});