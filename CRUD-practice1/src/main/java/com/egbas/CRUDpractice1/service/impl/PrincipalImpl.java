package com.egbas.CRUDpractice1.service.impl;

import com.egbas.CRUDpractice1.dto.PrincipalDto;
import com.egbas.CRUDpractice1.entity.Principal;
import com.egbas.CRUDpractice1.repository.PrincipalRepository;
import com.egbas.CRUDpractice1.service.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalImpl implements PrincipalService {
    private final PrincipalRepository principalRepository;
    @Override
    public PrincipalDto addPrincipal(PrincipalDto principalDto) {
        Principal principal = new Principal();
        BeanUtils.copyProperties(principalDto, principal);

        Principal newPrincipal = principalRepository.save(principal);

        PrincipalDto savedPrincipal = new PrincipalDto();
        BeanUtils.copyProperties(newPrincipal, savedPrincipal);

        return savedPrincipal;

    }
}
