package com.markcode.app.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class PersonaItemProcessor implements ItemProcessor<Persona,Persona> {

    private static final Logger logger = LoggerFactory.getLogger(PersonaItemProcessor.class);

    @Override
    public Persona process(final Persona persona) throws Exception {
        final String nombre = persona.nombre().toUpperCase();
        final String apellido = persona.apellido().toUpperCase();

        final Persona transformarPersona = new Persona(nombre, apellido);

        logger.info("Convirtiendo ( " +persona + " ) a ( " + transformarPersona + " )");

        return transformarPersona;
    }
}
