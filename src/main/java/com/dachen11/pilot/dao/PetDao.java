package com.dachen11.pilot.dao;

import com.dachen11.pilot.model.Pet;

import java.util.List;

public interface PetDao {
    List<Pet> findAll();
}
