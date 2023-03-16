package com.naehas.hibernatesample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class CSVFile {
	public static void parseForCsvFiles(String parentDirectory){

		File[] filesInDirectory = new File(parentDirectory).listFiles();
		for(File f : filesInDirectory)
		{
			if(f.isDirectory())
			{
				parseForCsvFiles(f.getAbsolutePath());
			}
			String filePath = f.getAbsolutePath();
			String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
			
			Configuration con=new Configuration().configure().addAnnotatedClass(TshirtData.class);
			ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf=con.buildSessionFactory(reg);
			Session session=sf.openSession();
			
			if("csv".equals(fileExtenstion)){
				try   
				{  
					BufferedReader br = new BufferedReader(new FileReader(f));  
					br.readLine();
					String line="";

					while ((line = br.readLine()) != null) 
					{  
						TshirtData ts=new TshirtData();
						if(!line.isEmpty())
						{
							String[] storeData = line.split("\\|");
							ts.setTid(storeData[0].toUpperCase());
							ts.setName(storeData[1].toUpperCase());
							ts.setColour(storeData[2].toUpperCase());
							ts.setGender(storeData[3].toUpperCase());
							ts.setSize(storeData[4].toUpperCase());
							ts.setPrice((Double.parseDouble(storeData[5])));
							ts.setRating((Double.parseDouble(storeData[6])));
							ts.setAvailability(storeData[7].toUpperCase());
							session.save(ts);
						}
					}
					br.close();
				}
				catch (IOException e)   
				{  
					e.printStackTrace();  
				} 
				Transaction tx=session.beginTransaction();
				tx.commit();
			}
		}
	}
}
