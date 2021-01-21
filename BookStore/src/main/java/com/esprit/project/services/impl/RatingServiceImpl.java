package com.esprit.project.services.impl;

import com.esprit.project.entities.Rating;
import com.esprit.project.repositories.RatingRepository;
import com.esprit.project.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating modifRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Long id) {
        try {
            ratingRepository.deleteById(id);
        }
     catch(
    EmptyResultDataAccessException e)

    {
        System.out.println("doesn't exist");
    }

}

    @Override
    public Rating findByBookPAndClient(Long idBookP, Long idClient) {
        return ratingRepository.findByBookP_IdAndClient_Id(idBookP,idClient);
    }

    @Override
    public List<Rating> findByBookPId(Long idBookP) {
        return (List<Rating>) ratingRepository.findRatingByBookP_Id(idBookP);
    }
}
