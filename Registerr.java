/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author MSI-JO
 */
@Entity
@Table(name = "tb_register")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registerr {
    
    @Id
    private Long id;
    
    private String email;
    
    private String username;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    

    
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "id" )
//    private Employee employee;
//    
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @ManyToMany (cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private List<Role> roles;
}

