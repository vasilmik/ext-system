package edu.javacourse.register.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "ro_marriage_certificate")
@Entity
public class MarriageCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marriage_certificate_id")
    private Long marriageCertificateID;
    @Column(name = "number_certificate")
    private String number;
    @Column(name = "date_issue")
    private LocalDate issueDate;
    @ManyToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "husband_id")
    private PersonMale husband;
    @ManyToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "wife_id")
    private PersonFemale wife;
    @Column(name = "active")
    private boolean active;
    @Column(name = "end_date")
    private LocalDate endDate;

}
