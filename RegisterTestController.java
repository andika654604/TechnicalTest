/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.controller;

import co.id.mii.serverside.model.Registerr;
import co.id.mii.serverside.service.RegisterServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vino
 */
@RestController
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@RequestMapping("/register")
public class RegisterTestController {
    
    private RegisterServiceTest registerrService;
    
    @Autowired
    public RegisterTestController(RegisterServiceTest registerrService) {
        this.registerrService = registerrService;
    }

    @PostMapping
    public ResponseEntity<Registerr> create(@RequestBody Registerr registerrData) {
        return new ResponseEntity(registerrService.create(registerrData), HttpStatus.CREATED);
    }
    
}
