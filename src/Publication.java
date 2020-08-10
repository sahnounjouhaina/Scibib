import java.util.List;

public class Publication {
    private String title;
    private Integer year;
    List<PersonneInfos> Auteur;

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}

