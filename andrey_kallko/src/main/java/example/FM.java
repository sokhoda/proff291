package example;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.ArrayList;

public class FM {
    private File[] paths;
    private ArrayList<String> lHistory = new ArrayList();
    private ArrayList<String> rHistory = new ArrayList();
    private int lPosition = 0;
    private int rPosition = 0;
    private File cFile = null;

    public FM() {
        File[] root = File.listRoots();
        int size = root.length;

        for(int i = 0; i < size; ++i) {
            this.lHistory.add(root[i] + "");
            this.rHistory.add(root[i] + "");
        }

    }

    public ArrayList<String> getlHistory() {
        return this.lHistory;
    }

    public void setlHistory(ArrayList<String> lHistory) {
        this.lHistory = lHistory;
    }

    public ArrayList<String> getrHistory() {
        return this.rHistory;
    }

    public void setrHistory(ArrayList<String> rHistory) {
        this.rHistory = rHistory;
    }

    public int getlPosition() {
        return this.lPosition;
    }

    public void setlPosition(int lPosition) {
        this.lPosition = lPosition;
    }

    public int getrPosition() {
        return this.rPosition;
    }

    public void setrPosition(int rPosition) {
        this.rPosition = rPosition;
    }

    public File[] getAll() {
        return this.paths;
    }

    public String lFile() {
        return (String)this.lHistory.get(this.lPosition);
    }

    public String rFile() {
        return (String)this.rHistory.get(this.rPosition);
    }

    public void copy() throws IOException {
        File end = new File(this.rFile());
        Files.copy(this.cFile.toPath(), end.toPath(), new CopyOption[0]);
    }
}
