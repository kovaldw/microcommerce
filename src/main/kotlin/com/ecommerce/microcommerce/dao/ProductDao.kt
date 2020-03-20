package com.ecommerce.microcommerce.dao

import com.ecommerce.microcommerce.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList


@Repository
interface ProductDao: JpaRepository<Product, Int>
{

    fun findByPrixGreaterThan(prix:Int):ArrayList<Product>
//    fun save(product: Product) :Product?

//    @Query("select p from Product p order by nom asc")
//    fun trierProduits():ArrayList<Product>

    fun findAllByOrderByNomDesc():ArrayList<Product>

    override fun existsById(id:Int):Boolean

}

