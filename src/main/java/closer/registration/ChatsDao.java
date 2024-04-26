package closer.registration;

import closer.models.Chats;
import closer.models.Groups;
import closer.models.GroupsChat;
import closer.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChatsDao extends GenericDao {
    public Chats createChat () {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();

            Chats chat = new Chats();

            session.persist(chat);
            t.commit();
            return chat;
        }catch (HibernateException e) {
            handleException(e);
            return null;
        }
    }
}
