/**
 * Created by santi on 16/03/2017.
 */
public class app {

    public static  void  main(String args[]) {

        System.out.println("App");

        Biblioteca b = new Biblioteca();
/* */
       try {

            b.afegirPublicacio(new Publicacio("Llibre 1", 11, Publicacio.MENSUAL, "Editorial A"));
            b.afegirPublicacio(new Publicacio("Llibre 2", 12, Publicacio.MENSUAL, "Editorial A"));
            b.afegirPublicacio(new Publicacio("Llibre 3", 13, Publicacio.MENSUAL, "Editorial A"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(b.toString());


        Publicacio p1 = new Publicacio("Llibre 4", 21, Publicacio.MENSUAL, "Editorial B");

        try {
            b.afegirPublicacio(p1);
            System.out.println(b.toString());

            b.esborrarPublicacio(p1);
            System.out.println(b.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
