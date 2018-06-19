package com.mutualofomaha.mob.repos

import com.mutualofomaha.mob.entity.Auth
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by req87834 on 4/11/18.
 */
@Repository
interface AuthRepository extends JpaRepository<Auth, Long>{

}