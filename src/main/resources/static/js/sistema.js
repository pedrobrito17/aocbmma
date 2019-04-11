$('.user').click(function () {
    $('#alterar-foto-perfil').modal();
});

$('.menu-down').click(function(){
    var display = $(this).find('ul').css('display');
    if(display == 'none'){
        $(this).find('ul').css('display','block');
    }
    else{
        $(this).find('ul').css('display','none');
    }
});

$(document).ready(function () {
    construcaoMenuMobile();

});

//constrói o menu mobile
function construcaoMenuMobile() {
    var nav = $('.col-menu');
    $('#mobileLinks').append(nav.html());
}

function menuMobile() {
    var mobileLinks = $('#mobileLinks');
    if (mobileLinks.css('display') === "block") {

        mobileLinks.css('display', 'none');

    } else {

        mobileLinks.css('display', 'block');

        $('.user').click(function () {
            $('#alterar-foto-perfil').modal();
        });

        $('.menu-down').click(function(){
            var display = $(this).find('ul').css('display');
            if(display == 'none'){
                $(this).find('ul').css('display','block');
            }
            else{
                $(this).find('ul').css('display','none');
            }
        });    
        
    }
}

