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
    public Rating findByBookPandClient(Long idBookP, Long idClient) {
        return ratingRepository.findByBookP_IdAndClient_Id(idBookP,idClient);
    }

    @Override
    public Rating findByBookAandClient(Long idBookA, Long idClient) {
        return null;
    }

    @Override
    public Rating findByBookNandClient(Long idBookN, Long IdClient) {
        return null;
    }

    @Override
    public Rating findByCdandClient(Long idCd, Long idClient) {
        return null;
    }

    @Override
    public Rating findByMagazineandClient(Long idMagazine, Long idClient) {
        return null;
    }

    @Override
    public List<Rating> findByBookPId(Long idBookP,Float minimum) {
        return (List<Rating>) ratingRepository.findRatingByBookP_IdAndNoteGreaterThanOrderByNoteDesc(idBookP,minimum);
    }

    @Override
    public List<Rating> findByBookAId(Long idBookA,Float min) {
        return (List<Rating>) ratingRepository.findRatingByBookA_IdAndNoteGreaterThanOrderByNoteDesc(idBookA,min);
    }

    @Override
    public List<Rating> findByBookNId(Long idBookN,Float min) {
        return (List<Rating>) ratingRepository.findRatingByBookN_IdAndNoteGreaterThanOrderByNoteDesc(idBookN,min);
    }

    @Override
    public List<Rating> findByCDId(Long idCD,Float min) {
        return (List<Rating>) ratingRepository.findRatingByCd_IdAndNoteGreaterThanOrderByNoteDesc(idCD,min);
    }

    @Override
    public List<Rating> findByMagazineId(Long Magazine,Float min) {
        return (List<Rating>) ratingRepository.findRatingByMagazine_IdAndNoteGreaterThanOrderByNoteDesc(Magazine,min);
    }

    @Override
    public List<Rating> findByClientandBookAIsNotNull(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByClient_IdAndBookAIsNotNullAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByClientandBookNIsNotNull(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByClient_IdAndBookNIsNotNullAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByClientandBookPIsNotNull(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByClient_IdAndBookPIsNotNullAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByClientandMagazineIsNotNull(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByClient_IdAndMagazineIsNotNullAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByClientandCDIsNotNull(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByClient_IdAndCdIsNotNullAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByBookAAuteurId(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByBookA_Auteur_IdAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByBookNAuteurId(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByBookN_Auteur_IdAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByBookPAuteurId(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByBookP_Auteur_IdAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByMagazineAuteurId(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByMagazine_Auteur_IdAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByBookACategorieId(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByBookA_Categorie_IdAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByBookNCategorieId(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByBookN_Categorie_IdAndNoteGreaterThanOrderByNoteDesc(id,min);
    }

    @Override
    public List<Rating> findByBookPCategorieId(Long id,Float min) {
        return (List<Rating>) ratingRepository.findRatingByBookP_Categorie_IdAndNoteGreaterThanOrderByNoteDesc(id,min);
    }



}
