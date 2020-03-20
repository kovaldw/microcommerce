package com.ecommerce.microcommerce.web.security

import com.ecommerce.microcommerce.dao.UserRepository
import com.ecommerce.microcommerce.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class CustomUserDetailsService() : UserDetailsService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Throws(UsernameNotFoundException::class)
    @Transactional
    override fun loadUserByUsername(usernameOrMail: String): UserDetails
    {
        var user: User? = userRepository.findByUsernameOrEmail(usernameOrMail, usernameOrMail)
                ?: throw UsernameNotFoundException("User not found with username or email : $usernameOrMail")

        return UserPrincipal.create(user!!)
    }

    fun loadUserById(id:Long):UserDetails
    {
        var user:User? = userRepository.findById(id) ?: throw UsernameNotFoundException("User not found with id: $id")

        return UserPrincipal.create(user!!)

    }
}