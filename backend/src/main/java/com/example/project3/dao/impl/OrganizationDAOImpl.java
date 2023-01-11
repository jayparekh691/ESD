package com.example.project3.dao.impl;

import com.example.project3.util.HibernateSessionUtil;
import com.example.project3.bean.Organization;
import com.example.project3.dao.OrganizationDAO;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDAOImpl implements OrganizationDAO {

    @Override
    public void deleteorganization(Organization n){
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
//            List<Organization> o= new ArrayList<>();
//            Query q =  session.createQuery("from Organization where name=: n");
////            List <Students> studentList = q.list();
//            q.setParameter("n", n);
            Integer nn=n.getO_id();
            String query_string="DELETE FROM Organization WHERE o_id =:nn";
            Query query=session.createQuery(query_string);
            query.setParameter("nn", nn);
            query.executeUpdate();
            transaction.commit();

//            for (final Object fetch : q.list()) {
//                o.add((Organization) fetch);
//            }
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }
    @Override
    public List<Organization> getOrganizationN(Organization n) {
        try(Session session = HibernateSessionUtil.getSession()){
            String nn=n.getName();
            List<Organization> o= new ArrayList<>();
            Query q =  session.createQuery("from Organization where name=: nn");
//            List <Students> studentList = q.list();
            q.setParameter("nn", nn);

            for (final Object fetch : q.list()) {
                o.add((Organization) fetch);
            }
            return o;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public void UpdateOrganization(Organization o){
        try (Session session = HibernateSessionUtil.getSession()) {
            Integer n = o.getO_id();
            String a = o.getAddress();
            String na = o.getName();
            Query query = session.createQuery("update Organization set address=: a,name=:na where o_id=:n");
            query.setParameter("n", n);
            query.setParameter("a",a);
            query.setParameter("na",na);
            Transaction transaction = session.beginTransaction();
            int result = query.executeUpdate();
            transaction.commit();
            session.close();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    };

    @Override
    public List<Organization> getOrganization() {
        List<Organization> organizationList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()) {
            for (final Object org: session.createQuery("from Organization").list()){
                organizationList.add((Organization) org);
            }
            return organizationList;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return organizationList;
    }
    @Override
    public Boolean createOrganization(Organization registry){
        try (Session session=HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            session.save(registry);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}
