package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Pietro
 *
 */
public class LocalDatabase {
	
	private final String MY_SQL_FOLDER = "mysql-5.7.25-win32";
	private final String MYSQL_PATH = System.getProperty("user.dir")+File.separator+MY_SQL_FOLDER+File.separator+"bin"+File.separator;
	private Process pr;
		
	public void start() throws IOException, InterruptedException {		
		ProcessBuilder   ps=new ProcessBuilder(MYSQL_PATH+"mysqld","--console");
		ps.redirectErrorStream(true);
		pr = ps.start(); 
				
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		System.out.println(in == null);
		String line;
		while ((line = in.readLine()) != null) 
		{
			if(line.contains("ready for connections")) break;
		    System.out.println(line);
		}
		System.out.println("MySQL Database Started!");
		in.close();
	}
}
