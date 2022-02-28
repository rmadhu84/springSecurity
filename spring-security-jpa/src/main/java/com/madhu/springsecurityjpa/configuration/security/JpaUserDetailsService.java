package com.madhu.springsecurityjpa.configuration.security;

import java.util.Optional;

import com.madhu.springsecurityjpa.domain.User;
import com.madhu.springsecurityjpa.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        user.orElseThrow(
                () -> new UsernameNotFoundException(String.format("User with userName %s not found", username)));
        return user.map(JpaUserDetails::new).get();
    }

}