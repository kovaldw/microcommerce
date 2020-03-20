package com.ecommerce.microcommerce.web.controller

//import com.ecommerce.microcommerce.configuration.PasswordEncoder
import com.ecommerce.microcommerce.dao.UserRepository
import com.ecommerce.microcommerce.model.User
import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("/user")
class UserController
{
    @Autowired
    lateinit var userRepository:UserRepository
//
//    @Autowired
//    lateinit var bCryptPasswordEncoder:PasswordEncoder

    @PostMapping("/signup")
    fun signUp(@RequestBody user: User):String
    {
        var userExiste = userRepository.findByUsernameOrEmail(user.username, user.username)
        if (userExiste == null)
        {
//            user.passwordEncoder = bCryptPasswordEncoder.bCryptPasswordEncoder().encode(user.password)
            userRepository.save(user)
            return user.username
        }
        else
        {
            return "no"
        }

    }

}