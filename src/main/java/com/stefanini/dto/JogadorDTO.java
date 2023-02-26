package com.stefanini.dto;

import com.stefanini.entity.Jogador;
import com.stefanini.entity.Stefamon;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JogadorDTO {

    private Long id;

    @NotBlank(message = "{nickname.not.blank}")
    private String nickname;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%&*()_+^]).{4,10}", message = "{senha.not.pattern}")
    @Size(min = 4, max = 10, message = "{senha.not.size}")
    private String password;

//    @NotBlank(message = "{saldo.not.blank}")
    private BigDecimal saldo = new BigDecimal(1000);

    private List<Stefamon> stefamons = new ArrayList<>();

    public JogadorDTO(){};

    public JogadorDTO(Long id, String nickname, String password, BigDecimal saldo, List<Stefamon> stefamons) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.saldo = saldo;
        this.stefamons = stefamons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Stefamon> getStefamons() {
        return stefamons;
    }

    public void setStefamons(List<Stefamon> stefamons) {
        this.stefamons = stefamons;
    }
}
