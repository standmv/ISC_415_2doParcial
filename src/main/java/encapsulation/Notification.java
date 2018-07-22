package encapsulation;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Notification")
@Table(name = "notification")
@Where(clause = "deleted = 0")

public class Notification implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;

    @Column(name = "notificacion")
    private String notificacion;

    @Column(name = "isSeen")
    private Boolean isSeen;

    @OneToOne
    @JoinColumn(name = "fromUser")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "toUser")
    private User toUser;

    private boolean deleted = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }


}
