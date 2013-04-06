package cr.data.impl;

import cr.data.TypeMetadata;
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
		return Holder.booleanType;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getInteger()
	{
		return Holder.integerType;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getNumberType()
	{
		return Holder.numberType;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getEnumType()
	{
		return Holder.enumType;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getMultiselectType()
	{
		return Holder.multiselectType;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getStringType()
	{
		return Holder.stringType;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getDateType()
	{
		return Holder.dateType;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getListType()
	{
		return Holder.listType;
	}
	
	/**
	 * 
	 * @return
	 */
	static public TypeMetadata getFileType()
	{
		return Holder.fileType;
	}
	

	
	// Встроенные типы
	static private class Holder
	{
		static public final TypeMetadata booleanType	= new TypeMetadataPredefinedImpl("boolean");
		static public final TypeMetadata integerType	= new TypeMetadataPredefinedImpl("ineteger");
		static public final TypeMetadata numberType		= new TypeMetadataPredefinedImpl("number");
		static public final TypeMetadata enumType		= new TypeMetadataPredefinedImpl("enum");
		static public final TypeMetadata multiselectType= new TypeMetadataPredefinedImpl("multiselect");
		static public final TypeMetadata stringType		= new TypeMetadataPredefinedImpl("string");
		static public final TypeMetadata dateType		= new TypeMetadataPredefinedImpl("date");
		static public final TypeMetadata listType		= new TypeMetadataPredefinedImpl("list");
		static public final TypeMetadata fileType		= new TypeMetadataPredefinedImpl("file");
	}
}
