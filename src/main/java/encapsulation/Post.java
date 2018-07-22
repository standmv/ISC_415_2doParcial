package encapsulation;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.annotations.Where;
import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Post")
@Table(name = "post")
@Where(clause = "deleted = 0")

public class Post implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;

    @Column(name = "texto")
    private String texto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "likes")
    private int likes;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "postValoraciones", joinColumns = {@JoinColumn(name = "post_id")}, inverseJoinColumns = {@JoinColumn(name = "likeDislike_id")})
    private Set<LikeDislike> valoraciones;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "wall_id", nullable = true, updatable = false)
    private Wall wall;

    @OneToMany(  mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> etiquetas = new HashSet<>();

    private boolean deleted = false;

    public Post(){
        super();
    }
    public Post(Integer id, String texto, LocalDate fecha, Integer likes, Set<LikeDislike> valoraciones, Photo photo,
                User user, Wall wall, Set<Comment> comments, Set<Tag> etiquetas)
    {
        this.id = id;
        this.texto = texto;
        this.fecha = fecha;
        this.likes = likes;
        this.valoraciones = valoraciones;
        this.photo = photo;
        this.user = user;
        this.wall = wall;
        this.comments = comments;
        this.etiquetas = etiquetas;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Set<Tag> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Set<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Set<LikeDislike> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(Set<LikeDislike> valoraciones) {
        this.valoraciones = valoraciones;
    }
}
