package com.reactassessment.placesearch.service.imp;

import com.reactassessment.placesearch.component.FavoritePlaceComponent;
import com.reactassessment.placesearch.entity.FavoritePlace;
import com.reactassessment.placesearch.repository.FavoritePlaceRepository;
import com.reactassessment.placesearch.service.IFavoritePlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FavoritePlaceService implements IFavoritePlaceService {

    @Autowired
    private FavoritePlaceRepository favoritePlaceRepository;
    @Autowired
    protected FavoritePlaceComponent favoritePlaceComponent;

    private static final Logger logger = LoggerFactory.getLogger(FavoritePlaceService.class);

    @Override
    public boolean saveFavorite(FavoritePlace _favoritePlace) {
        try {
            favoritePlaceRepository.save(_favoritePlace);
            return true;
        }catch (Exception e){
            logger.error("FavoritePlace saving: " + e.toString());
            return false;
        }
    }

    @Override
    public List<FavoritePlace> getAllFavorites() {
        return favoritePlaceRepository.findAll();
    }

    @Override
    public boolean deleteFavorite(Long id) {
        if (favoritePlaceComponent.checkexisting(id) == true)
        {
            try {
                favoritePlaceRepository.deleteById(id);
            }catch (Exception e){
                logger.error("FavoritePlace deleting : {}" + e.toString());
                return false;
            }
        }
        else{
            return false;
        }

        return true;
    }
}
