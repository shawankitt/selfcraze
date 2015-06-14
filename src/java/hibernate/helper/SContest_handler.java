/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.helper;

import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Raj-HP
 */
public class SContest_handler {
        private Session session;

        public String insert_into_table(String handle,String photoid,String photo,int votes)
        {
            boolean error_flag=false;
        
            session=hibernate.helper.HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = null;
            
        try
        {
            tx=session.beginTransaction();
            
            hibernate.pojo.SContest c = new hibernate.pojo.SContest();
            SUsers_handler su = new SUsers_handler();
            hibernate.pojo.SUsers u = su.get_tuple(handle);
            
            if(u!=null)
                   c.setSUsers(u);
            else    throw new Exception();
            
            c.setSPhoto(photo);
            c.setSPhotoId(photoid);
            c.setSVotes(new BigDecimal(votes));
        
            session.save(c);
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
        
        public hibernate.pojo.SContest get_tuple(String photoid)
        {
            session=hibernate.helper.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            hibernate.pojo.SContest c = new hibernate.pojo.SContest();
            try
            {
           
                tx=session.beginTransaction();
                c = (hibernate.pojo.SContest) session.get(hibernate.pojo.SContest.class,photoid);
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
                return c;
            }
        }
}
