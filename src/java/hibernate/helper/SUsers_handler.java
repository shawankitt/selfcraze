/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.helper;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Raj-HP
 */
public class SUsers_handler {
        private Session session;

        public String insert_into_table(String handle,String email,String fname,String lname,String sex,String clg)
        {
            boolean error_flag=false;
        
            session=hibernate.helper.HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = null;
            
        try
        {
            tx=session.beginTransaction();
            
            hibernate.pojo.SUsers u = new hibernate.pojo.SUsers();
            u.setSHandle(handle);
            u.setSEmail(email);
            u.setSFirstName(fname);
            u.setSLastName(lname);
            u.setSSex(sex);
            u.setSCollege(clg);
        
            session.save(u);
            tx.commit();
        }
        catch(Exception e)
        {
            error_flag=true; 
            if (tx != null) {
                tx.rollback();
            //e.printStackTrace();
        }
        }
        finally
        {
            session.close();
           if(error_flag==false) return "Success";
           else         return "Failure";
        }
        }
        
        public hibernate.pojo.SUsers get_tuple(String handle)
        {
            session=hibernate.helper.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            hibernate.pojo.SUsers u = new hibernate.pojo.SUsers();
            try
            {
           
                tx=session.beginTransaction();
                u=(hibernate.pojo.SUsers) session.get(hibernate.pojo.SUsers.class,handle);
            }
            catch(Exception e)
            {
                if (tx != null) {
                    tx.rollback();
                e.printStackTrace();
            }
            }
            finally
            {
                session.close();
                return u;
            }
        }
}
