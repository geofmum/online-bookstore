package api.domain;

public class Publisher extends BaseModel {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
