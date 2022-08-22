package com.training.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.training.Service.IDoctorService;
import com.training.exception.DoctorNotFoundException;
import com.training.exception.IdNotFoundException;
import com.training.model.Doctor;
@Component
public class DoctorImplDao implements IDoctorDao {

	public List<Doctor> findAll() {
		return showAllDoctors() ;
	}

	public Doctor findById(int doctorId) throws IdNotFoundException {
		   return showAllDoctors().stream().filter(doctor->doctor.getDoctorId() == doctorId)
				.findFirst().get();
		}

	public List<Doctor> findByName(String name) throws DoctorNotFoundException {
		 return showAllDoctors().stream().filter(doctor->doctor.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}

	public List<Doctor> findBySpeciality(String speciality) throws DoctorNotFoundException {
		return showAllDoctors().stream().filter(doctor->doctor.getSpeciality().equalsIgnoreCase(speciality))
				.collect(Collectors.toList());
	}

	public List<Doctor> findByFee(double fee) throws DoctorNotFoundException {
		return showAllDoctors().stream().filter(doctor->doctor.getFee()==(fee))
				.collect(Collectors.toList());
	}
	private List<Doctor> showAllDoctors(){
		return Arrays.asList(
		new Doctor ("saijala",1001,"neurologist",2000),
		new Doctor ("kavitha",1002,"orthopeditrian",4000),
		new Doctor ("kumari",1003,"Dentist",1000),
		new Doctor ("Komali",1004,"radiology",3000),
		new Doctor ("dheeraj",1005,"nutrionist",2500),
		new Doctor ("Gautam",1006,"dermatology",5000));
	}

}
