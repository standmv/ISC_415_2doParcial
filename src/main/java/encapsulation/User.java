package encapsulation;


import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
@Where(clause = "deleted = 0")

public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id", nullable = false, unique = true, updatable = false)
    private int id;

    @NotEmpty
    @Column(name = "username")
    private String username;

    @NotEmpty(message="La contrasena no puede estar vacia")
    @Column(name = "password")
    private String password;

    @NotEmpty(message="El correo no puede estar vacio")
    @Column(name = "email")
    private String email;

    @Column(name = "priviledge")
    private boolean priviledge;

    @Column(name="deleted")
    private boolean deleted = false;

}
