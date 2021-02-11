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


    List<Rating> findRatingByBookN_Id(Long id);
    List<Rating> findRatingByBookA_Id(Long id);
    List<Rating> findRatingByBookP_Id(Long id);
    List<Rating> findRatingByCd_Id(Long id);
    List<Rating> findRatingByMagazine_Id(Long id);

    List<Rating> findRatingByClient_IdAndBookAIsNotNull(Long id);
    List<Rating> findRatingByClient_IdAndBookNIsNotNull(Long id);
    List<Rating> findRatingByClient_IdAndBookPIsNotNull(Long id);
    List<Rating> findRatingByClient_IdAndMagazineIsNotNull(Long id);
    List<Rating> findRatingByClient_IdAndCdIsNotNull(Long id);

    List<Rating> findRatingByBookA_Auteur_Id(Long id);
    List<Rating> findRatingByBookN_Auteur_Id(Long id);
    List<Rating> findRatingByBookP_Auteur_Id(Long id);
    List<Rating> findRatingByMagazine_Auteur_Id(Long id);

    List<Rating> findRatingByBookA_Categorie_Id(Long id);
    List<Rating> findRatingByBookN_Categorie_Id(Long id);
    List<Rating> findRatingByBookP_Categorie_Id(Long id);





}
