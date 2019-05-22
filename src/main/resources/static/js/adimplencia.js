$(function(){
    $('.dados-adimplencia').css('display','none');
});

function getDadosAdimplencia(socioCod) {
    
    $.ajax({
        url: '/admin/buscar-dados-adimplencia/' + socioCod,
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        type: 'GET',
        beforeSend: function(){
            $('#animacao').css('display','block'); //inicia a animação
        },
        error: function (jqXHR) {
            console.log("Desculpe! Houve um erro: " + jqXHR.status);
        },
        success: function(retorno){
            console.log(retorno);
            construtorDosDadosNaView(retorno);
        },
        complete: function(){
            $('#animacao').css('display','none'); //encerra a animação
            $('.dados-adimplencia').css('display','block');
        }
      });
}

function construtorDosDadosNaView(json){
    $('#nome').text(json.nome);
    $('#status').text(json.status);
    $('#menIni').text(json.dataAdesao);

    let tam = json.mensalidadesAtrasadas.length;
    $('#menAtrasadas').empty();

    if(json.status == 'inadimplente'){
        for(let i = 0 ; i < tam ; i++){
            $('#menAtrasadas').append(
                '<p class="mt-n3" style="color:red;">'
                +
                    json.mensalidadesAtrasadas[i]
                +
                '</p>'
            )
        }
    }

}
 