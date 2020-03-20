package com.ecommerce.microcommerce.web.security

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint {



    companion object
    {
        var logger: Logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint::class.java)
    }

    /*override fun commence(httpServletRequest: HttpServletRequest,
                          httpServletResponse: HttpServletResponse,
                          exception: AuthenticationException)
    {
        logger.error("Responding with unauthorized error. Message - {}", exception.message)
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.message)
    }*/

    @Throws(IOException::class, ServletException::class)
    override fun commence(httpServletRequest:HttpServletRequest,
                 httpServletResponse:HttpServletResponse,
                 e:AuthenticationException)
    {
        logger.error("Responding with unauthorized error. Message - {}", e.message)
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.message)
    }

}