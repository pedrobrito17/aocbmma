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
        '].nome" id="dependentes' + cont + '.nome" placeholder="Dependente" autofocus>' +
        '</div>' +
        '<div class="col-sm-12 col-lg-4 mt-4 mt-lg-0">' +
        '<select class="form-control form-custom" name="dependentes[' + cont +
        '].parentesco" id="dependentes' + cont + '.parentesco">' +
        '<option value="" disabled selected>Parentesco</option>' +
        '<option value="Cônjuge">Cônjuge</option>' +
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

$('#tipoSocio').popover({
    trigger: 'focus',
    placement: 'top',
    html: true,
    content: '<div class="popover-custom">' +
        '<div class="body-popover">' +
        '<ol style="list-style-type: upper-roman; margin: 0px;">' +
        '<li>Fundadores: oficiais que assinaram a Ata de Fundação. </li>' +
        '<li>Efetivos: cadetes, aspirantes e oficiais do CBMMA.</li>' +
        '<li>Contribuintes: oficiais das Forças Armadas ou Forças Auxiliares e também civis.</li>' +
        '<li>Honorários: reconhecidos por Assembléia Geral.</li>' +
        '</ol>' +
        '</div>' +
        '</div>'
});

$(document).ready(function () {
    $('#data_nascimento').mask('00/00/0000');
    $('.agencia').mask('#-0', {reverse: true});
    $('.conta_corrente').mask('#-0', {reverse: true});
    $('.matricula').mask('#-00', {reverse: true});
    $('.rg_militar').mask('000000');
    $('.cep').mask('00000-000');
    $('.phone_with_ddd').mask('(00) 00000-0000');
    $('.mixed').mask('AAA 000-S0S');
    $('#cpf').mask('000.000.000-00', {
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

$(".cep").focusout(function () {
    $('#animacao').css('display','block'); //inicia a animação
    $.ajax({
        url: 'https://viacep.com.br/ws/' + $(this).val() + '/json/unicode/',
        dataType: 'json',
        success: function (resposta) {
            $(".endereco").val(resposta.logradouro);
            $(".bairro").val(resposta.bairro);
            $(".cidade").val(resposta.localidade);
            $(".uf").val(resposta.uf);
            $(".numero").focus();
            
            $('#animacao').css('display','none'); //encerra a animação
        },
        fail: function(jqXHR, textStatus, errorThrown) {
            console.log("Desculpe! Houve um erro: " + jqXHR.status);
            $('#animacao').css('display','none'); //encerra a animação
        }
    });
});

$(function(){
    $('#civil').click(function(){
        if( $('#civil').is(':checked') ){
            $('#dados-oficial').hide();
            $('#dadosOficial.nome_guerra').val(null);
            $('#dadosOficial.posto').val(null);
            $('#dadosOficial.lotacao').val(null);
            $('#dadosOficial.rg_militar').val(null);
            $('#dadosOficial.matricula').val(null);
        }
    })
});

//Formatando o texto de entrada nos inputs
$(function(){
    $("[type='email']").keyup(function(){
        $(this).val($(this).val().toLowerCase());
    });
    $('#nome').keyup(function(){
        $(this).val($(this).val().toUpperCase());
    });
    $("[name='dadosOficial.nome_guerra']").keyup(function(){
        $(this).val($(this).val().toUpperCase());
    });
});

$(document).ready(function(){
    // $('input[name=nome]').val('Pedro');
    // $('input[name=cpf]').val('001.881.933-83');
    // $('#categoria').val('efetivo');
    // $('input[name=data_nascimento]').val('17/04/1988');

    // $('#nome_guerra').val('Aragão');
    // $('#posto').val('Capitão');
    // $('#lotacao').val('2 BBM');
    // $('#rg_militar').val('2170');
    // $('#matricula').val('435');

    // $('#banco').val('Banco do Brasil S.A.');
    // $('#agencia').val('5878-1');
    // $('#conta_corrente').val('24973-4');

    // $('#whatsapp').val('(98) 98204-5453');
    // $('#celular').val('(98) 98204-5453');
    // $('#email').val('');

    // $('#cep').val('65070-400');

    // $('#senha').val('fsadu');
    // $('#conf-senha').val('fsadu');
});