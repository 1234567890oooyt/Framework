package hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static hibernate.HibernateUtil.getSessionFactory;


public class HibernateMain  {
    static Session session = getSessionFactory().getCurrentSession();



    public static void saveToApiLogs(String response ,Integer statusCode) {
        SaveApiLogsModel saveLogs = new SaveApiLogsModel();
        saveLogs.setId(new Random().nextLong());
        saveLogs.setResponse(response);
        saveLogs.setStatusCode(statusCode);
        session.save(saveLogs);


    }
    public static void saveToWebLogs(Long id, Blob dom , String logger) {
        SaveWebLogsModel saveLogs = new SaveWebLogsModel();
        saveLogs.setId(id);
        saveLogs.setDom(dom);
        saveLogs.setLogger(logger);
        session.save(saveLogs);


    }
    public static void beginTrans(){
        session.beginTransaction();
    }
    public static void closeSession(){
        session.getTransaction().commit();
        session.close();
    }


}