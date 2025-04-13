package com.ssharaev.webauthnexample.repository;

import com.ssharaev.webauthnexample.model.PublicKeyCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.web.webauthn.api.PublicKeyCredentialUserEntity;

public interface PublicKeyCredentialEntityRepository extends JpaRepository<PublicKeyCredentialEntity, byte[]> {

    PublicKeyCredentialUserEntity findByName(String name);

}
