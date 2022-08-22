package com.training.dao;

import java.util.List;

import com.training.exception.DoctorNotFoundException;
import com.training.exception.IdNotFoundException;
import com.training.model.Doctor;

public interface IDoctorDao {
	List<Doctor> findAll();
	Doctor findById(int doctorId)throws IdNotFoundException;
	List<Doctor> findByName(String name)throws DoctorNotFoundException;
	List<Doctor> findBySpeciality(String speciality)throws DoctorNotFoundException;
	List<Doctor> findByFee(double fee)throws DoctorNotFoundException;
}
