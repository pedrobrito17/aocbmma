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
    beforeShowDay: disableSunday
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
      showAnim: 'slide',
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

/** Days to be disabled as an array */

function DisableSpecificDates(date) {

  var m = date.getMonth();
  var d = date.getDate();
  var y = date.getFullYear();

  // First convert the date in to the mm-dd-yyyy format 
  // Take note that we will increment the month count by 1 
  var currentdate = (m + 1) + '-' + d + '-' + y;



  // We will now check if the date belongs to disableddates array 
  for (var i = 0; i < disableddates.length; i++) {

    // Now check if the current date is in disabled dates array. 
    if ($.inArray(currentdate, disableddates) != -1) { //disableddates são as datas já reservadas. Váriavel global.
      return [false];
    }
  }

  // In case the date is not present in disabled array, we will now check if it is a weekend. 
  // We will use the noWeekends function
  var sundayDate = disableSunday(date);
  return sundayDate;

}

function disableSunday(date) {
  var day = date.getDay();
  return [(day > 0), ""];
}