package ru.geekbrains.lessontwelve.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.lessontwelve.models.Role;
import ru.geekbrains.lessontwelve.models.UserProfile;
import ru.geekbrains.lessontwelve.repository.UserProfileRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserProfileService implements UserDetailsService {

    UserProfileRepository userProfileRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserProfile userProfile = userProfileRepository.findUserProfileByName(s);
        return new User(userProfile.getName(), userProfile.getPassword(), mapRolesToAuthorities(userProfile.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
