package com.ecommerce.microcommerce.web.security.payload.requests

import javax.validation.constraints.NotBlank

class LoginRequest(
        @NotBlank
        var usernameOrEmail:String = "",

        @NotBlank
        var password:String = ""
)