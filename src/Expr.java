public class Expr {

    boolean bool;
    int valInt;
    String valString;
    float valFloat;
    CallProcOP cp;
    public Expr(){}

    public Expr (Boolean b){
        this.bool=b;
    }
    public Expr (int val){
        this.valInt=val;
    }
    public Expr (float val){
        this.valFloat=val;
    }
    public Expr (String val){
        this.valString=val;
    }
    public Expr (CallProcOP cp) {
        this.cp=cp;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public int getValInt() {
        return valInt;
    }

    public void setValInt(int valInt) {
        this.valInt = valInt;
    }

    public String getValString() {
        return valString;
    }

    public void setValString(String valString) {
        this.valString = valString;
    }

    public float getValFloat() {
        return valFloat;
    }

    public void setValFloat(float valFloat) {
        this.valFloat = valFloat;
    }

    public CallProcOP getCp() {
        return cp;
    }

    public void setCp(CallProcOP cp) {
        this.cp = cp;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
}
