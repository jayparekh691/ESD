package com.example.project3.dao.impl;

import com.example.project3.bean.Organization;
import com.example.project3.util.HibernateSessionUtil;
import com.example.project3.bean.Organization_HR;
import com.example.project3.dao.Organization_HRDAO;
import jakarta.ws.rs.core.Response;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Organization_HRDAOImpl implements Organization_HRDAO {

    @Override
    public Boolean deleteorganization_HR(Integer o){
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
//            List<Organization> o= new ArrayList<>();
//            Query q =  session.createQuery("from Organization where name=: n");
////            List <Students> studentList = q.list();
//            q.setParameter("n", n);
            String query_string="DELETE FROM Organization_HR WHERE hr_id =:o";
            Query query=session.createQuery(query_string);
            query.setParameter("o", o);
            query.executeUpdate();
            transaction.commit();
            return true;

//            for (final Object fetch : q.list()) {
//                o.add((Organization) fetch);
//            }
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    public List<Organization_HR> getOrganization_HR() {
        List<Organization_HR> organizationList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()) {
            for (final Object org: session.createQuery("from Organization_HR").list()){
                organizationList.add((Organization_HR) org);
            }
            return organizationList;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return organizationList;
    }

    @Override
    public List<Organization_HR> getOrganization_HR(Integer id) {
        try(Session session = HibernateSessionUtil.getSession()){
            List<Organization_HR> o= new ArrayList<>();

            Query q =  session.createQuery("from Organization_HR where org.o_id=:id");
//            List <Students> studentList = q.list();
            q.setParameter("id", id);

            for (final Object fetch : q.list()) {
                o.add((Organization_HR) fetch);
            }
            return o;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
    @Override
    public Boolean createOrganization_HR(Organization_HR regist){
        try (Session session=HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            Integer o=regist.geto_id();
            List<Object> result = new ArrayList<>(session.createQuery("FROM Organization WHERE o_id=:o")
                    .setParameter("o",o)
                    .list()
            );
            if(result.size()==0) {
                session.save(regist);
                transaction.commit();
                return false;
            }
            session.save(regist);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public void UpdateOrganization_HR(Integer n,Organization_HR o){
        try (Session session = HibernateSessionUtil.getSession()) {
            String e = o.getEmail();
            String f = o.getFirst_name();
            String l = o.getLast_name();
            String c = o.getContact_number();
            Query query = session.createQuery("update Organization_HR set first_name=:f,last_name=:l,contact_number=:c, email=:e where hr_id=:n ");
            query.setParameter("e", e);
            query.setParameter("f",f);
            query.setParameter("l",l);
            query.setParameter("c",c);
            query.setParameter("n",n);
            Transaction transaction = session.beginTransaction();
            int result = query.executeUpdate();
            transaction.commit();
            session.close();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    };

}
