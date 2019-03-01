Il programma attualmente funziona soltanto con la funzioen "Run uCOM" di Eclipse

PRIMA DI PROVARE IL PROGRAMMA

Bisogna far partire un database MySQL in locale e riconfigurare il file 'hibernate.cfg.xml'.
In particolare le seguenti linee:

        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">uComPassword</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/uCOM?createDatabaseIfNotExist=true</property>


La versione di MySQL utilizzata è la 5.7.25, ma è possibile che funzioni anche altre versioni.


Gli utenti di prova disponibili già dal primo avvio sono:

sysadmin
admin
student

La password per tutti gli utenti e' "test" (anche per utenti che vengono aggiunti dopo).



L'interfaccia è volutamente un misto tra interfaccia grafica e interfaccia a linea di comando per mostrare la facilità d'integrazione
di un'interfaccia grafica dal momento in cui il software è progettato in maniera flessibile.

Soltanto il Registro Utenti è integrato con il database, e soltanto l'operazione di aggiunta utenti è attualmente disponibile.

Alcuni test falliscono dalla seconda esecuzione (vedere commenti codice), proprio perché non è stata implementata l'eliminazione dal Database.