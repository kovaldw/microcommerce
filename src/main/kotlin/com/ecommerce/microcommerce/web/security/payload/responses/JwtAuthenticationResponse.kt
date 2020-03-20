package com.ecommerce.microcommerce.web.security.payload.responses

class JwtAuthenticationResponse (
        var accessToken:String = "",
        var tokenType:String = "Bearer"
) {
}