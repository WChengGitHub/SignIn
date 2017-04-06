package pojo;

import java.util.Date;

public class TbNotify {
    private String notifyid;

    private String title;

    private String content;

    private Date notifytime;

    private String adscription;

    public String getNotifyid() {
        return notifyid;
    }

    public void setNotifyid(String notifyid) {
        this.notifyid = notifyid == null ? null : notifyid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getNotifytime() {
        return notifytime;
    }

    public void setNotifytime(Date notifytime) {
        this.notifytime = notifytime;
    }

    public String getAdscription() {
        return adscription;
    }

    public void setAdscription(String adscription) {
        this.adscription = adscription == null ? null : adscription.trim();
    }
}