/**
 * Created by santi on 16/03/2017.
 */
public class Biblioteca {

    private class Node {
        private String editorial; private Acb inf; private Node seg;
        public  Node( String editorial, Node n) {
            this.editorial = editorial; seg = n; inf = new AcbEnll();
        }

        @Override
        public String toString() {
            return this.editorial;
        }
    } // fi classe privada

    private Node publicacions; /* seqüencia enllaçada sense capçalera */

    public Biblioteca() {publicacions=null;}

    public void afegirPublicacio(Publicacio m) throws Exception {
        /* Exercici l */
        if (   this.publicacions == null )
            this.publicacions = new Node(m.getEditorial(), null);

        Node editorial = this.publicacions;

        boolean trobat = false;
        while (trobat != true && editorial != null) {
            if (editorial.editorial.equals(m.getEditorial())) {
                trobat = true;
            } else
                editorial = editorial.seg;
        }
        if (!trobat) {                                          // no s'ha trobat
            editorial = new Node(m.getEditorial(), null);
            editorial.inf.Inserir(m);
        } else {                                                // editorial trobada
            if ( editorial.inf.Membre(m)) throw new Exception("Existeix");
            editorial.inf.Inserir(m);
        }
    }


    public void esborrarPublicacio(Publicacio m) throws Exception {
        /* Exercici 2 */
        Node editorial = this.publicacions;
        Node ref = this.publicacions;

        boolean trobat = false;
        while (trobat != true && editorial != null) {
            if (editorial.editorial.equals(m.getEditorial()))
                trobat = true;
            else {
                ref = editorial;
                editorial = editorial.seg;
            }
        }
        if (trobat) {                                          // editorial trobat
            editorial.inf.Esborrar(m);

            try {
                Comparable n = editorial.inf.ArreL();
                if ( n == null)
                    ref.seg = editorial.seg.seg;
            } catch (Exception e) {
            }

        } else {
            throw new Exception("No s'ha trobat l'editorial de la publicació a la biblioteca");
        }
    }

    public void llistatPublicacions(int periodicitat) {/* Exercici 3 */

        Node editorial = this.publicacions;
        while (editorial.seg != null) {
            System.out.println(editorial.inf.toString());
            editorial = editorial.seg;
        }
    }

    public String trobarPublicacio (int identificador)throws Exception {/* Exer 4 */ return null;}

    @Override
    public String toString() {
        String s = "";
        try {
            Node editorial = this.publicacions;
            while(editorial!=null) {
                s += "\n"+ editorial.toString();
                editorial = editorial.seg;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Biblioteca:"+ s;
    }
} //fi classe Biblioteca
