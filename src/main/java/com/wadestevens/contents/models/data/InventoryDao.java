package com.wadestevens.contents.models.data;

import com.wadestevens.contents.models.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InventoryDao extends CrudRepository<Inventory, Integer> {

}
