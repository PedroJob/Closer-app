package closer.registration;

import closer.models.Groups;
import closer.models.User;
import closer.models.GroupsUsers;
import closer.models.GroupsChat;
import closer.models.Chats;
import closer.utils.HibernateUtil;
import org.hibernate.*;

import java.util.List;

public class GroupsDao extends GenericDao{
    public List<Groups> getAllByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Groups> allGroups = session.createQuery("SELECT g FROM GroupsUsers ug JOIN ug.group g WHERE ug.user.id = :user", Groups.class)
                    .setParameter("user", user.getId())
                    .getResultList();
            return allGroups;
        } catch (HibernateException e) {
            handleException(e);
            return null;
        }
    }

    public Groups createGroup (String nome, int type) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();

            Groups group = new Groups();
            group.setNome(nome);
            group.setType(type);

            session.persist(group);
            t.commit();
            System.out.println("Group " + nome + " created");
            return group;
        }catch (HibernateException e) {
            handleException(e);
            return null;
        }
    }
}
