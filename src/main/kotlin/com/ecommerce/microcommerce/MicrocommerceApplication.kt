package com.ecommerce.microcommerce

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@SpringBootApplication
class MicrocommerceApplication

fun main(args: Array<String>) {
	runApplication<MicrocommerceApplication>(*args)
}
