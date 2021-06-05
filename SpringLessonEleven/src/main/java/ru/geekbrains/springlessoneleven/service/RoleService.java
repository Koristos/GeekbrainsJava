package ru.geekbrains.springlessoneleven.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.springlessoneleven.repository.RoleRepository;

import javax.persistence.Access;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

}
