package pojo;

import java.util.Date;

public class TbArriveandleave {
    private String arriveandleaveid;

    private String employeeid;

    private Date arrivetime;

    private Date leavetime;

    public String getArriveandleaveid() {
        return arriveandleaveid;
    }

    public void setArriveandleaveid(String arriveandleaveid) {
        this.arriveandleaveid = arriveandleaveid == null ? null : arriveandleaveid.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public Date getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(Date arrivetime) {
        this.arrivetime = arrivetime;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }
}