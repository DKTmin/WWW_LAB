package iuh.fit.se.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Firstname khong ton tai")
    @Column(name = "firstname")
    private String firstName;
    @NotEmpty(message = "Lastname khong ton tai")
    @Column(name= "lastname")
    private String lastName;
}
