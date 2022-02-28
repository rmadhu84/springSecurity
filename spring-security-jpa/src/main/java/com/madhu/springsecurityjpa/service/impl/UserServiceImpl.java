package com.madhu.springsecurityjpa.service.impl;

import java.util.Optional;

import com.madhu.springsecurityjpa.command.UserCommand;
import com.madhu.springsecurityjpa.domain.User;
import com.madhu.springsecurityjpa.exception.NoRecordFoundException;
import com.madhu.springsecurityjpa.repository.UserRepository;
import com.madhu.springsecurityjpa.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserCommand getUserById(long id) throws NoRecordFoundException {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserCommand::new)
                .orElseThrow(() -> new NoRecordFoundException(String.format("No Record found for user Id : %d", id)));
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserCommand getUserByName(String name) {
        Optional<User> user = userRepository.findByUserName(name);
        return user.map(UserCommand::new).orElseThrow(
                () -> new NoRecordFoundException(String.format("No Record found for user with userName: %s ", name)));
    }

}
