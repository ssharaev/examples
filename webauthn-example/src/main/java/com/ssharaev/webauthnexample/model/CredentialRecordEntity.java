package com.ssharaev.webauthnexample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.web.webauthn.api.AuthenticatorTransport;
import org.springframework.security.web.webauthn.api.Bytes;
import org.springframework.security.web.webauthn.api.CredentialRecord;
import org.springframework.security.web.webauthn.api.ImmutablePublicKeyCose;
import org.springframework.security.web.webauthn.api.PublicKeyCose;
import org.springframework.security.web.webauthn.api.PublicKeyCredentialType;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Entity
public class CredentialRecordEntity implements CredentialRecord {

    private String credentialType;

    @Id
    @Column(columnDefinition="bytea")
    private byte[] credentialId;

    @Column(columnDefinition="bytea")
    private byte[] userEntityUserId;

    @Column(columnDefinition="bytea")
    private byte[] publicKey;

    private long signatureCount;

    private boolean uvInitialized;

    @JdbcTypeCode(SqlTypes.JSON)
    private Set<AuthenticatorTransport> transports;

    private boolean backupEligible;

    private boolean backupState;

    @Column(columnDefinition="bytea")
    private byte[] attestationObject;

    @Column(columnDefinition="bytea")
    private byte[] attestationClientDataJSON;

    private Instant created;

    private Instant lastUsed;

    private String label;

    public CredentialRecordEntity() {
    }

    public CredentialRecordEntity(CredentialRecord record) {
        this.credentialId = record.getCredentialId().getBytes();
        this.signatureCount = record.getSignatureCount();
        this.uvInitialized = record.isUvInitialized();
        this.backupEligible = record.isBackupEligible();
        this.backupState = record.isBackupState();
        this.userEntityUserId = record.getUserEntityUserId().getBytes();
        this.attestationObject = record.getAttestationObject().getBytes();
        this.attestationClientDataJSON = record.getAttestationClientDataJSON().getBytes();
        this.publicKey = record.getPublicKey().getBytes();
        this.label = record.getLabel();
        this.lastUsed = record.getLastUsed();
        this.created = record.getCreated();
        this.transports = record.getTransports();
    }


    @Override
    public PublicKeyCredentialType getCredentialType() {
        return PublicKeyCredentialType.valueOf(this.credentialType);
    }

    @Override
    public Bytes getCredentialId() {
        return new Bytes(credentialId);
    }

    @Override
    public PublicKeyCose getPublicKey() {
        return new ImmutablePublicKeyCose(this.publicKey);
    }

    @Override
    public Set<AuthenticatorTransport> getTransports() {
        return Set.of();
    }


    @Override
    public Bytes getUserEntityUserId() {
        return new Bytes(this.userEntityUserId);
    }

    @Override
    public Bytes getAttestationObject() {
        return new Bytes(this.attestationObject);
    }

    @Override
    public Bytes getAttestationClientDataJSON() {
        return  new Bytes(this.attestationClientDataJSON);
    }
}
