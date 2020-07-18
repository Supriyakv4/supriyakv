package com.mphasis.training.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mphasis.training.entities.Player;


public class PlayerDao {

 SessionFactory sessionFactory=null;
	 
	 public PlayerDao() {
		 Configuration con=new Configuration().configure().addAnnotatedClass(Player.class);
	        StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
	         sessionFactory=con.buildSessionFactory(builder.build());
	 }
	 public void insertPlayer(Player p) {
	        Session session=sessionFactory.openSession();
	        session.beginTransaction();
	        session.save(p);
	        session.getTransaction().commit();
	        session.close();
	    }
	 
	 public void updatePlayer(Player p) {
	        Session session=sessionFactory.openSession();
	        session.beginTransaction();
	        session.update(p);
	        session.getTransaction().commit();
	        session.close();
	    }
	 
	 public void deletePlayer(int id) {
	        Session session=null;
	        
	         try {
	            session=sessionFactory.openSession();
	            session.beginTransaction();
	            Player p=(Player)session.get(Player.class, id);
	            session.delete(p);
	            session.getTransaction().commit();
	            
	        } catch (HibernateException e) {
	            // TODO Auto-generated catch block
	            session.getTransaction().rollback();
	        }finally {
	            session.close();
	        }
	    }
	 
	 
	 public Player retrievePlayerById(int id) {
	        Session session=sessionFactory.openSession();
	        Player p=(Player)session.get(Player.class, id);
	        return p; 
	    }
	 
	 public List<Player> retrieveAll(){
	        List<Player> players=new ArrayList<>();
	       Session session=sessionFactory.openSession();
	        players=session.createCriteria(Player.class).list();
	        return players;
	        
	    }
	 
	 public List<Player> retrieveByAge(int age){
	        List<Player> players=new ArrayList<>();
	        Session session=sessionFactory.openSession();
	        players=session.createCriteria(Player.class).add(Restrictions.eq("age", age)).list();
	        
	        return players; 
	    }
	 public List<Player> retrieveByName(String name){
	        List<Player> players=new ArrayList<>();
	        Session session=sessionFactory.openSession();
	        players=session.createCriteria(Player.class).add(Restrictions.eq("name", name)).list();
	        
	        return players; 
	    }
	 public List<Player> retrieveByGender(String gender){
	        List<Player> players=new ArrayList<>();
	        Session session=sessionFactory.openSession();
	        players=session.createCriteria(Player.class).add(Restrictions.eq("gender", gender)).list();
	        
	        return players; 
	    }
	 public List<Player> retrieveByContact(String contact){
	        List<Player> players=new ArrayList<>();
	        Session session=sessionFactory.openSession();
	        players=session.createCriteria(Player.class).add(Restrictions.eq("contact", contact)).list();
	        
	        return players; 
	    }public List<Player> retrieveByEmail(String email){
	        List<Player> players=new ArrayList<>();
	        Session session=sessionFactory.openSession();
	        players=session.createCriteria(Player.class).add(Restrictions.eq("email", email)).list();
	        
	        return players; 
	    }
	    public List<Player> retrieveByTeamName(String teamname){
	        List<Player> players=new ArrayList<>();
	        Session session=sessionFactory.openSession();
	        players=session.createCriteria(Player.class).add(Restrictions.eq("teamname", teamname)).list();
	        
	        return players; 
	    }
	    public List<Player> retrieveByScore(long score){
	        List<Player> players=new ArrayList<>();
	        Session session=sessionFactory.openSession();
	        players=session.createCriteria(Player.class).add(Restrictions.eq("score", score)).list();
	        
	        return players; 
	    }
}
