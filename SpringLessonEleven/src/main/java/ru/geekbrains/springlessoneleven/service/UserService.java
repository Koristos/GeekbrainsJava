package ru.geekbrains.springlessoneleven.service;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.springlessoneleven.models.Role;
import ru.geekbrains.springlessoneleven.models.User;
import ru.geekbrains.springlessoneleven.repository.UserRepository;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUserByName(s);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

    public User findUserById (int id) {
        return userRepository.findById(id).orElseThrow(()->new NoSuchElementException("No user with this id found!"));
    }

    public User findUserByName (String name) {
        return userRepository.findUserByName(name);
    }
}
