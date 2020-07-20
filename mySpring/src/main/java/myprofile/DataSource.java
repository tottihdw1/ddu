package myprofile;

/**
 * @author hdw
 * @create 2020-07-17-15:06
 * @desc 描述
 */
public class DataSource {
    private String  url;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "DataSource{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
