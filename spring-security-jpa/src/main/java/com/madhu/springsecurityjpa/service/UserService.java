package com.madhu.springsecurityjpa.service;

import com.madhu.springsecurityjpa.command.UserCommand;

public interface UserService {
    public UserCommand getUserById(long id);

    public Object getUserByName(String user);
}
