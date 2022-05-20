package jp.co.sss.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.game.entity.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {

}
