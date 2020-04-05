package com.aimbra.sied.security.services;

import com.aimbra.sied.business.services.AlunoService;
import com.aimbra.sied.business.services.ProfessorService;
import com.aimbra.sied.domain.Pessoa;
import com.aimbra.sied.domain.builders.UserBuilder;
import com.aimbra.sied.domain.utils.Utils;
import com.aimbra.sied.security.converters.UserConverter;
import com.aimbra.sied.security.dtos.JwtPayloadDto;
import com.aimbra.sied.security.dtos.UserDto;
import com.aimbra.sied.security.dtos.UserRegisterDto;
import com.aimbra.sied.security.entities.UserEntity;
import com.aimbra.sied.security.exceptions.UserNotFoundException;
import com.aimbra.sied.security.repositories.UserRepository;
import com.aimbra.sied.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserConverter converter;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Qualifier("jwtUserDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    public UserDto findByUsername(String username) {
        Optional<UserEntity> response = repository.findFirstByUsernameEquals(username);
        return response.map(userEntity -> converter.toDto(userEntity)).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
    }

    public JwtPayloadDto login(JwtPayloadDto payloadDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        payloadDto.getUsername(),
                        payloadDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userDetailsService.loadUserByUsername(payloadDto.getUsername());
        String token = jwtTokenUtil.getToken(userDetails);

        payloadDto = new JwtPayloadDto();
        payloadDto.setUser(findByUsername(userDetails.getUsername()));
        payloadDto.setToken(token);
        payloadDto.setPassword(null);
        payloadDto.setUsername(payloadDto.getUser().getUsername());
        payloadDto.getUser().setPassword(null);

        return payloadDto;
    }

    public Pessoa register(UserRegisterDto dto) {
        //É preciso fazer um relacionamento com aluno ou professor
        if (dto.getAluno() != null) {
            UserEntity userEntity = UserBuilder.create(
                    dto.getAluno().getUser().getId(),
                    dto.getAluno().getUser().getUsername(),
                    Utils.encodePassoword(dto.getAluno().getUser().getPassword()),
                    dto.getAluno().getUser().getRole(),
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            UserEntity userResponse = repository.save(userEntity);
            dto.getAluno().setUser(converter.toDto(userResponse));
            return alunoService.save(dto.getAluno());
        } else {
            UserEntity userEntity = UserBuilder.create(
                    dto.getProfessor().getUser().getId(),
                    dto.getProfessor().getUser().getUsername(),
                    Utils.encodePassoword(dto.getProfessor().getUser().getPassword()),
                    dto.getProfessor().getUser().getRole(),
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            UserEntity userResponse = repository.save(userEntity);
            dto.getProfessor().setUser(converter.toDto(userResponse));
            return professorService.save(dto.getProfessor());
        }
    }
}
