package kvl.school.ivh11.repository;

import kvl.school.ivh11.domain.Abstr.AppUser;

import java.util.Optional;

public interface AppUserRepo extends BaseRepo<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
