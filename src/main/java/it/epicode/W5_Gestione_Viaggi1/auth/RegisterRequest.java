package it.epicode.W5_Gestione_Viaggi1.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
