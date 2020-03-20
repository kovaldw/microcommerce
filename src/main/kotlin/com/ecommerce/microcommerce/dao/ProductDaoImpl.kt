//package com.ecommerce.microcommerce.dao
//
//import com.ecommerce.microcommerce.model.Product
//import org.springframework.stereotype.Repository
//
//
//@Repository
//class ProductDaoImpl : ProductDao {
//
//    companion object
//    {
//        var produits : ArrayList<Product> = arrayListOf(
//                Product(1, "Ordinateur Portable", 350, 120),
//                Product(2, "Aspirateur Robot", 500, 200),
//                Product(3, "Table de Ping Pong", 75, 400)
//        )
//    }
//
//    override fun findAll(): ArrayList<Product> = produits
//
//    override fun findBy(id: Int): Product? {
//        for (product in produits)
//        {
//            if (product.id == id)
//            {
//                return product
//            }
//        }
//        return null
//    }
//
//    override fun save(product: Product): Product? {
//        try {
//            produits.add(product)
//            return product
//        }
//        catch (exception: Exception)
//        {
//            return null
//        }
//
//    }
//
//
//}