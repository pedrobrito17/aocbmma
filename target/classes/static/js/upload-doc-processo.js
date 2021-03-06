$(function(){
    var count_rows = $('#table-files tbody tr').length;
    if(count_rows>1){
        $('#table-files tbody tr:first-child').remove();  
    }
});

$(function(){
    $('#file1').change(function(){
        var tam = this.files[0].size;
        usuarioEscolheuAnexo(tam, this);
    });
    $('#file2').change(function(){
        var tam = this.files[0].size;
        usuarioEscolheuAnexo(tam, this);
    });
    $('#file3').change(function(){
        var tam = this.files[0].size;
        usuarioEscolheuAnexo(tam, this);
    });
});

var tam_file = 0;
var num_input = 1;
function usuarioEscolheuAnexo(size_file, input){
    var temTresArquivos = impedirUploadDeMaisDe3Arquivos();
    var arquivoMaiorQue2Mb = verificadorDeTamanho(size_file);
    if(temTresArquivos){
        $('#text-return').append('<p class="text-danger">Não permitido. O máximo são 3 arquivos.</p>');
        input.value='';
    }
    else if(arquivoMaiorQue2Mb){
        $('#text-return').append('<p class="text-danger">Não permitido. O arquivo é maior que 2mb.</p>');
        input.value='';
    }
    else{
        $('#text-return').empty();
        var inputFile = input.value;
        var file = input.files[0];
        $('#names_files').append(
            '<div class="row mb-4">'+
                '<div class="col-sm-12 col-md-2 offset-md-1 img-preview"></div>'+
                '<div class="col-sm-12 col-md-2 row-file align-middle"><span class="align-middle">'+getNameFile(inputFile)+'</span></div>'+
                '<div class="col-sm-3 col-md-4">'+
                    '<div class="progress">'+
                        '<div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" '+
                            'role="progressbar" style="width: 0%" aria-valuenow="0" aria-valuemin="0" '+
                            'aria-valuemax="100">'+
                                '<span class="status-bar">0% enviado</span>'+
                        '</div>'+
                    '</div>'+
                '</div>'+
                '<div class="col-sm-3 col-md-3">'+tam_file+' Kb</div>'+
            '</div>'
        );
        insertSrcImgInput(file);
        $('#labelfiles').prop('for','file'+(num_input+1) );
        num_input = (num_input + 1) == 4 ? 1 : num_input+1;
    }
}

function insertSrcImgInput(file){
    var fileReader = new FileReader();
    fileReader.readAsDataURL(file);
    fileReader.onloadend = function(){
        var error = fileReader.error;
        var file_type = file.type;
        if(error==null && file_type != 'application/pdf'){
            $('.img-preview').last().append('<img src="'+ fileReader.result +'" class="img-thumbnail rounded">');
        }
    }
}

function verificadorDeTamanho(tam){
    if(tam > 2097152){
        return true;
    }else{
        tam_file = tam*0.001;
        tam_file = tam_file.toFixed(3);
        return false;
    }
}

function impedirUploadDeMaisDe3Arquivos(){
    var count_files = $('#names_files').find('.row-file').length;
    var count_rows = $('#table-files tbody tr').length;
    var count_anexo0 = $('#table-files tbody tr#nenhum-anexo').length;

    if(count_files == 3 || count_rows == 3){
        return true;
    }
    else if( (count_files+count_rows-count_anexo0)==3 ){
        return true;
    }
    return false;
}

function getNameFile(path){
    var id0 = path.lastIndexOf("\\");
    var idlast = path.length;
    return path.slice(id0+1, idlast);
}

function limparListaDeArquivosASeremEnviados(){
    $('#names_files').empty();
    $('#text-return').empty();
    $('#labelfiles').prop('for','file1');
    $('#file1').val('');
    $('#file2').val('');
    $('#file3').val('');
}

function submitFormDocs(formDocs){
    var formData = getFormData();
    $.ajax({
        url: '/sisaocbmma/upload-files',
        type: 'POST',
        data: formData,
        dataType: "json",
        contentType: false,
        cache: false,
        processData: false,
        xhr: function () {
            var xhr = $.ajaxSettings.xhr();
            if(xhr.upload){
                xhr.upload.addEventListener('progress', function(event) {
                    var percent = 0;
                    var position = event.loaded || event.position;
                    var total = event.total;
                    if (event.lengthComputable) {
                        percent = Math.ceil(position / total * 100);
                    }
                    //update progressbar
                    $(".progress-bar").css("width", + percent +"%");
                    $(".status-bar").text(percent +"%");
                }, true);
            }
            return xhr;         
        }
    })
    .done(function (resposta) {
        var dados = JSON.parse( JSON.stringify(resposta) );
        if(dados.msg=='vazio'){
            alert('Desculpe! Ocorreu um erro no envio da documentação.'+
            '\nVerifique novamente a documentação e se você está adimplente.'+
            '\nSomente os sócios adimplentes podem enviar a documentação.');
        }
        else if(dados.msg=='gravou'){
            window.location.reload();
        }
        else{
            setTimeout(function(){
                inserirDadosNaTabela(dados);
                limparListaDeArquivosASeremEnviados();
                $('#text-return').append('<p class="text-success">Documento enviado com sucesso!</p>');
            }, 1000);
        }
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        alert("Desculpe! Houve um erro: " + jqXHR.status);
        limparListaDeArquivosASeremEnviados();
    });
}

function getFormData(){
    var formData = new FormData();
    var inputsFiles = $('form#docs input[type="file"]');

    for(let i = 0 ; i < inputsFiles.length ; i++){
        if(inputsFiles[i].files[0] != null){
            formData.append("file", inputsFiles[i].files[0]);
        }
    }
    return formData;
}

function inserirDadosNaTabela(dados){
    $('table#table-files tbody tr').remove();  
    for(let i = 0 ; i < dados.length ; i++){
        $('#table-files tbody').append(
            '<tr id="'+dados[i].id+'">'+
                '<td class="align-middle">'+dados[i].name+'</td>'+
                '<td class="align-middle">'+dados[i].tamanho+'</td>'+
                '<td class="align-middle text-center">'+
                    '<a class="btn btn-sm btn-danger text-white" href="javascript:deletarArquivo('+dados[i].id+');">'+
                        '<i class="far fa-trash-alt"></i>'+
                    '</a>'+
                '</td>'+
                '<td class="align-middle text-center">'+
                    '<a class="btn btn-sm btn-dark text-white" download="'+dados[i].name+'" href="'+dados[i].path+'">'+
                        '<i class="fas fa-download"></i>'+
                    '</a>'+
                '</td>'+
            '</tr>'
        );  
    }
}

function deletarArquivo(id){
    $.ajax({
        url: '/sisaocbmma/deletar-upload-file-doc/'+id,
        type: 'POST'
    })
    .done(function (resposta) {
        if(resposta=='true'){
            deleteRowFile(id);
            $('#text-return').append('<p class="text-success">Documento deletado com sucesso!</p>');            
        }
        else{
            alert('Desculpe! Não foi possível deletar. Tente novamente.')
        }
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        alert("Desculpe! Houve um erro: " + jqXHR.status);
    });
}

function deleteRowFile(id){
    $('#table-files tbody #'+id).remove();  
    var children = $('#table-files tbody').children();  
    if(children.length==0){
        $('#table-files tbody').append(
            '<tr>'+
                '<td colspan="4">Nenhum documento anexado.</td>'+
            '</tr>'
        );
    }
}