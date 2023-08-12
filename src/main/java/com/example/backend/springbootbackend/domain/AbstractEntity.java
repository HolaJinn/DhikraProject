package com.example.backend.springbootbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
@Data
//@MappedSuperclass est utilisée en Java Persistence API (JPA) pour définir une classe
// parente abstraite qui contient des attributs et des méthodes communes à plusieurs entités
@MappedSuperclass
// enregistrer et suivre les changements apportés aux entités
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {


    @Column(name = "utilisateur")
    private String  utilisateur;
    @Column(name = "operation")
    private String operation;
    @Column(name = "isSelected")
    private int isSelected;
    //createddate fait partie du module Spring Data JPA etest utilisée pour marquer une propriété d'une entité comme devant être
    // automatiquement renseignée avec la date
    @CreatedDate
    @Column(name="creationDate",nullable = false)

    private Instant createdDate;

    @Column(name = "createdby")
    private String createdBy;
    @LastModifiedDate
    @Column(name="updateddate")

    private Instant updatedDate;
    @Column(name = "updatedby")
    private String updatedBy;
}
