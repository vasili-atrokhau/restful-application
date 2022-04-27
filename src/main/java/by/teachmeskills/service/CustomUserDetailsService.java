package by.teachmeskills.service;

import by.teachmeskills.entity.User;
import by.teachmeskills.exception.EmployeeException;
import by.teachmeskills.mapper.UserMapper;
import by.teachmeskills.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new EmployeeException("User was not found"));

        return UserMapper.mapToCustomUser(user);
    }
}