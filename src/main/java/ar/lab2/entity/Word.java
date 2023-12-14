package ar.lab2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    @TableGenerator(
            name="AutoIncrement",
            allocationSize=1)

    @Id
    @GeneratedValue(generator = "AutoIncrement")
    private Integer id;

    private String text;
    private String translation;
}
