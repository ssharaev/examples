package com.ssharaev.webauthnexample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.web.webauthn.api.Bytes;
import org.springframework.security.web.webauthn.api.PublicKeyCredentialUserEntity;

@Setter
@Getter
@Entity
public class PublicKeyCredentialEntity implements PublicKeyCredentialUserEntity {

    @Id
    @Column(columnDefinition="bytea")
    private byte[] id;

    private String name;

    private String displayName;

    public PublicKeyCredentialEntity() {

    }

    @Override
    public Bytes getId() {
        return new Bytes(this.id);
    }

    public PublicKeyCredentialEntity(PublicKeyCredentialUserEntity entity) {
        this.id = entity.getId().getBytes();
        this.name = entity.getName();
        this.displayName = entity.getDisplayName();
    }
}
