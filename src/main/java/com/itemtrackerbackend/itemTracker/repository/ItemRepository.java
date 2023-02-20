package com.itemtrackerbackend.itemTracker.repository;

import com.itemtrackerbackend.itemTracker.models.jpa.ItemJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<ItemJPA, Long> {
}
