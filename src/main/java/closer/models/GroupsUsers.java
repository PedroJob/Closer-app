package closer.models;

import jakarta.persistence.*;
import org.hibernate.validator.internal.engine.groups.Group;

@Entity
@Table(name = "grupos_usuarios", schema = "closer")
public class GroupsUsers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "Nome")
    private String nome;
    @OneToOne
    @Column(name = "UserID")
    private User user;
    @OneToOne
    @Column(name = "GroupID")
    private Groups group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }
}
