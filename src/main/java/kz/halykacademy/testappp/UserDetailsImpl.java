package kz.halykacademy.testappp;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findByLogin(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(foundUser.getLogin())
                .password(foundUser.getPassword())
                .authorities(foundUser.getRole())
                .build();
    }
}
