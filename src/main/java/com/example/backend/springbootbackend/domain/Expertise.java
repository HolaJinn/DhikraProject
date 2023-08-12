package com.example.backend.springbootbackend.domain;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table(name = "ref_expertise")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE ref_expertise set  isDeleted=1 where id=?")
@Where(clause = "is_deleted=0")
@Getter
@Setter
public class Expertise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "libar")
    private String  libAr;

    @Column(name = "libfr")
    private String libFr;

    @Column(name = "liban")
    private String libAn;

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
    //@LastModifiedDate
    @Column(name="updateddate")
    private LocalDateTime updatedDate;

    @Column(name = "updatedby")
    private String updatedBy;


}
