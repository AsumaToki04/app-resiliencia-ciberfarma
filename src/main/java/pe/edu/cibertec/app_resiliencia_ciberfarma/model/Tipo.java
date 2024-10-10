package pe.edu.cibertec.app_resiliencia_ciberfarma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_tipos")
public class Tipo {

    @Id
    @Column(name = "idtipo")
    private Integer id;

    private String descripcion;
}
