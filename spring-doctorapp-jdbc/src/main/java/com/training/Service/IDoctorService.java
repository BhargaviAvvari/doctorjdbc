package com.training.Service;

import java.util.List;

import com.training.exception.DoctorNotFoundException;
import com.training.exception.IdNotFoundException;
import com.training.model.Doctor;

public interface IDoctorService {
	List<Doctor> getAll();
	Doctor getById(int doctorId)throws IdNotFoundException;
	List<Doctor> getByName(String name)throws DoctorNotFoundException;
	List<Doctor> getBySpeciality(String speciality)throws DoctorNotFoundException;
	List<Doctor> getByFee(double fee)throws DoctorNotFoundException;
	
}
