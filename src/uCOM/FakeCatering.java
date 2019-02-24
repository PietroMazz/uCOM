package uCOM;

import java.util.concurrent.ThreadLocalRandom;

import util.Status;

/**
 * @author Pietro
 *
 */
public class FakeCatering {
	
	private final String [] PRIMI = {"PASTA", "RISO", "PATATE", "FARRO", "LENTICCHIE", "CECI"};
	private final String [] CONDIMENTI = {"TONNO", "POMODORO", "FORMAGGIO", "CARCIOFI", "GAMBERI"};
	private final String [] SECONDI = {"CARNE", "PESCE", "SALUMI MISTI", "HAMBURGER", "TOFU", "SALSICCIA"};
	private final String [] CONTORNI = {"LATTUGA", "INSALATA ALLA NORMA", "CAPONATA", "PARMIGIANA", "SPINACI SALTATI"};
	
	public String [] getMenu()
	{
		int randomPrimo = ThreadLocalRandom.current().nextInt(0, PRIMI		.length);
		int randomCond 	= ThreadLocalRandom.current().nextInt(0, CONDIMENTI	.length);
		int randomSec 	= ThreadLocalRandom.current().nextInt(0, SECONDI	.length);
		int randomCont 	= ThreadLocalRandom.current().nextInt(0, CONTORNI	.length);
		
		String primoUno = PRIMI[randomPrimo] + " con " + CONDIMENTI[randomCond];
		String secondoUno = SECONDI[randomSec] + " e contorno di " + CONTORNI[randomCont];
		
		randomPrimo = ThreadLocalRandom.current().nextInt(0, PRIMI		.length);
		randomCond 	= ThreadLocalRandom.current().nextInt(0, CONDIMENTI	.length);
		randomSec 	= ThreadLocalRandom.current().nextInt(0, SECONDI	.length);
		randomCont 	= ThreadLocalRandom.current().nextInt(0, CONTORNI	.length);
		
		String primoDue= PRIMI[randomPrimo] + " con " + CONDIMENTI[randomCond];
		String secondoDue = SECONDI[randomSec] + " e contorno di " + CONTORNI[randomCont];
		
		String [] s = {primoUno, primoDue, secondoUno, secondoDue};
		
		return s;
	}
	
	public Status sendMealBooking()
	{
		return Status.SUCCESS;
	}

}
