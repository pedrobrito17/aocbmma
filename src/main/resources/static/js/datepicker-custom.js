//DATEPICKER CAMPO DE FUTEBOL
$(function () {
  $("#datepicker-campo").datepicker({
    dateFormat: 'dd/mm/yy',
    dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
    dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D'],
    dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb', 'Dom'],
    monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    nextText: 'Próximo',
    prevText: 'Anterior',
    autoSize: true,
    showAnim: 'slide',
    minDate: 0,
    beforeShowDay: DisableDatesFeriadosEDomingos
  });
});

//DATEPICKER ESPACO CAJUEIRO
$(function () {
  $("#datepicker-cajueiro").datepicker({
    dateFormat: 'dd/mm/yy',
    dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
    dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D'],
    dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb', 'Dom'],
    monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    nextText: 'Próximo',
    prevText: 'Anterior',
    autoSize: true,
    showAnim: 'slide',
    minDate: 0,
    beforeShowDay: DisableSpecificDates
  });
});

//DATEPICKER CHALE
$(function () {
  var dateFormat = 'dd/mm/yy', from = $("#checkin")
    .datepicker({
      dateFormat: 'dd/mm/yy',
      changeMonth: true,
      numberOfMonths: 2,
      dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
      dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D'],
      dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb', 'Dom'],
      monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
      monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
      nextText: 'Próximo',
      prevText: 'Anterior',
      autoSize: true,
      showAnim: 'slide',
      minDate: 0
    })
    .on("change", function () {
      to.datepicker("option", "minDate", getDate(this));
    }),
    to = $("#checkout").datepicker({
      dateFormat: 'dd/mm/yy',
      changeMonth: true,
      numberOfMonths: 2,
      dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
      dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D'],
      dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb', 'Dom'],
      monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
      monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
      nextText: 'Próximo',
      prevText: 'Anterior',
      autoSize: true,
      showAnim: 'slide'
    })
    .on("change", function () {
      from.datepicker("option", "maxDate", getDate(this));
    });

  function getDate(element) {
    var date;
    try {
      date = $.datepicker.parseDate(dateFormat, element.value);
    } catch (error) {
      date = null;
      console.log(error);
    }
    return date;
  }
});


function DisableSpecificDates(date) {
  var currentdate = getCurrenteDate(date);
  
  if ($.inArray(currentdate, disableddates) != -1) { //disableddates são as datas já reservadas. Váriavel global.
    return [false];
  }
  else if ($.inArray(currentdate, getDatasFeriadosDoAno() ) != -1) {
    return [false];
  }
  else if ($.inArray(currentdate, datasBloqueadasPeloAdmin ) != -1) { //datasBloqueadasPeloAdmin é uma variavel global
    return [false];
  }
  else{
    var sundayDate = disableSunday(date);
    return sundayDate;
  }
}


function DisableDatesFeriadosEDomingos(date){
  var currentdate = getCurrenteDate(date);
  if ($.inArray(currentdate, getDatasFeriadosDoAno() ) != -1) {
    return [false];
  }
  else if ($.inArray(currentdate, datasBloqueadasPeloAdmin ) != -1) { //datasBloqueadasPeloAdmin é uma variavel global
    return [false];
  }
  else{
    var sundayDate = disableSunday(date);
    return sundayDate;
  }
}

function disableSunday(date) {
  var day = date.getDay();
  return [(day > 0), ""];
}

function getCurrenteDate(date){
  var m = (date.getMonth()+1)<10 ? '0'+(date.getMonth()+1) : (date.getMonth()+1);
  var d = (date.getDate()<10) ? '0'+date.getDate() : date.getDate();
  var y = date.getFullYear();

  var currentdate = y + '-' + m + '-' + d;
  return currentdate;
}

function getDatasFeriadosDoAno(){
  var anoAtual = new Date().getFullYear();
  var proximoAno = new Date().getFullYear() + 1;

  var dataFeriados = [
    anoAtual+'-01-01', //ano novo
    anoAtual+'-04-21', //tiradentes
    anoAtual+'-05-01', //dia do trabalhador
    anoAtual+'-06-29', //são pedro
    anoAtual+'-07-28', //adesão do maranhão a independência
    anoAtual+'-09-07', //independência do brasil
    anoAtual+'-09-08', //aniversário de são luís
    anoAtual+'-10-12', //nossa senhora aparecida
    anoAtual+'-10-28', //dia do servidor público
    anoAtual+'-11-02', //finados
    anoAtual+'-11-15', //proclamação da república
    anoAtual+'-11-20', //dia da consciência negra
    anoAtual+'-12-08', //nossa senhora da conceição
    anoAtual+'-12-24', //véspera de natal
    anoAtual+'-12-25', //natal
    anoAtual+'-12-31', //véspera de ano novo

    //ano seguinte

    proximoAno+'-01-01', //ano novo
    proximoAno+'-04-21', //tiradentes
    proximoAno+'-05-01', //dia do trabalhador
    proximoAno+'-06-29', //são pedro
    proximoAno+'-07-28', //adesão do maranhão a independência
    proximoAno+'-09-07', //independência do brasil
    proximoAno+'-09-08', //aniversário de são luís
    proximoAno+'-10-12', //nossa senhora aparecida
    proximoAno+'-10-28', //dia do servidor público
    proximoAno+'-11-02', //finados
    proximoAno+'-11-15', //proclamação da república
    proximoAno+'-11-20', //dia da consciência negra
    proximoAno+'-12-08', //nossa senhora da conceição
    proximoAno+'-12-24', //véspera de natal
    proximoAno+'-12-25', //natal
    proximoAno+'-12-31' //véspera de ano novo
  ];

  return dataFeriados;
}