package com.xdesign.munro.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Munro {

    @Id
    @Column( name = "running_no" )
    @JsonIgnore
    private String runningNo;

    private String name;

    @Column( name = "height_m" )
    private Integer height;

    @Column( name = "post_1997" )
    private String category;

    @Column( name = "grid_ref" )
    private String gridRef;
}
