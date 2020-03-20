package com.ecommerce.microcommerce.web.controller

import com.ecommerce.microcommerce.dao.ProductDao
import com.ecommerce.microcommerce.dao.UserRepository
import com.ecommerce.microcommerce.model.Product
import com.ecommerce.microcommerce.model.User
import com.ecommerce.microcommerce.payload.responses.ApiResponse
import com.ecommerce.microcommerce.web.security.CustomUserDetailsService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpRequest
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.security.core.Authentication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.lang.Exception
import java.net.URI
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid
import kotlin.collections.ArrayList


@Api(description = "Ce controller gere les CRUD des produits")
@RestController
class ProductController
{

    @Autowired
    lateinit var productDao: ProductDao

    @Autowired
    lateinit var userRepository: UserRepository


    @ApiOperation(value = "Récupère un produit grâce à son ID")
    @GetMapping(value = ["/produits/{id}"])
    fun oneProduit(@PathVariable id:Int) : Optional<Product>
    {

        if (!productDao.existsById(id))  throw Exception("Produit introuvable")
        return productDao.findById(id)

    }


    @RequestMapping(value = ["/produits"], method = arrayOf(RequestMethod.GET))
    fun listePorduits(request:HttpServletRequest): MutableList<Product>
    {
//        var listeProduits = productDao.findAll();//On stocke la liste des porduits dans une variable
//
//        //On definit la regle de filtre
//        var monFiltre: SimpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat", "id")
//
//        //On definit les classes sur lesquelles on veut appliquer la regle de filtre
//        //Dans notre cas, il s'agit des classes qui ont pour annotation monFiltreDynamique
//        var listeDeNosFiltres: FilterProvider = SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre)
//
//        //On met les produits au format MappingJackson afin davoir acces a la metode setFilter()
//        var listeProduitsFiltres: MappingJacksonValue = MappingJacksonValue(listeProduits)
//        listeProduitsFiltres.filters = listeDeNosFiltres
//
//        return listeProduitsFiltres

//        var listeProduits: ArrayList<Product> = productDao.findByPrixGreaterThan(400)
//        return listeProduits


//        var authentication:Authentication = SecurityContextHolder.getContext().authentication


        return productDao.findAll()


    }




    @PostMapping(value = ["/produits"])
    fun ajouterProduit(@Valid @RequestBody product:Product, request: HttpServletRequest): ResponseEntity<Any>
    {
        if (product.prix == 0)
        {
            return ResponseEntity.ok(ApiResponse(false, "Le prix est null"))
        }

        val userName = request.userPrincipal.name
        val user = userRepository.findByUsernameOrEmail(userName)

        product.user = user

        var productAdded = productDao.save(product)


//        val productAdded = productDao.save(product) ?: return ResponseEntity.noContent().build()
        val location: URI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.id)
                .toUri()
        return ResponseEntity.created(location).build()
    }


    @GetMapping(value = ["/AdminProduits"])
    fun calculerMargeProduit(): ArrayList<Int>
    {
        var produits = productDao.findAll()
        var json = ""
        var tableau = arrayListOf<Int>()
        for (produit in produits)
        {
            val marge = produit.prix?.minus(produit.prixAchat!!)
            if (marge != null) {
                tableau.add(marge)
            }
        }

        return tableau
    }


    @GetMapping(value = ["produits/tri"])
    fun triProduits(): ArrayList<Product> {
//        return productDao.trierProduits()
        return productDao.findAllByOrderByNomDesc()


    }



}