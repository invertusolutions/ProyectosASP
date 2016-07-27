package com.asp.corresponsal.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.asp.operaciones.ejb.remote.BitacoraBeanRemote;

public class ActivityLogEJB {

	private static BitacoraBeanRemote log;
	
	
	public static BitacoraBeanRemote obtenerLog(){
		
		if(log == null){
			Context co;
			try {
				co = new InitialContext();
				log = (BitacoraBeanRemote) co.lookup(ConstantesUtil.ACTIVITY_LOG_BEAN);

			} catch (NamingException e) {
				System.out.println(ActivityLogEJB.class.getName() + ": No se puede obtener el contexto");
				System.err.println(ActivityLogEJB.class.getName() + ": No se puede obtener el contexto " + e.getMessage());
			}			
		}
	
		return log;
	}
		
}
	