package lt.ku.sporto_klubas.Entities;
import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "workouts")
public class Workouts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 64)
    private String name;
    @Column(nullable = false, length = 64)
    private String date;
    @Column(nullable = false, length = 64)
    private Integer places;
    @Column(nullable = false, length = 64)
    private String location;
    @Column
    private String filename;
    @OneToMany(mappedBy = "workout", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Registrations> registrations;

    public Workouts(){}
    public Workouts(String name, String date, Integer places, String location) {
        this.name = name;
        this.date = date;
        this.places = places;
        this.location = location;
    }
    public Workouts(String name, String date, Integer places, String location, String filename) {
        this.name = name;
        this.date = date;
        this.places = places;
        this.location = location;
        this.filename = filename;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Registrations> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registrations> registrations) {
        this.registrations = registrations;
    }
}
