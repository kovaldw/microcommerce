package com.ecommerce.microcommerce.model

import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.validator.constraints.Length
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Min

//@JsonIgnoreProperties(value = ["id", "prixAchat"])
//@JsonFilter("monFiltreDynamique")
@EnableAutoConfiguration
@Entity
class Product constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Int? = null,

        @Length(min = 3, max = 20)
        var nom:String? = null,

        @Min(value = 1)
        var prix:Int? = null,

        @Min(value = 1)
        var prixAchat:Int? = null,

        var supprimer:Boolean? = false,

        var created:Date? = Date(),

        @ManyToOne
        var user: User? = null



)


{

}