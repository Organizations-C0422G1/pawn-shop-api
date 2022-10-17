package com.pawn_shop.repository;

import com.pawn_shop.model.login.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole,Long> {
}
