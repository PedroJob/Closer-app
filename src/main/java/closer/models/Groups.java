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

    public enum GroupType {
        FAMILY(0, "family.jpg"),
        FRIENDS(1, "friends.jpg"),
        DATE(2, "date.jpg");

        private final int typeCode;
        private final String imagePath;

        GroupType(int typeCode, String imagePath) {
            this.typeCode = typeCode;
            this.imagePath = imagePath;
        }

        public String getImagePath() {
            return imagePath;
        }

        public static GroupType fromTypeCode(int typeCode) {
            for (GroupType type : values()) {
                if (type.typeCode == typeCode) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown GroupType code: " + typeCode);
        }
    }

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

    public String getImageFileName() {
        return GroupType.fromTypeCode(this.type).getImagePath();
    }
}