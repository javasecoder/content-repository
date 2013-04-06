package cr.session.impl;

import cr.session.SessionFactory;

/**
 * 
 * �������� ������ ������
 * 
 * @author dgladkov
 *
 */
public class SessionFactoryManager
{
	/**
	 * 
	 * �������� ��������� �������
	 * 
	 * @return ��������� �������
	 */
	static public SessionFactory getFactory()
	{
		return Holder.instance;
	}
	
	
	// ������ ��� ������� ���������� �������
	static private class Holder
	{
		static public final SessionFactory instance = new SessionFactoryImpl();
	}
}
