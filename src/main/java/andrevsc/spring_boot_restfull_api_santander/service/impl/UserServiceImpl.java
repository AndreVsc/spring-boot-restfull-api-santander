package andrevsc.spring_boot_restfull_api_santander.service.impl;

import andrevsc.spring_boot_restfull_api_santander.domain.model.User;
import andrevsc.spring_boot_restfull_api_santander.domain.repository.UserRepository;
import andrevsc.spring_boot_restfull_api_santander.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}