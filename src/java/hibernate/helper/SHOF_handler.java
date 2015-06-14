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
public class SHOF_handler {
        private Session session;

        public String insert_into_table(String handle, String photoid, int rank, byte[] photo)
        {
            boolean error_flag=false;
        
            session=hibernate.helper.HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = null;
            
        try
        {
            tx=session.beginTransaction();
            
            hibernate.pojo.SHallOfFame c = new hibernate.pojo.SHallOfFame();
            SUsers_handler su = new SUsers_handler();
            hibernate.pojo.SUsers u = su.get_tuple(handle);
            
            if(u!=null)
                   c.setSUsers(u);
            else    throw new Exception();
            
            c.setSId(BigDecimal.ONE);
            c.setSPhoto(photo);
            c.setSRank(new BigDecimal(rank));
            
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
        
        public hibernate.pojo.SHallOfFame get_tuple(String sid)
        {
            session=hibernate.helper.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            hibernate.pojo.SHallOfFame c = new hibernate.pojo.SHallOfFame();
            try
            {
           
                tx=session.beginTransaction();
                c = (hibernate.pojo.SHallOfFame) session.get(hibernate.pojo.SHallOfFame.class,sid);
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
