package com.esprit.project.services;

import com.esprit.project.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);
    Rating modifRating(Rating rating);
    void deleteRAting(Long id);
    Rating findByBookPAndClient(Long idBookP,Long idClient);
    List<Rating> findByBookPId(Long idBookP);

}
