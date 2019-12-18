package com.example.securitylogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securitylogin.domain.Authority;

/**
 * @author Yonghui
 * @since 2019. 12. 13
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByUsername(String username);
}
