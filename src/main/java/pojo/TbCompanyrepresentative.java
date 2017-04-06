package pojo;

public class TbCompanyrepresentative {
    private String companyrepresentativeid;

    private String name;

    private String password;

    private String telephone;

    private String email;

    public String getCompanyrepresentativeid() {
        return companyrepresentativeid;
    }

    public void setCompanyrepresentativeid(String companyrepresentativeid) {
        this.companyrepresentativeid = companyrepresentativeid == null ? null : companyrepresentativeid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}