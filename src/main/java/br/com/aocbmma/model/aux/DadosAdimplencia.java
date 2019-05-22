package br.com.aocbmma.model.aux;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.aocbmma.model.PagamentoMensalidade;

public class DadosAdimplencia {

    private String nome;

    private String status;

    private String dataAdesao;

    private List<String> mensalidadesAtrasadas;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataAdesao() {
        return this.dataAdesao;
    }

    public void setDataAdesao(String dataAdesao) {
        this.dataAdesao = dataAdesao;
    }

    public List<String> getMensalidadesAtrasadas() {
        return this.mensalidadesAtrasadas;
    }

    public void setMensalidadesAtrasadas(List<String> mensalidadesAtrasadas) {
        this.mensalidadesAtrasadas = mensalidadesAtrasadas;
    }

    public DadosAdimplencia criarObjetoDadosAdimplencia(List<PagamentoMensalidade> pags){
        DadosAdimplencia dadosAdimp = new ConversorPagamentoMensalidadeEmDadosAdimplencia().converterListPagamentMensalidadeEmDadosAdimplencia(pags);
        return dadosAdimp;
    }
    
    public class ConversorPagamentoMensalidadeEmDadosAdimplencia{

        private DadosAdimplencia dadosAdimplencia;

        public DadosAdimplencia converterListPagamentMensalidadeEmDadosAdimplencia(List<PagamentoMensalidade> pags){
            List<Date> mensalidadesAtrasadas = new ArrayList<Date>();
            String nomeSocio = pags.get(0).getSocio().getSocio().getNome();
            Date dataAdesao = pags.get(0).getSocio().getData_adesao();
            String status = pags.get(0).getSocio().getStatus();
            
            for (PagamentoMensalidade pag : pags) {
                mensalidadesAtrasadas.add( pag.getData_mensalidade() );
            }

            dadosAdimplencia = new DadosAdimplencia();
            dadosAdimplencia.setNome(nomeSocio);
            dadosAdimplencia.setStatus(status);
            dadosAdimplencia.setDataAdesao( this.converterDataEmString(dataAdesao) );
            dadosAdimplencia.setMensalidadesAtrasadas( this.converterListDataEmListString(mensalidadesAtrasadas) );
            return dadosAdimplencia;
        }


        public String converterDataEmString(Date data){
            SimpleDateFormat formatador = new SimpleDateFormat("MMM, yyyy");
            return formatador.format(data).toUpperCase();
        }
    
        public List<String> converterListDataEmListString(List<Date> datas){
            SimpleDateFormat formatador = new SimpleDateFormat("MMM, yyyy");
            List<String> list = new ArrayList<String>();
            
            for (Date data : datas) {
                list.add( formatador.format(data).toUpperCase() );
            }
            return list;
        }
    }

}