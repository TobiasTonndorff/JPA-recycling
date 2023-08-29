package model;

import java.text.SimpleDateFormat;
import java.util.Random;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "driver")
public class Driver {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "driver_id")
    private String driverId;

    @Temporal(TemporalType.DATE)
    @Column(name = "employment_date")
    private Date employmentDate;

    @Column(name = "firstname", nullable = false)
    private String firstname;


    @Column(name = "driver_salary")
    private BigDecimal driverSalary;

    @Column(name = "surname", nullable = false)
    private String surname;


    public Driver(String firstname, String surname, BigDecimal driverSalary){
        this.firstname = firstname;
        this.surname = surname;
        this.driverSalary = driverSalary;
    }

    public String generateId() {
        // Format employment date to ddMMyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String employmentDateStr = dateFormat.format(employmentDate);

        // Extract first letters of first name and last name
        String initials = (firstname.substring(0, 1) + surname.substring(0, 1)).toUpperCase();

        // Generate random number between 100 and 999
        Random random = new Random();
        int randomNum = random.nextInt(900) + 100;

        // Get the last letter of the last name
        char lastLetter = surname.charAt(surname.length() - 1);

        // Construct the ID
        String id = employmentDateStr + "-" + initials + "-" + randomNum + lastLetter;

        return id;
    }

    public Boolean validateDriverId(String driverId) {
        return driverId.matches("[0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z][A-Z]-[0-9][0-9][0-9][A-Z]");
    }

    @PrePersist
    public void prePersist() {
        this.employmentDate = new Date();
        this.driverId = generateId();
    }






}
