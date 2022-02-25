package com.nse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nse.entity.ShareDemo;

public interface ShareRepo extends JpaRepository<ShareDemo, Integer>{

}
