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



}
