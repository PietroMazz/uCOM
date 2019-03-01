package uCOM;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import persistence.HibernateUtil;
import util.Status;

/**
 * @author Pietro
 *
 */
public class RegistroUtenti {
	
	private Map<String, DatiUtente> registro;
	
	/**
	 * Crea il registro utenti prelevando i dati dal database, tramite Hibernate
	 */
	public RegistroUtenti()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
         
		@SuppressWarnings("unchecked")
		List<DatiUtente> utenti = session.createQuery("from DatiUtente").list();
        
        registro = new Hashtable<String, DatiUtente>();
        @SuppressWarnings("rawtypes")
		Iterator it = utenti.iterator();
        while(it.hasNext())
        {
        	DatiUtente u = (DatiUtente) it.next();
        	registro.put(u.getUsername(), u);
        }
         
        session.close();
	}
	
	/**
	 * Aggiunge nuova riga di DatiUtente al registro
	 * @param du Dati utente
	 * @return esito operazione
	 */
	public Status add(DatiUtente du)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			
			session.save(du);
			session.getTransaction().commit();
			
			session.close();			
		} catch(Exception e)
		{
			if(tx!=null) tx.rollback();
			session.close();			
			return Status.FAIL;
		}
		String user = du.getUsername();
		registro.put(user, du);
        return Status.SUCCESS;
 
	}

	/**
	 * Restitusce il Ruolo dato l'Utente
	 * @param user usenrname utente richiesto
	 * @return Ruolo utente richiesto
	 */
	public Ruolo getRoleForUser(String user) {
		DatiUtente 	du 	= registro.get(user);
		if(du == null) return null;
		Ruolo 		r 	= du.getRuolo();
		return r;
	}

}
