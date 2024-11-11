package tecinfo.poo.model;

public class Dado {
    private int num;

    public Dado(){

    }

    public void numSort(){
        num = (int)(Math.random() * 11 + 1);
    }

    public long getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    
    
}
