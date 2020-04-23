package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.AlunoEntity;
import com.aimbra.sied.domain.sied.entities.AtividadeEntity;
import com.aimbra.sied.domain.sied.entities.RespostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaEntity, Integer> {

    @Query("select r from RespostaEntity r join AlunoEntity a on r.aluno = a join UserEntity u on a.user = u where r.atividade.id = :atividadeId and u.username = :username")
    Optional<RespostaEntity> findAllByAtividadeIdAndUsername(@PathParam("atividadeId") Integer atividadeId, @PathParam("username") String username);


    @Query("select r from RespostaEntity r join AtividadeEntity a on r.atividade = a join AulaEntity aula on aula = a.aula where aula.id = :aulaId")
    Optional<List<RespostaEntity>> findAllByAulaId(@PathParam("aulaId") Integer aulaId);

    Integer countAllByAtividade_Aula_IdAndAluno_User_Username(Integer aulaId, String username);
    Integer countAllByAtividade_Aula_Id(Integer aulaId);
    Integer countAllByAtividade_Aula_Turma_Id(Integer turmaId);
    Integer countAllByAtividade_Aula_Turma_IdAndAluno_User_Username(Integer turmaId, String username);
    Optional<List<RespostaEntity>> findAllByAtividade_Id(Integer atividadeId);

    Optional<RespostaEntity> findFirstByAlunoAndAtividade(AlunoEntity aluno, AtividadeEntity atividade);

    void deleteByAtividade_Id(Integer id);
}
