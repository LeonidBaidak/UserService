package com.baidak.softserve.user_service.repository;

import com.baidak.softserve.user_service.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID> { // TODO Paging
}
