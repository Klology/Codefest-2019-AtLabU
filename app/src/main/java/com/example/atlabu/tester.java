package com.example.atlabu;

class tester {
    private static final tester ourInstance = new tester();
    private boolean SUs=false, PUs=false, Ss=false, Ps=false, Ws=false, SLEs=false, Rs=false, Ms=false  ;
    private boolean SUs=false, PUs=false, Ss=false, Ps=false;
    private boolean Ws=false, SLEs=false;
    private int cash=0;
    static tester getInstance() {
        return ourInstance;
    }

    private tester() {




    }

    public static tester getOurInstance() {
        return ourInstance;
    }

    public void setUsername (String username){
       // this.username = username;
    }
    public void setPUs(Boolean PUz){
        this.PUs = PUz;
    }
    public void setSUs(Boolean SUz){
        this.SUs = SUz;
    }
    public void setSs(Boolean Sz){
        this.Ss = Sz;
    }
    public void setPs(Boolean Pz){
        this.Ps = Pz;
    }
    public void setWs(Boolean Wz){ this.Ws = Wz; }
    public void setSLEs(Boolean SLEz){ this.SLEs = SLEz; }
    public void setRs(Boolean Rs){ this.Rs = Rs; }
    public void setMs(Boolean Ms){ this.Ms = Ms; }
//////////////////////////geters
    public boolean getPUs(){
        return PUs;
    }
    public boolean getSUs(){
        return SUs;
    }
    public boolean getSs(){
        return Ss;
    }
    public boolean getPs(){
        return Ps;
    }
    public boolean getWs(){
        return Ws;
    }
    public boolean getSLEs(){
        return SLEs;
    }
    public void mutCash(int points){
        cash += points;
    }
    public int getCash(){

        return cash;
    }

    public boolean getRs(){
        return Rs;
    }
    public boolean getMs(){
        return Ms;
    }

}
