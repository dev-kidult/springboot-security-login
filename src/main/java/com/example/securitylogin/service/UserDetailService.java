package com.example.securitylogin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securitylogin.domain.Authority;
import com.example.securitylogin.domain.AuthorityUser;
import com.example.securitylogin.domain.User;
import com.example.securitylogin.repository.AuthorityRepository;
import com.example.securitylogin.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Yonghui
 * @since 2019. 12. 13
 */
@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return AuthorityUser.builder()
                    .username(username)
                    .password(user.get().getPassword())
                    .authorities(getAuthorities(username))
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .isEnabled(true)
                    .build();
        } else {
            throw new UsernameNotFoundException(String.format("%s is not found", username));
        }
    }

    private Collection<GrantedAuthority> getAuthorities(String username) {
        List<Authority> authorityList = authorityRepository.findByUsername(username);
        List<GrantedAuthority> result = new ArrayList<>();
        authorityList.forEach(authority -> result.add(new SimpleGrantedAuthority(authority.getAuthority())));
        return result;
    }
}
