package com.ecommerce.exceptions

import java.lang.RuntimeException

class AppException (
        override var message:String = "",
        override var cause:Throwable? = null

        ): RuntimeException()
{

}