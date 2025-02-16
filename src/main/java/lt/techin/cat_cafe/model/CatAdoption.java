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
  String catName;
  String status;
  LocalDateTime applicationDate;


}
