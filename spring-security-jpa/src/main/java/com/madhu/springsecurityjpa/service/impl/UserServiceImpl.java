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
        UserCommand userCommand = null;
        Optional<User> user;
        if ((user = userRepository.findById(id)).isPresent()) {
            userCommand = new UserCommand();
            BeanUtils.copyProperties(user.get(), userCommand);
        } else
            throw new NoRecordFoundException(String.format("No Record found for user Id : %d", id));
        return userCommand;
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Object getUserByName(String name) {
        UserCommand userCommand = null;
        Optional<User> user;
        if ((user = userRepository.findByUserName(name)).isPresent()) {
            userCommand = new UserCommand();
            BeanUtils.copyProperties(user.get(), userCommand);
        } else
            throw new NoRecordFoundException(String.format("No Record for user with user_name: %s", name));
        return userCommand;
    }

}
