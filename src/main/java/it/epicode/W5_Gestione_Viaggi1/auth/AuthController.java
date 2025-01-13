package it.epicode.W5_Gestione_Viaggi1.auth;

import it.epicode.W5_Gestione_Viaggi1.auth.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody it.epicode.W5_Gestione_Viaggi1.auth.RegisterRequest registerRequest) {
        appUserService.registerUser(
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                Set.of(it.epicode.W5_Gestione_Viaggi1.auth.Role.ROLE_USER) // Assegna il ruolo di default
        );
        return ResponseEntity.ok("Registrazione avvenuta con successo");
    }

    @PostMapping("/login")
    public ResponseEntity<it.epicode.W5_Gestione_Viaggi1.auth.AuthResponse> login(@RequestBody it.epicode.W5_Gestione_Viaggi1.auth.LoginRequest loginRequest) {
        String token = appUserService.authenticateUser(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        return ResponseEntity.ok(new it.epicode.W5_Gestione_Viaggi1.auth.AuthResponse(token));
    }
}
