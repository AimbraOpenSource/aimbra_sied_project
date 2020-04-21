package com.aimbra.sied.infra.repositories;

import com.aimbra.sied.domain.sied.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {
    Optional<AlunoEntity> findFirstByUser_Username(String username);

    @Query(
            value = "select * from alunos a" +
                    "   join inscricoes i on a.id = i.aluno_id" +
                    "   join turmas t on i.turma_id = t.id" +
                    "   join professores p on t.professor_id = p.id" +
                    "   join security.users u on p.user_id = u.id" +
                    "   where u.username = :username",
            nativeQuery = true
    )
    List<AlunoEntity> findAllAlunosOfProfessor(@PathParam("username") String username);
}
