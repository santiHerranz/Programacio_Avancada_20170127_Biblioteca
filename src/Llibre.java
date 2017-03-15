public class Llibre extends Publicacio {


private String isbn;
private int any;

public Llibre(String nom, int identificador, int periodicitat, String isbn, int any, String editorial) {
        super(nom, identificador, Publicacio.ANYAL, editorial);
        this.isbn = isbn; this.any=any;

}

public String getIsbn() { return this.isbn; }

public int getAny() { return this.any; }
        }
