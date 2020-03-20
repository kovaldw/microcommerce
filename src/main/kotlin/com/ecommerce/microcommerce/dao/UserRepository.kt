package com.ecommerce.microcommerce.dao

import com.ecommerce.microcommerce.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface UserRepository : JpaRepository<User, Int>
{
    fun findByUsernameOrEmail(username:String, email:String = username):User?

    fun findById(id:Long): User?

    fun existsByUsername(username: String):Boolean

    fun existsByEmail(email: String):Boolean

}