package com.esprit.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entities.Categorie;
import com.esprit.project.entities.Pub;
import com.esprit.project.entities.Rating;
import com.esprit.project.services.CategorieService;
import com.esprit.project.services.PubService;
import com.esprit.project.services.RatingService;
@RestController
public class PubController {
	
    @Autowired
    private PubService pubservice;
    @Autowired
    private RatingService ratingService;
    
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/AllPub")
    public Object getAll()
    {
        List<Pub> pub = pubservice.getAllPub();
        return ResponseEntity.status(HttpStatus.FOUND).body(pub);
    }
    
    @GetMapping("/Pub/{id}")
    public Object getById(@PathVariable Long id)
    {
        Pub pub = pubservice.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(pub);
    }
    
    @GetMapping("/PubCategorie/{id}")
    public Object getByCategorieId(@PathVariable Long id)
    {
    	List<Pub> pub = pubservice.getListPubByCategorieId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(pub);
    }
    
    @DeleteMapping("/Pub/deletePub/{idPub}")
    public  void deletePub(@PathVariable("idPub") Long idPub){
        pubservice.deletePub(idPub);
    }
    
    @PostMapping("/addPub/categorie/{idC}")
    public ResponseEntity<?> addPub(@RequestBody Pub pub, @PathVariable("idC") Long idc)
    {
 Categorie cat = categorieService.getById(idc);
    	pub.setCategorie(cat);
        pub =  pubservice.savePub(pub);
        return ResponseEntity.status(HttpStatus.FOUND).body(pub);
    }
    @PostMapping("/updatePub")
    public ResponseEntity<?> updatePub(@RequestBody Pub pub) {
        Pub pubUpdated = pubservice.updatePub(pub);
        return ResponseEntity.accepted().body(pubUpdated);
    }
    
    @GetMapping("/ClientPub/{idClent}/{min}")
    public Object pubForMe(@PathVariable("idClent") Long id,@PathVariable("min") Float min)
    {
    	List<Rating> ratingList =ratingService.findByClient_Id(id,min);
    	if(!ratingList.isEmpty()) {
    	ArrayList<Categorie> catList =new ArrayList();
    	for (Rating rating : ratingList) {
			if(rating.getBookA()!=null) {
			catList.add(rating.getBookA().getCategorie());	
			}
			if(rating.getBookN()!=null) {
			catList.add(rating.getBookN().getCategorie());	
			}
			if(rating.getBookP()!=null) {
			catList.add(rating.getBookP().getCategorie());	
			}
		}
    	Categorie maxOcu = catList.get(0);
    	int max =1;
    	for (Categorie cat : catList) {
			int count =0;
			if(cat==cat) {
				count++;
			}
			if(count>max) {
				maxOcu = cat;
				max = count;
			}
			
		}
    	Random rand = new Random();
    	List<Pub> pubList = pubservice.getListPubByCategorieId(maxOcu.getId());
		if(pubList.isEmpty()) {
			return null;
		}
    	Pub randomPub = pubList.get(rand.nextInt(pubList.size()));
		return ResponseEntity.accepted().body(randomPub);
    	}else {
    		List<Pub> pubList = pubservice.getAllPub();
    		if(pubList.isEmpty()) {
    			return null;
    		}
    		Random rand = new Random();
    		Pub randomPub = pubList.get(rand.nextInt(pubList.size()));
    		return ResponseEntity.accepted().body(randomPub);
    	}    	
    }
}
