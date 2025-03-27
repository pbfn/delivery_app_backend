package com.delivery.service;

import com.delivery.dto.RegisterUserDTO;
import com.delivery.exceptions.EmailAlreadyRegisteredException;
import com.delivery.model.Users;
import com.delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users registerUser(RegisterUserDTO data) throws Exception{
        if(userRepository.findByEmail(data.email()).isPresent()){
            throw new EmailAlreadyRegisteredException("Email already registered");
        }

        var encryptedPassword = passwordEncoder.encode(data.password());

        var user = new Users(
                data.name(),
                data.email(),
                encryptedPassword,
                data.address(),
                data.latitude(),
                data.longitude(),
                data.type()
        );

        return userRepository.save(user);
    }
}
