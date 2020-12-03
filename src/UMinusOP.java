public class UMinusOP extends Expr{

    private Expr e;
    private int i;
    public UMinusOP(Expr e){
        this.i= 0 - e.getValInt(); //TODO chiedere al prof
    }

    public Expr getE() {
        return e;
    }

    public void setE(Expr e) {
        this.e = e;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}
