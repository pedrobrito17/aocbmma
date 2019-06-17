package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.UploadFilesDoc;

@Repository
public interface UploadFilesDocRepository extends JpaRepository<UploadFilesDoc, Integer>{

	List<UploadFilesDoc> findBySocio(Socio socio);

	@Query(value="select s.nome, u.socio_id, count(u.socio_id) as num_files, max(u.data_insercao) as data from upload_files_doc u inner join socio s on u.socio_id=s.id group by socio_id order by data desc", nativeQuery=true)
	List<Object> getDadosViewAdmin();
    
}