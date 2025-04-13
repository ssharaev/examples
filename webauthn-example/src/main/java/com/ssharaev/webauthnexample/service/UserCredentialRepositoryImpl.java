package com.ssharaev.webauthnexample.service;

import com.ssharaev.webauthnexample.model.CredentialRecordEntity;
import com.ssharaev.webauthnexample.repository.CredentialRecordEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.webauthn.api.Bytes;
import org.springframework.security.web.webauthn.api.CredentialRecord;
import org.springframework.security.web.webauthn.management.UserCredentialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCredentialRepositoryImpl implements UserCredentialRepository {

    private final CredentialRecordEntityRepository credentialRecordEntityRepository;

    @Override
    public void delete(Bytes credentialId) {
        credentialRecordEntityRepository.deleteById(credentialId.getBytes());
    }

    @Override
    public void save(CredentialRecord credentialRecord) {
        credentialRecordEntityRepository.save(new CredentialRecordEntity(credentialRecord));
    }

    @Override
    public CredentialRecord findByCredentialId(Bytes credentialId) {
        return credentialRecordEntityRepository.findById(credentialId.getBytes()).orElse(null);
    }

    @Override
    public List<CredentialRecord> findByUserId(Bytes userId) {
        return credentialRecordEntityRepository.findByUserEntityUserId(userId.getBytes());
    }
}
