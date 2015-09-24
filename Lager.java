public class Konto{
	private int Reifen=0;
	private int karosserieTeile=0;
	private int motorTeile=0;
	private int kleinTeile=0;
	private int lagerPlatzMax=200;
	private int lagerPlatzFrei=200;
	private int kleinerTraktor=0;
	private int großerTraktor=0;
	private int PlatzKleinerTraktor=10;
	private int PlatzGroßerTraktor=25;
	private double PreisReifen;
	private double PreiskarosserieTeile;
	private double PreisMotorTeile;
	private double PreisKleinTeile;
	private int[]Lager={{0},{0},{0},{0},{0},{0}}
#	private double Lagerplatzmiete;
	
	public boolean hinzufuegen(int[6]produkte){
		int menge=0
		for(int i=0, i<=5, i++)
		{
			if(produkte[i]>0)
			{
				switch (i){
					case 0:
						menge+=produkte[i];
						if(menge>lagerPlatzFrei)
						{
							return false;
						}
						break;
					case 1:
						menge+=produkte[i]*3;
						if(menge>lagerPlatzFrei)
						{
							return false;
						}
						break;
					case 2:
						menge+=produkte[i]*3;
						if(menge>lagerPlatzFrei)
						{
							return false;
						}
						break;
					case 3:
						menge+=produkte[i];
						if(menge>lagerPlatzFrei)
						{
							return false;
						}
						break;
					case 4:
						menge+=produkte[i]*PlatzKleinerTraktor;
						if(menge>lagerPlatzFrei)
						{
							return false;
						}
						break;
					case 5:
						menge+=produkte[i]*PlatzGroßerTraktor;
						if(menge>lagerPlatzFrei)
						{
							return false;
						}
						break;
				}
			}
		}
		lagerPlatzFrei-=menge;
		for(int i=0; i<=5; i++)
		{
			Lager[i]+=produkte[i];
		}
		return true;
	}
		
	public boolean verbrauchen (int[6]produkte){
		int menge=0
		for(int i=0, i<=5, i++)
		{
			if(produkte[i]>0)
			{
				switch (i){
					case 0:
						menge+=produkte[i];
						if(produkte[i]>Lager[i])
						{
							return false;
						}
						break;
					case 1:
						menge+=produkte[i]*3;
						if(produkte[i]>Lager[i])
						{
							return false;
						}
						break;
					case 2:
						menge+=produkte[i]*3;
						if(produkte[i]>Lager[i])
						{
							return false;
						}
						break;
					case 3:
						menge+=produkte[i];
						if(produkte[i]>Lager[i])
						{
							return false;
						}
						break;
					case 4:
						menge+=produkte[i]*PlatzKleinerTraktor;
						if(produkte[i]>Lager[i])
						{
							return false;
						}
						break;
					case 5:
						menge+=produkte[i]*PlatzGroßerTraktor;
						if(produkte[i]>Lager[i])
						{
							return false;
						}
						break;
				}
			}
		}
		lagerPlatzFrei+=menge;
		for(int i=0; i<=5; i++)
		{
			Lager[i]-=produkte[i];
		}
		return true;
	}
	
	public boolean kaufen(int[6]produkte){
		int menge=0
		for(int i=0, i<=3, i++)
		{
			if(produkte[i]>0)
			{
				switch (i){
					case 0:
						menge+=produkte[i];
						if(menge>lagerPlatzFrei||Finanzen.pruefeKontostand(PreisReifen*produkte[i]==false)
						{
							return false;
						}
						break;
					case 1:
						menge+=produkte[i]*3;
						if(menge>lagerPlatzFrei||Finanzen.pruefeKontostand(PreiskarosserieTeile*produkte[i]==false)
						{
							return false;
						}
						break;
					case 2:
						menge+=produkte[i]*3;
						if(menge>lagerPlatzFrei||Finanzen.pruefeKontostand(PreisMotorTeile*produkte[i]==false)
						{
							return false;
						}
						break;
					case 3:
						menge+=produkte[i];
						if(menge>lagerPlatzFrei||Finanzen.pruefeKontostand(PreisKleinTeile*produkte[i]==false)
						{
							return false;
						}
						break;
				}
			}
		}
		lagerPlatzFrei-=menge;
		for(int i=0; i<=3; i++)
		{
			Lager[i]-=produkte[i];
		}
		return true;
	}
	
	public void PreisAendern(String Produkt, double Preis){
		switch (Produkt){
			case "Reifen":
				PreisReifen=Preis;
				break;
			case "karosserieTeile"_
				PreiskarosserieTeile=Preis;
				break;
			case "motorTeile":
				PreisMotorTeile=Preis;
				break;
			case "kleinTeile":
				PreisKleinTeile=Preis;
				break;
		}
	}
	
	public void LagerplatzErhöhen(int Platz){
		lagerPlatzFrei=lagerPlatzFrei+Platz;
		lagerPlatzMax=lagerPlatzMax+Platz;
	}