package closer.registration;

import closer.models.Chats;
import closer.models.GroupsChat;
import closer.models.Groups;
import closer.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GroupsChatDao extends GenericDao {
    public GroupsChat createGroupsChat(Chats chats, Groups group) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();

            GroupsChat groupsChat = new GroupsChat();

            session.persist(groupsChat);
            t.commit();
            return groupsChat;
        }catch (HibernateException e) {
            handleException(e);
            return null;
        }
    }
}
