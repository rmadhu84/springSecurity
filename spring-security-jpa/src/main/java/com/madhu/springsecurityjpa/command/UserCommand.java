package com.madhu.springsecurityjpa.command;

import lombok.Data;

@Data
public class UserCommand {
    private long id;
    private boolean active;
    private String roles;
    private String pwd;
    private String userName;
}
