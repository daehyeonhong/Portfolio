package com.project.portfolio.domains.member.repository;

import com.project.portfolio.domains.member.domain.entity.MemberEntity;
import com.project.portfolio.domains.member.domain.response.LoginResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByUsername(String username);

    Optional<LoginResponse> findOneByUsername(String username);
}
