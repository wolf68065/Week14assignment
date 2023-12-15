package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;

@RestController
@Slf4j
public class PetStoreController{
@Autowired
private PetStoreService petStoreService;

@PostMapping("/pet_store")
@ResponseStatus(code = HttpStatus.CREATED)
public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {
	log.info("Create pet store {}", petStoreData);
	
	return petStoreService.savePetStore(petStoreData);
}
@PutMapping("/pet_store/{petStoreId}")
public PetStoreData updatePetStore(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
	
	petStoreData.setPetStoreId(petStoreId);
	log.info("Update pet Store {}",petStoreData);
	return petStoreService.savePetStore(petStoreData);
}
}