package com.mahasiswa.Data.Kampus.loginSecurity.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mahasiswa.Data.Kampus.loginSecurity.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
    public Optional<User> findByUsername(String username);
}