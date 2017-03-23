/**
 * Created by santi on 16/03/2017.
 */
public class AcbEnll implements Acb { //no hereta de AbEnll

    private class NodeA{
        private Publicacio inf; private NodeA esq,dret;
        public NodeA( Comparable m) { this((Publicacio)m,null,null); }
        public NodeA( Publicacio m, NodeA e, NodeA d) { inf=m;esq=e;dret=d;}
    } //fi classe privada

    private NodeA arrel;
    public AcbEnll(){arrel=null;}


    /* implementació de totes les operacions de la interfície */
    @Override
    public boolean Membre(Comparable e)  {
        return (MembreRecursiva(arrel, (Publicacio)e));
    }

    private boolean MembreRecursiva(NodeA d, Publicacio c) {
        if (d == null) return false;
        if (c.compareTo(d.inf) == 0) return true;

        if (c.compareTo(d.inf) < 0)
            return (MembreRecursiva(d.esq, c));
        else if (c.compareTo(d.inf) > 0)
            return (MembreRecursiva(d.dret, c));
        return false;
    }


    @Override
    public void Inserir(Comparable e) throws Exception {
        this.arrel = inserirRecursiu(this.arrel, e);
    }

    private NodeA inserirRecursiu(NodeA a, Comparable e) throws Exception {
        if(a == null) {
            a = new NodeA(e);
        } else {
            int cmp = e.compareTo(a.inf);
            if (cmp == 0)
                throw new Exception("Repetit " + e +", un arbre de cerca binari no pot guardar elements repetits.");
            if (cmp < 0) {
                a.esq = inserirRecursiu(a.esq, e);
            } else {
                a.dret = inserirRecursiu(a.dret, e);
            }
        }
        return a;
    }


    @Override
    public void Esborrar(Comparable e) throws Exception {
        arrel = EsborrarRecursiu(arrel, (Comparable)e);
    }

    private NodeA EsborrarRecursiu(NodeA d, Comparable c) throws Exception {

        if (d == null) {
            throw new Exception("l'element no hi és");
        } else if (c.compareTo(d.inf) < 0) {
            d.esq = EsborrarRecursiu(d.esq, c);
        } else if (c.compareTo(d.inf) > 0) {
            d.dret = EsborrarRecursiu(d.dret, c);
        } else {
            // Es una fulla també es arrel
            if (d.esq == null && d.dret == null) {
                d = null; //esborra la referencia
            } else if (d.esq != null && d.dret != null) {
                // Dos fills
                NodeA node = d.dret;
                while (node.esq != null) {
                    node = node.esq;
                }
                d.inf = node.inf;
                d.dret = node;
            } else if (d.esq == null){
                d = d.dret;  // Unic fill dret
            } else {
                d = d.esq; // Unic fill esquerre
            }
        }
        return d;
    }



    @Override
    public Comparable ArreL() throws Exception {
        if (this.arrel == null) throw new Exception("L'arbre és buit");
        return this.arrel.inf;
    }

    @Override
    public Acb FillEsquerre() {
        AcbEnll resultat = new AcbEnll();
        resultat.arrel = this.arrel.esq;
        return resultat;
    }

    @Override
    public Acb FillDret()  {
        AcbEnll resultat = new AcbEnll();
        resultat.arrel = this.arrel.dret;
        return resultat;
    }

    @Override
    public boolean ArbreBuit() {
        return null == arrel;
    }

    @Override
    public void Buidar() {
        arrel = null;
    }

} // fi classe
