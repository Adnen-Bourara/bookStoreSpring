package com.esprit.project.repositories;

import com.esprit.project.entities.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long> {

    Rating findByBookP_IdAndClient_Id(Long idBookP,Long IdClient);
    Rating findByBookA_IdAndClient_Id(Long idBookA,Long IdClient);
    Rating findByBookN_IdAndClient_Id(Long idBookN,Long IdClient);
    Rating findByCd_IdAndClient_Id(Long idCd, Long idClient);
    Rating findByMagazine_IdAndClient_Id(Long idMagazine,Long idClient);


    List<Rating> findRatingByBookN_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByBookA_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByBookP_IdAndNoteGreaterThanOrderByNoteDesc(Long id, Float minimum);
    List<Rating> findRatingByCd_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByMagazine_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);

    List<Rating> findRatingByClient_IdAndBookAIsNotNullAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByClient_IdAndBookNIsNotNullAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByClient_IdAndBookPIsNotNullAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByClient_IdAndMagazineIsNotNullAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByClient_IdAndCdIsNotNullAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);

    List<Rating> findRatingByBookA_Auteur_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByBookN_Auteur_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByBookP_Auteur_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByMagazine_Auteur_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);

    List<Rating> findRatingByBookA_Categorie_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByBookN_Categorie_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);
    List<Rating> findRatingByBookP_Categorie_IdAndNoteGreaterThanOrderByNoteDesc(Long id,Float min);

}
