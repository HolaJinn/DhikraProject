package com.example.backend.springbootbackend.domain;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Table(name = "ref_contactUs")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE ref_contactUs set  isDeleted=1 where id=?")
@Where(clause = "is_deleted=0")
@Getter
@Setter
public class ContactUs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fullname")
    private String  fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "description ")
    private String description;

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
   //  @LastModifiedDate
    @Column(name="updateddate")
    private LocalDateTime updatedDate;
    @Column(name = "updatedby")
    private String updatedBy;

}
