package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PicInfo;

public interface PicRepo extends JpaRepository<PicInfo,String>{

}
