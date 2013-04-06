package cr.session.impl;

import cr.session.SessionFactory;

/**
 * 
 * Менеджер фабрик сессий
 * 
 * @author dgladkov
 *
 */
public class SessionFactoryManager
{
	/**
	 * 
	 * Получить экземпляр фабрики
	 * 
	 * @return экземпляр фабрики
	 */
	static public SessionFactory getFactory()
	{
		return Holder.instance;
	}
	
	
	// Холдер для храения экземпляра фабрики
	static private class Holder
	{
		static public final SessionFactory instance = new SessionFactoryImpl();
	}
}
