import java.util.ArrayList;

public class AssignOP extends Stat {
    private ArrayList<Id> ilist;
    private ArrayList<Expr> elist;

    public AssignOP(ArrayList<Id> ilist, ArrayList<Expr> elist) {
        super();
        this.ilist=ilist;
        this.elist=elist;
    }

    public void setIlist(ArrayList<Id> ilist) {
        this.ilist = ilist;
    }

    public void setElist(ArrayList<Expr> elist) {
        this.elist = elist;
    }

    public ArrayList<Id> getIlist() {
        return ilist;
    }

    public ArrayList<Expr> getElist() {
        return elist;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
}
