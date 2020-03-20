package com.ecommerce.microcommerce.dao

import com.ecommerce.microcommerce.model.Role
import com.ecommerce.microcommerce.model.RoleName
import org.springframework.data.jpa.repository.JpaRepository


interface RoleRepository : JpaRepository<Role, Long> {

    fun findByName(name:RoleName):Role?
}