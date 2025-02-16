package lt.techin.cat_cafe.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private User user;
  private LocalDate dateOfReservation;
  private String timeSlot;
  private int numGuests;

  public Reservation(User user, LocalDate dateOfReservation, String timeSlot, int numGuests) {
    this.user = user;
    this.dateOfReservation = dateOfReservation;
    this.timeSlot = timeSlot;
    this.numGuests = numGuests;
  }

  public Reservation() {
  }

  public long getId() {
    return id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LocalDate getDateOfReservation() {
    return dateOfReservation;
  }

  public void setDateOfReservation(LocalDate dateOfReservation) {
    this.dateOfReservation = dateOfReservation;
  }

  public String getTimeSlot() {
    return timeSlot;
  }

  public void setTimeSlot(String timeSlot) {
    this.timeSlot = timeSlot;
  }

  public int getNumGuests() {
    return numGuests;
  }

  public void setNumGuests(int numGuests) {
    this.numGuests = numGuests;
  }
}
