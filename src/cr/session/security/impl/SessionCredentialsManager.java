package cr.session.security.impl;

import java.util.Properties;

import cr.session.security.SessionCredentials;

/**
 * 
 * 
 * 
 * @author dgladkov
 *
 */
public class SessionCredentialsManager
{
	/**
	 * 
	 * 
	 * @param props
	 * @return
	 */
	static public SessionCredentials createFromProperties(final Properties props)
	{
		return new SessionReadOnlyCredentials();
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	static public SessionCredentials createFromXMLFile(final String fileName)
	{
		return new SessionReadOnlyCredentials();
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	static public SessionCredentials createFromXMLFileInClasspath(final String fileName)
	{
		return new SessionReadOnlyCredentials();
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	static public SessionCredentials createFromProrpetiesFile(final String fileName)
	{
		return new SessionReadOnlyCredentials();
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	static public SessionCredentials createFromPropertiesFileInClasspath(final String fileName)
	{
		return new SessionReadOnlyCredentials();
	}
	
	/**
	 * 
	 * @return
	 */
	static public SessionCredentials createFromDefaultLocation()
	{
		return new SessionReadOnlyCredentials();
	}
}
