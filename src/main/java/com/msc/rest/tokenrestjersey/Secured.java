package com.msc.rest.tokenrestjersey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.ws.rs.NameBinding;

/**
 * Annotation a mettre au dessus des methodes qui ont besoin d'etre tokeniser.
 * Ne pas oublier de mettre a chaque fois le @Context SecurityContext
 * securityContext dans les paramettres.
 *
 * @author Micky
 */
@NameBinding
@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Secured {

}
