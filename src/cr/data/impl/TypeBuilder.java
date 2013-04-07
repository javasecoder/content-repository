package cr.data.impl;

import cr.data.TypeMetadata;
import cr.data.types.impl.TypeMetadataBoolImpl;
import cr.data.types.impl.TypeMetadataDateImpl;
import cr.data.types.impl.TypeMetadataEnumImpl;
import cr.data.types.impl.TypeMetadataFileImpl;
import cr.data.types.impl.TypeMetadataIntImpl;
import cr.data.types.impl.TypeMetadataListImpl;
import cr.data.types.impl.TypeMetadataMultiselectImpl;
import cr.data.types.impl.TypeMetadataNumberImpl;
import cr.data.types.impl.TypeMetadataStringImpl;
import cr.data.types.impl.TypeMetadataStructureImpl;
import cr.session.security.impl.PermissionChecker;

/**
 * 
 * 
 * Класс для создания типов данных
 * 
 * 
 * @author dgladkov
 *
 */
public class TypeBuilder
{
	/**
	 * 
	 */
	static public final TypeMetadata BOOLEAN	= new TypeMetadataBoolImpl();
	/**
	 * 
	 */
	static public final TypeMetadata INTEGER	= new TypeMetadataIntImpl();
	/**
	 * 
	 */
	static public final TypeMetadata NUMBER		= new TypeMetadataNumberImpl();
	/**
	 * 
	 */
	static public final TypeMetadata ENUM		= new TypeMetadataEnumImpl();
	/**
	 * 
	 */
	static public final TypeMetadata MULTISELECT= new TypeMetadataMultiselectImpl();
	/**
	 * 
	 */
	static public final TypeMetadata STRING		= new TypeMetadataStringImpl();
	/**
	 * 
	 */
	static public final TypeMetadata DATE		= new TypeMetadataDateImpl();
	/**
	 * 
	 */
	static public final TypeMetadata LIST		= new TypeMetadataListImpl();
	/**
	 * 
	 */
	static public final TypeMetadata FILE		= new TypeMetadataFileImpl();
	
	
	/**
	 * 
	 * Создать структуру
	 * 
	 * @param name имя структуры
	 * @param baseType базовый тип
	 * @param checker 
	 * @return созданный тип
	 */
	static public TypeMetadata createStuructureType(final String name, final TypeMetadata baseType, final PermissionChecker checker)
	{
		return new TypeMetadataStructureImpl(name, baseType, checker);
	}
	
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getBooleanType()
	{
		return BOOLEAN;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getInteger()
	{
		return INTEGER;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getNumberType()
	{
		return NUMBER;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getEnumType()
	{
		return ENUM;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getMultiselectType()
	{
		return MULTISELECT;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getStringType()
	{
		return STRING;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getDateType()
	{
		return DATE;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getListType()
	{
		return LIST;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getFileType()
	{
		return FILE;
	}
}
