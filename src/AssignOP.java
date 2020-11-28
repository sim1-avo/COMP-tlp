import java.util.ArrayList;

public class AssignOP extends Stat {
    private ArrayList<String> ilist;
    private ArrayList<Expr> elist;

    public AssignOP(ArrayList<String> ilist, ArrayList<Expr> elist) {
        super();
        this.ilist=ilist;
        this.elist=elist;
    }

    public ArrayList<String> getIlist() {
        return ilist;
    }

    public ArrayList<Expr> getElist() {
        return elist;
    }
}
