package br.com.CelsoParking.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Util {
	
	public static String gerarCodigo() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

}
