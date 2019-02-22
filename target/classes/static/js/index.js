$(document).ready(function () {
    construcaoMenuMobile();

    $('.ativar-sub-mobile').click(function () {
        var submenu = $(this).parent().find('.menu-dropdown-mobile');
        if (submenu.css('display') === 'none') {
            submenu.css('display', 'block');
        } else {
            submenu.css('display', 'none');
        }
    });

    $(".news > div > p + p").hide();
});

// Carrousel dos convênios
$('.carousel').carousel({
    interval: 5000
});

//constrói o menu mobile
function construcaoMenuMobile() {
    var nav = $('nav');
    $('#mobileLinks').append(nav.html());
    var listMenu = $('#mobileLinks').find('.menu');
    for (let index = 0; index < listMenu.length; index++) {
        listMenu[index].className = 'menu-mobile';
        listMenu[index].children[0].className = 'ativar-sub-mobile';
        listMenu[index].children[1].className = 'menu-dropdown-mobile';
    }
}

function menuMobile() {
    var mobileLinks = $('#mobileLinks');
    if (mobileLinks.css('display') === "block") {
        mobileLinks.css('display', 'none');
        $('.topo-div-end').css('display', 'block');

    } else {
        mobileLinks.css('display', 'block');
        $('.topo-div-end').css('display', 'none');
    }
}