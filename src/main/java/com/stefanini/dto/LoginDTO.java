package com.stefanini.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginDTO {

    @NotBlank(message = "{nickname.not.blank}")
    private String nickname;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%&*()_+^]).{4,10}", message = "{senha.not.pattern}")
    @Size(min = 4, max = 10, message = "{senha.not.size}")
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
