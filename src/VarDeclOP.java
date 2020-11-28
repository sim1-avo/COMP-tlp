import java.util.ArrayList;

public class VarDeclOP {
    String type;
    //ArrayList<IdInitOP> IdListInit;
    ArrayList<IdListInitOP> IdListInit;

    public VarDeclOP(String type, ArrayList<IdListInitOP> idListInit) {
        this.type = type;
        IdListInit = idListInit;
    }

}
