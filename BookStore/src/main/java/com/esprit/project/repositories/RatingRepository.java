package com.esprit.project.repositories;

import com.esprit.project.entities.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long> {

    Rating findByBookP_IdAndAndClient_Id(Long idBookP,Long IdClient);
    List<Rating> findByBookPId(Long id);

}
