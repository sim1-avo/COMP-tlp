import java.util.ArrayList;

public class NotOP extends Expr {
    private String ne;

    public NotOP(Expr expr){
        this.ne="!"+expr;
    }



}
