package mavenTest.zad2;

import java.util.Random;

public class Kontrakt implements Psikus {

	private Integer dzielna;
	
	public Kontrakt() { }
	
	public Kontrakt(Integer liczba) {
		dzielna = liczba;
	}
	
	public Integer CyfroKrad(Integer liczba) {
		
		if (liczba == null)
			throw new IllegalArgumentException();
		
		boolean czyUjemna = false;
		if (liczba < 0) {
			czyUjemna = true;
			liczba = -liczba;
		}
		
		int ileCyfr = liczba.toString().length();
		
		if (ileCyfr == 1)
			return null;
		
		Random losowy = new Random();
		int doUsuniecia = losowy.nextInt(ileCyfr);
		
		String wynik = "";	
		for(int i = 0; i < ileCyfr; i++) {
			if(i != doUsuniecia)
				wynik += liczba.toString().charAt(i);
		}
		
		liczba = Integer.parseInt(wynik);
		if (czyUjemna)
			liczba = -liczba;
		
		return liczba;
	}


	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException {
		
		if (liczba == null)
			throw new NieudanyPsikusException();
		
		boolean czyUjemna = false;
		if (liczba < 0) {
			czyUjemna = true;
			liczba = -liczba;
		}
		
		int ileCyfr = liczba.toString().length();
		
		if (ileCyfr == 1)
			throw new NieudanyPsikusException();
		
		Random losowy = new Random();
		int doZamiany1 = losowy.nextInt(ileCyfr);
		int doZamiany2 = losowy.nextInt(ileCyfr);
		
		while (doZamiany1 == doZamiany2)
			doZamiany2 = losowy.nextInt(ileCyfr);
		
		String wynik = "";
		for(int i = 0; i < ileCyfr; i++) {
			if (i == doZamiany1)
				wynik += liczba.toString().charAt(doZamiany2);
			else if (i == doZamiany2)
				wynik += liczba.toString().charAt(doZamiany1);
			else
				wynik += liczba.toString().charAt(i);
		}

		liczba = Integer.parseInt(wynik);
		if (czyUjemna)
			liczba = -liczba;
		
		return liczba;
	}

	public Integer Nieksztaltek(Integer liczba) {

		if (liczba == null)
			throw new IllegalArgumentException();
		
		int ileCyfrDoZamiany = 0;
		for (char cyfra : liczba.toString().toCharArray()) {
			if (cyfra == '3' || cyfra == '6' || cyfra == '7')
				ileCyfrDoZamiany++;
		}
		
		if (ileCyfrDoZamiany == 0)
			return liczba;
		
		Random losowy = new Random();
		int doZamiany = losowy.nextInt(ileCyfrDoZamiany);
		
		String wynik = "";
		int pomoc = 0;
		for(int i = 0; i < liczba.toString().length(); i++) {
			char cyfra = liczba.toString().charAt(i);
			if (cyfra == '3' || cyfra == '6' || cyfra == '7') {
				if (pomoc == doZamiany) {
					switch (cyfra) {
					case '3' : cyfra = '8';
							   break;
					case '7' : cyfra = '1';
							   break;
					case '6' : cyfra = '9';
							   break;
					}
				}
				pomoc++;
			}
			wynik += cyfra;
		}
		return Integer.parseInt(wynik);		
	}

	public Integer Heheszki(Integer liczba) {
		
		if (liczba == null)
			throw new IllegalArgumentException();
		
		if (liczba <= 0)
			throw new IllegalArgumentException();
		
		Random losowy = new Random();
		int wynik = losowy.nextInt(liczba);
		return wynik;
	}

	public boolean Titit(Integer liczba_dziel) {
		
		if (liczba_dziel == null)
			throw new IllegalArgumentException();
		
		if (liczba_dziel == 0)
			throw new IllegalArgumentException();
		
		boolean wynik = false;
		if (dzielna % liczba_dziel == 0)
			wynik = true;
		return wynik;
	}

}
