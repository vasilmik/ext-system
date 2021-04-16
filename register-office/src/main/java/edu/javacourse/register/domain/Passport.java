package edu.javacourse.register.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "ro_passport")
@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Long passportID;

    @ManyToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @Column
    private String seria;
    @Column
    private String number;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "issue_department")
    private String issueDepartment;

    public Long getPassportID() {
        return passportID;
    }

    public void setPassportID(Long passportID) {
        this.passportID = passportID;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
