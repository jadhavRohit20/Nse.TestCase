package com.nse.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nse.entity.PortfolioDemo;
import com.nse.entity.ShareDemo;

public interface PortfolioRepo extends JpaRepository<PortfolioDemo, Integer> {

	

}
