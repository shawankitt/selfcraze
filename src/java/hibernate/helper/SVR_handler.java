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
public class SVR_handler {
        private Session session;

        public String insert_into_table(String voter,String votee,boolean votes)
        {
            boolean error_flag=false;
        
            session=hibernate.helper.HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = null;
            
        try
        {
            tx=session.beginTransaction();
            
            hibernate.pojo.SVoteRestrict c = new hibernate.pojo.SVoteRestrict();
            
            c.setSId(BigDecimal.ONE);
            c.setSVoteFlag(votes);
            c.setSVotee(votee);
            c.setSVoter(voter);
        
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
        
        public hibernate.pojo.SVoteRestrict get_tuple(String sid)
        {
            session=hibernate.helper.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            hibernate.pojo.SVoteRestrict c = new hibernate.pojo.SVoteRestrict();
            try
            {
           
                tx=session.beginTransaction();
                c = (hibernate.pojo.SVoteRestrict) session.get(hibernate.pojo.SVoteRestrict.class,sid);
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
