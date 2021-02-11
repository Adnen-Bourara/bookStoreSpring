package com.esprit.project.repositories;

import com.esprit.project.entities.BookAudio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookAudioRepository extends CrudRepository<BookAudio,Long>
{


    //@Query(value = "select bookaudio0_.id as id1_1_, bookaudio0_.adaptation as adaptati2_1_, bookaudio0_.auteur_id as auteur_20_1_, bookaudio0_.categorie_id as categor21_1_, bookaudio0_.collection as collecti3_1_, bookaudio0_.couverture as couvertu4_1_, bookaudio0_.date_de_parution as date_de_5_1_, bookaudio0_.duree as duree6_1_, bookaudio0_.editeur as editeur7_1_, bookaudio0_.file_path as file_pat8_1_, bookaudio0_.format as format9_1_, bookaudio0_.langue as langue10_1_, bookaudio0_.langue_origine as langue_11_1_, bookaudio0_.lieu_parution as lieu_pa12_1_, bookaudio0_.narrateur as narrate13_1_, bookaudio0_.prix as prix14_1_, bookaudio0_.sommaire as sommair15_1_, bookaudio0_.statut as statut16_1_, bookaudio0_.taille_file as taille_17_1_, bookaudio0_.titre as titre18_1_, bookaudio0_.traducteur as traduct19_1_ from book_audio bookaudio0_ left outer join categorie categorie1_ on bookaudio0_.categorie_id=categorie1_.id where categorie1_.id=:id",nativeQuery = true)
   List <BookAudio> findByAuteur_Id(Long id);
    List <BookAudio> findByCategorie_Id(Long id);

}
