package com.training.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.dao.IDoctorDao;
import com.training.exception.DoctorNotFoundException;
import com.training.exception.IdNotFoundException;
import com.training.model.Doctor;
@Component
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
IDoctorDao doctorDao;
	public List<Doctor> getAll() {
		List<Doctor> doctors=doctorDao.findAll();
		List<Doctor>doctorList =doctors
				.stream()
				.sorted((d1,d2)->d1.getName().compareTo(d2.getName()))
				.collect(Collectors.toList());
		return doctorList;
	}

	public Doctor getById(int doctorId) throws IdNotFoundException {
	Doctor doctorById=doctorDao.findById(doctorId);
		if(doctorById !=null) {
			return doctorById;
		}
throw new IdNotFoundException("id not exception");
}
	

	public List<Doctor> getByName(String name) throws DoctorNotFoundException {
		List<Doctor>doctor=doctorDao
				.findByName(name)
				.stream()
				.sorted((d1,d2)->d1.getName().compareTo(d2.getName()))
				.collect(Collectors.toList());
		if(doctor.isEmpty())
		{
			throw new DoctorNotFoundException("doctor not found");
		}
		return doctor;
	}

	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
		List<Doctor>doctor=doctorDao
				.findBySpeciality(speciality)
				.stream()
				.sorted((d1,d2)->d1.getName().compareTo(d2.getName()))
				.collect(Collectors.toList());
		if(doctor.isEmpty())
		{
			throw new DoctorNotFoundException("doctor not found");
		}
		return doctor;
	}

	public List<Doctor> getByFee(double fee) throws DoctorNotFoundException {
		List<Doctor>doctor=doctorDao
				.findByFee(fee)
				.stream()
				.sorted((d1,d2)->d1.getName().compareTo(d2.getName()))
				.collect(Collectors.toList());
		if(doctor.isEmpty())
		{
			throw new DoctorNotFoundException("doctor not found");
		}
		return doctor;
	}

}
