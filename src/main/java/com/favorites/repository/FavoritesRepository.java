package com.favorites.repository;

import com.favorites.domain.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {

    Favorites findById(long id);

    List<Favorites> findByUserId(Long userId);

    List<Favorites> findByUserIdOrderByLastModifyTimeDesc(Long userId);

    List<Favorites> findByUserIdOrderByLastModifyTimeAsc(Long userId);

    Favorites findByUserIdAndName(Long userId, String name);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Favorites f set f.count=(f.count-1),f.lastModifyTime =:lastModifyTime where f.id =:id")
    void reduceCountById(@Param("id") Long id, @Param("lastModifyTime") Long lastModifyTime);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Favorites set name=:name ,lastModifyTime=:lastModifyTime where id=:id")
    void updateNameById(@Param("id") Long id, @Param("lastModifyTime") Long lastModifyTime, @Param("name") String name);

    @Query("select id from Favorites where name=?1")
    List<Long> findIdByName(String name);
}