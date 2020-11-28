import java.util.ArrayList;

public class BodyOP {
    private ArrayList<Stat> statList;

    public BodyOP (ArrayList<Stat> statList) {
        this.statList=statList;
    }

    public BodyOP () {
        this.statList=new ArrayList<Stat>();
    }

    public void addStat(Stat s) {
        statList.add(s);
    }

    public ArrayList<Stat> getStatList() {
        return statList;
    }

}
