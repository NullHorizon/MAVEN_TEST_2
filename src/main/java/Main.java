/**
 * Created by CallMeF3AR on 12.07.2016.
 */
import org.hibernate.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory Factory = HibUtil.getSessionFactory();
        Session session = Factory.openSession();
        String req = "SHOW TABLES";
        Query q = session.createSQLQuery(req);
        List content = q.list();
        for(Object l : content)
        {
            System.out.println("+" + l.toString());

            String nreq = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='" + l.toString() + "'";
            Query nq = session.createSQLQuery(nreq);
            List ncontent = nq.list();
            for(Object nl : ncontent)
            {
                System.out.println("--" + nl.toString());
            }

        }
        session.close();
        HibUtil.shutdown();
    }

}