package closer.models;

import jakarta.persistence.*;

@Entity
@Table(name = "grupos", schema = "closer")
public class Groups {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "GroupID")
    private int id;
    @Basic
    @Column(name = "Nome")
    private String nome;
    @Basic
    @Column(name = "TypeID")
    private int type;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
