import java.util.ArrayList;

public class IfOP extends Stat{
    private Expr e;
    private BodyOP sList;
    private ArrayList<ElifOP>elList;
    private ElseOP el;

    public IfOP(Expr e, BodyOP sList, ArrayList<ElifOP> elList, ElseOP el) {
        super();
        this.e=e;
        this.sList=sList;
        this.elList=elList;
        this.el=el;
    }

    public Expr getE() {
        return e;
    }

    public BodyOP getsList() {
        return sList;
    }

    public ArrayList<ElifOP> getElList() {
        return elList;
    }

    public ElseOP getEl() {
        return el;
    }
}
