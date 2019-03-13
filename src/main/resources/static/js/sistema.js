$('.menu-down').click(function(){
    var display = $(this).find('ul').css('display');
    if(display == 'none'){
        $(this).find('ul').css('display','block');
    }
    else{
        $(this).find('ul').css('display','none');
    }

});



