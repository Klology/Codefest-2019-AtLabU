package com.example.atlabu;

class tester {
    public static final tester ourInstance = new tester();
    private boolean SUs=false, PUs=false, Ss=false, Ps=false;
    private boolean Ws=false, SLEs=false;
    static tester getInstance() {
        return ourInstance;
    }

    public tester() {




    }

    public void setUsername (String username){
       // this.username = username;
    }
    public void setPUs(Boolean PUz){
        PUs = PUz;
    }
    public void setSUs(Boolean SUz){
        SUs = SUz;
    }
    public void setSs(Boolean Sz){
        Ss = Sz;
    }
    public void setPs(Boolean Pz){
        Ps = Pz;
    }
    public void setWs(Boolean Wz){
        Ws = Wz;
    }
    public void setSLEs(Boolean SLEz){
        SLEs = SLEz;
    }
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


}
