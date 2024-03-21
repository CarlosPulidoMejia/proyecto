package com.bim.reporte.proyecto.service.implement;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.proyecto.repository.CerrarSemanaRepo;
import com.bim.reporte.proyecto.service.CerrarSemanaService;

@Service
public class CerrarSemanaServiceImpl implements CerrarSemanaService{

	@Autowired
	private CerrarSemanaRepo cerrarSemanaRepo;
	
	@Override
	public void obtenerFecha() {
		// TODO Auto-generated method stub
		LocalDate hoy = LocalDate.now();
		hoy = hoy.plusDays(7);
        DayOfWeek diaActual = hoy.getDayOfWeek();
        int diasParaMartes = DayOfWeek.TUESDAY.getValue() - diaActual.getValue();
        
        if (diasParaMartes < 0) {
            // Ya pasó el martes de esta semana, avanza a la próxima semana.
            diasParaMartes += 7;
        }
        
        LocalDate proximoMartes = hoy.plusDays(diasParaMartes);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        
        proximoMartes.format(formatter);
        
        String fecha = proximoMartes.toString();
        
        System.out.println("Siguiente martes es: " + fecha);
        
        cerrarSemanaRepo.cerrarSemanaHis(fecha);

	}

}
