package uo.asw.inciManager.service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.dbManagement.model.Categoria;
import uo.asw.dbManagement.model.Incidencia;
import uo.asw.dbManagement.model.Propiedad;
import uo.asw.dbManagement.tipos.CategoriaTipos;
import uo.asw.dbManagement.tipos.PropiedadTipos;
import uo.asw.inciManager.repository.CategoriaRepository;
import uo.asw.inciManager.repository.PropiedadRepository;

@Service
public class InsertSampleDataService {
	
	@Autowired
	private IncidenciasService incidenciaService;
	
	@Autowired
	private CategoriaRepository c;
	
	@Autowired
	private PropiedadRepository p;

	@PostConstruct
	public void init() {
		
		// ID's agentes
		String idAgente1 = "Id1";
		String idAgente2 = "Id2";

		
		// Creación de propiedades 
		Propiedad p1 = new Propiedad(PropiedadTipos.TEMPERATURA, 100.0); /* ¿UNIDADES? */
		Propiedad p2 = new Propiedad(PropiedadTipos.HUMEDAD, 90.0);
		Propiedad p3 = new Propiedad(PropiedadTipos.PRESION,  1.1);
		Propiedad p4 = new Propiedad(PropiedadTipos.VELOCIDAD_CIRCULACION,  110.0);
		Propiedad p5 = new Propiedad(PropiedadTipos.VELOCIDAD_VIENTO,  120.0);
		Propiedad p6 = new Propiedad(PropiedadTipos.VALOR_NO_ASIGNADO,  0.0);
		
		// Categorias 
		Categoria c1 = new Categoria(CategoriaTipos.ACCIDENTE_AEREO);
		Categoria c2 = new Categoria(CategoriaTipos.ACCIDENTE_CARRETERA);
		Categoria c3 = new Categoria(CategoriaTipos.FUEGO);
		Categoria c4 = new Categoria(CategoriaTipos.INUNDACION);
		Categoria c5 = new Categoria(CategoriaTipos.METEOROLOGICA);
		Categoria c6 = new Categoria(CategoriaTipos.VALOR_NO_ASIGNADO);
		
		// Creación de fechas 
		Calendar Choy = Calendar.getInstance();
		Calendar CunaSemana = Calendar.getInstance(); CunaSemana.add(Calendar.DAY_OF_MONTH, 7); 
		
		// Set de propiedades
		Set<Propiedad> propiedades1 = new HashSet<Propiedad>();
		propiedades1.add(p1);
		propiedades1.add(p2);
		Set<Propiedad> propiedades2 = new HashSet<Propiedad>();
		propiedades1.add(p3);
		propiedades1.add(p4);
		Set<Propiedad> propiedades3 = new HashSet<Propiedad>();
		propiedades1.add(p5);
		Set<Propiedad> propiedades4 = new HashSet<Propiedad>(); 
		propiedades2.add(p6);

		// Set de categorias
		Set<Categoria> categorias1 = new HashSet<Categoria>(); 
		categorias1.add(c1);
		categorias1.add(c2);
		Set<Categoria> categorias2 = new HashSet<Categoria>(); 
		categorias1.add(c3);
		categorias1.add(c4);
		Set<Categoria> categorias3 = new HashSet<Categoria>(); 
		categorias1.add(c5);
		Set<Categoria> categorias4 = new HashSet<Categoria>();
		categorias2.add(c6);
		
		//Incidencias
		/* PROPIEDADES = TEMPERATURA, HUMEDAD
		 * CATEGORIAS = ACCIDENTE_AEREO, ACCIDENTE_CARRETERA
		 * ESTADO = ABIERTA - SIN OPERARIO */
		Incidencia inci1 = new Incidencia("Inci1", "descripcion1", "Lat1", "Lon1", Choy.getTime(),
				CunaSemana.getTime(), idAgente1, propiedades1 , categorias1);
		
		/* PROPIEDADES = PRESION, VELOCIDAD_CIRCULACION
		 * CATEGORIAS = FUEGO, INUNDACION
		 * ESTADO = ABIERTA - SIN OPERARIO */
		Incidencia inci2 = new Incidencia("Inci2", "descripcion2", "Lat2", "Lon2",  Choy.getTime(),
				CunaSemana.getTime(), idAgente1, propiedades2 , categorias2);
		
		/* PROPIEDADES = VELOCIDAD_VIENTO
		 * CATEGORIAS = METEOROLOGICA 
		 * ESTADO = ABIERTA - SIN OPERARIO */
		Incidencia inci3 = new Incidencia("Inci3", "descripcion3", "Lat3", "Lon3",Choy.getTime(),
				CunaSemana.getTime(), idAgente2, propiedades3 , categorias3);
		
		/* PROPIEDADES = VALOR_NO_ASIGNADO
		 * CATEGORIAS = VALOR_NO_ASIGNADO
		 * ESTADO = ABIERTA - SIN OPERARIO */
		Incidencia inci4 = new Incidencia("Inci4", "descripcion4", "Lat4", "Lon4",  Choy.getTime(),
				CunaSemana.getTime(), idAgente2, propiedades4 , categorias4);
		
		p.save(p1);
		p.save(p2);
		p.save(p3);
		p.save(p4);
		p.save(p5);
		p.save(p5);
		c.save(c1);
		c.save(c2);
		c.save(c3);
		c.save(c4);
		c.save(c5);
		c.save(c6);
		incidenciaService.addIncidencia(inci1);
		incidenciaService.addIncidencia(inci2);
		incidenciaService.addIncidencia(inci3);
		incidenciaService.addIncidencia(inci4);
		
	}
}
