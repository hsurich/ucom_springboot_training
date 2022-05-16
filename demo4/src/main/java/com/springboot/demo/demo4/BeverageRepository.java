package com.springboot.demo.demo4;

import org.springframework.data.repository.CrudRepository;

public interface BeverageRepository extends CrudRepository<Beverage, Long> {
}
