package com.reactassessment.placesearch.component;


import com.reactassessment.placesearch.repository.FavoritePlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FavoritePlaceComponent {

    @Autowired
    private FavoritePlaceRepository favoritePlaceRepository;

    public boolean checkexisting(Long id ){
        if (favoritePlaceRepository.existsById(id) == true){
            return true;
        }
        return false;
    }
}
