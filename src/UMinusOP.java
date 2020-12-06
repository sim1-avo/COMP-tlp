public class UMinusOP extends Expr{

    private IntConst i;
    private FloatConst f;
    public UMinusOP(int i){
        this.i=new IntConst(i);
    }
    public UMinusOP(float f){
        this.f=new FloatConst(f);
    }

    public IntConst getI() {
        return i;
    }

    public void setI(IntConst i) {
        this.i = i;
    }

    public FloatConst getF() {
        return f;
    }

    public void setF(FloatConst f) {
        this.f = f;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}
