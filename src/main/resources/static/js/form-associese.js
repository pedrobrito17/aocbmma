var cont = 0;

function addDependente() {
    var dadosDependente = $('.dependente');
    console.log(dadosDependente);
    cont = 0;
    if (dadosDependente != undefined) {
        if (dadosDependente.length > 1) {
            cont = dadosDependente.length;
            console.log("array: " + cont);
        } else if (dadosDependente.length == 0) {
            cont = 0;
        } else {
            cont = 1;
        }
    }

    $('#dependente').append('<div class="row mt-4">' +
        '<div class="col-sm-12 col-lg-8">' +
        '<input class="form-control form-custom dependente" type="text" name="dependentes[' + cont +
        '].nome" id="dependentes' + cont + '.nome" placeholder="Dependente">' +
        '</div>' +
        '<div class="col-sm-12 col-lg-4 mt-4 mt-lg-0">' +
        '<select class="form-control form-custom" name="dependentes[' + cont +
        '].parentesco" id="dependentes' + cont + '.parentesco">' +
        '<option value="" disabled selected>Parentesco</option>' +
        '<option value="Cônjugue">Cônjugue</option>' +
        '<option value="Filho(a)">Filho(a)</option>' +
        '<option value="Pai">Pai</option>' +
        '<option value="Mãe">Mãe</option>' +
        '<option value="Sogro(a)">Sogro(a)</option>' +
        '</select>' +
        '</div>' +
        '</div>');
}

function removeDependente() {
    $('#dependente .row:last-child').remove();
    cont--;
}

function deletarDependente(id) {
    var url = location.href; //pega endereço que esta no navegador
    url = url.split("/"); //quebra o endeço de acordo com a / (barra)

    $.ajax({
        url: '/sisaocbmma/deletar-dependente/' + id,
        type: 'DELETE'
      })
      .done(function () {
        console.log("funcionou");
        location.reload();
      })
      .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("Desculpe! Houve um erro: " + jqXHR.status);
      });
}

$('#popover').popover({
    trigger: 'hover',
    placement: 'top',
    html: true,
    content: '<div class="popover-custom">' +
        '<div class="title-popover">' +
        '<h5>Quem são dependentes?</h5>' +
        '</div>' +
        '<div class="body-popover">' +
        '<ol style="list-style-type: upper-roman; margin: 0px;">' +
        '<li>filho(a) solteiro(a) até 21 anos de idade ou 24 anos se estudante universitário;</li>' +
        '<li>mãe, pai ou sogro(a), viúvo(a), desquitada ou divorciada que viva sob dependência financeira e mesmo teto do associado.</li>' +
        '</ol>' +
        '</div>' +
        '</div>'
});

$('#categoria').popover({
    trigger: 'hover',
    placement: 'top',
    html: true,
    content: '<div class="popover-custom">' +
        '<div class="body-popover">' +
        '<ol style="list-style-type: upper-roman; margin: 0px;">' +
        '<li>Fundadores: oficiais que assinaram a Ata de Fundação. </li>' +
        '<li>Efetivos: cadetes, aspirantes e oficiais do CBMMA.</li>' +
        '<li>Contribuintes: oficiais das Forças Armadas ou outras Forças Auxiliares.</li>' +
        '<li>Honorários: reconhecidos por Assembléia Geral.</li>' +
        '</ol>' +
        '</div>' +
        '</div>'
});

$(document).ready(function () {
    $('.date').mask('00/00/0000');
    $('.cep').mask('00000-000');
    $('.phone_with_ddd').mask('(00) 00000-0000');
    $('.mixed').mask('AAA 000-S0S');
    $('.cpf').mask('000.000.000-00', {
        reverse: true
    });
    $('.money').mask('000.000.000.000.000,00', {
        reverse: true
    });
    $('.money2').mask("#.##0,00", {
        reverse: true
    });
    $('.percent').mask('##0,00%', {
        reverse: true
    });
    $('.clear-if-not-match').mask("00/00/0000", {
        clearIfNotMatch: true
    });
    $('.placeholder').mask("00/00/0000", {
        placeholder: "__/__/____"
    });
    $('.fallback').mask("00r00r0000", {
        translation: {
            'r': {
                pattern: /[\/]/,
                fallback: '/'
            },
            placeholder: "__/__/____"
        }
    });
    $('.selectonfocus').mask("00/00/0000", {
        selectOnFocus: true
    });
});

function validarForm(form) {
    var erros = validarInputsAndSelects();

    if (!validarSenha() || erros > 0) {
        console.log("Form com erros de validação");
        return false;
    } else {
        form.submit();
    }
}

function validarInputsAndSelects() {
    var erros = 0;
    var nome = $('input[name=nome]').val();
    var cpf = $('input[name=cpf]').val();
    var dta_nascimento = $('input[name=data_nascimento]').val();
    var cep = $('#cep').val();
    var whatsapp = $('#whatsapp').val();
    var posto = $('#posto').val();
    var categoria = $('#categoria').val();
    var banco = $('#banco').val();
    var corporacao = $("#corporacao input[type=radio]:checked").val();
    var quadro = $("#quadro input[type=radio]:checked").val();

    var input_text = $('.validacao-input-text');
    for (let i = 0; i < input_text.length; i++) {
        if (input_text[i].value == '') {
            input_text[i].focus();
            input_text[i].classList.add('is-invalid');
            erros++;
        }
    }
    if (cep.length != 9) {
        $('#cep').focus();
        $('#cep').addClass('is-invalid');
        erros++;
    }
    if (whatsapp.length != 15) {
        $('#whatsapp').focus();
        $('#whatsapp').addClass('is-invalid');
        erros++;
    }
    if (cpf.length != 14) {
        $('input[name=cpf]').focus();
        $('input[name=cpf').addClass('is-invalid');
        erros++;
    }
    if (dta_nascimento.length != 10) {
        $('input[name=data_nascimento]').focus();
        $('input[name=data_nascimento').addClass('is-invalid');
        erros++;
    }
    if (posto.length == 0) {
        $('#posto').focus();
        $('#posto').addClass('is-invalid');
        erros++;
    }
    if (categoria.length == 0) {
        $('#categoria').focus();
        $('#categoria').addClass('is-invalid');
        erros++;
    }
    if (banco.length == 0) {
        $('#banco').focus();
        $('#banco').addClass('is-invalid');
        erros++;
    }
    if (corporacao == undefined) {
        $('#corporacao').focus();
        $('#corporacao input[type=radio]').addClass('is-invalid');
        erros++;
    }

    return erros;
}

function validarSenha() {
    var senha = $('input[name=senha]').val();
    var conf_senha = $('input[name=conf_senha]').val();
    if (senha != conf_senha || senha.length == 0 || conf_senha == 0) {
        $('input[name=senha]').addClass('is-invalid');
        $('input[name=conf_senha]').addClass('is-invalid');
        return false;
    }
    return true;
}

function validarAlterarSenha(form) {
    if (validarSenha()) {
        form.submit();
    }
}

function validarFormAtualizarMeusDados(form) {
    var erros = validarInputsAndSelects();
    if (erros == 0) {
        form.submit();
    }
}

$(".validacao-input-text").focusout(function () {
    if (!$(this).val()) {
        $(this).addClass('is-invalid');
    } else {
        $(this).removeClass('is-invalid');
    }
});

$("#cpf").focusout(function () {
    if ($(this).val().length != 14) {
        $(this).addClass('is-invalid');
    } else {
        $(this).removeClass('is-invalid');
    }
});

$("#cep").focusout(function () {
    if ($(this).val().length != 9) {
        $(this).addClass('is-invalid');
    } else {
        $(this).removeClass('is-invalid');
    }
});

$("#whatsapp").focusout(function () {
    if ($(this).val().length != 15) {
        $(this).addClass('is-invalid');
    } else {
        $(this).removeClass('is-invalid');
    }
});

$("#data_nascimento").focusout(function () {
    if ($(this).val().length != 10) {
        $(this).addClass('is-invalid');
    } else {
        $(this).removeClass('is-invalid');
    }
});

$('input').focus(function () {
    $(this).removeClass('is-invalid');
});
$('select').focus(function () {
    $(this).removeClass('is-invalid');
});

$("#cep").focusout(function () {
    $('#animacao').css('display','block'); //inicia a animação
    $.ajax({
        url: 'https://viacep.com.br/ws/' + $(this).val() + '/json/unicode/',
        dataType: 'json',
        success: function (resposta) {
            $("#logradouro").val(resposta.logradouro);
            $("#complemento").val(resposta.complemento);
            $("#bairro").val(resposta.bairro);
            $("#cidade").val(resposta.localidade);
            $("#uf").val(resposta.uf);
            $("#numero").focus();
            
            $('#animacao').css('display','none'); //encerra a animação
        },
        fail: function(jqXHR, textStatus, errorThrown) {
            console.log("Desculpe! Houve um erro: " + jqXHR.status);
            $('#animacao').css('display','none'); //encerra a animação
        }
    });
});



// $(document).ready(function(){
//     $('input[name=nome]').val('Pedro');
//     $('input[name=cpf]').val('001.881.933-83');
//     // $('input[name=data_nascimento]').val('17/04/1988');

//     $('#nome_guerra').val('Aragão');
//     $('#lotacao').val('2 BBM');
//     $('#rg_militar').val('2170');
//     $('#matricula').val('435');

//     $('#agencia').val('5878-1');
//     $('#conta_corrente').val('24973-4');

//     $('#whatsapp').val('(98) 98204-5453');
//     $('#celular').val('(98) 98204-5453');
//     $('#email').val('aragao@cbm.ma.gov.br');

//     $('#cep').val('65070-400');

//     $('#senha').val('fsadu');
//     $('#conf_senha').val('fsadu');
// });