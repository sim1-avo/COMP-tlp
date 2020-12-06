import java.util.ArrayList;

public class AssignOP extends Stat {
    private ArrayList<AssignSingle> a;

    public AssignOP(ArrayList<Id> ilist, ArrayList<Expr> elist) {
        super();
        a=new ArrayList<AssignSingle>();
        doSingleAssign(ilist, elist);
    }

    public void doSingleAssign(ArrayList<Id> ilist, ArrayList<Expr> elist) {
        if(ilist.size() == elist.size()) {
            for (int i=0; i<ilist.size(); i++) {
                AssignSingle as=new AssignSingle(ilist.get(i),elist.get(i));
                a.add(as);
            }
        } else {
            boolean hasCallProc= false;
            for(Expr e: elist) {
                if (e.getCp()!=null) hasCallProc=true;
            }
            if(hasCallProc) {
                int index_expr=0;
                int diff=ilist.size()-elist.size();
                for (int i=0; i<ilist.size(); i++) {
                    AssignSingle as=new AssignSingle(ilist.get(i),elist.get(index_expr));
                    a.add(as);
                    if(elist.get(index_expr).getCp() != null ) {

                        for (int j=i+1; j< i+1+diff; j++) {
                            AssignSingle as1=new AssignSingle(ilist.get(j),elist.get(index_expr));
                            a.add(as1);
                        }
                        i=i+diff;
                    }
                    index_expr++;
                }
            } else {
                throw new Error("Syntax Error on Assign");
            }
        }

    }

    public ArrayList<AssignSingle> getA() {
        return a;
    }

    public void setA(ArrayList<AssignSingle> a) {
        this.a = a;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}
