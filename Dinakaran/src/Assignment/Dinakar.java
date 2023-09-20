
package Assignment;

public class Dinakar {
    private String faceColor,hairColor;
    private int hairCount;
    public  final boolean beardPresent;

    public Dinakar(String faceColor, String hairColor, int hairCount, boolean beardPresent) {
        this.faceColor = faceColor;
        this.hairColor = hairColor;
        this.hairCount = hairCount;
        this.beardPresent = beardPresent;
    }

    public String getFaceColor() {
        return faceColor;
    }

    public void setFaceColor(String faceColor) {
        this.faceColor = faceColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public int getHairCount() {
        return hairCount;
    }

    public void setHairCount(int hairCount) {
        this.hairCount = hairCount;
    }
    
    
}
