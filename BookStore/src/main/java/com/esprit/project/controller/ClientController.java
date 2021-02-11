package com.esprit.project.controller;

import com.esprit.project.entities.Client;
import com.esprit.project.exceptions.SavingIdException;
import com.esprit.project.security.TokenProvider;
import com.esprit.project.services.CDService;
import com.esprit.project.services.ClientService;
import com.esprit.project.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/client/")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody HashMap<String, String> login ) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.get("mail"),
                        login.get("mdp")
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(token);
    }
    @PostMapping("addclient")
    public ResponseEntity<?> save(@RequestBody Client client ){


        if(client.getId() == null){

            Optional<Client> client1 = Optional.of(clientService.save(client));
            return ResponseEntity.created(null).body(client1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id must be null");
        }

    }
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody Client client){
        if(client.getId() != null){
            Client client1 = clientService.save(client);
            return ResponseEntity.accepted().body(client1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }
}
