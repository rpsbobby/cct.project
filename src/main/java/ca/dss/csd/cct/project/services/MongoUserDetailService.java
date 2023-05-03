package ca.dss.csd.cct.project.services;

import ca.dss.csd.cct.project.entity.MongoUser;
import ca.dss.csd.cct.project.repositories.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MongoUserDetailService implements UserDetailsService {

    // documentation available at: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/core/userdetails/UserDetailsService.html

    private MongoUserRepository userRepository;


    @Autowired
    public MongoUserDetailService(MongoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MongoUser user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = getUserAuthority(user);

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> getUserAuthority(MongoUser user) {
        Set<GrantedAuthority> roles = new HashSet<>();
        user.getRoles().forEach(role -> roles.add(new SimpleGrantedAuthority(role.toString())));
        return roles.stream().toList();
    }

    public void saveUser(MongoUser user) {
        // every new user will have a USER authority 
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        SimpleGrantedAuthority role = new SimpleGrantedAuthority("USER");
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }
}
