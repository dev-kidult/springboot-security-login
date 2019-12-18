package com.example.securitylogin.domain;

import javax.annotation.Generated;
import javax.persistence.*;

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
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String authority;
}
