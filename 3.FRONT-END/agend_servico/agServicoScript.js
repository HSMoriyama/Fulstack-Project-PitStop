const form = document.querySelector('form');
const nome = document.querySelector('#nomeCliente');
const telefone = document.querySelector('#telefoneCliente');
const nomeOficina = document.querySelector('#nomeOficina');
const data = document.querySelector('#data');
const horario = document.querySelector('#horario');
const descricaoServico = document.querySelector('#exampleFormControlTextarea1');

//FUNÇÃO cadastrar()
function cadastrar(){

    //FETCH ACESSA A API ATRAVÉS DO ENDEREÇO
    //UPLOAD DE UM JSON PARA A API
    fetch("http://localhost:8080/servico",
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
                nomeCliente: nome.value,
                telefoneCliente: telefone.value,
                nomeOficina: nomeOficina.value,
                data: data.value,
                horario: horario.value,
                descricaoServico: descricaoServico.value
            })
        })
        //O QUE FAZER COM A RESPOSTA
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })

        window.alert(`Seu serviço foi cadastrado! Em instantes a oficina ${nomeOficina.value} receberá seu agendamento!`);

}

function limpaDados(){
    const status = document.querySelector("#status");
    status.value = "STATUS: Dados cadastrados com sucesso!";
    nome.value = " ";
    telefone.value = " ";
    nomeOficina.value = " ";
    data.value = " ";
    horario.value = " ";
    descricaoServico.value = " ";
}

form.addEventListener('submit', function(event){
    event.preventDefault();
    cadastrar();
    limpaDados();
});