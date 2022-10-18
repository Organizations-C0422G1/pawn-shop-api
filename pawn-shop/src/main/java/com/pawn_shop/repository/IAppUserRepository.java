package com.pawn_shop.repository;

import com.pawn_shop.model.login.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
}
