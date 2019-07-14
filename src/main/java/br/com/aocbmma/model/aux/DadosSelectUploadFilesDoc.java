package br.com.aocbmma.model.aux;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DadosSelectUploadFilesDoc {

    private String nome;

    private int socio_id;

    private int num_files;

    private Date data;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSocio_id() {
        return this.socio_id;
    }

    public void setSocio_id(int socio_id) {
        this.socio_id = socio_id;
    }

    public int getNum_files() {
        return this.num_files;
    }

    public void setNum_files(int num_files) {
        this.num_files = num_files;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<DadosSelectUploadFilesDoc> getLista(List<Object> listObjectSelect) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		
		List<DadosSelectUploadFilesDoc> listDadosSelect = new ArrayList<DadosSelectUploadFilesDoc>();
		for(Object obj : listObjectSelect){
			Object[] o = (Object[]) obj;
			
			DadosSelectUploadFilesDoc dados = new DadosSelectUploadFilesDoc();
            dados.setNome(String.valueOf(o[0]));
            dados.setSocio_id(Integer.parseInt(String.valueOf(o[1])));
            dados.setNum_files(Integer.parseInt(String.valueOf(o[2])));
			try {
			 dados.setData(dt.parse(String.valueOf(o[3])));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		 listDadosSelect.add(dados);
        }
		return listDadosSelect;
	}

    
}