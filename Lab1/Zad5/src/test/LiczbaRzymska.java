package test;

public class LiczbaRzymska {
	
	int liczba;
	
	public LiczbaRzymska(int licz) {
		liczba = licz;
	}
	
	public String toString() {
		if (liczba <= 0)
			throw new NumberFormatException();
		
        String rzymski[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int wartosc[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        String wynik = "";
        int krok = liczba;
        
        for (int i = 0; liczba > 0; i++) {
            krok = liczba / wartosc[i];
            for (int j = 1; j <= krok; j++) {
            	wynik += rzymski[i];
            }
            liczba = liczba % wartosc[i];
        }
        return wynik;
	}
}
