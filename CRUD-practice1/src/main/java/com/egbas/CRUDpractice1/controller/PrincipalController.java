package com.egbas.CRUDpractice1.controller;

import com.egbas.CRUDpractice1.dto.PrincipalDto;
import com.egbas.CRUDpractice1.service.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/principal")
public class PrincipalController {
    private final PrincipalService principalService;

    @PostMapping("/new")
    public ResponseEntity<PrincipalDto> addPrincipal(@RequestBody PrincipalDto principalDto){
        PrincipalDto newPrincipal = principalService.addPrincipal(principalDto);

        return new ResponseEntity<>(newPrincipal, HttpStatus.CREATED);
    }
}
