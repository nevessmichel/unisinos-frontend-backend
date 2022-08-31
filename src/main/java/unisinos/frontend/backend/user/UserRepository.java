package unisinos.frontend.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select * from User where email=:email ans password=:password limit 1")
    User login(@Param("email") String email,
               @Param("password") String password);

}
