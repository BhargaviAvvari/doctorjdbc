package com.training.client;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.Service.DoctorServiceImpl;
import com.training.Service.IDoctorService;

public class DoctorMain {

	public static void main(String[] args) {
		 ApplicationContext context=new AnnotationConfigApplicationContext("com.training");
		 Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
		IDoctorService doctorService= context.getBean(DoctorServiceImpl.class,"doctorServiceImpl");// TODO Auto-generated method stub
doctorService.getAll().forEach(System.out::println);
System.out.println("Name");
doctorService.getByName("kavitha").forEach(System.out::println);
System.out.println("Specialist");
doctorService.getBySpeciality("dentist").forEach(System.out::println);
System.out.println("Fee");
doctorService.getByFee(4000).forEach(System.out::println);
System.out.println("doctorId");
System.out.println("DoctorId "+doctorService.getById(1003));

	}

}
