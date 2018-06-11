package hello;

public class MCC {

    private final long id;
    private final String content;

    public MCC(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
