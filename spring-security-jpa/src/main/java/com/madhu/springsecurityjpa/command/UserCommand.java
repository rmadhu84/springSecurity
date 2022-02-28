package com.madhu.springsecurityjpa.command;

import com.madhu.springsecurityjpa.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCommand {
    private long id;
    private boolean active;
    private String roles;
    private String pwd;
    private String userName;

    public UserCommand(User user) {
        this.id = user.getId();
        this.active = user.isActive();
        this.roles = user.getRoles();
        this.pwd = user.getPwd();
        this.userName = user.getUserName();
    }
}
