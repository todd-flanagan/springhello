package hello;

public class Build {

    private String toolbox;
    private String ctf;

    public Build() {
    }

    public Build(String toolbox, String ctf) {
        this.toolbox = toolbox;
        this.ctf = ctf;
    }

    public void settoolbox(String toolbox) {
        this.toolbox = toolbox;
    }

    public String gettoolbox() {
        return toolbox;
    }

    public String getctf() {
        return ctf;
    }

    public void setctf(String ctf) {
        this.ctf = ctf;
    }

    @Override
    public String toString() {
        return "toolbox: " + toolbox + ", ctf: " + ctf;
    }

}
