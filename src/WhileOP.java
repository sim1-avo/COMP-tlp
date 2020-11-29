import java.util.ArrayList;

public class WhileOP extends Stat {
    private BodyOP sList1, sList2;
    private Expr e;

    public WhileOP(BodyOP sList1, Expr e, BodyOP sList2) {
        super();
        this.sList1=sList1;
        this.e=e;
        this.sList2=sList2;
    }

    public WhileOP(Expr e, BodyOP sList2) {
        super();
        this.e=e;
        this.sList2=sList2;
    }

    public BodyOP getsList1() {
        return sList1;
    }

    public BodyOP getsList2() {
        return sList2;
    }

    public Expr getE() {
        return e;
    }
}
