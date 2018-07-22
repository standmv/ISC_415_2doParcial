package encapsulation;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Loader;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.annotations.Where;

@Entity(name = "Profile")
@Table(name = "profile")
@Where(clause = "deleted = 0")

public class Profile implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;

    @Loader
    @Column(name = "profilepic", columnDefinition = "BLOB")
    private byte[] profilepic;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechanacimiento")
    private Date fechanacimiento;

    @Column(name = "ciudadnacimiento")
    private String ciudadnacimiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "lugarestudio")
    private String lugarestudio;

    @Column(name = "trabajo")
    private String trabajo;

    @Column(name = "pais")
    private String pais;

    @Column(name = "sexo")
    private Character sexo;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    private boolean deleted = false;

    public Profile(){
        super();
    }
    public Profile(int id, String nombre, String apellido, Date fechanacimiento, String ciudadnacimiento,
                   String direccion, String lugarestudio, String trabajo, String pais, Character sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.ciudadnacimiento = ciudadnacimiento;
        this.direccion = direccion;
        this.lugarestudio = lugarestudio;
        this.trabajo = trabajo;
        this.pais = pais;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getCiudadnacimiento() {
        return ciudadnacimiento;
    }

    public void setCiudadnacimiento(String ciudadnacimiento) {
        this.ciudadnacimiento = ciudadnacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLugarestudio() {
        return lugarestudio;
    }

    public void setLugarestudio(String lugarestudio) {
        this.lugarestudio = lugarestudio;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(byte[] profilepic) {
        this.profilepic = profilepic;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}