package com.reactassessment.placesearch.service;

import com.reactassessment.placesearch.entity.FavoritePlace;

import java.util.List;

public interface IFavoritePlaceService {

    boolean saveFavorite(FavoritePlace _favoritePlace);
    List<FavoritePlace> getAllFavorites();
    boolean deleteFavorite(Long id);


}
