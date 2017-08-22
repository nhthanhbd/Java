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
public class SinhVienMonHocDAO {

    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    public List<Sinhvienmonhoc> getAll() {
        try {
            Session ss = HibernateUtil.openSession();
            ss.beginTransaction();
            Criteria c = ss.createCriteria(Sinhvienmonhoc.class);
            return c.list();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Sinhvienmonhoc> getUserbyMonHocID(String maMonhoc) {
        try {
            Session ss = HibernateUtil.openSession();
            ss.beginTransaction();
            Query c = ss.createQuery("From Sinhvienmonhoc where MaMh ='" + maMonhoc + "'");
            return c.list();
        } catch (Exception e) {
            return null;
        }

    }

    public List<Sinhvienmonhoc> getUserbyListMonHocID(String maMonhoc, String maSinhvien) {
        try {
            Session ss = HibernateUtil.openSession();
            ss.beginTransaction();
            Query c = ss.createQuery("From Sinhvienmonhoc where MaMh ='" + maMonhoc + "' and maSv ='" + maSinhvien + "'");
            return c.list();
        } catch (Exception e) {
            return null;
        }

    }

    public List<Sinhvienmonhoc> getSubjectbyStudentID(String maSinhvien) {
        try {
            Session ss = HibernateUtil.openSession();
            ss.beginTransaction();
            Query c = ss.createQuery("From Sinhvienmonhoc where maSv ='" + maSinhvien + "'");
            return c.list();
        } catch (Exception e) {
            return null;
        }

    }

    public String getweekbyStudentID(String tuan, String maSinhvien, String maMonhoc) {
        try {
            Session ss = sf.openSession();
            ss.beginTransaction();
            String sql = "Select " + tuan + " From Sinhvienmonhoc where maSv ='" + maSinhvien + "' and maMh='" + maMonhoc + "'";
            Query c = ss.createQuery(sql);

            ss.getTransaction().commit();
            return c.uniqueResult().toString();

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }

    public boolean save(Sinhvienmonhoc svmh) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(svmh);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    public boolean update(String maSinhVien, String tuan, boolean isDiemDanh, String maMonHoc) {

        try {
            sf.getCurrentSession().beginTransaction();
            String sql = "UPDATE Sinhvienmonhoc SET "
                    + tuan + " = " + isDiemDanh + " WHERE maSv='" + maSinhVien + "' and maMh='" + maMonHoc + "'";
            Query query = sf.getCurrentSession().createSQLQuery(sql);
            int c = query.executeUpdate();
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

}
