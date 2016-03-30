package soundProgs.domain;

/**
 * Created by ${BIM} on 22.02.2016.
 */
public class InterfaceInfo {

    private int    LID;
    private String ProjectCaption;
    private String AuthorName;
    private String Owner;
    private String Result;
    private String Phonenumber;
    private String CallCreated;
    private int    CallLength;
    private String Direction;
    private String TaskName;
    private String recordurl;


    public InterfaceInfo() {
    }

    public InterfaceInfo(int LID, String projectCaption, String authorName, String owner, String result, String phonenumber, String callCreated, int callLength, String direction, String taskName, String recordurl) {
        this.LID = LID;
        this.ProjectCaption = projectCaption;
        this.AuthorName = authorName;
        this.Owner = owner;
        this.Result = result;
        this.Phonenumber = phonenumber;
        this.CallCreated = callCreated;
        this.CallLength = callLength;
        this.Direction = direction;
        this.TaskName = taskName;
        this.recordurl = recordurl;
    }

    public int getLID() {
        return LID;
    }

    public void setLID(int LID) {
        this.LID = LID;
    }

    public String getProjectCaption() {
        return ProjectCaption;
    }

    public void setProjectCaption(String projectCaption) {
        ProjectCaption = projectCaption;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getCallCreated() {
        return CallCreated;
    }

    public void setCallCreated(String callCreated) {
        CallCreated = callCreated;
    }

    public int getCallLength() {
        return CallLength;
    }

    public void setCallLength(int callLength) {
        CallLength = callLength;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getRecordurl() {
        return recordurl;
    }

    public void setRecordurl(String recordurl) {
        this.recordurl = recordurl;
    }
}
