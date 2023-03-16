package com.naehas.hibernatesample;
import org.hibernate.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Sorting 
{
	public void doSorting(App app)
	{
		Configuration con=new Configuration().configure().addAnnotatedClass(TshirtData.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session session=sf.openSession();
		session.beginTransaction();

		String search_colour=app.getColour();
		String search_gender=app.getGender();
		String search_size=app.getSize();
		
		if(app.getOutputpreference().equals("PRICE"))
		{
			Query query= session.createQuery("FROM TshirtData WHERE Colour =:search_colour AND Gender =:search_gender AND Size =:search_size ORDER BY price");
			query.setParameter("search_colour", search_colour);
			query.setParameter("search_gender", search_gender);
			query.setParameter("search_size", search_size);
			List<Object> tshirts=query.list();
			if(tshirts.isEmpty())
				System.out.println("No Tshirts Found!!!");
			else {
				System.out.println("TShirt Found"+"\n");
				for(Object tdata:tshirts)
				{
					System.out.println(tdata);
					System.out.println();
				}
			}
		}
		else if(app.getOutputpreference().equals("RATING"))
		{
			Query query= session.createQuery("FROM TshirtData WHERE Colour =:search_colour AND Gender =:search_gender AND Size =:search_size ORDER BY rating");
			query.setParameter("search_colour", search_colour);
			query.setParameter("search_gender", search_gender);
			query.setParameter("search_size", search_size);
			List<Object> tshirts=query.list();
			if(tshirts.isEmpty())
				System.out.println("No Tshirts Found!!!");
			else 
			{
				System.out.println("TShirt Found"+"\n");
				for(Object tdata:tshirts)
				{
					System.out.println(tdata);
					System.out.println();
				}
			}
		}
	}
}
