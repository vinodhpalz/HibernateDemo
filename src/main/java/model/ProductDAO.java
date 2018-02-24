package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProductDAO {
	private Transaction trans;
	private Session sess;
	private boolean b = true;
	public boolean insertProduct(Product p)
	{
		try
		{
		DbConfig db = new DbConfig();
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
	public List<Product> getProducts()
	{
		Query query = sess.createQuery("from Product");
		List<Product> lp = (List<Product>)query.getResultList();
		
		return lp;
		
	}
	public boolean updateProduct(Product p)
	{
		try
		{
		DbConfig db = new DbConfig();
		 sess = db.getSess();
		 trans = sess.beginTransaction();
		// Product p1 =(Product)sess.get(Product.class, p.getPid());
		//sess.delete(p1);
		sess.update(p);
		trans.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			trans.rollback();
			b = false;
		}
		return b;
	}
	public boolean deleteProduct(Product p)
	{
		try
		{
		DbConfig db = new DbConfig();
		 sess = db.getSess();
		 trans = sess.beginTransaction();
		 Product p1 =(Product)sess.get(Product.class, p.getPid());
		 sess.delete(p1);
		
		trans.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			trans.rollback();
			b = false;
		}
		return b;
	}
}
