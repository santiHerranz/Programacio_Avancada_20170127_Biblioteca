/**
 * Created by santi on 15/03/2017.
 */
public class Publicacio implements Comparable{



    public static final int DIARI = 1;
    public static final int MENSUAL = 2;
    public static final int TRIMESTRAL = 3;
    public static final int SEMESTRAL = 4;
    public static final int ANYAL = 5;

    protected String nom;

    protected int identificador; // identificador i únic per cada publicació

    protected String editorial;

    protected int periodicitat;//Només pot ser DIARI, MENSUAL, TRIMESTRAL, SEMESTRAL o ANYAL

    public Publicacio(String nom, int identificador, int periodicitat, String editorial) {
        this.nom = nom;
        this.identificador = identificador;
        this.periodicitat = periodicitat;
        this.editorial = editorial;
    }

    public int getIdentificador() { return this.identificador;}
    public String getNom() {return this.nom; }
    public String getEditorial() { return this.editorial;}
    public int getPeriodicitat() { return this.periodicitat;}

    public int compareTo(Object o) {
        Integer p = new Integer(((Publicacio) o).getIdentificador());
        return (new Integer(identificador)).compareTo(p);
    }
}

