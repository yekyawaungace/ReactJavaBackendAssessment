package com.reactassessment.placesearch.repository;

import com.reactassessment.placesearch.entity.FavoritePlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritePlaceRepository extends JpaRepository<FavoritePlace, Long> {
}