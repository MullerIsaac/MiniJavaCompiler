package Tree;import java.util.LinkedList;public  class ExpList extends Exp1  {        private LinkedList<Exp1> list;    public ExpList(LinkedList<Exp1> l){	list = l;    }    public LinkedList<Exp1> getList(){	return list;    }        public LinkedList<Exp1> kids(){return null;}    public Exp1 build(LinkedList<Exp1> kids){return null;}    public void accept(IntVisitor v, int d){}    public <R> R accept(ResultVisitor<R> v){return null;}    public Temp.Temp accept(CodeVisitor v){return null;}}