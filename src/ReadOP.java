import java.util.ArrayList;

public class ReadOP extends Stat{
    private ArrayList<String> idList;

    public ReadOP() {
        super();
        this.idList=new ArrayList<String>();
    }

    public ReadOP (ArrayList<String> idList) {
        super();
        this.idList=idList;
    }

    public void addId(String id) {
        this.idList.add(id);
    }

}
