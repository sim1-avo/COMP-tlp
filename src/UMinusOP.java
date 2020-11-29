public class UMinusOP extends Expr{

    private Expr e;
    private int i;
    public UMinusOP(Expr e){
        this.i= 0 - e.getValInt();
    }
}
