package model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository("productDAO")
@Transactional
public class ProductDAO implements IPoductDAO {
	private Transaction trans;
	//@Autowired(required= true)
	//private SessionFactory sessionFactory;
	
	private Session sess;
	
	private boolean b = true;
	private DbConfig db;
	public ProductDAO()
	{
		db = new DbConfig();
	}
	
	
	/* (non-Javadoc)
	 * @see model.IPoductDAO#insertProduct(model.Product)
	 */
	public boolean insertProduct(Product p)
	{
		try
		{
		//sessionFactory.getCurrentSession().save(p);
		 sess = db.getSess();
		 trans = sess.beginTransaction();
		// Product p1 =(Product)sess.get(Product.class, p.getPid());
		//sess.delete(p1);
		sess.save(p);
		//sess.save(s);
		trans.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			trans.rollback();
			b = false;
		}
		return b;
	}
	/* (non-Javadoc)
	 * @see model.IPoductDAO#getProducts()
	 */
	public ArrayList<Product> getProducts()
	{
		sess = db.getSess();
		return (ArrayList<Product>) sess.createQuery("FROM Product", Product.class).getResultList();
		
	//	return lp;
		
	}
	/* (non-Javadoc)
	 * @see model.IPoductDAO#getProduct(int)
	 */
	public Product getProduct(int id)
	{
		sess = db.getSess();
		return (Product) sess.get(Product.class, Integer.valueOf(id));
		
	//	return lp;
		
	}
	/* (non-Javadoc)
	 * @see model.IPoductDAO#updateProduct(model.Product)
	 */
	public boolean updateProduct(Product p)
	{
		try
		{
		 sess = db.getSess();
		 //trans = sess.beginTransaction();
		// Product p1 =(Product)sess.get(Product.class, p.getPid());
		//sess.delete(p1);
		sess.update(p);
		//trans.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			//trans.rollback();
			b = false;
		}
		return b;
	}
	/* (non-Javadoc)
	 * @see model.IPoductDAO#deleteProduct(model.Product)
	 */
	public boolean deleteProduct(Product p)
	{
		try
		{
		 sess = db.getSess();
		 //trans = sess.beginTransaction();
		 //Product p1 =sess.get(Product.class, p.getPid());
		 sess.delete(p);
		
		//trans.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			//trans.rollback();
			b = false;
		}
		return b;
	}
}
