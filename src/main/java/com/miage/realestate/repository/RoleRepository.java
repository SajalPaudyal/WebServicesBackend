package com.miage.realestate.repository;

import com.miage.realestate.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
