package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.RespostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.Optional;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaEntity, Integer> {

    @Query("select r from RespostaEntity r join AlunoEntity a on r.aluno = a join UserEntity u on a.user = u where r.atividade.id = :atividadeId and u.username = :username")
    Optional<RespostaEntity> findAllByAtividadeIdAndUsername(@PathParam("atividadeId") Integer atividadeId, @PathParam("username") String username);
}
