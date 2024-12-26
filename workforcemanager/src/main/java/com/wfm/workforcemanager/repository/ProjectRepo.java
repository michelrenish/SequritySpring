package com.wfm.workforcemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfm.workforcemanager.entity.Project;

public interface ProjectRepo extends JpaRepository<Project,Integer>{

}
