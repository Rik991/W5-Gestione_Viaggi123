package it.epicode.W5_Gestione_Viaggi1.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
