package pe.edu.cibertec.app_resiliencia_ciberfarma.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @Column(name = "cod_usua")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_usua")
    private String nombres;

    @Column(name = "ape_usua")
    private String apellidos;

    @Column(name = "usr_usua")
    private String username;

    @Column(name = "cla_usua")
    private String password;

    @Column(name = "fna_usua")
    private String fecNac;

    @Column(name = "est_usua")
    private Byte estado;

    @ManyToOne
    @JoinColumn(name = "idtipo")
    private Tipo tipo;
}
