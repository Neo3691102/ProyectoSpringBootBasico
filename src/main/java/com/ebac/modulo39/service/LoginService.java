package com.ebac.modulo39.service;

import com.ebac.modulo39.dto.Login;
import com.ebac.modulo39.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public List<Login> traerUsuarios(){
        return loginRepository.findAll();
    }
}
