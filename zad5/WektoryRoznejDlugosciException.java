
//Wyjatek - przyklad z wykladu
class WektoryRoznejDlugosciException extends Exception { 

    private int i, j;
	
    public WektoryRoznejDlugosciException(String msg){
        super(msg);
    }
	
    public WektoryRoznejDlugosciException(String msg, int i, int j){
        super(msg);
        this.i = i;
        this.j = j;
    }
	
    public int value1(){
        return i;
    }
	
    public int value2(){
        return j;
    }
}