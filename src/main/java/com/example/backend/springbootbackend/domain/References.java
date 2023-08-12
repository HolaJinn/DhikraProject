package com.example.backend.springbootbackend.domain;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;

import java.time.LocalDateTime;

@Data
@Table(name = "image_references")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE image_references set  isDeleted=1 where id=?")
@Where(clause = "is_deleted=0")
@Getter
@Setter

public class References implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nomar")
    private String  nomAr;
    @Column(name = "nomfr")
    private String nomFr;
    @Column(name = "noman")
    private String nomAn;
    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] image;

    @Column(name = "utilisateur")
    private String  utilisateur;
    @Column(name = "operation")
    private String operation;
    @Column(name = "isSelected")
    private int isSelected;
    //createddate fait partie du module Spring Data JPA etest utilisée pour marquer une propriété d'une entité comme devant être
    // automatiquement renseignée avec la date
    @Column(name = "isDeleted")
    private Integer isDeleted;
    @CreatedDate
    @Column(name="creationDate")

    private LocalDateTime createdDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name="updateddate")

    private LocalDateTime updatedDate;
    @Column(name = "updatedby")
    private String updatedBy;



}
