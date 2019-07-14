//adiciona os options ao select
$(document).ready(function () {
    $('.time').mask('00:00');

    for (let i = 8; i < 22; i++) {
        $('#hora-inicio').append('<option value="' + i + ':00:00">' + i + ':00</option>');
    }
    for (let j = 9; j < 23; j++) {
        $('#hora-termino').append('<option value="' + j + ':00:00">' + j + ':00</option>');
    }
});

//recupera a data do input, troca / por - e chama o ajax
$(function () {
    $('#datepicker-campo').change(function () {
        $('#animacao').css('display','block'); //inicia a animação
        var data = $(this).val();
        data = data.replace('/', '-');
        data = data.replace('/', '-');
        getHorasIniciaisReservadasDoDiaSelecionado(data);
        getHorasTerminaisReservadasDoDiaSelecionado(data);
        limparDatasEscolhidas();
    });
});

var horas_iniciais = [];
function getHorasIniciaisReservadasDoDiaSelecionado(data) { // recupera as horas iniciais
    var url = location.href; //pega endereço que esta no navegador
    url = url.split("/"); //quebra o endeço de acordo com a / (barra)

    $.ajax({
            url: '/sisaocbmma/horas-iniciais/' + data,
            type: 'GET',
            async: false
        })
        .done(function (resposta) {
            horas_iniciais = resposta;
        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            alert("Desculpe! Houve um erro: " + jqXHR.status);
        });
}

var horas_terminais = [];
function getHorasTerminaisReservadasDoDiaSelecionado(data) { // recupera as horas iniciais
    var url = location.href; //pega endereço que esta no navegador
    url = url.split("/"); //quebra o endeço de acordo com a / (barra)

    $.ajax({
        url: '/sisaocbmma/horas-terminais/' + data,
        type: 'GET',
        async: false
    })
    .done(function (resposta) {
        horas_terminais = resposta;
    })
    .always(function () {
        $('#animacao').css('display','none'); //encerra a animação
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        alert("Desculpe! Houve um erro: " + jqXHR.status);
    });

}

function limparDatasEscolhidas() {
    let tam = horas_iniciais.length;

    $('#hora-inicio option').each(function (index, element) {
        for (let i = 0; i < tam; i++) {
            if (element.value == horas_iniciais[i]+':00:00' && (horas_terminais[i]-horas_iniciais[i])>1 ) {
                element.setAttribute('disabled','disabled');

                let valor = (horas_terminais[i]-horas_iniciais[i]);
                let horaNum = parseInt(horas_iniciais[i]);
                for(let j = 1 ; j < valor ; j ++){
                    $("#hora-inicio option[value='"+(horaNum+j)+":00:00']").attr('disabled','disabled');
                    $("#hora-termino option[value='"+(horaNum+j)+":00:00']").attr('disabled','disabled');
                }
            }
            else if(element.value == horas_iniciais[i]+':00:00'){
                element.setAttribute('disabled','disabled');
            }
        }
    });
    $('#hora-termino option').each(function (index, element) {
        for (let i = 0; i < tam; i++) {
            if (element.value == horas_terminais[i]+':00:00') {
                element.setAttribute('disabled','disabled');
            }
        }
    });
}

function exibirTermo(form){
    $('#termo').modal();
    $('#btn-reservar').click(function(){
        form.submit();
    });
}

function exibirTermoChale(form){
    $('input[name=data_entrada]').val( $('#checkin').val() );
    $('input[name=data_saida]').val( $('#checkout').val() );
    // $('input[name=chale]').val( $('chale-disp .span').text() );

    $('#termo').modal();
    $('#btn-reservar').click(function(){
        form.submit();
    });
}

function pesquisarDisponibilidade(){
    var data_entrada = $('#checkin').val();
    data_entrada = data_entrada.replace('/','-').replace('/','-');
    var data_saida = $('#checkout').val();
    data_saida = data_saida.replace('/','-').replace('/','-');

    var url = location.href; //pega endereço que esta no navegador
    url = url.split("/"); //quebra o endeço de acordo com a / (barra)

    $('#chales-disponiveis').load('/sisaocbmma/pesquisar-chale/'+data_entrada+'/'+data_saida);

}