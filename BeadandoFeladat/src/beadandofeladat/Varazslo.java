package beadandofeladat;

public class Varazslo extends Karakter{
    private int eletero = 5;
    private int pozicio = 0;
    private char tipus = ' ';

    public Varazslo(int eletero, int pozicio, char tipus) throws EleteroRangeCheckedException, PozicioRangeCheckedException {
        if (this.eletero > 4 && this.eletero < 10) {
            this.eletero = eletero;
        } else {
            throw new EleteroRangeCheckedException(" Tartományon kívüli Harcos életerő!");
        }
        if (this.pozicio > -1 && this.pozicio < 3) {
            this.pozicio = pozicio;
        } else {
            throw new PozicioRangeCheckedException(" Tartományon kívüli Harcos pozíció!");
        }
        this.tipus = getTipus();
    }

    @Override
    public char getTipus() {
        return 'V';
    } 
    
    public int getEletero(){ return this.eletero; }
    public void setEletero(int eletero) { this.eletero = eletero; }    
    public int getPozicio() {  return this.pozicio; }
    public void setPozicio(int pozicio) { this.pozicio = pozicio; }
    
}
