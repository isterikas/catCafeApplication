package lt.techin.cat_cafe.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cat_adoptions")
public class CatAdoption {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private User user;
  private String catName;
  private String status;
  private LocalDateTime applicationDate;

  public CatAdoption(User user, String catName, String status, LocalDateTime applicationDate) {
    this.user = user;
    this.catName = catName;
    this.status = status;
    this.applicationDate = applicationDate;
  }

  public CatAdoption() {
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

  public String getCatName() {
    return catName;
  }

  public void setCatName(String catName) {
    this.catName = catName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDateTime getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(LocalDateTime applicationDate) {
    this.applicationDate = applicationDate;
  }
}
