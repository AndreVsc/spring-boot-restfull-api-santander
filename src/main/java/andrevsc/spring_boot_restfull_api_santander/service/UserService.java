package andrevsc.spring_boot_restfull_api_santander.service;

import andrevsc.spring_boot_restfull_api_santander.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}