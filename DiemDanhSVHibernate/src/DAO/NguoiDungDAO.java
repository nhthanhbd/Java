/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.*;
import Entity.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ThanhNH
 */
public class NguoiDungDAO {

    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    public List<Nguoidung> getAll() {
        try {
            Session ss = HibernateUtil.openSession();
            ss.beginTransaction();
            Criteria c = ss.createCriteria(Nguoidung.class);
            
            return c.list();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Nguoidung> getSinhVien() {
        try {
            Session ss = HibernateUtil.openSession();
            ss.beginTransaction();
            Query c = ss.createQuery("FROM Nguoidung nd WHERE nd.maLoaiNguoiDung = '2'");
            return c.list();
        } catch (Exception e) {
            return null;
        }
    }

    public Nguoidung getUserbyUsrName(String username) {
        try {
            sf.getCurrentSession().beginTransaction();
            Nguoidung nd = (Nguoidung)sf.getCurrentSession().get(Nguoidung.class, username);
            sf.getCurrentSession().getTransaction().commit();
            return nd;
        } catch (Exception e) {
            return null;
        }
    } 
    public Nguoidung getUserbyID(int maLoaiNguoiDung) {
        try {
            sf.getCurrentSession().beginTransaction();
            Nguoidung nd = (Nguoidung)sf.getCurrentSession().get(Nguoidung.class, maLoaiNguoiDung);
            sf.getCurrentSession().getTransaction().commit();
            return nd;
        } catch (Exception e) {
            return null;
        }

    }
    public boolean save(Nguoidung nd){
        try{
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(nd);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        }catch(Exception e){
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    
    public boolean updatepass(String newpass,String tenNguoiDung){
        try{
            sf.getCurrentSession().beginTransaction();
            String sql = "UPDATE Nguoidung SET matKhau = '" + newpass + "' WHERE tenNguoiDung ='" 
                    + tenNguoiDung + "'";
            Query query = sf.getCurrentSession().createSQLQuery(sql);
            int c = query.executeUpdate();
            sf.getCurrentSession().getTransaction().commit();
            return true;
        }catch(Exception e) {
            System.out.println(e.toString());
            return false;
        }

    }
    
    public String countStudents(){
        try{
        Session ss = sf.openSession();
        ss.beginTransaction();
        Query c = ss.createQuery("Select count(tenNguoiDung) from Nguoidung where maLoaiNguoiDung = 2 ");
        ss.getTransaction().commit();
        String a = String.valueOf(c.uniqueResult());
        return a;
    }catch(Exception e){
        System.out.println(e.toString());
        return null;
    }

}
}
