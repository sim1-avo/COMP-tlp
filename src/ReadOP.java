import java.util.ArrayList;

public class ReadOP extends Stat{
    private ArrayList<Id> idList;

    public ReadOP() {
        super();
        this.idList=new ArrayList<Id>();
    }

    public ReadOP (ArrayList<Id> idList) {
        super();
        this.idList=idList;
    }



}
