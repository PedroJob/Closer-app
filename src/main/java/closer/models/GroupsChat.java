package closer.models;

import jakarta.persistence.*;

@Entity
@Table(name = "grupos_chat", schema = "closer")
public class GroupsChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GroupID")
    private Groups groupID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChatID")
    private Chats chatID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Groups getGroupID() {
        return groupID;
    }

    public void setGroupID(Groups groupID) {
        this.groupID = groupID;
    }

    public Chats getChatID() {
        return chatID;
    }

    public void setChatID(Chats chatID) {
        this.chatID = chatID;
    }

}