package pojo;

public class TbCompany {
    private String companyid;

    private String name;

    private String address;

    private Boolean del;

    private String companyrepresentativeid;

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public String getCompanyrepresentativeid() {
        return companyrepresentativeid;
    }

    public void setCompanyrepresentativeid(String companyrepresentativeid) {
        this.companyrepresentativeid = companyrepresentativeid == null ? null : companyrepresentativeid.trim();
    }
}