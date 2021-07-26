package com.example.demo.repository;

import com.example.demo.model.entity.DataH2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<DataH2,String> {


     List<DataH2> findAll();

     DataH2 save(DataH2 dataH2);

}
