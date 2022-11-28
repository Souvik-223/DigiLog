package com.example.digilog;

public class storinglabdata {
    String roomno, laptopc, pcno, entrytime,regno;

    public storinglabdata() {
    }

    public storinglabdata(String roomno, String laptopc, String pcno, String entrytime, String regno) {
        this.roomno = roomno;
        this.laptopc = laptopc;
        this.pcno = pcno;
        this.entrytime = entrytime;
        this.regno = regno;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getLaptopc() {
        return laptopc;
    }

    public void setLaptopc(String laptopc) {
        this.laptopc = laptopc;
    }

    public String getPcno() {
        return pcno;
    }

    public void setPcno(String pcno) {
        this.pcno = pcno;
    }

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }
}
