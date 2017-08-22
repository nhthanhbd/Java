/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.*;
import org.hibernate.*;
import Entity.*;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author ThanhNH
 */
public class MonHocDAO {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    public List<Monhoc> getAll(){
        try{
            Session ss = HibernateUtil.openSession();
            ss.beginTransaction();
            Criteria c = ss.createCriteria(Monhoc.class);
            return c.list();
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Monhoc> getSubjectbyName() {
         try{
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createSQLQuery("SELECT TenMonHoc FROM Monhoc").list();
        }catch(Exception e){
            return null;
        }
        
    } 
    public String countSubject() {
         try{
            Session ss = sf.openSession();
            ss.beginTransaction();
            Query c = ss.createQuery("select count(maMonHoc) from Monhoc");
            ss.getTransaction().commit();            
           
            String a = String.valueOf(c.uniqueResult());
            return a;
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
        
    } 
    public Monhoc getSubjectbyID(String maMonhoc) {
         try{
            sf.getCurrentSession().beginTransaction();
            Monhoc mh = (Monhoc)sf.getCurrentSession().get(Monhoc.class, maMonhoc);
            sf.getCurrentSession().getTransaction().commit();
            return mh;
        }catch(Exception e){
            return null;
        }
        
    } 

    public boolean save(Monhoc mh){
        try{
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(mh);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        }catch(Exception e){
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
}
