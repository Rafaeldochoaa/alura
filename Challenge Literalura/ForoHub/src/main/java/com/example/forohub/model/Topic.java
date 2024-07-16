package com.example.forohub.model;

import lombok.Data;
import javax.persistence.;
import java.time.LocalDateTime;

@Data
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;

    @ManyToOne
    private User autor;

    @ManyToOne
    private Course curso;
}
