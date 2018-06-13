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

    public void setToolbox(String toolbox) {
        this.toolbox = toolbox;
    }

    public String getToolbox() {
        return toolbox;
    }

    public String getCtf() {
        return ctf;
    }

    public void setCtf(String ctf) {
        this.ctf = ctf;
    }

    @Override
    public String toString() {
        return "toolbox: " + toolbox + ", ctf: " + ctf;
    }

}
