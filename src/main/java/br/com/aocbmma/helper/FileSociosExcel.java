package br.com.aocbmma.helper;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.SocioService;

@Component
public class FileSociosExcel {

    public static String FILE = "socios-AOCBMMA.xlsx";

    @Autowired
    private SocioService socioService;

    private HSSFWorkbook planilha;

    public byte[] criarArquivoExcel(String path_root){
        planilha = new HSSFWorkbook();
        

        FileOutputStream fileOutputStream = null;
        try{
            File file = new File(path_root + FILE);
            apagarArquivoCriadoAnteriormente(file);
            fileOutputStream = new FileOutputStream( file );

            criarFolhaPorCategoriaDoSocio("fundador");
            criarFolhaPorCategoriaDoSocio("efetivo");
            criarFolhaPorCategoriaDoSocio("contribuinte");
            criarFolhaPorCategoriaDoSocio("honorário");

            planilha.write(fileOutputStream);
            return FileUtils.readFileToByteArray(file);
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("ERRO AO CRIAR A PLANILHA DO EXCEL COM OS DADOS DOS SÓCIOS");
        }finally{
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("ERRO AO ENCERRAR O OBJETO FILEOUTPUTSTREAM");
            }
        }
        return null;
    }
    
    public void criarFolhaPorCategoriaDoSocio(String categoria){
        HSSFSheet folha = planilha.createSheet(categoria);
        definirAlturaPadraoDasLinhas(folha);
        criarCabecalho(folha);
        inserirDadosDoSocioNaFolha(folha, categoria);
        definirComprimentoDasColunas(folha);
    }

    public void criarCabecalho(HSSFSheet folha){
        HSSFRow rowDados = folha.createRow(0);
        rowDados.createCell(0).setCellValue("Ord");
        rowDados.createCell(1).setCellValue("Nome");
        rowDados.createCell(2).setCellValue("Posto");
        rowDados.createCell(3).setCellValue("Nome de guerra");
        rowDados.createCell(4).setCellValue("Data de nascimento");
        rowDados.createCell(5).setCellValue("CPF");
        rowDados.createCell(6).setCellValue("Corporação");
        rowDados.createCell(7).setCellValue("Lotação");
        rowDados.createCell(8).setCellValue("RG Militar");
        rowDados.createCell(9).setCellValue("Matrícula");
        rowDados.createCell(10).setCellValue("Endereço");
        rowDados.createCell(11).setCellValue("Número");
        rowDados.createCell(12).setCellValue("Complemento");
        rowDados.createCell(13).setCellValue("Cidade");
        rowDados.createCell(14).setCellValue("UF");
        rowDados.createCell(15).setCellValue("CEP");
        rowDados.createCell(16).setCellValue("E-mail");
        rowDados.createCell(17).setCellValue("Whatsapp");
        rowDados.createCell(18).setCellValue("Celular");
        rowDados.createCell(19).setCellValue("Banco");
        rowDados.createCell(20).setCellValue("Agência");
        rowDados.createCell(21).setCellValue("Conta corrente");

        formatarCabecalho(folha);
    }

    public void formatarCabecalho(HSSFSheet folha){
        HSSFRow rowDados = folha.getRow(0);
        HSSFCellStyle style = planilha.createCellStyle();
        HSSFFont fonte = planilha.createFont();
        fonte.setFontName( Font.MONOSPACED );
        fonte.setBold(true);

        style.setFont( fonte );
        style.setAlignment( HorizontalAlignment.LEFT );

        for(int i = 0 ; i < 22 ; i ++){
            Cell cellDados = rowDados.getCell(i);
            cellDados.setCellStyle(style);
        }
    }

    public void inserirDadosDoSocioNaFolha(HSSFSheet folha, String categoria){
        List<Socio> sociosEfetivos = getSociosAtivosDaCategoria(categoria);

        int cont = 1;
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        for (Socio socio : sociosEfetivos) {
            HSSFRow rowDados = folha.createRow(cont);
            String data_nascimento = formatador.format(socio.getData_nascimento());

            rowDados.createCell(0).setCellValue( cont );
            rowDados.createCell(1).setCellValue( socio.getNome() );
            rowDados.createCell(2).setCellValue( socio.getDadosOficial()!=null ? socio.getDadosOficial().getPosto() + " " + socio.getDadosOficial().getQuadro() : " - " );
            rowDados.createCell(3).setCellValue( socio.getDadosOficial()!=null ? socio.getDadosOficial().getNome_guerra() : " - " );
            rowDados.createCell(4).setCellValue( data_nascimento );
            rowDados.createCell(5).setCellValue( socio.getCpf() );
            rowDados.createCell(6).setCellValue( socio.getDadosOficial()!=null ? socio.getDadosOficial().getCorporacao() : " - " );
            rowDados.createCell(7).setCellValue( socio.getDadosOficial()!=null ? socio.getDadosOficial().getLotacao() : " - " );
            rowDados.createCell(8).setCellValue( socio.getDadosOficial()!=null ? socio.getDadosOficial().getRg_militar() : " - ");
            rowDados.createCell(9).setCellValue( socio.getDadosOficial()!=null ? socio.getDadosOficial().getMatricula() : " - ");
            rowDados.createCell(10).setCellValue( socio.getDadosContato().getEndereco() );
            rowDados.createCell(11).setCellValue( socio.getDadosContato().getNumero() );
            rowDados.createCell(12).setCellValue( socio.getDadosContato().getComplemento() );
            rowDados.createCell(13).setCellValue( socio.getDadosContato().getCidade() );
            rowDados.createCell(14).setCellValue( socio.getDadosContato().getUf() );
            rowDados.createCell(15).setCellValue( socio.getDadosContato().getCep() );
            rowDados.createCell(16).setCellValue( socio.getDadosContato().getEmail() );
            rowDados.createCell(17).setCellValue( socio.getDadosContato().getWhatsapp() );
            rowDados.createCell(18).setCellValue( socio.getDadosContato().getCelular() );
            rowDados.createCell(19).setCellValue( socio.getDadosBancarios().getBanco() );
            rowDados.createCell(20).setCellValue( socio.getDadosBancarios().getAgencia() );
            rowDados.createCell(21).setCellValue( socio.getDadosBancarios().getConta_corrente() );

            formatarCellDados(folha, rowDados);
            cont++;
        }
    }

    public void formatarCellDados(HSSFSheet folha, HSSFRow rowDados){
        HSSFCellStyle style = planilha.createCellStyle();
        HSSFFont fonte = planilha.createFont();
        fonte.setFontName( Font.MONOSPACED );
        
        style.setFont( fonte );
        style.setAlignment( HorizontalAlignment.LEFT );

        for(int i = 0 ; i < 22 ; i ++){
            Cell cellDados = rowDados.getCell(i);
            cellDados.setCellStyle(style);
        }
    }

    public void definirComprimentoDasColunas(HSSFSheet folha){
        HSSFRow rowCabecalho = folha.getRow(0);
        HSSFRow rowDados = folha.getRow(1);

        try{
            for(int i = 0 ; i < 22 ; i++){
                CellType tipo = rowDados.getCell(i).getCellType();
                if( tipo.compareTo(CellType.NUMERIC) != 0  ){
                    int widthCabecalho = rowCabecalho.getCell(i).getStringCellValue().length();
                    int widthDados = rowDados.getCell(i).getStringCellValue().length();
                    
                    int width = (widthCabecalho > widthDados) ? widthCabecalho : widthDados;
                    folha.setColumnWidth(i, width*500);
                }
            }
        }catch(NullPointerException e){
            System.out.println("A PLANILHA DE SÓCIOS HONORÁRIOS ESTÁ VAZIA POR ISSO RETORNA NULL");
        }
    }
    
    public void definirAlturaPadraoDasLinhas(HSSFSheet folha){
        folha.setDefaultRowHeight( (short) 400);
    }

    public List<Socio> getSociosAtivosDaCategoria(String categoria){
        List<Socio> socios = socioService.getSociosAtivosDesta(categoria);
        return socios;
    }

    public void apagarArquivoCriadoAnteriormente(File file){
        if( file.delete() ){
            System.out.println("ARQUIVO APAGADO COM SUCESSO");
        }else{
            System.out.println("ARQUIVO NÃO EXISTE");
        }

    }
    

}