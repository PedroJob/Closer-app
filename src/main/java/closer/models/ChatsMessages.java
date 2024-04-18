package closer.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chats_messages", schema = "closer")
public class ChatsMessages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "Content")
    private String content;
    @ManyToOne
    @Column(name = "ChatID")
    private Chats chat;
    @ManyToOne
    @Column(name = "UserID")
    private User user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Chats getChat() {
        return chat;
    }

    public void setChat(Chats chat) {
        this.chat = chat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
