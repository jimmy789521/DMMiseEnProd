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
    public final PasswordEncoder passwordEncoder;
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
    public void deleteUser(ToeicUser deletedUser)
    {
        toeicUserRepository.delete(deletedUser);
    }
    public void updateUser(ToeicUser user)
    {
        toeicUserRepository.save(user);
    }

    public Optional<ToeicUser> getUserById(int id) {

        return  toeicUserRepository.findById(id);
    }
    @PostConstruct
    public void Test() {
        if (toeicUserRepository.findByName("admin")==null)
        {
            log.info("Création de l'utilisateur par defaut");
            ToeicUser user = new ToeicUser();
            user.setName("admin");
            user.setAdmin(true);
            user.setPassword(passwordEncoder.encode("admin"));
            this.toeicUserRepository.save(user);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        log.info("récupération de {}",username);
        ToeicUser user = toeicUserRepository.findByName(username);
        System.out.println(user.getName());
        log.info(user.getName(),"est admin");
        if(user!=null) //Pour être authentifié , l'utilisateur doit avoir un identifiant un mot de passe mais aussi être administrateur ( admin = true)
        {
            return new User(user.getName(),user.getPassword(),List.of());

        }
        else {
            throw new UsernameNotFoundException("L'utilisateur n'existe pas ou n'a pas les droits d'accès");
        }
    }
}
