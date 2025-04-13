package com.ssharaev.webauthnexample.service;

import com.ssharaev.webauthnexample.model.PublicKeyCredentialEntity;
import com.ssharaev.webauthnexample.repository.PublicKeyCredentialEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.webauthn.api.Bytes;
import org.springframework.security.web.webauthn.api.PublicKeyCredentialUserEntity;
import org.springframework.security.web.webauthn.management.PublicKeyCredentialUserEntityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicKeyCredentialUserEntityRepositoryImpl implements PublicKeyCredentialUserEntityRepository {

    private final PublicKeyCredentialEntityRepository repository;

    @Override
    public PublicKeyCredentialUserEntity findById(Bytes id) {
        return repository.findById(id.getBytes()).orElse(null);
    }

    @Override
    public PublicKeyCredentialUserEntity findByUsername(String username) {
        return repository.findByName(username);
    }

    @Override
    public void save(PublicKeyCredentialUserEntity userEntity) {
        repository.save(new PublicKeyCredentialEntity(userEntity));
    }

    @Override
    public void delete(Bytes id) {
        repository.deleteById(id.getBytes());
    }
}
