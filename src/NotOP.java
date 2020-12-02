import java.util.ArrayList;

public class NotOP extends Expr {
    private String ne;

    public NotOP(Expr expr){
        this.ne="!"+expr;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public String getNe() {
        return ne;
    }

    public void setNe(String ne) {
        this.ne = ne;
    }
}
