package pojo;

import java.util.Date;

public class TbAdvice {
    private String adviceid;

    private String employeeid;

    private String content;

    private Boolean status;

    private Date date;

    private Boolean style;

    public String getAdviceid() {
        return adviceid;
    }

    public void setAdviceid(String adviceid) {
        this.adviceid = adviceid == null ? null : adviceid.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStyle() {
        return style;
    }

    public void setStyle(Boolean style) {
        this.style = style;
    }
}