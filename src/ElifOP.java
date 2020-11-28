import java.util.ArrayList;

public class ElifOP {
    private Expr e;
    private ArrayList<Stat> sList;

    public ElifOP(Expr e, ArrayList<Stat> sList) {
        this.e=e;
        this.sList=sList;
    }

    public Expr getE() {
        return e;
    }

    public ArrayList<Stat> getsList() {
        return sList;
    }
}
