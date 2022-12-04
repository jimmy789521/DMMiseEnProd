package org.polytech.toeic.service;

import org.polytech.toeic.entity.ToeicUser;
import org.polytech.toeic.repository.ToeicUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ToeicUserService implements UserDetailsService {

    private static Logger log = LoggerFactory.getLogger(ToeicUserService.class);
    private final PasswordEncoder passwordEncoder;
    private final ToeicUserRepository toeicUserRepository;

    public ToeicUserService(ToeicUserRepository toeicUserRepository, PasswordEncoder passwordEncoder)
    {
        this.passwordEncoder = passwordEncoder;
        this.toeicUserRepository = toeicUserRepository;
    }

    public List<ToeicUser> getUsers()
    {
        return toeicUserRepository.findAll();
    }

    public ToeicUser addUser(ToeicUser newUser)
    {
        toeicUserRepository.save(newUser);
        return newUser;
    }
    public void updateUser(ToeicUser user)
    {
        toeicUserRepository.save(user);
    }

    public Optional<ToeicUser> getUserById(int id) {

        return  toeicUserRepository.findById(id);
    }
    @PostConstruct
    public void createUserDefault() {
        if (toeicUserRepository.findByName("trueadmin")==null)
        {
            log.info("Création de l'utilisateur par defaut");
            ToeicUser user = new ToeicUser();
            user.setName("trueadmin");
            user.setPassword(passwordEncoder.encode("password"));
            this.toeicUserRepository.save(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        log.info("récupération de {}",username);
        ToeicUser user = toeicUserRepository.findByName(username);
        if(user!=null)
        {
            return new User(user.getName(),user.getPassword(),List.of());

        }
        else {
            throw new UsernameNotFoundException("L'utilisateur n'existe pas");
        }
    }
}
