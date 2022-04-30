package lt.ku.sporto_klubas.Entities;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "registrations")
public class Registrations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Clients clients;
    @OneToOne
    @JoinColumn(name = "workout_id")
    private Workouts workout;
    @Column(nullable = false, length = 64)
    private String registration_date;

    public Registrations(){}
    public Registrations(Clients clients, Workouts workout) {
        this.clients = clients;
        this.workout = workout;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.registration_date = dateFormat.format(date);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public Workouts getWorkout() {
        return workout;
    }

    public void setWorkout(Workouts workout) {
        this.workout = workout;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.registration_date = dateFormat.format(date);
    }
}
