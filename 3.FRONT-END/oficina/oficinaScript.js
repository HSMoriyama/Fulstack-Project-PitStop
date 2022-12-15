//VARIAVEIS DO CADASTRO DE OFICINA
const form = document.querySelector("form");
const razaoSocial = document.querySelector("#razaoSocial");
const cnpj = document.querySelector("#cnpj");
const telefone = document.querySelector("#telefone");
const email = document.querySelector("#exampleInputEmail1");
const endereco = document.querySelector("#exampleFormControlTextarea1");
const statusOficina = document.querySelector("#statusOficina");

//VARIAVEIS DA CONSULTA DE SERVIÇO
const url = "http://localhost:8080/servico";
const lista = document.querySelector("#listaServicos");

//FUNÇÃO CADASTRO DE OFICINA
function cadastrar(){
    
    //FETCH ACESSA A API ATRAVÉS DO ENDEREÇO
    //UPLOAD DE UM JSON PARA A API
    fetch("http://localhost:8080/oficina",
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
                razaoSocial: razaoSocial.value,
                cnpj: cnpj.value,
                telefone: telefone.value,
                email: email.value,
                endereco: endereco.value,
                status: statusOficina.value
            })
        })
        //O QUE FAZER COM A RESPOSTA
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })

}

function limpaDados(){
    const status = document.querySelector("#status");
    status.value = "STATUS: Dados cadastrados com sucesso!";
    razaoSocial.value = " ";
    cnpj.value = " ";
    telefone.value = " ";
    email.value = " ";
    endereco.value = " ";
    statusOficina.value = " ";
}


form.addEventListener('submit', (event) => {
    event.preventDefault();
    cadastrar();
    limpaDados();
});

async function consultarServicos() {
    const response = await fetch(url);
    const Data = await response.json();
    console.log(Data);

    Data.map((post) => {
        
        tr = document.createElement("tr");

       let id = document.createElement("td");
       let nome = document.createElement("td");
       let telefone = document.createElement("td");
       let oficina = document.createElement("td");
       let data = document.createElement("td");
       let horario = document.createElement("td");
       let descricao = document.createElement("td");
                    
        id.innerHTML = post.idServico;
        nome.innerHTML = post.nomeCliente;
        telefone.innerHTML = post.telefoneCliente;
        oficina.innerHTML = post.nomeOficina;
        data.innerHTML = post.data;
        horario.innerHTML = post.horario;
        descricao.innerHTML = post.descricaoServico;
        
        tr.appendChild(id);
        tr.appendChild(nome);
        tr.appendChild(telefone);
        tr.appendChild(oficina);
        tr.appendChild(data);
        tr.appendChild(horario);
        tr.appendChild(descricao);
        
        listaServicos.appendChild(tr);
        
    });

}               