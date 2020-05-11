package embeded.homework.hw1.bean;


public class Face {
    private Long id;
    private String faceName;
    private String faceToken;

    public Face(Long id, String faceName, String faceToken) {
        this.id = id;
        this.faceName = faceName;
        this.faceToken = faceToken;
    }

    @Override
    public String toString() {
        return "Face{" +
                "id=" + id +
                ", faceToken='" + faceToken + '\'' +
                ", faceName='" + faceName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {
        this.faceName = faceName;
    }
}
