import java.util.ArrayList;

public class WriteOP extends Stat{
    private ArrayList<Expr> exprList;

    public WriteOP(ArrayList<Expr> exprList) {
        super();
        this.exprList=exprList;
    }

    public ArrayList<Expr> getExprList() {
        return exprList;
    }
}
