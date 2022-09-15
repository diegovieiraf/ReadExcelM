
public class Student {

    private int id;
    private String name;
    private String nickname;
    private String [] languages;
    private String[] areasOfInterest;
    private String dateOfBirth;

    public int getId() {
        return this.id;
    }

    public void setId(int xx) {
        this.id = xx;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return this.nickname;
    }
    public void setNickname (String nickname) {
        this.nickname = nickname;
    }

    public String[] getLanguages() {
        return this.languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getAreasOfInterest() {
        return areasOfInterest;
    }

    public void setAreasOfInterest(String[] areasOfInterest) {
        this.areasOfInterest = areasOfInterest;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
