package br.com.aocbmma.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ata_assembleia")
public class AtaAssembleia{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_assembleia;

    @Column
    private String path_ata;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_assembleia() {
        return this.data_assembleia;
    }

    public void setData_assembleia(Date data_assembleia) {
        this.data_assembleia = data_assembleia;
    }

    public String getPath_ata() {
        return this.path_ata;
    }

    public void setPath_ata(String path_ata) {
        this.path_ata = path_ata;
    }

}