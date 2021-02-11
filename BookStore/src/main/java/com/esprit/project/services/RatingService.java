package com.esprit.project.services;

import com.esprit.project.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);
    Rating modifRating(Rating rating);
    void deleteRating(Long id);

    Rating findByBookPandClient(Long idBookP, Long idClient);
    Rating findByBookAandClient(Long idBookA, Long idClient);
    Rating findByBookNandClient(Long idBookN,Long IdClient);
    Rating findByCdandClient(Long idCd, Long idClient);
    Rating findByMagazineandClient(Long idMagazine,Long idClient);


    List<Rating> findByBookPId(Long idBookP,Float min);
    List<Rating> findByBookAId(Long idBookA,Float min);
    List<Rating> findByBookNId(Long idBookN,Float min);
    List<Rating> findByCDId(Long idCD,Float min);
    List<Rating> findByMagazineId(Long Magazine,Float min);

    List<Rating> findByClientandBookAIsNotNull(Long id,Float min);
    List<Rating> findByClientandBookNIsNotNull(Long id,Float min);
    List<Rating> findByClientandBookPIsNotNull(Long id,Float min);
    List<Rating> findByClientandMagazineIsNotNull(Long id,Float min);
    List<Rating> findByClientandCDIsNotNull(Long id,Float min);


    List<Rating> findByBookAAuteurId(Long id,Float min);
    List<Rating> findByBookNAuteurId(Long id,Float min);
    List<Rating> findByBookPAuteurId(Long id,Float min);
    List<Rating> findByMagazineAuteurId(Long id,Float min);

    List<Rating> findByBookACategorieId(Long id,Float min);
    List<Rating> findByBookNCategorieId(Long id,Float min);
    List<Rating> findByBookPCategorieId(Long id,Float min);

    List<Rating> findByClient_Id(Long id,Float min);



}
