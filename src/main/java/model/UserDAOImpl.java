package model;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private Transaction trans;
	private Session sess;
	private DbConfig db;
	
	public UserDAOImpl()
	{
		db = new DbConfig();
	}
	public void addUser(User user) {
		try
		{
		sess = db.getSess();
		trans = sess.beginTransaction();
		sess.save(user);
		trans.commit();
		}// TODO Auto-generated method stub
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void editUser(User user) {
		// TODO Auto-generated method stub
		try
		{
		sess = db.getSess();
		trans = sess.beginTransaction();
		sess.update(user);
		trans.commit();
		}// TODO Auto-generated method stub
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		try
		{
		sess = db.getSess();
		trans = sess.beginTransaction();
		sess.delete(findUser(userId));
		trans.commit();
		}// TODO Auto-generated method stub
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public User findUser(int userId) {
		try
		{
		sess = db.getSess();
		}// TODO Auto-generated method stub
		catch(Exception e) {
			e.printStackTrace();
		}

		return (User) sess.get(User.class, userId);
	}

	public User findUserByName(String username) {
		sess = db.getSess();
		
		CriteriaBuilder cb = sess.getCriteriaBuilder();
	    CriteriaQuery<User> query = cb.createQuery(User.class);
	    Root<User> root = query.from(User.class);
	    query.select(root);
	    query.where(cb.equal(root.get("username"), username));
	    TypedQuery<User> typedQuery = sess.createQuery(query);
	    return typedQuery.getSingleResult();
		
		//UserDAOImpl.CriteriaQuery<User> cq = sess.getCriteriaBuilder().createQuery(User.class);
		//cq.add(Restrictions.eq("username", username));		
		//return (User) cq.uniqueResult();
	}

	public List<User> getAllUsers() {
		try {
		sess = db.getSess();
		trans = sess.beginTransaction();
		}// TODO Auto-generated method stub
		catch(Exception e) {
			e.printStackTrace();
		}
		return sess.createQuery("from User").getResultList();
	}

}
