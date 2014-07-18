package de.unipotsdam.rulegenerator.enums;

import java.security.SecureRandom;

public class EnumUtils {
	private static final SecureRandom random = new SecureRandom();
	
	public static <T extends Enum<?>> T randomEnum(Class<T> clazz){	
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}