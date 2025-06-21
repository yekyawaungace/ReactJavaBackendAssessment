package com.reactassessment.placesearch.controller;

import com.reactassessment.placesearch.component.FavoritePlaceComponent;
import com.reactassessment.placesearch.entity.FavoritePlace;
import com.reactassessment.placesearch.repository.FavoritePlaceRepository;
import com.reactassessment.placesearch.service.imp.FavoritePlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favorite")
@CrossOrigin(origins = "http://localhost:3000") // adjust to frontend port
public class FavoritePlaceController {
    @Autowired
    private  FavoritePlaceRepository repository;

    @Autowired
    private FavoritePlaceComponent favoritePlaceComponent;

    @Autowired
    private FavoritePlaceService favoritePlaceService;

    private static final Logger logger = LoggerFactory.getLogger(FavoritePlaceController.class);

    @GetMapping
    public ResponseEntity<List<FavoritePlace>> getAllFavorites() {
        logger.info("getAllFavorites");
        List<FavoritePlace> favoritePlaces = favoritePlaceService.getAllFavorites();
        logger.info("FavoritePlace fetched: {}", favoritePlaces.size());
        return new ResponseEntity<List<FavoritePlace>>(favoritePlaces, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FavoritePlace> saveFavorite(@RequestBody FavoritePlace place) {

        if (favoritePlaceService.saveFavorite(place) == true)
        {
            logger.info("FavoritePlace have been created Successfully : {}" , place.getName());
            return new ResponseEntity<FavoritePlace>(place, HttpStatus.CREATED);
        }else{
            logger.info("FavoritePlace have been created Fail : {}" , place.getName());
            return new ResponseEntity<FavoritePlace>(place, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    // DELETE /api/favorite/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        logger.info("deleteFavorite by id : {}" , id);
        if (favoritePlaceComponent.checkexisting(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}