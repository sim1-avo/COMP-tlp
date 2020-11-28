import java.util.ArrayList;

public class WhileOP extends Stat {
    private ArrayList<Stat> sList1, sList2;
    private Expr e;

    public WhileOP(ArrayList<Stat> sList1, Expr e, ArrayList<Stat> sList2) {
        super();
        this.sList1=sList1;
        this.e=e;
        this.sList2=sList2;
    }

    public WhileOP(Expr e, ArrayList<Stat> sList2) {
        super();
        this.e=e;
        this.sList2=sList2;
    }

    public ArrayList<Stat> getsList1() {
        return sList1;
    }

    public ArrayList<Stat> getsList2() {
        return sList2;
    }

    public Expr getE() {
        return e;
    }
}
