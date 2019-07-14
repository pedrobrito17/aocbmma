$(function(){
    $('#form-cadastro').validate({
        errorClass: "is-invalid",
        rules: {
            nome: {
                required: true,
                minlength: 5
            },
            cpf: {
                required: true,
                minlength: 14
            },
            tipoSocio: "required",
            data_nascimento: "required",
            "dadosOficial.nome_guerra" : "required",
            "dadosOficial.posto" : "required",
            "dadosOficial.corporacao" : "required",  
            "dadosOficial.lotacao" : "required",  
            "dadosOficial.rg_militar" : "required",  
            "dadosOficial.matricula" : "required",
            "dadosBancarios.banco" : "required",
            "dadosBancarios.agencia" : "required",
            "dadosBancarios.conta_corrente" : "required",
            "dadosContato.cep" : "required",
            "dadosContato.whatsapp" : "required",
            "dadosContato.email" : {
                required: true,
                email: true
            },
            "conf-email" : {
                required: true,
                email: true,
                equalTo : ".email"
            },
            "conf-senha" : {
                equalTo : "#senha"
            }
        },
        messages: {
            nome: "Digite seu nome completo",
            cpf: {
                "required": "Digite seu CPF"
            },
            tipoSocio: "Escolha uma categoria",
            data_nascimento: {
                "required": "Digite sua data de nascimento"
            },
            "dadosOficial.nome_guerra" : "Digite seu nome de guerra",
            "dadosOficial.posto" : "Selecione seu posto",
            "dadosOficial.corporacao" : "Marque a sua corporação",
            "dadosOficial.lotacao" : "Digite o local do seu trabalho",
            "dadosOficial.rg_militar" : "Digite o número da sua identificação funcional",
            "dadosOficial.matricula" : "Digite sua matrícula",
            "dadosBancarios.banco" : "Selecione o seu banco",
            "dadosBancarios.agencia" : "Digite o número da sua agência bancária",
            "dadosBancarios.conta_corrente" : "Digite o número da sua conta corrente",
            "dadosContato.cep" : "Digite o seu CEP",
            "dadosContato.whatsapp" : "Digite o número do seu whatsapp",
            "dadosContato.email" :  {
                "required" : "Digite seu e-mail",
                "email": "Digite um e-mail válido"
            },
            "conf-email" : {
                "required": "Confirme seu e-mail",
                "email": "Digite um e-mail válido",
                "equalTo" : "E-mail não confere"
            },
            "conf-senha" : {
                "equalTo" : "Senha não confere"
            }
        }
    });
});

$(function(){
    $('#form-meus-dados').validate({
        errorClass: "is-invalid",
        rules: {
            nome: {
                required: true,
                minlength: 5
            },
            cpf: {
                required: true,
                minlength: 14
            },
            data_nascimento: "required",
            "dadosOficial.nome_guerra" : "required",
            "dadosOficial.posto" : "required",
            "dadosOficial.corporacao" : "required",  
            "dadosOficial.lotacao" : "required",  
            "dadosOficial.rg_militar" : "required",  
            "dadosOficial.matricula" : "required",
            "dadosBancarios.banco" : "required",
            "dadosBancarios.agencia" : "required",
            "dadosBancarios.conta_corrente" : "required",
            "dadosContato.cep" : "required",
            "dadosContato.whatsapp" : "required",
            "dadosContato.email" : {
                required: true,
                email: true
            }
        },
        messages: {
            nome: "Digite seu nome completo",
            cpf: {
                "required": "Digite seu CPF"
            },
            data_nascimento: {
                "required": "Digite sua data de nascimento"
            },
            "dadosOficial.nome_guerra" : "Digite seu nome de guerra",
            "dadosOficial.posto" : "Selecione seu posto",
            "dadosOficial.corporacao" : "Marque a sua corporação",
            "dadosOficial.lotacao" : "Digite o local do seu trabalho",
            "dadosOficial.rg_militar" : "Digite o número da sua identificação funcional",
            "dadosOficial.matricula" : "Digite sua matrícula",
            "dadosBancarios.banco" : "Selecione o seu banco",
            "dadosBancarios.agencia" : "Digite o número da sua agência bancária",
            "dadosBancarios.conta_corrente" : "Digite o número da sua conta corrente",
            "dadosContato.cep" : "Digite o seu CEP",
            "dadosContato.whatsapp" : "Digite o número do seu whatsapp",
            "dadosContato.email" :  {
                "required" : "Digite seu e-mail",
                "email": "Digite um e-mail válido"
            }
        }
    });
});

$(function(){
    $('#form-alterar-senha').validate({
        errorClass: "is-invalid",
        rules: {
            "conf-senha" : {
                equalTo : "#senha"
            }
        },
        messages: {
            "conf-senha" : {
                "equalTo" : "Senha não confere"
            }
        }
    });
});

jQuery.validator.addMethod("data_nascimento", function (value, element) {
    return value.match(/^(0?[1-9]|[12][0-9]|3[0-1])[/](0?[1-9]|1[0-2])[/](19|20)(\d{2})$/);
}, "Digite uma data no padrão dd/MM/yyyy");

jQuery.validator.addMethod("cpf", function (value, element) {
    var cpf = value.replace(".","").replace(".","").replace("-","");
    return validarCPF(cpf);
}, "Digite um CPF válido");

function validarCPF(cpf) {
    var numeros, digitos, soma, i, resultado, digitos_iguais;
    digitos_iguais = 1;
    if (cpf.length < 11)
        return false;
    for (i = 0; i < cpf.length - 1; i++)
        if (cpf.charAt(i) != cpf.charAt(i + 1)) {
            digitos_iguais = 0;
            break;
        }
    if (!digitos_iguais) {
        numeros = cpf.substring(0, 9);
        digitos = cpf.substring(9);
        soma = 0;
        for (i = 10; i > 1; i--)
            soma += numeros.charAt(10 - i) * i;
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != digitos.charAt(0))
            return false;
        numeros = cpf.substring(0, 10);
        soma = 0;
        for (i = 11; i > 1; i--)
            soma += numeros.charAt(11 - i) * i;
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != digitos.charAt(1))
            return false;
        return true;
    } else
        return false;
}