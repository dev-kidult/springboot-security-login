package com.example.securitylogin.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yonghui
 * @since 2019. 12. 13
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String username;
    @Column(length = 256, nullable = false)
    private String password;
    @CreatedDate
    private LocalDateTime createdAt;
}
