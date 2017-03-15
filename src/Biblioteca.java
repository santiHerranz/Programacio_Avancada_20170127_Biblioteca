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
        boolean trobat = false;
        Node n = this.publicacions;
        if ( n == null) {                                       // no hi han editorials
            this.publicacions = new Node(m.getEditorial(), null);
            this.publicacions.inf.Inserir(m);
            return;
        }
        if (n.editorial.equals(m.getEditorial()))                // es la primera
            trobat = true;
        while (trobat != true && n.seg != null) {
            if (n.seg.editorial.equals(m.getEditorial())) {
                trobat = true;
            } else
                n = n.seg;
        }
        if (!trobat) {                                          // no s'ha trobat
            n.seg = new Node(m.getEditorial(), null);
            n.inf.Inserir(m);
        } else {                                                // editorial trobada
            if ( n.inf.Membre(m)) throw new Exception("Existeix");
            n.inf.Inserir(m);
        }
    }


    public void esborrarPublicacio(Publicacio m) throws Exception {
        /* Exercici 2 */

    }
    public void llistatPublicacions(int periodicitat) {/* Exercici 3 */}

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
