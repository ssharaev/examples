package com.ssharaev.webauthnexample.repository;

import com.ssharaev.webauthnexample.model.CredentialRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.web.webauthn.api.CredentialRecord;

import java.util.List;

public interface CredentialRecordEntityRepository extends JpaRepository<CredentialRecordEntity, byte[]> {

    List<CredentialRecord> findByUserEntityUserId(byte[] bytes);

}
