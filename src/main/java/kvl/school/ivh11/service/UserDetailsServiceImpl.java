package kvl.school.ivh11.service;

import kvl.school.ivh11.domain.Abstr.AppUser;
import kvl.school.ivh11.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserRepo repo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = repo.findByUsername(username);
        if (appUser.isPresent()) {
            return appUser.get();
        }

        throw new UsernameNotFoundException(username);
    }
}
