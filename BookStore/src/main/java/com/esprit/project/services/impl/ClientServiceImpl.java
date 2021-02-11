package com.esprit.project.services.impl;


import com.esprit.project.entities.Client;
import com.esprit.project.repositories.ClientRepository;
import com.esprit.project.security.MyUserDetails;
import com.esprit.project.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class ClientServiceImpl implements ClientService, UserDetailsService {
    @Autowired
    private ClientRepository clrep;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Client save(Client client) {

    client.setMdp(passwordEncoder.encode(client.getMdp()));
        return clrep.save(client);
    }

    @Override
    public Client getByID(Long id) {
        return clrep.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(clrep.findByMail(username));
    }
}
