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
@Table(name = "ref_contactInfo")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE ref_contactInfo set  isDeleted=1 where id=?")
@Where(clause = "is_deleted=0")
@Getter
@Setter
public class ContactInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "address")
    private String  address;
    @Column(name = "email")
    private String email;

    @Column(name = "utilisateur")
    private String  utilisateur;

    @Column(name = "operation")
    private String operation;

    @Column(name = "isSelected")
    private int isSelected;

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
