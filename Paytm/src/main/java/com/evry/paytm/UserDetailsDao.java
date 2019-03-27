package com.evry.paytm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class UserDetailsDao {
	
	
	
	
	public void createUserDetails(UserDetails ud)
	{
		

		
		StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(sr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		
		
		
		session.save(ud);
		t.commit();
		System.out.println("Done with trnasaction");
		factory.close();
//		session.close();
	}
	
	public boolean loginVerify(String username,String password)
	{
		boolean flag=false;
		StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(sr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		
		
		
		UserDetails ud=session.get(UserDetails.class,username);
		t.commit();
		System.out.println("Done with trnasaction");
		factory.close();
//		session.close();
		if(ud!=null)
		{
		if(username.equals(ud.getUsername())  && password.equals(ud.getPassword()))
			flag=true;
		}
		return flag;
	}
	
	public void createWallet(WalletAccount wac)
	{
		
		StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(sr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		
		
		
		session.save(wac);
		t.commit();
		System.out.println("Done with trnasaction");
		factory.close();
//		session.close();
	}
	
	public WalletAccount depositMoney(int accountno,int amount)
	{
		
		StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(sr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		
		
		
		WalletAccount wa=session.get(WalletAccount.class,accountno);
		wa.setBalance(wa.getBalance()+amount);
		session.update(wa);
		wa=session.get(WalletAccount.class,accountno);
		t.commit();
		System.out.println("Done with trnasaction");
		factory.close();
//		session.close();
		return wa;
	}
	
	public WalletAccount getBalance(int accountno)
	{
		
		StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(sr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		
		
		
		WalletAccount wa=session.get(WalletAccount.class,accountno);
		t.commit();
		System.out.println("Done with trnasaction");
		factory.close();
//		session.close();
		return wa;
	}
	
	public WalletAccount transferMoney(int accountno,int beneficiaryaccountno,int amount)
	{
		StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(sr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		
		
		
		WalletAccount wa=session.get(WalletAccount.class,accountno);
		WalletAccount bwa=session.get(WalletAccount.class,beneficiaryaccountno);
		wa.setBalance(wa.getBalance()-amount);
		bwa.setBalance(bwa.getBalance()+amount);
		session.update(wa);
		session.update(bwa);
		wa=session.get(WalletAccount.class,accountno);
		t.commit();
		System.out.println("Done with trnasaction");
		factory.close();
//		session.close();
		return wa;
	}

}
